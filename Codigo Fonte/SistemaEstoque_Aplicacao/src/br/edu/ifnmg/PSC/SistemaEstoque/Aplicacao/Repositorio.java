/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.PSC.SistemaEstoque.Aplicacao;

import java.util.List;

/**
 *
 * @author junior-ormundo
 * @param <Q>
 */
public interface Repositorio <Q extends Entidade> {
   
    public boolean Salvar(Q obj);
    
    public boolean Apagar(Q obj);
    
    public Q Abrir(int id);
    
    public List<Q> Buscar(Q filtro);
}
   

