package org.jesse.dataaccessobjects.impl;

import org.jesse.dataaccessobjects.ProdutoDAO;
import org.jesse.entities.Produto;
import org.jesse.util.ConexaoFactory;
import org.jesse.entities.Produto.ProdutoBuilder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAOImpl implements ProdutoDAO {

    @Override
    public List<Produto> listar(Produto produto) throws SQLException {
        Connection conexao = ConexaoFactory.getConexao();
        StringBuilder sqlBuilder = new StringBuilder("SELECT NOME, QUANTIDADE, PRECO, DATA_VALIDADE, DATA_CADASTRO")
                .append(" FROM mavenwebapparchetype.produto;");
        PreparedStatement preparedStatement = conexao.prepareStatement(sqlBuilder.toString());
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Produto> produtos = new ArrayList<>();

        while (resultSet.next()){
            ProdutoBuilder produtoBuilder = new ProdutoBuilder();
            produtoBuilder.setNome(resultSet.getString("NOME")).setQuantidade(resultSet.getInt("QUANTIDADE"))
                    .setPreco(resultSet.getDouble("PRECO")).setDataValidade(resultSet.getDate("DATA_VALIDADE"))
                    .setDataCadastro(resultSet.getDate("DATA_CADASTRO"));
            produtos.add(new Produto(produtoBuilder));
        }

        conexao.close();

        return produtos;
    }

    @Override
    public Produto consultar(Produto produto) {
        return null;
    }

    @Override
    public boolean inserir(Produto produto) throws SQLException {
        Connection conexao = ConexaoFactory.getConexao();
        StringBuilder sqlBuilder = new StringBuilder("INSERT INTO mavenwebapparchetype.produto")
                .append( " (NOME, QUANTIDADE, PRECO, DATA_VALIDADE, DATA_CADASTRO)")
                .append( " VALUES(?,?,?,?,?);");
        PreparedStatement preparedStatement = conexao.prepareStatement(sqlBuilder.toString());
        preparedStatement.setString(1,produto.getNome());
        preparedStatement.setInt(2, produto.getQuantidade());
        preparedStatement.setDouble(3, produto.getPreco());
        preparedStatement.setDate(4, new java.sql.Date(produto.getDataValidade().getTime()));
        preparedStatement.setDate(5, new java.sql.Date(produto.getDataCadastro().getTime()));

        boolean result = preparedStatement.execute();
        conexao.close();

        return result;
    }

    @Override
    public void alterar(Produto produto) {

    }

    @Override
    public void excluir(Produto produto) {

    }
}
