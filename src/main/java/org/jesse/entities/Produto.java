package org.jesse.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@NoArgsConstructor
public class Produto {

    public Produto(ProdutoBuilder produtoBuilder){
        this.nome = produtoBuilder.nome;
        this.quantidade = produtoBuilder.quantidade;
        this.preco = produtoBuilder.preco;
        this.dataCadastro = produtoBuilder.dataCadastro;
        this.dataValidade = produtoBuilder.dataValidade;
    }

    @Getter @Setter
    private Integer id;

    @Getter @Setter
    private String nome;

    @Getter @Setter
    private Integer quantidade;

    @Getter @Setter
    private Double preco;

    @Getter @Setter
    private Date dataValidade;

    @Getter @Setter
    private Date dataCadastro;

    public static class ProdutoBuilder{

        private Integer id;
        private String nome;
        private Integer quantidade;
        private Double preco;
        private Date dataValidade;
        private Date dataCadastro;

        public Integer getId() {
            return id;
        }

        public ProdutoBuilder setId(Integer id) {
            this.id = id;
            return this;
        }

        public String getNome() {
            return nome;
        }

        public ProdutoBuilder setNome(String nome) {
            this.nome = nome;
            return this;
        }

        public Integer getQuantidade() {
            return quantidade;
        }

        public ProdutoBuilder setQuantidade(Integer quantidade) {
            this.quantidade = quantidade;
            return this;
        }

        public Double getPreco() {
            return preco;
        }

        public ProdutoBuilder setPreco(Double preco) {
            this.preco = preco;
            return this;
        }

        public Date getDataValidade() {
            return dataValidade;
        }

        public ProdutoBuilder setDataValidade(Date dataValidade) {
            this.dataValidade = dataValidade;
            return this;
        }

        public Date getDataCadastro() {
            return dataCadastro;
        }

        public ProdutoBuilder setDataCadastro(Date dataCadastro) {
            this.dataCadastro = dataCadastro;
            return this;
        }
    }

}
