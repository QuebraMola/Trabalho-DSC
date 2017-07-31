/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.PSC.SistemaEstoque_Persistencia;

import br.edu.ifnmg.PSC.SistemaEstoque.Aplicacao.Fornecedor;
import br.edu.ifnmg.PSC.SistemaEstoque.Aplicacao.FornecedorRepositorio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author junior-ormundo
 */
public class FornecedorDAO extends DAOGenerico<Fornecedor> implements FornecedorRepositorio {

    public FornecedorDAO() throws ClassNotFoundException, SQLException {
        super();
    }

    
    @Override
    protected String getConsultaInsert() {
       return "insert into fornecedores(nome,cnpj,telefone) values (?,?,?) ";
  }

    @Override
    protected String getConsultaUpdate() {
        return "update fornecedores set nome=?, cnpj=?, telefone=? where id = ?";
      }

    @Override
    protected String getConsultaDelete() {
        return "delete from fornecedores where id=? ";
    }

    @Override
    protected String getConsultaAbrir() {
        return "select id,nome,cnpj,telefone from fornecedores where id=?";

    }

    @Override
    protected String getConsultaBuscar() {
        return "select id,nome,cnpj,telefone from fornecedores";
    }

    @Override
    protected void setBuscaFiltros(Fornecedor filtro) {
        if(filtro.getId() > 0)
            this.adicionarFiltro("id", filtro.getId());
        
        if(filtro.getNome() != null && !filtro.getNome().isEmpty())
            this.adicionarFiltro("nome", filtro.getNome());
        
        if(filtro.getCnpj() != null && !filtro.getCnpj().isEmpty())
            this.adicionarFiltro("cnpj", filtro.getCnpj());
        
        if(filtro.getTelefone()!= null && !filtro.getTelefone().isEmpty())
            this.adicionarFiltro("telefone", filtro.getTelefone());
  
       }

    @Override
    protected void setParametros(PreparedStatement sql, Fornecedor obj) {
         try {
            
            sql.setString(1, obj.getNome());
            sql.setString(2, obj.getCnpj());
            sql.setString(3,obj.getTelefone());
          
            if(obj.getId() > 0)
                sql.setInt(4, obj.getId());
            
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        
        }
    
    }

    @Override
    protected Fornecedor setDados(ResultSet resultado) {
        try {

            Fornecedor obj = new Fornecedor();
            obj.setId(resultado.getInt("id"));
            obj.setNome(resultado.getString("nome"));
            obj.setCnpj(resultado.getString("cnpj"));
            obj.setTelefone(resultado.getString("Telefone"));
            
            return obj;
            
        } catch (Exception ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
