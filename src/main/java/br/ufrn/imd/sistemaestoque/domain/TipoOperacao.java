package br.ufrn.imd.sistemaestoque.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TipoOperacao")
public class TipoOperacao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_tipo")
    private Integer idTipo;

    @Column(name = "descricao")
    private String descricao;

    @OneToMany(mappedBy = "TipoOperacao")
    private Set<Operacao> operacoes = new HashSet<>();

    public TipoOperacao()  { /*empty*/ }

    public TipoOperacao(Integer idTipo, String descricao, Set<Operacao> operacoes) {
        this.idTipo = idTipo;
        this.descricao = descricao;
        this.operacoes = operacoes;
    }

    public Integer getIdTipo() {
        return idTipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Set<Operacao> getOperacoes() {
        return operacoes;
    }

    public void setOperacoes(Set<Operacao> operacoes) {
        this.operacoes = operacoes;
    }
}
