/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.PSC.SistemaEstoque_Persistencia;

import br.edu.ifnmg.PSC.SistemaEstoque.Aplicacao.Pessoa;
import br.edu.ifnmg.PSC.SistemaEstoque.Aplicacao.PessoaRepositorio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author junior-ormundo
 */
public class PessoaDAO extends DAOGenerico<Pessoa> implements PessoaRepositorio {

    public PessoaDAO() throws ClassNotFoundException, SQLException {
        super();
    
    }

  
    
    
    @Override
    protected String getConsultaInsert() {
           return "insert into pessoas(nomeCompleto,cpf,nomeUsuario,senha) values (?,?,?,?) ";
    }

    @Override
    protected String getConsultaUpdate() {
            return "update pessoas set nomeCompleto=?, cpf=?, nomeUsuario=?, senha=? where id = ?";
    }

    @Override
    protected String getConsultaDelete() {
            return "delete from pessoas where id=? ";
    }

    @Override
    protected String getConsultaAbrir() {
            return "select nomeCompleto,cpf,nomeUsuario from pessoas where=?";
    }

    @Override
    protected String getConsultaBuscar() {
            return "select id,nomeCompleto,cpf,nomeUsuario from pessoas";
    }
    

    @Override
    protected void setBuscaFiltros(Pessoa filtro) {
         if(filtro.getId() > 0)
            this.adicionarFiltro("id", filtro.getId());
        
        if(filtro.getNomeCompleto() != null && !filtro.getNomeCompleto().isEmpty())
            this.adicionarFiltro("nomeCompleto", filtro.getNomeCompleto());
        
        if(filtro.getCpf() != null && !filtro.getCpf().isEmpty())
            this.adicionarFiltro("cpf", filtro.getCpf());
        
        if(filtro.getNomeUsuario()!= null && !filtro.getNomeUsuario().isEmpty())
            this.adicionarFiltro("nomeUsuario", filtro.getNomeUsuario());
        
 
        if(filtro.getSenha() != null && !filtro.getSenha().isEmpty())
            this.adicionarFiltro("senha", filtro.getSenha());
       }

    @Override
    protected void setParametros(PreparedStatement sql, Pessoa obj) {
        try {
            
            sql.setString(1, obj.getNomeCompleto());
            sql.setString(2, obj.getNomeUsuario());
            sql.setString(3,obj.getCpf());
            sql.setString(4, obj.getSenha());
            
            if(obj.getId() > 0)
                sql.setInt(5, obj.getId());
            
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected Pessoa setDados(ResultSet resultado) {
        try {

            Pessoa obj = new Pessoa();
            obj.setId(resultado.getInt("id"));
            obj.setNomeCompleto(resultado.getString("nomeCompleto"));
            obj.setCpf(resultado.getString("cpf"));
            obj.setNomeUsuario(resultado.getString("nomeUsuario"));
            //obj.setSenha(resultado.getString("senha"));
            
            return obj;
            
        } catch (Exception ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
