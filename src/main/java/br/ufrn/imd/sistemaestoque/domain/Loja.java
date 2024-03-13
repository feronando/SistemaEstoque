package br.ufrn.imd.sistemaestoque.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "Loja")
public class Loja {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_loja")
    private Integer idLoja;

    @Column(name = "nome")
    private String nome;

    @Column(name = "endereco")
    private String endereco;

    public Loja() { /*empty*/ }

    public Loja(Integer idLoja, String nome, String endereco) {
        this.idLoja = idLoja;
        this.nome = nome;
        this.endereco = endereco;
    }

    public Integer getIdLoja() {
        return idLoja;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
