package br.edu.ifnmg.PSC.SistemaEstoque.Aplicacao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.edu.ifnmg.PSC.SistemaEstoque.Aplicacao.Pessoa;
import br.edu.ifnmg.PSC.SistemaEstoque.Aplicacao.RegraNegocioException;
import static br.edu.ifnmg.PSC.SistemaEstoque.Aplicacao.Validacoes.validarCpf;
import java.util.Objects;

/**
 *
 * @author junior-ormundo
 */
public class Usuario extends Pessoa implements Entidade{
    
   private String nomeUsuario;
   private Tipo tipo;
   private String senha;

    public Usuario( int id,String nomeUsuario, String senha,String nomeCompleto, String cpf, Tipo tipo) {
        super(id, nomeCompleto, cpf);
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.tipo = tipo;
    }


    public Usuario() {
        super();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.nomeUsuario);
        hash = 37 * hash + Objects.hashCode(this.senha);
        hash = 37 * hash + Objects.hashCode(this.tipo);
        
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.nomeUsuario, other.nomeUsuario)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        return true;
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

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    

}


