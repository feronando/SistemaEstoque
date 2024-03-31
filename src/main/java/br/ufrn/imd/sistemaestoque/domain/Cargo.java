package br.ufrn.imd.sistemaestoque.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_cargo")
    private Long idCargo;

    @Column(name = "nome_cargo")
    private String nomeCargo;

    @ManyToMany(mappedBy = "Cargo")
    private Set<Usuario> usuarios = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Cargo_Permissao",
            joinColumns = { @JoinColumn(name = "id_cargo") },
            inverseJoinColumns = { @JoinColumn(name = "id_permissao") })
    private Set<Permissao> permissoes;

    public Cargo() { /*empty*/ }

    public Cargo(Long idCargo, String nomeCargo, Set<Usuario> usuarios, Set<Permissao> permissoes) {
        this.idCargo = idCargo;
        this.nomeCargo = nomeCargo;
        this.usuarios = usuarios;
        this.permissoes = permissoes;
    }

    public Long getIdCargo() {
        return idCargo;
    }

    public String getNomeCargo() {
        return nomeCargo;
    }

    public void setNomeCargo(String nomeCargo) {
        this.nomeCargo = nomeCargo;
    }

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Set<Permissao> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(Set<Permissao> permissoes) {
        this.permissoes = permissoes;
    }
}
