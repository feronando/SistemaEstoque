package br.ufrn.imd.sistemaestoque.domain;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Estoque {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_estoque")
    private Long idEstoque;

    @ManyToOne
    @JoinColumn(name = "id_loja")
    private Loja idLoja;

    @OneToMany(mappedBy = "Estoque")
    private Set<ProdutoEstoque> produtoEstoque;

    public Estoque() { /*empty*/ }

    public Estoque(Loja idLoja, Set<ProdutoEstoque> produtoEstoque) {
        this.idLoja = idLoja;
        this.produtoEstoque = produtoEstoque;
    }

    public Long getIdEstoque() {
        return idEstoque;
    }

    public Loja getIdLoja() {
        return idLoja;
    }

    public void setIdLoja(Loja idLoja) {
        this.idLoja = idLoja;
    }

    public Set<ProdutoEstoque> getProdutoEstoque() {
        return produtoEstoque;
    }

    public void setProdutoEstoque(Set<ProdutoEstoque> produtoEstoque) {
        this.produtoEstoque = produtoEstoque;
    }
}
