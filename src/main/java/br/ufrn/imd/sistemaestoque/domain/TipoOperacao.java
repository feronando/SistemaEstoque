package br.ufrn.imd.sistemaestoque.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "TipoOperacao")
public class TipoOperacao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_tipo")
    private Integer idTipo;

    @Column(name = "descricao")
    private String descricao;
}
