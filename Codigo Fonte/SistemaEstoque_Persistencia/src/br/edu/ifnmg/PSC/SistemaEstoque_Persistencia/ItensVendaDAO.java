/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.PSC.SistemaEstoque_Persistencia;

import br.edu.ifnmg.PSC.SistemaEstoque.Aplicacao.ItensVenda;
import br.edu.ifnmg.PSC.SistemaEstoque.Aplicacao.ItensVendaRepositorio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author junior-ormundo
 */
public class ItensVendaDAO extends DAOGenerico<ItensVenda> implements ItensVendaRepositorio {

    public ItensVendaDAO() throws ClassNotFoundException, SQLException {
        super();
        produto = new ProdutoDAO();
        venda = new VendaDAO();
    }
        
        
    

    @Override
    protected String getConsultaInsert() {
        return "insert into itensvenda(produto,venda,qtd) values (?,?,?) ";
    }

    @Override
    protected String getConsultaUpdate() {
         return "update itensvenda set produto=?, venda=?, qtd=? where id=?";
    }

    @Override
    protected String getConsultaDelete() {
        return "delete from itensvenda where id=?";
    }

    @Override
    protected String getConsultaAbrir() {
        return "select id,produto,venda,qtd from itensvenda where id=? and venda=?";
    } 

    @Override
    protected String getConsultaBuscar() {
         return "select id,produto,venda,qtd from itensvenda where venda=?";
    }

    @Override   
    protected void setBuscaFiltros(ItensVenda filtro) {
     
            if(filtro.getId() > 0)
            this.adicionarFiltro("id", filtro.getId());
        
            if(filtro.getProduto() != null)
                this.adicionarFiltro("produto", filtro.getProduto().getId());
          
            if(filtro.getProduto() != null)
                this.adicionarFiltro("venda", filtro.getVenda().getId());
                      
            if(filtro.getQtd() > 0 )
                this.adicionarFiltro("qtd", filtro.getQtd());
        
        }

    @Override
    protected void setParametros(PreparedStatement sql, ItensVenda obj) {
        try {
            
            sql.setInt(1, obj.getProduto().getId());
            sql.setInt(2, obj.getVenda().getId());
            sql.setInt(3,obj.getQtd());
            
             
            if(obj.getId() > 0)
                sql.setInt(4, obj.getId());
                        
        } catch (SQLException ex) {
            Logger.getLogger(ItensVendaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    ProdutoDAO produto;
    VendaDAO venda;
    
    @Override
    protected ItensVenda setDados(ResultSet resultado) {
     try {

            ItensVenda obj = new ItensVenda();
            obj.setId(resultado.getInt("id"));
            obj.setProduto( produto.Abrir( resultado.getInt("produto") ) );
            obj.setVenda( venda.Abrir( resultado.getInt("venda") ) );
            obj.setQtd(resultado.getInt("qtd"));
            
            return obj;
            
        } catch (Exception ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
    

