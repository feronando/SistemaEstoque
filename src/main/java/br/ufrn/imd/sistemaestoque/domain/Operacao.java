package br.ufrn.imd.sistemaestoque.domain;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Operacao")
public class Operacao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_operacao")
    private Integer idOperacao;

    @Column(name = "data_operacao")
    private Date dataOperacao;

    @Column(name = "qtd_alterada")
    private Integer qtdAlterada;
}
