/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.PSC.SistemaEstoque.Aplicacao;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author junior-ormundo
 */
public class Produto implements Entidade{
    
    private int id;
    private String descricao;
    private Fornecedor fornecedor;
    private float valorCompra;
    private int porcentagemLucro;
    private int qtd;
    private Date validade;
    private float valorFinal;
    
    public Produto(int id, String descricao, Fornecedor fornecedor, float valorCompra, int porcentagemLucro, int qtd, Date validade) {
        this.id = id;
        this.descricao = descricao;
        this.fornecedor = fornecedor;
        this.valorCompra = valorCompra;
        this.porcentagemLucro = porcentagemLucro;
        this.qtd = qtd;
        this.validade = validade;
    }

    public Produto() {
        
    }

    @Override
    public void setId(int id) {
        this.id=id;
    }

    @Override
    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(float valorCompra) {
        this.valorCompra = valorCompra;
    }

    public int getPorcentagemLucro() {
        return porcentagemLucro;
    }

    public void setPorcentagemLucro(int porcentagemLucro) {
        this.porcentagemLucro = porcentagemLucro;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }
    public void setValorFinal(float valorCompra, int porcentagemLucro){
        this.valorFinal = valorCompra+(valorCompra*porcentagemLucro/100);
    
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public float getValorFinal() {
        return valorFinal;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
   
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.id;
        hash = 43 * hash + Objects.hashCode(this.descricao);
        hash = 43 * hash + Float.floatToIntBits(this.valorCompra);
        hash = 43 * hash + this.porcentagemLucro;
        hash = 43 * hash + this.qtd;
        hash = 43 * hash + Objects.hashCode(this.validade);
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
        final Produto other = (Produto) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Float.floatToIntBits(this.valorCompra) != Float.floatToIntBits(other.valorCompra)) {
            return false;
        }
        if (this.porcentagemLucro != other.porcentagemLucro) {
            return false;
        }
        if (this.qtd != other.qtd) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.validade, other.validade)) {
            return false;
        }
        return true;
    }
    
}
