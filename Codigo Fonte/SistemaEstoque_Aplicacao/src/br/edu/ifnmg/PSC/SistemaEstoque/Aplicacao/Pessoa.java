/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.PSC.SistemaEstoque.Aplicacao;

import java.util.Objects;

/**
 *
 * @author junior-ormundo
 */
public class Pessoa implements Entidade {
    
   private int id;
   private String nomeCompleto;
   private String nomeUsuario;
   private String cpf;
   private String senha;
   private tipoPessoa tipo;

    public Pessoa(int id, String nomeCompleto, String cpf, String nomeUsuario, String senha, tipoPessoa tipo) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.tipo = tipo;
    }

    public Pessoa() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) throws RegraNegocioException {
        if(cpf.contains("^[a-z]"))
             throw new RegraNegocioException("O Cpf deve conter Apenas Números !!!");
        this.cpf = cpf;
        
    }
    

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }
 

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) throws RegraNegocioException {
        if(nomeCompleto.length()< 5)
               throw new RegraNegocioException("O Nome Completo deve ter mais de 5 caracteres!");        
        this.nomeCompleto = nomeCompleto;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }
    
    
    public void setNomeUsuario(String nomeUsuario) throws RegraNegocioException {
        if(nomeUsuario.length()< 3)
               throw new RegraNegocioException("O Nome de Usuario deve ter mais de 3 caracteres!");        
         this.nomeUsuario=nomeUsuario;
       }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) throws RegraNegocioException {
        if(senha.length()< 3)
               throw new RegraNegocioException("A Senha deve ter mais de 3 caracteres!");        
        this.senha = senha;
    }

    public tipoPessoa getTipo() {
        return tipo;
    }

    public void setTipo(tipoPessoa tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.id;
        hash = 53 * hash + Objects.hashCode(this.nomeCompleto);
        hash = 53 * hash + Objects.hashCode(this.nomeUsuario);
        hash = 53 * hash + Objects.hashCode(this.cpf);
        hash = 53 * hash + Objects.hashCode(this.senha);
        hash = 53 * hash + Objects.hashCode(this.tipo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nomeCompleto, other.nomeCompleto)) {
            return false;
        }
        if (!Objects.equals(this.nomeUsuario, other.nomeUsuario)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        if (this.tipo != other.tipo) {
            return false;
        }
        return true;
    }

    
   
  
}


