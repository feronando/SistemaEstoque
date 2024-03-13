package br.ufrn.imd.sistemaestoque.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "Cargo_Usuario")
public class CargoUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_cargo_usuario")
    private Integer idCargoUsuario;
}
