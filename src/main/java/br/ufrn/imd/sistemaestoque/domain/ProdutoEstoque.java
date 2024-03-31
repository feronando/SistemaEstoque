package br.ufrn.imd.sistemaestoque.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class ProdutoEstoque {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_produto_estoque")
    private Long idProdutoEstoque;

    @Column(name = "qtd_produto")
    private Integer qtdProduto;

    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "id_estoque")
    private Estoque estoque;

    @OneToMany(mappedBy = "Produto_Estoque")
    private Set<Operacao> operacoes = new HashSet<>();

    public ProdutoEstoque() { /*empty*/ }

    public ProdutoEstoque(Integer qtdProduto, Produto produto, Estoque estoque, Set<Operacao> operacoes) {
        this.qtdProduto = qtdProduto;
        this.produto = produto;
        this.estoque = estoque;
        this.operacoes = operacoes;
    }

    public Long getIdProdutoEstoque() {
        return idProdutoEstoque;
    }

    public Integer getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(Integer qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    public Set<Operacao> getOperacoes() { return operacoes; }

    public void setOperacoes(Set<Operacao> operacoes) { this.operacoes = operacoes; }
}
