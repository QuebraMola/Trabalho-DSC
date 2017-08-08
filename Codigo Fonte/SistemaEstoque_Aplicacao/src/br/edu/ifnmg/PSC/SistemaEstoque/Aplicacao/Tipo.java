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
public enum Tipo {
    
    ADMINISTRADOR(1,"Administrador"),
    USUARIO(2, "Usuario");

    
    private int id;
    private String descricao;

    private Tipo(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
    
    
    public static Tipo Abrir(int id){
        for(Tipo t : Tipo.values())
            if(id == t.getId())
                return t;
        return null;
    }
    
    
}
