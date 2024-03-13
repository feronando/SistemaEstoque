package br.ufrn.imd.sistemaestoque.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "Produto_Estoque")
public class ProdutoEstoque {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_produto_estoque")
    private Integer idProdutoEstoque;

    @Column(name = "qtd_produto")
    private Integer qtdProduto;
}
