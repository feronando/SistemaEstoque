package br.ufrn.imd.sistemaestoque.domain;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Estoque")
public class Estoque {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_estoque")
    private Integer idEstoque;

    @ManyToOne
    @JoinColumn(name = "id_loja")
    private Loja id_loja;

    @OneToMany(mappedBy = "Estoque")
    private Set<ProdutoEstoque> produto_estoque;

    public Estoque() { /*empty*/ }

    public Estoque(Integer idEstoque, Loja id_loja, Set<ProdutoEstoque> produto_estoque) {
        this.idEstoque = idEstoque;
        this.id_loja = id_loja;
        this.produto_estoque = produto_estoque;
    }

    public Integer getIdEstoque() {
        return idEstoque;
    }

    public Loja getId_loja() {
        return id_loja;
    }

    public void setId_loja(Loja id_loja) {
        this.id_loja = id_loja;
    }

    public Set<ProdutoEstoque> getProduto_estoque() {
        return produto_estoque;
    }

    public void setProduto_estoque(Set<ProdutoEstoque> produto_estoque) {
        this.produto_estoque = produto_estoque;
    }
}
