/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.PSC.SistemaEstoque_Persistencia;

import br.edu.ifnmg.PSC.SistemaEstoque.Aplicacao.Usuario;
import br.edu.ifnmg.PSC.SistemaEstoque.Aplicacao.UsuarioRepositorio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author junior-ormundo
 */
public class UsuarioDAO extends DAOGenerico<Usuario> implements UsuarioRepositorio {
    
    public UsuarioDAO() throws ClassNotFoundException, SQLException {
        super();
    
    }

  
    
    
    @Override
    protected String getConsultaInsert() {
           return "insert into usuarios(nomeCompleto,nomeUsuario,cpf,senha) values (?,?,?,?) ";
    }

    @Override
    protected String getConsultaUpdate() {
            return "update usuarios set nomeCompleto=?, nomeUsuario=?, cpf=?, senha=? where id = ?";
    }

    @Override
    protected String getConsultaDelete() {
            return "delete from usuarios where id=? ";
    }

    @Override
    protected String getConsultaAbrir() {
            return "select id,nomeCompleto,nomeUsuario,cpf,senha from usuarios where id=?";
    }

    @Override
    protected String getConsultaBuscar() {
            return "select id,nomeCompleto,nomeUsuario,cpf from usuarios";
    }
    

    @Override
    protected void setBuscaFiltros(Usuario filtro) {
        if(filtro.getId() > 0)
            this.adicionarFiltro("id", filtro.getId());
        
        if(filtro.getNomeCompleto() != null && !filtro.getNomeCompleto().isEmpty())
            this.adicionarFiltro("nomeCompleto", filtro.getNomeCompleto());
        
        if(filtro.getNomeUsuario()!= null && !filtro.getNomeUsuario().isEmpty())
            this.adicionarFiltro("nomeUsuario", filtro.getNomeUsuario());
        
        if(filtro.getSenha() != null && !filtro.getSenha().isEmpty())
            this.adicionarFiltro("senha", filtro.getSenha());
        
    }

    @Override
    protected void setParametros(PreparedStatement sql, Usuario obj) {
        try {
            
            sql.setString(1, obj.getNomeCompleto());
            sql.setString(2, obj.getNomeUsuario());
            sql.setString(3,obj.getCpf());
            sql.setString(4, obj.getSenha());
            
            if(obj.getId() > 0)
                sql.setInt(5, obj.getId());
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected Usuario setDados(ResultSet resultado) {
        try {

            Usuario obj = new Usuario();
            obj.setId(resultado.getInt("id"));
            obj.setNomeCompleto(resultado.getString("nomeCompleto"));
            obj.setNomeUsuario(resultado.getString("nomeUsuario"));
            obj.setCpf(resultado.getString("cpf"));
           // obj.setSenha(resultado.getString("senha"));
            
            return obj;
            
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
