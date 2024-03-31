package br.ufrn.imd.sistemaestoque.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class TipoOperacao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_tipo")
    private Long idTipo;

    @Column(name = "descricao")
    private String descricao;

    @OneToMany(mappedBy = "TipoOperacao")
    private Set<Operacao> operacoes = new HashSet<>();

    public TipoOperacao()  { /*empty*/ }

    public TipoOperacao(String descricao, Set<Operacao> operacoes) {
        this.descricao = descricao;
        this.operacoes = operacoes;
    }

    public Long getIdTipo() {
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
