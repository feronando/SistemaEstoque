package br.ufrn.imd.sistemaestoque.domain;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "NivelAcesso")
public class NivelAcesso {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_nivel_acesso")
    private Integer idNivelAcesso;

    @Column(name = "descricao")
    private String descricao;

    @OneToMany(mappedBy = "NivelAcesso")
    private Set<Usuario> usuarios;

    public NivelAcesso()  { /*empty*/ }

    public NivelAcesso(Integer idNivelAcesso, String descricao, Set<Usuario> usuarios) {
        this.idNivelAcesso = idNivelAcesso;
        this.descricao = descricao;
        this.usuarios = usuarios;
    }

    public Integer getIdNivelAcesso() {
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