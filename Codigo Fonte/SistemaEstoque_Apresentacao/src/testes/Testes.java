/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import br.edu.ifnmg.PSC.SistemaEstoque.Aplicacao.Pessoa;
import br.edu.ifnmg.PSC.SistemaEstoque.Aplicacao.PessoaRepositorio;
import br.edu.ifnmg.PSC.SistemaEstoque_Persistencia.PessoaDAO;
import java.sql.SQLException;

/**
 *
 * @author junior-ormundo
 */
public class Testes {
    public static void main (String[] args) throws ClassNotFoundException, SQLException{
    
        PessoaRepositorio pessoas = new PessoaDAO();
        
        Pessoa pessoa1 = new Pessoa(0,"João Pimenta","234uy32u4","jpimenta","123456");
        
       pessoas.Salvar(pessoa1);
       
        
    
}
    
}
