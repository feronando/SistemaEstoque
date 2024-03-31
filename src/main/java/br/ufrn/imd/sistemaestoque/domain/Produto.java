package br.ufrn.imd.sistemaestoque.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_produto")
    private Long idProduto;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "preco_custo")
    private Double precoCusto;

    @Column(name = "preco_venda")
    private Double precoVenda;

    @OneToMany(mappedBy = "Produto")
    private Set<ProdutoEstoque> produtoEstoque = new HashSet<>();

    public Produto() { /*empty*/ }

    public Produto(String nome, String descricao, Double precoCusto, Double precoVenda, Set<ProdutoEstoque> produtoEstoque) {
        this.nome = nome;
        this.descricao = descricao;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.produtoEstoque = produtoEstoque;
    }

    public Long getidProduto() {
        return idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getprecoCusto() {
        return precoCusto;
    }

    public void setprecoCusto(Double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public Double getprecoVenda() {
        return precoVenda;
    }

    public void setprecoVenda(Double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public Set<ProdutoEstoque> getProdutoEstoque() { return produtoEstoque; }

    public void setProdutoEstoque(Set<ProdutoEstoque> produtoEstoque) { this.produtoEstoque = produtoEstoque; }
}
