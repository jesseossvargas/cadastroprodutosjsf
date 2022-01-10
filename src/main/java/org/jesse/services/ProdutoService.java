package org.jesse.services;

import org.jesse.entities.Produto;

import java.util.List;

public interface ProdutoService {

    List<Produto> listar(Produto produto);
    Produto consultar(Produto produto);
    void inserir(Produto produto);
    void alterar(Produto produto);
    void excluir(Produto produto);

}
