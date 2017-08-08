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
public class Venda implements Entidade {


    private int id;
    private Date dataVenda;
    private double valorVenda;
    private Cliente cliente;
    private Usuario funcionario;

    public Venda(int id, Date dataVenda, double valorVenda, Cliente cliente, Usuario funcionario) {
        this.id = id;
        this.dataVenda = dataVenda;
        this.valorVenda = valorVenda;
        this.cliente = cliente;
        this.funcionario = funcionario;
    }

   

    public Venda() {
    }
    
    

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) throws RegraNegocioException {
      Date data = new Date(System.currentTimeMillis());
        if(dataVenda.compareTo(data)>0)
            throw new RegraNegocioException("Data Inválida !!!");
        this.dataVenda = dataVenda;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) throws RegraNegocioException {
        if(valorVenda<0)
                throw new RegraNegocioException("Nunca o Valor da venda pode ser Negativo");
        this.valorVenda = valorVenda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Usuario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Usuario funcionario) {
        this.funcionario = funcionario;
    }
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.id;
        hash = 17 * hash + Objects.hashCode(this.dataVenda);
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.valorVenda) ^ (Double.doubleToLongBits(this.valorVenda) >>> 32));
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
        final Venda other = (Venda) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.valorVenda) != Double.doubleToLongBits(other.valorVenda)) {
            return false;
        }
        if (!Objects.equals(this.dataVenda, other.dataVenda)) {
            return false;
        }
        return true;
    }
    
    
}
