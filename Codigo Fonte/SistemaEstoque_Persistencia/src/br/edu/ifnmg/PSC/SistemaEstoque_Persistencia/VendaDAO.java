/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.PSC.SistemaEstoque_Persistencia;

import br.edu.ifnmg.PSC.SistemaEstoque.Aplicacao.Venda;
import br.edu.ifnmg.PSC.SistemaEstoque.Aplicacao.VendaRepositorio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author junior-ormundo
 */
public class VendaDAO extends DAOGenerico<Venda> implements VendaRepositorio{

    public VendaDAO() throws ClassNotFoundException, SQLException {
        super();
    }


    @Override
    protected String getConsultaInsert() {
         return "insert into vendas(valorVenda,dataVenda,cliente,funcionario) values (?,?,?,?) ";
    }

    @Override
    protected String getConsultaUpdate() {
        return "update vendas set valorVenda=?,dataVenda=?, cliente=?, funcionario=? where id = ?";
    }

    @Override
    protected String getConsultaDelete() {
        return  "delete from vendas where id=? ";
    }

    @Override
    protected String getConsultaAbrir() {
        return "select id,valorVenda,dataVenda,cliente,funcionario from vendas where id=?";
    }

    @Override
    protected String getConsultaBuscar() {
        return "select id,valorVenda,dataVenda,cliente,funcionario from vendas";
    }

    @Override
    protected void setBuscaFiltros(Venda filtro) {
         
        if(filtro.getId() > 0)
            this.adicionarFiltro("id", filtro.getId());
               
      
        if(filtro.getValorVenda() > 0 )
            this.adicionarFiltro("valorVenda", filtro.getValorVenda());
       
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        
        if(filtro.getDataVenda()!= null) 
            this.adicionarFiltro("dataVenda",filtro.getDataVenda().getTime());
        
        if(filtro.getCliente() != null)
            this.adicionarFiltro("cliente", filtro.getCliente().getId());
        
          if(filtro.getFuncionario()!= null)
            this.adicionarFiltro("funcionario", filtro.getFuncionario().getId());
             
    }

    @Override
    protected void setParametros(PreparedStatement sql, Venda obj) {
         try {
            
            sql.setDouble(1,obj.getValorVenda());
            sql.setDate(2, new java.sql.Date(obj.getDataVenda().getTime()));
            sql.setInt(3, obj.getCliente().getId());
            sql.setInt(4, obj.getFuncionario().getId());
            
            if(obj.getId() > 0)
                sql.setInt(5, obj.getId());
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
     UsuarioDAO funcionario;
     ClienteDAO cliente;
     
    @Override
    protected Venda setDados(ResultSet resultado) {
        try {

            Venda obj = new Venda();
            obj.setId(resultado.getInt("id"));
            obj.setValorVenda(resultado.getDouble("valorVenda"));
            obj.setDataVenda(new Date(resultado.getDate("dataVenda").getTime()));;
            obj.setCliente( cliente.Abrir( resultado.getInt("cliente") ) );
            obj.setFuncionario( funcionario.Abrir( resultado.getInt("funcionario") ) );
            
            return obj;
            
        } catch (Exception ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
