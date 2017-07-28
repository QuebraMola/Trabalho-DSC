/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.PSC.SistemaEstoque_Apresentacao;
import br.edu.ifnmg.PSC.SistemaEstoque.Aplicacao.Entidade;
import br.edu.ifnmg.PSC.SistemaEstoque.Aplicacao.Repositorio;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author junior-ormundo
 */
public abstract class TelaBuscar<Q extends Entidade> extends javax.swing.JInternalFrame {
   
    Repositorio<Q> repositorio;
    Q filtro;
    
    TelaEditar<Q> tela_editar;
    Class tipo_tela;
    
    public abstract int retornaIdSelecionado();
    
    public abstract void preencheFiltro();
    
    public abstract void preencheTabela(List<Q> listagem);

    public TelaBuscar(Repositorio<Q> repositorio, Class tipo_tela) {
        this.repositorio = repositorio;
        this.tipo_tela = tipo_tela;
    }
    
    public void buscar(){
        
        
        preencheFiltro();
        
        List<Q> listagem = repositorio.Buscar(filtro);
        
        preencheTabela(listagem);
         
        
    }
    
    
    
    public void novo() {
        
        try {
            tela_editar = (TelaEditar<Q>) tipo_tela.newInstance();
            
        } catch (InstantiationException ex) {
            Logger.getLogger(TelaBuscar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(TelaBuscar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        tela_editar.setBuscar(this);
        
        tela_editar.setRepositorio(repositorio);
        
        tela_editar.setEntidade(filtro);
        
        this.getParent().add(tela_editar);
       
        tela_editar.setVisible(true);
        
        this.setVisible(false);

    }
   
    public void apagar(){
        int id =retornaIdSelecionado();
        
        filtro = repositorio.Abrir(id);
        
        if(JOptionPane.showConfirmDialog(rootPane, "Deseja realmente apagar?") == 0 ){
            Q entidade;
            if(repositorio.Apagar(filtro)){
                JOptionPane.showMessageDialog(rootPane, "Apagado com sucesso!");      
            } else {
                JOptionPane.showMessageDialog(rootPane, "Falha ao Apagar!");
            }
        }  else {
            JOptionPane.showMessageDialog(rootPane, "Operação Cancelada!");
        }
        
        
    
    }
    
    
    public void editar(){
        int id = retornaIdSelecionado();
        
        filtro = repositorio.Abrir(id);
        
          
        try {
            tela_editar = (TelaEditar<Q>) tipo_tela.newInstance();
            
        } catch (InstantiationException ex) {
            Logger.getLogger(TelaBuscar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(TelaBuscar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        tela_editar.setBuscar(this);
        
        tela_editar.setRepositorio(repositorio);
        
        tela_editar.setEntidade(filtro);
        
        this.getParent().add(tela_editar);
        
        tela_editar.setVisible(true);
        
        this.setVisible(false);
    }
        
    
   
    
}
