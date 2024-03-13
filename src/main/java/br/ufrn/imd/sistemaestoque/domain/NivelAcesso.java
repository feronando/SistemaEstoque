package br.ufrn.imd.sistemaestoque.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "NivelAcesso")
public class NivelAcesso {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_nivel_acesso")
    private Integer idNivelAcesso;

    @Column(name = "descricao")
    private String descricao;
}