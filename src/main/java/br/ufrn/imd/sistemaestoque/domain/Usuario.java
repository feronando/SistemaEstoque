package br.ufrn.imd.sistemaestoque.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;

    @OneToMany(mappedBy = "Usuario")
    private Set<Operacao> operacoes = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "id_nivel_acesso")
    private NivelAcesso nivelAcesso;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Cargo_Usuario",
            joinColumns = { @JoinColumn(name = "id_usuario") },
            inverseJoinColumns = { @JoinColumn(name = "id_cargo") })
    private Set<Cargo> cargos = new HashSet<>();

    public Usuario()  { /*empty*/ }

    public Usuario(String nome, String email, String senha, Set<Operacao> operacoes, NivelAcesso nivelAcesso, Set<Cargo> cargos) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.operacoes = operacoes;
        this.nivelAcesso = nivelAcesso;
        this.cargos = cargos;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Set<Operacao> getOperacoes() {
        return operacoes;
    }

    public void setOperacoes(Set<Operacao> operacoes) {
        this.operacoes = operacoes;
    }

    public NivelAcesso getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(NivelAcesso nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }

    public Set<Cargo> getCargos() {
        return cargos;
    }

    public void setCargos(Set<Cargo> cargos) {
        this.cargos = cargos;
    }
}
