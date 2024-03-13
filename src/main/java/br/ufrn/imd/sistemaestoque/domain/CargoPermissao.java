package br.ufrn.imd.sistemaestoque.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "Cargo_Permissao")
public class CargoPermissao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_cargo_permissao")
    private Integer idCargoPermissao;
}
