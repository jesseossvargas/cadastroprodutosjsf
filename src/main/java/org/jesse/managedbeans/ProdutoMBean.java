package org.jesse.managedbeans;

import lombok.Getter;
import lombok.Setter;
import org.jesse.dataaccessobjects.ProdutoDAO;
import org.jesse.dataaccessobjects.impl.ProdutoDAOImpl;
import org.jesse.entities.Produto;
import org.jesse.entities.Produto.ProdutoBuilder;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;


@ManagedBean(name = "produtoMBean")
@ViewScoped
public class ProdutoMBean {

    @Getter @Setter
    private String nome;

    @Getter @Setter
    private Integer quantidade;

    @Getter @Setter
    private String precoString;

    private Double preco;

    @Getter @Setter
    private Date dataValidade;

    @Getter @Setter
    private Date dataCadastro;

    @Getter @Setter
    private boolean incluiu;

    @Getter @Setter
    private boolean exibirListagem;

    public void salvar() throws SQLException {
        preco = Double.parseDouble(precoString);
        incluiu = false;
        Produto produto = getProduto();
        ProdutoDAO produtoDAO = new ProdutoDAOImpl();

        produtoDAO.inserir(produto);
        atualizarAposInclusaoSucesso();
    }

    private Produto getProduto(){
        ProdutoBuilder produtoBuilder = new ProdutoBuilder();
        Produto produto = new Produto(produtoBuilder.setNome(nome).setQuantidade(quantidade).setPreco(preco).setDataValidade(dataValidade).
                setDataCadastro(dataCadastro));

        return produto;
    }

    private void atualizarAposInclusaoSucesso(){
        limparValores();
        incluiu = true;
    }

    private void limparValores(){
        precoString = null;
        preco = null;
        dataCadastro = null;
        dataValidade = null;
        nome = null;
        quantidade = null;
    }

    public List<Produto> getProdutos() throws SQLException {
        exibirListagem = true;
        incluiu = false;
        return new ProdutoDAOImpl().listar(getProduto());
    }

    public void limparLista(){
        exibirListagem = false;
    }
}