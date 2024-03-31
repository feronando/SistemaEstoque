package br.ufrn.imd.sistemaestoque.domain;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Permissao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_permissao")
    private Long idPermissao;

    @Column(name = "descricao")
    private String descricao;

    @ManyToMany(mappedBy = "Permissao")
    private Set<Cargo> cargos;

    public Permissao()  { /*empty*/ }

    public Permissao(String descricao, Set<Cargo> cargos) {
        this.descricao = descricao;
        this.cargos = cargos;
    }

    public Long getIdPermissao() {
        return idPermissao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Set<Cargo> getCargos() {
        return cargos;
    }

    public void setCargos(Set<Cargo> cargos) {
        this.cargos = cargos;
    }
}
