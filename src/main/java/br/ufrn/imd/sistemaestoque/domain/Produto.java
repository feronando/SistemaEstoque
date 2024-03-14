package br.ufrn.imd.sistemaestoque.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_produto")
    private Integer idProduto;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "preco_custo")
    private Double precoCusto;

    @Column(name = "preco_venda")
    private Double precoVenda;

    @OneToMany(mappedBy = "Produto")
    private Set<ProdutoEstoque> produto_estoque = new HashSet<>();

    public Produto() { /*empty*/ }

    public Produto(Integer idProduto, String nome, String descricao, Double precoCusto, Double precoVenda, Set<ProdutoEstoque> produto_estoque) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.descricao = descricao;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.produto_estoque = produto_estoque;
    }

    public Integer getidProduto() {
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

    public Set<ProdutoEstoque> getProduto_estoque() { return produto_estoque; }

    public void setProduto_estoque(Set<ProdutoEstoque> produto_estoque) { this.produto_estoque = produto_estoque; }
}
