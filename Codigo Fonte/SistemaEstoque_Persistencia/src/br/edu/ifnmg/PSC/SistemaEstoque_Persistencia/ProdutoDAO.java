/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.PSC.SistemaEstoque_Persistencia;

import br.edu.ifnmg.PSC.SistemaEstoque.Aplicacao.Produto;
import br.edu.ifnmg.PSC.SistemaEstoque.Aplicacao.ProdutoRepositorio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

/**
 *
 * @author junior-ormundo
 */
public class ProdutoDAO extends DAOGenerico<Produto> implements ProdutoRepositorio {

    public ProdutoDAO() throws ClassNotFoundException, SQLException {
        super();
        fornecedor = new FornecedorDAO();
      
    
    }

    @Override
    protected String getConsultaInsert() {
         return "insert into produtos(descricao,fornecedor,valorCompra,porcentagemLucro,qtd,validade,valorFinal) values (?,?,?,?,?,?) ";
    }

    @Override
    protected String getConsultaUpdate() {
         return "update produtos set descricao=?, fornecedor=?, valorCompra=?, porcentagemlucro=?,qtd=?,validade=? valorFinal=? where id = ?";
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
        if(filtro.getId() > 0)
            this.adicionarFiltro("id", filtro.getId());
        
        if(filtro.getDescricao() != null && !filtro.getDescricao().isEmpty())
            this.adicionarFiltro("descricao", filtro.getDescricao());
        
        if(filtro.getFornecedor() != null)
            this.adicionarFiltro("fornecedor", filtro.getFornecedor().getId());
          
        if(filtro.getValorCompra() > 0 )
            this.adicionarFiltro("valorCompra", filtro.getValorCompra());
        
        if(filtro.getPorcentagemLucro() > 0 )
            this.adicionarFiltro("porcentagemLucro", filtro.getPorcentagemLucro());
        
        if(filtro.getQtd() > 0 )
            this.adicionarFiltro("qtd", filtro.getQtd());
        
         SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
         
         this.where = "validade" + df.format(filtro.getValidade() != null) ;
         
        if(filtro.getValorFinal() > 0 )
            this.adicionarFiltro("valorFinal", filtro.getValorFinal());
     
      
    }

    @Override
    protected void setParametros(PreparedStatement sql, Produto obj) {
        
    }
    
    FornecedorDAO fornecedor;
    
    @Override
    protected Produto setDados(ResultSet resultado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
