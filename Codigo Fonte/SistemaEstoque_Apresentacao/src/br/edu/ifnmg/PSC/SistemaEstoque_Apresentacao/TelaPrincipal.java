/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.PSC.SistemaEstoque_Apresentacao;

import br.edu.ifnmg.PSC.SistemaEstoque.Aplicacao.Aplicacao;
import br.edu.ifnmg.PSC.SistemaEstoque.Aplicacao.ClienteRepositorio;
import br.edu.ifnmg.PSC.SistemaEstoque.Aplicacao.ProdutoRepositorio;
import br.edu.ifnmg.PSC.SistemaEstoque.Aplicacao.Tipo;
import br.edu.ifnmg.PSC.SistemaEstoque.Aplicacao.UsuarioRepositorio;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;


/**
 *
 * @author junior-ormundo
 */
public class TelaPrincipal extends javax.swing.JFrame {

     TelaLogin telalogin;
      
    /**
     * Creates new form TelaPrincipal
     */
    
    public void setTelalogin(TelaLogin telalogin) {
        this.telalogin = telalogin;
    }
    public TelaPrincipal() {
       
        initComponents();
         
        Color minhaCor = new Color(176, 226, 255);
        
        this.getContentPane().setBackground(minhaCor); 
        
        lblIcone.setEnabled(false);
        
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
        btnLogout = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuUsuario = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        mnuClientes = new javax.swing.JMenuItem();
        mnuProdutos = new javax.swing.JMenuItem();
        mnuFornecedores = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        mnuRelatorios = new javax.swing.JMenu();
        mnuEstoque = new javax.swing.JMenuItem();
        mnuRelatorioClientes = new javax.swing.JMenuItem();
        mnuRelatorioUsuario = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gerenciamento de Estoque Quebra-Mola");
        setBackground(new java.awt.Color(99, 184, 255));
        setExtendedState(6);

        lblIcone.setIcon(new javax.swing.ImageIcon("/home/junior-ormundo/PSCMYPROJECTS/Trabalho-DSC/Codigo Fonte/SistemaEstoque_Apresentacao/Icons/gerenciador.png")); // NOI18N
        lblIcone.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        lblIcone.setFocusable(false);

        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        jMenuBar1.setBackground(new java.awt.Color(69, 59, 55));

        mnuUsuario.setText("Cadastros");

        jMenuItem3.setText("Usuarios");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        mnuUsuario.add(jMenuItem3);

        mnuClientes.setText("Clientes");
        mnuClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuClientesActionPerformed(evt);
            }
        });
        mnuUsuario.add(mnuClientes);

        mnuProdutos.setText("Produtos");
        mnuProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuProdutosActionPerformed(evt);
            }
        });
        mnuUsuario.add(mnuProdutos);

        mnuFornecedores.setText("Fornecedores");
        mnuFornecedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuFornecedoresActionPerformed(evt);
            }
        });
        mnuUsuario.add(mnuFornecedores);

        jMenuBar1.add(mnuUsuario);

        jMenu1.setText("Vendas");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        mnuRelatorios.setText("Relatorios");

        mnuEstoque.setText("Estoque");
        mnuEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuEstoqueActionPerformed(evt);
            }
        });
        mnuRelatorios.add(mnuEstoque);

        mnuRelatorioClientes.setText("Clientes");
        mnuRelatorioClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRelatorioClientesActionPerformed(evt);
            }
        });
        mnuRelatorios.add(mnuRelatorioClientes);

        mnuRelatorioUsuario.setText("Usuarios");
        mnuRelatorioUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRelatorioUsuarioActionPerformed(evt);
            }
        });
        mnuRelatorios.add(mnuRelatorioUsuario);

        jMenuBar1.add(mnuRelatorios);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(778, Short.MAX_VALUE)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lblIcone)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnLogout)
                .addContainerGap(556, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lblIcone)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        if(Aplicacao.getUsuario().getTipo()!= Tipo.ADMINISTRADOR){
            JOptionPane.showMessageDialog(rootPane, "Você não tem Permissão para Acessar essa área!");
            return;
        }
        UsuarioBuscar tela = new UsuarioBuscar(Repositorios.getUsuarioRepositorio(),UsuarioEditar.class);
        this.add(tela);
        tela.setVisible(false);
        tela.setVisible(true);
        
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void mnuClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuClientesActionPerformed
        ClienteBuscar tela = new ClienteBuscar(Repositorios.getClienteRepositorio(),ClienteEditar.class);
        this.add(tela);
        tela.setVisible(true);
        
        
    }//GEN-LAST:event_mnuClientesActionPerformed

    private void mnuProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuProdutosActionPerformed
        if(Aplicacao.getUsuario().getTipo()!= Tipo.ADMINISTRADOR){
            JOptionPane.showMessageDialog(rootPane, "Você não tem Permissão para Acessar essa área!");
            return;
        }
        ProdutoBuscar tela = new ProdutoBuscar(Repositorios.getProdutoRepositorio(),ProdutoEditar.class);
        this.add(tela);
        tela.setVisible(true);
     
    }//GEN-LAST:event_mnuProdutosActionPerformed

    private void mnuFornecedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuFornecedoresActionPerformed
       if(Aplicacao.getUsuario().getTipo()!= Tipo.ADMINISTRADOR){
            JOptionPane.showMessageDialog(rootPane, "Você não tem Permissão para Acessar essa área!");
            return;
        }
        FornecedorBuscar tela = new FornecedorBuscar(Repositorios.getFornecedorRepositorio(),FornecedorEditar.class);
        this.add(tela);
        tela.setVisible(true);
    }//GEN-LAST:event_mnuFornecedoresActionPerformed

    private void mnuEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuEstoqueActionPerformed
         
        ProdutoRepositorio dao = Repositorios.getProdutoRepositorio();
        
        Map parametros = new HashMap();
        
        exibeRelatorioJasper("TProdutos.jasper", dao.Buscar(null), parametros);
    }//GEN-LAST:event_mnuEstoqueActionPerformed

    private void mnuRelatorioClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRelatorioClientesActionPerformed
        ClienteRepositorio dao = Repositorios.getClienteRepositorio();
        
        Map parametros = new HashMap();
        
        exibeRelatorioJasper("Clientes.jasper", dao.Buscar(null), parametros);
    }//GEN-LAST:event_mnuRelatorioClientesActionPerformed

    private void mnuRelatorioUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRelatorioUsuarioActionPerformed
        UsuarioRepositorio dao = Repositorios.getUsuarioRepositorio();
        
        Map parametros = new HashMap();
        
        exibeRelatorioJasper("Usuarios.jasper", dao.Buscar(null), parametros);
    }//GEN-LAST:event_mnuRelatorioUsuarioActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed

    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        VendaBuscar tela = new VendaBuscar(Repositorios.getVendaRepositorio(),VendaEditar.class);
        this.add(tela);
        tela.setVisible(true);
    }//GEN-LAST:event_jMenu1MouseClicked

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        actionLogout();
    }//GEN-LAST:event_btnLogoutActionPerformed

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
    
     private void exibeRelatorioJasper(String caminho_relatorio, List dados, Map parametros) {

        try {
            // Parâmetros
            if(parametros == null)
                parametros = new HashMap();

            // Pega o caminho do arquivo do relatório
            URL arquivo = getClass().getResource(caminho_relatorio);
            
            // Carrega o relatório na memória
            JasperReport relatorio = (JasperReport) JRLoader.loadObject(arquivo);
            
            // Data Source - Fonte de Dados do Relatório
            JRDataSource fontededados = new JRBeanCollectionDataSource(dados, true);
            
            // Preenche o relatório com os dados fornecidos pelo Data Source
            JasperPrint jasperPrint = JasperFillManager.fillReport(relatorio, parametros, fontededados);
            
            // Visualiza o relatório, isto é, abre uma janela que mostra o relatório
            JasperViewer jrviewer = new JasperViewer(jasperPrint, false);
            
            jrviewer.setVisible(true);
        
        } catch (JRException ex) {
            Logger.getLogger(JasperReport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogout;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JLabel lblIcone;
    private javax.swing.JMenuItem mnuClientes;
    private javax.swing.JMenuItem mnuEstoque;
    private javax.swing.JMenuItem mnuFornecedores;
    private javax.swing.JMenuItem mnuProdutos;
    private javax.swing.JMenuItem mnuRelatorioClientes;
    private javax.swing.JMenuItem mnuRelatorioUsuario;
    private javax.swing.JMenu mnuRelatorios;
    private javax.swing.JMenu mnuUsuario;
    // End of variables declaration//GEN-END:variables

    public void actionLogout() {
       TelaLogin login = new TelaLogin();
            
       login.setTelaPrincipal(this);
            
       login.setVisible(true);
       
       this.setVisible(false);
   
    }



}
