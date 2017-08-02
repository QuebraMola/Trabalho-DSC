/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.PSC.SistemaEstoque_Apresentacao;

import br.edu.ifnmg.PSC.SistemaEstoque.Aplicacao.ClienteRepositorio;
import br.edu.ifnmg.PSC.SistemaEstoque.Aplicacao.FornecedorRepositorio;
import br.edu.ifnmg.PSC.SistemaEstoque.Aplicacao.ProdutoRepositorio;
import br.edu.ifnmg.PSC.SistemaEstoque.Aplicacao.UsuarioRepositorio;
import br.edu.ifnmg.PSC.SistemaEstoque_Persistencia.ClienteDAO;
import br.edu.ifnmg.PSC.SistemaEstoque_Persistencia.FornecedorDAO;
import br.edu.ifnmg.PSC.SistemaEstoque_Persistencia.ProdutoDAO;
import br.edu.ifnmg.PSC.SistemaEstoque_Persistencia.UsuarioDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author junior-ormundo
 */
public class Repositorios {
    
    
  static UsuarioRepositorio usuarioDAO = null;
    
    public static UsuarioRepositorio getUsuarioRepositorio(){
        if(usuarioDAO == null)
            try {
                usuarioDAO = new UsuarioDAO();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Repositorios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Repositorios.class.getName()).log(Level.SEVERE, null, ex);
            }
        return usuarioDAO;
    }
    
      static ClienteRepositorio clienteDAO = null;
    
    public static ClienteRepositorio getClienteRepositorio(){
        if(clienteDAO == null)
            try {
                clienteDAO = new ClienteDAO();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Repositorios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Repositorios.class.getName()).log(Level.SEVERE, null, ex);
            }
        return clienteDAO;
    }
    
     static FornecedorRepositorio fornecedorDAO = null;
    
    public static FornecedorRepositorio getFornecedorRepositorio(){
        if(fornecedorDAO == null)
            try {
                fornecedorDAO = new FornecedorDAO();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Repositorios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Repositorios.class.getName()).log(Level.SEVERE, null, ex);
            }
        return fornecedorDAO;
    
    }
    static ProdutoRepositorio produtoDAO = null;
    
    public static ProdutoRepositorio getProdutoRepositorio(){
        if(produtoDAO == null)
            try {
                produtoDAO = new ProdutoDAO();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Repositorios.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Repositorios.class.getName()).log(Level.SEVERE, null, ex);
            }
        return produtoDAO;
    }
    
    
    
}
