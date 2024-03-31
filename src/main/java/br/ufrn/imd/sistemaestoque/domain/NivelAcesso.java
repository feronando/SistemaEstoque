package br.ufrn.imd.sistemaestoque.domain;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class NivelAcesso {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_nivel_acesso")
    private Long idNivelAcesso;

    @Column(name = "descricao")
    private String descricao;

    @OneToMany(mappedBy = "NivelAcesso")
    private Set<Usuario> usuarios;

    public NivelAcesso()  { /*empty*/ }

    public NivelAcesso(String descricao, Set<Usuario> usuarios) {
        this.descricao = descricao;
        this.usuarios = usuarios;
    }

    public Long getIdNivelAcesso() {
        return idNivelAcesso;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}