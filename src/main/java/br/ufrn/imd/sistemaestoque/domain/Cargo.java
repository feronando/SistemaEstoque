package br.ufrn.imd.sistemaestoque.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "Cargo")
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_cargo")
    private Integer idCargo;

    @Column(name = "nome_cargo")
    private String nomeCargo;
}
