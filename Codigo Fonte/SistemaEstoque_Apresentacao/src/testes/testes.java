/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import br.edu.ifnmg.PSC.SistemaEstoque.Aplicacao.Fornecedor;
import br.edu.ifnmg.PSC.SistemaEstoque.Aplicacao.FornecedorRepositorio;

import br.edu.ifnmg.PSC.SistemaEstoque.Aplicacao.Produto;
import br.edu.ifnmg.PSC.SistemaEstoque.Aplicacao.ProdutoRepositorio;
import br.edu.ifnmg.PSC.SistemaEstoque.Aplicacao.RegraNegocioException;
import br.edu.ifnmg.PSC.SistemaEstoque_Persistencia.FornecedorDAO;

import br.edu.ifnmg.PSC.SistemaEstoque_Persistencia.ProdutoDAO;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author junior-ormundo
 */
public class testes{ 

    public static void main(String[] args) throws RegraNegocioException {
         
          try{
            FornecedorRepositorio fornecedor = new FornecedorDAO();
            ProdutoRepositorio produto = new ProdutoDAO();
            
            Fornecedor fornecedor1 = fornecedor.Abrir(9);
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            try{
                  Produto produto2 = new Produto();
                  produto2.setId(9);
                  produto2.setDescricao("ProdutoTeste3");
                  produto2.setPorcentagemLucro(10);
                  produto2.setValorCompra(1200);
                  produto2.setQtd(2);
                  produto2.setValidade(df.parse("15/08/2018"));
                  produto2.setFornecedor(fornecedor1);
                  produto2.setValorFinal(produto2.getValorCompra(), produto2.getPorcentagemLucro());
               
                  produto.Salvar(produto2);
                
            } catch (ParseException ex) {
                Logger.getLogger(testes.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(testes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(testes.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}

    
    

