/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.PSC.SistemaEstoque_Persistencia;

import br.edu.ifnmg.PSC.SistemaEstoque.Aplicacao.Fornecedor;
import br.edu.ifnmg.PSC.SistemaEstoque.Aplicacao.Produto;
import br.edu.ifnmg.PSC.SistemaEstoque.Aplicacao.ProdutoRepositorio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author junior-ormundo
 */
public class ProdutoDAO extends DAOGenerico<Produto> implements ProdutoRepositorio {

    public ProdutoDAO() throws ClassNotFoundException, SQLException {
        super();
    }
    
    

 @Override
    protected String getConsultaInsert() {
       return "insert into produtos(descricao,fornecedor,valorCompra,porcentagemLucro,qtd,validade) values (?,?,?,?,?,?) ";
  }

    @Override
    protected String getConsultaUpdate() {
        return "update produtos descricao=?,fornecedor=?,valorCompra=?,porcentagemLucro=?,qtd=?,validade=? where id = ?";
      }

    @Override
    protected String getConsultaDelete() {
        return "delete from produtos where id=? ";
    }

    @Override
    protected String getConsultaAbrir() {
        return "select id,descricao,fornecedor,valorCompra,porcentagemLucro,qtd,validade,valorFinal from produtos where id=?";

    }

    @Override
    protected String getConsultaBuscar() {
        return "select id,descricao,fornecedor,valorCompra,porcentagemLucro,qtd,validade,valorFinal from produtos";
    }

    @Override
    protected void setBuscaFiltros(Produto filtro) {
        
          SimpleDateFormat df = new SimpleDateFormat("dd-mm-yyyy");
        
        if(filtro.getValidade() != null)
            this.adicionarFiltro("validade",df.format(filtro.getValidade()));
        
        if(filtro.getId() > 0)
            this.adicionarFiltro("id", filtro.getId());
        
        if(filtro.getDescricao() != null && !filtro.getDescricao().isEmpty())
            this.adicionarFiltro("descricao", filtro.getDescricao());
        
        if(filtro.getFornecedor() != null)
            this.adicionarFiltro("fornecedor", filtro.getFornecedor().getId());
        
        if(filtro.getValorCompra() > 0)
            this.adicionarFiltro("valorCompra", filtro.getValorCompra());
        
        if(filtro.getPorcentagemLucro() > 0)
            this.adicionarFiltro("porcentagemLucro", filtro.getPorcentagemLucro());
        
        if(filtro.getQtd() > 0)
            this.adicionarFiltro("qtd", filtro.getQtd());
        
          
       }

    @Override
    protected void setParametros(PreparedStatement sql, Produto obj) {
         try {
            
            sql.setString(1, obj.getDescricao());
            sql.setString(2, obj.getFornecedor().getNome());
            sql.setFloat(3,obj.getValorCompra());
            sql.setInt(4,obj.getPorcentagemLucro());
            sql.setInt(5,obj.getQtd());
            sql.setFloat(6, obj.getValorFinal());
          
            if(obj.getId() > 0)
                sql.setInt(7, obj.getId());
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        
        }
    
    }
    
    FornecedorDAO fornecedor;
   
    @Override
    protected Produto setDados(ResultSet resultado) {
        try {

            Produto obj = new Produto();
            obj.setId(resultado.getInt("id"));
            obj.setDescricao(resultado.getString("descricao"));
            obj.setFornecedor(fornecedor.Abrir(resultado.getInt("fornecedor")));
            obj.setValorCompra(resultado.getFloat("ValorCompra"));
            obj.setPorcentagemLucro(resultado.getInt("porcentagemLucro"));
            obj.setQtd(resultado.getInt("qtd"));
            obj.setValidade(resultado.getTime("validade"));
            obj.setValorFinal(resultado.getFloat("valorCompra"),resultado.getInt("porcentagemLucro"));
            
            return obj;
            
        } catch (Exception ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }    

   
}