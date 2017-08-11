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
    private double valorCompra;
    private int porcentagemLucro;
    private int qtd;
    private Date validade;
    private double valorFinal;

    public Produto(int id, String descricao, Fornecedor fornecedor, double valorCompra, int porcentagemLucro, int qtd, Date validade, double valorFinal) {
        this.id = id;
        this.descricao = descricao;
        this.fornecedor = fornecedor;
        this.valorCompra = valorCompra;
        this.porcentagemLucro = porcentagemLucro;
        this.qtd = qtd;
        this.validade = validade;
        this.valorFinal = valorFinal;
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

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public int getPorcentagemLucro() {
        return porcentagemLucro;
    }

    public void setPorcentagemLucro(int porcentagemLucro) throws RegraNegocioException {
        if(porcentagemLucro < 0)
            throw new RegraNegocioException("A Porcentagem de Lucro nunca deve ser Negativa!");
        this.porcentagemLucro = porcentagemLucro;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) throws RegraNegocioException {
        if(qtd < 0)
            throw new RegraNegocioException("A Quantidade nunca deve ser Negativa!");
        this.qtd = qtd;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) throws RegraNegocioException{
        Date data = new Date(System.currentTimeMillis());
        if(validade.compareTo(data)<0)
            throw new RegraNegocioException("Data Inválida !!!"); 
        this.validade = validade;
    }
    public void setValorFinal(double valorCompra, int porcentagemLucro){
        this.valorFinal = calculaValorFinal(valorCompra,porcentagemLucro);
    
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.id;
        hash = 89 * hash + Objects.hashCode(this.descricao);
        hash = 89 * hash + Objects.hashCode(this.fornecedor);
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.valorCompra) ^ (Double.doubleToLongBits(this.valorCompra) >>> 32));
        hash = 89 * hash + this.porcentagemLucro;
        hash = 89 * hash + this.qtd;
        hash = 89 * hash + Objects.hashCode(this.validade);
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.valorFinal) ^ (Double.doubleToLongBits(this.valorFinal) >>> 32));
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
        if (Double.doubleToLongBits(this.valorCompra) != Double.doubleToLongBits(other.valorCompra)) {
            return false;
        }
        if (this.porcentagemLucro != other.porcentagemLucro) {
            return false;
        }
        if (this.qtd != other.qtd) {
            return false;
        }
        if (Double.doubleToLongBits(this.valorFinal) != Double.doubleToLongBits(other.valorFinal)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.fornecedor, other.fornecedor)) {
            return false;
        }
        if (!Objects.equals(this.validade, other.validade)) {
            return false;
        }
        return true;
    }

    private double calculaValorFinal(double valorCompra, int porcentagemLucro) {
        return valorCompra+(valorCompra*porcentagemLucro/100);
    }

    @Override
    public String toString() {
        return  descricao;
    }
   
    
}
