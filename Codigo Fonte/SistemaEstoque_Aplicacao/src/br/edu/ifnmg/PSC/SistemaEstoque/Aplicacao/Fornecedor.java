/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.PSC.SistemaEstoque.Aplicacao;

import static br.edu.ifnmg.PSC.SistemaEstoque.Aplicacao.Validacoes.validarCnpj;
import java.util.Objects;

/**
 *
 * @author junior-ormundo
 */
public class Fornecedor implements Entidade {

    private int id;
    private String nome;
    private String telefone;
    private String cnpj;

    public Fornecedor(int id, String nome, String telefone, String cnpj) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.cnpj = cnpj;
    }

    public Fornecedor() {
     }


    public String getNome()  {
        return nome;
    }

    public void setNome(String nome)throws RegraNegocioException {
        if(nome.length()< 5)
               throw new RegraNegocioException("O Nome do Fornecedor deve ter mais de 5 caracteres!");        
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) throws RegraNegocioException {
        if(telefone.contains("~[a-z]") || telefone.length() > 8)
            throw new RegraNegocioException("Informe um Telefone Válido");
        this.telefone = telefone;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) throws RegraNegocioException {
        if(!validarCnpj(cnpj))
            throw new RegraNegocioException("Informe um Cnpj válido!");
        this.cnpj = cnpj;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.id;
        hash = 13 * hash + Objects.hashCode(this.nome);
        hash = 13 * hash + Objects.hashCode(this.telefone);
        hash = 13 * hash + Objects.hashCode(this.cnpj);
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
        final Fornecedor other = (Fornecedor) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (!Objects.equals(this.cnpj, other.cnpj)) {
            return false;
        }
        return true;
    }
    
    
    
    @Override
    public void setId(int id) {
        this.id = id;}

    @Override
    public int getId() {
        return id;
    }
    
}
