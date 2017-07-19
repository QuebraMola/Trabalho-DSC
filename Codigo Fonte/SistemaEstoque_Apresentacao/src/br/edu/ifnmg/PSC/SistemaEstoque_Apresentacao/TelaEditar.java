/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.PSC.SistemaEstoque_Apresentacao;

import br.edu.ifnmg.PSC.SistemaEstoque.Aplicacao.Entidade;
import br.edu.ifnmg.PSC.SistemaEstoque.Aplicacao.RegraNegocioException;
import br.edu.ifnmg.PSC.SistemaEstoque.Aplicacao.Repositorio;
import javax.swing.JOptionPane;

/**
 *
 * @author junior-ormundo
 * @param <Q>
 */
public abstract class TelaEditar<Q extends Entidade> extends javax.swing.JInternalFrame {
    

    Repositorio<Q> repositorio;
    Q entidade;

    public TelaEditar() {
    }

    public Repositorio<Q> getRepositorio() {
        return repositorio;
    }

    public void setRepositorio(Repositorio<Q> repositorio) {
        this.repositorio = repositorio;
    }

    public Q getEntidade() {
        return entidade;
    }

    public void setEntidade(Q entidade) {
        this.entidade = entidade;
    }
    
    public abstract void carregaCampos();
    public abstract void carregaObjeto() throws RegraNegocioException;
    public abstract boolean verificarCamposObrigatorios();
    
    public void salvar(){
        if(!verificarCamposObrigatorios()){
            JOptionPane.showMessageDialog(rootPane, "Todos os campos são de preenchimento obrigatório!");
            return;
        }
            
        if(JOptionPane.showConfirmDialog(rootPane, "Deseja realmente salvar o objeto?") == 0 ){

            try {
                carregaObjeto();
                
            } catch (RegraNegocioException ex) {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());
                return; 
            }
            
            if(repositorio.Salvar(entidade)){
                JOptionPane.showMessageDialog(rootPane, "Registro salvo com sucesso!");
            } else {
                JOptionPane.showMessageDialog(rootPane, "Falha ao salvar o registro!");
            }
            
        } else {
            JOptionPane.showMessageDialog(rootPane, "Operação Cancelada!");
        }
    }
    
    
    public void cancelar(){
        this.setVisible(false);
        this.dispose();
    }
    
    
    
}
