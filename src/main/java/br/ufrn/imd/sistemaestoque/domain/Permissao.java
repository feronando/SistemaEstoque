package br.ufrn.imd.sistemaestoque.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "Permissao")
public class Permissao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_permissao")
    private Integer idPermissao;

    @Column(name = "descricao")
    private String descricao;
}
