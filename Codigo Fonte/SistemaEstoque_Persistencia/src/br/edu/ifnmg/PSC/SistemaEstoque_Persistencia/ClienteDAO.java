/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.PSC.SistemaEstoque_Persistencia;

import br.edu.ifnmg.PSC.SistemaEstoque.Aplicacao.Cliente;
import br.edu.ifnmg.PSC.SistemaEstoque.Aplicacao.ClienteRepositorio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author junior-ormundo
 */
public class ClienteDAO extends DAOGenerico<Cliente> implements ClienteRepositorio {
    
      public ClienteDAO() throws ClassNotFoundException, SQLException {
        super();
    
    }

  
    
    
    @Override
    protected String getConsultaInsert() {
           return "insert into clientes(nomeCompleto,cpf,endereco,telefone,dataNascimento) values (?,?,?,?,?) ";
    }

    @Override
    protected String getConsultaUpdate() {
            return "update clientes set nomeCompleto=?,cpf=?, endereco=?, telefone=?, dataNascimento=? where id = ?";
    }

    @Override
    protected String getConsultaDelete() {
            return "delete from clientes where id=? ";
    }

    @Override
    protected String getConsultaAbrir() {
            return "select id,nomeCompleto,cpf,endereco,telefone,dataNascimento from clientes where id=?";
    }

    @Override
    protected String getConsultaBuscar() {
            return "select id,nomeCompleto,cpf,endereco,telefone,dataNascimento from clientes";
    }
    

    @Override
    protected void setBuscaFiltros(Cliente filtro) {
       
        if(filtro.getId() > 0)
            this.adicionarFiltro("id", filtro.getId());
        
        if(filtro.getNomeCompleto() != null && !filtro.getNomeCompleto().isEmpty())
            this.adicionarFiltro("nomeCompleto", filtro.getNomeCompleto());
        
        if(filtro.getEndereco() != null && !filtro.getEndereco().isEmpty())
            this.adicionarFiltro("endereco", filtro.getNomeCompleto());
        
        
        
    }

    @Override
    protected void setParametros(PreparedStatement sql, Cliente obj) {
        try {
            
            sql.setString(1, obj.getNomeCompleto());
            sql.setString(2, obj.getCpf());
            sql.setString(3,obj.getEndereco());
            sql.setString(4, obj.getTelefone());
            sql.setDate(5, new java.sql.Date(obj.getDataNascimento().getTime()));
            
            if(obj.getId() > 0)
                sql.setInt(6, obj.getId());
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected Cliente setDados(ResultSet resultado) {
        try {

            Cliente obj = new Cliente();
            obj.setId(resultado.getInt("id"));
            obj.setNomeCompleto(resultado.getString("nomeCompleto"));
            obj.setCpf(resultado.getString("cpf"));
            obj.setEndereco(resultado.getString("endereco"));
            obj.setTelefone(resultado.getString("telefone"));
            obj.setDataNascimento(new Date(resultado.getDate("dataNascimento").getTime()));
            
            return obj;
            
        } catch (Exception ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

    
