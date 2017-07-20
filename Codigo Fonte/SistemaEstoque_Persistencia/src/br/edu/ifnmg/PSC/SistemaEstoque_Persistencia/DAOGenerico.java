/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.PSC.SistemaEstoque_Persistencia;

import br.edu.ifnmg.PSC.SistemaEstoque.Aplicacao.Entidade;
import br.edu.ifnmg.PSC.SistemaEstoque.Aplicacao.Repositorio;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author junior-ormundo
 * @param <Q>
 */
public abstract class DAOGenerico <Q extends Entidade> implements Repositorio<Q> {
    
    private Connection conexao;
    
    protected String where = "";

    public DAOGenerico() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        
        conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/SistemaEstoque","root","123");
    
    
    }
    
    protected abstract String getConsultaInsert();
    protected abstract String getConsultaUpdate();
    protected abstract String getConsultaDelete();
    protected abstract String getConsultaAbrir();
    protected abstract String getConsultaBuscar();
    protected abstract void setBuscaFiltros(Q filtro);
    
    protected abstract void setParametros(PreparedStatement sql, Q obj);
    protected abstract Q setDados(ResultSet resultado);

    @Override
    public boolean Salvar(Q obj) {
        PreparedStatement sql = null;
        
        try{
        
            if(obj.getId() == 0){
                sql = conexao.prepareStatement(getConsultaInsert());
            }else{
                sql = conexao.prepareStatement(getConsultaUpdate());
            }
        
            setParametros(sql, obj);

            if (sql.executeUpdate() > 0) 
                return true;
            else 
                return false;
            
        } catch(Exception ex){
             return false;
        }
                
                
    }

    @Override
    public boolean Apagar(Q obj) {
        try {
            PreparedStatement sql = conexao.prepareStatement(getConsultaDelete());
            
            sql.setInt(1, obj.getId());
            
            if (sql.executeUpdate() > 0) {
                obj = null;
                return true;
            } else 
                return false;
            
        } catch(Exception ex) {
             return false;
        }
    }

    @Override
    public Q Abrir(int id) {
        try {
            PreparedStatement sql = conexao.prepareStatement(getConsultaAbrir());
            
            sql.setInt(1,id);
            
            ResultSet resultado = sql.executeQuery();
            
            if(resultado.next())
                return this.setDados(resultado);
            else
                return null;
            
                        
        } catch (SQLException ex) {
            Logger.getLogger(DAOGenerico.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
       protected DAOGenerico<Q> adicionarFiltro(String campo, String valor){
        if(where.length() > 0)
            where += " and ";
        
        where += campo + " = '"+ valor + "'";
        
        return this;
    }
    
    protected DAOGenerico<Q> adicionarFiltro(String campo, int valor){
        if(where.length() > 0)
            where += " and ";
        
        where += campo + " = "+ Integer.toString(valor);
        
        return this;
    }

    @Override
    public List<Q> Buscar(Q filtro) {
           
        
           List<Q> lista = new ArrayList<>();
       
        try {
            
            if(filtro != null)
                this.setBuscaFiltros(filtro);
            
            String sqlfinal = this.getConsultaBuscar();
            
            if(! where.isEmpty())
                sqlfinal += " where " + where;
            
            PreparedStatement sql = conexao.prepareStatement(sqlfinal);
                       
            ResultSet resultado = sql.executeQuery();
            
            while(resultado.next())
                lista.add(this.setDados(resultado) );
            
            this.where = "";
            
            return lista;
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOGenerico.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}