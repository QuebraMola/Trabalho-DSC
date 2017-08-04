/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.PSC.SistemaEstoque_Apresentacao;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;


/**
 *
 * @author junior-ormundo
 */
public class TelaPrincipal extends javax.swing.JFrame {
      
    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
       
        initComponents();
         
        Color minhaCor = new Color(176, 226, 255);
        
        this.getContentPane().setBackground(minhaCor); 
        
                
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        lblIcone = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuPessoa = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        mnuClientes = new javax.swing.JMenuItem();
        mnuProdutos = new javax.swing.JMenuItem();
        mnuFornecedores = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gerenciamento de Estoque Quebra-Mola");
        setBackground(new java.awt.Color(99, 184, 255));
        setExtendedState(6);

        lblIcone.setIcon(new javax.swing.ImageIcon("/home/junior-ormundo/PSCMYPROJECTS/Trabalho-DSC/Codigo Fonte/SistemaEstoque_Apresentacao/Icons/gerenciador.png")); // NOI18N

        jMenuBar1.setBackground(new java.awt.Color(69, 59, 55));

        mnuPessoa.setText("Cadastros");

        jMenuItem3.setText("Usuarios");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        mnuPessoa.add(jMenuItem3);

        mnuClientes.setText("Clientes");
        mnuClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuClientesActionPerformed(evt);
            }
        });
        mnuPessoa.add(mnuClientes);

        mnuProdutos.setText("Produtos");
        mnuProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuProdutosActionPerformed(evt);
            }
        });
        mnuPessoa.add(mnuProdutos);

        mnuFornecedores.setText("Fornecedores");
        mnuFornecedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuFornecedoresActionPerformed(evt);
            }
        });
        mnuPessoa.add(mnuFornecedores);

        jMenuBar1.add(mnuPessoa);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 929, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lblIcone)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 597, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lblIcone)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        UsuarioBuscar tela = new UsuarioBuscar(Repositorios.getUsuarioRepositorio(),UsuarioEditar.class);
        this.add(tela);
        lblIcone.setEnabled(false);
        tela.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void mnuClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuClientesActionPerformed
        ClienteBuscar tela = new ClienteBuscar(Repositorios.getClienteRepositorio(),ClienteEditar.class);
        this.add(tela);
        lblIcone.setEnabled(false);
        tela.setVisible(true);
    }//GEN-LAST:event_mnuClientesActionPerformed

    private void mnuProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuProdutosActionPerformed
        ProdutoBuscar tela = new ProdutoBuscar(Repositorios.getProdutoRepositorio(),ProdutoEditar.class);
        this.add(tela);
        lblIcone.setEnabled(false);
        tela.setVisible(true);
    }//GEN-LAST:event_mnuProdutosActionPerformed

    private void mnuFornecedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuFornecedoresActionPerformed
        FornecedorBuscar tela = new FornecedorBuscar(Repositorios.getFornecedorRepositorio(),FornecedorEditar.class);
        this.add(tela);
        lblIcone.setEnabled(false);
        tela.setVisible(true);
    }//GEN-LAST:event_mnuFornecedoresActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
             }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JLabel lblIcone;
    private javax.swing.JMenuItem mnuClientes;
    private javax.swing.JMenuItem mnuFornecedores;
    private javax.swing.JMenu mnuPessoa;
    private javax.swing.JMenuItem mnuProdutos;
    // End of variables declaration//GEN-END:variables
}
