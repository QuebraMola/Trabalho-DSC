/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.PSC.SistemaEstoque.Aplicacao;

/**
 *
 * @author junior-ormundo
 */
public interface VendaRepositorio extends Repositorio<Venda>{
    public int buscarUltimoId();
    public boolean ExcluirItens(int idvenda);

    
}
