package org.jesse.dataaccessobjects;

import org.jesse.entities.Produto;

import java.sql.SQLException;
import java.util.List;

public interface ProdutoDAO {

    List<Produto> listar(Produto produto) throws SQLException;
    Produto consultar(Produto produto);
    boolean inserir(Produto produto) throws SQLException;
    void alterar(Produto produto);
    void excluir(Produto produto);

}
