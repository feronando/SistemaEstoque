package br.ufrn.imd.sistemaestoque.domain;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Operacao")
public class Operacao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_operacao")
    private Integer idOperacao;

    @Column(name = "data_operacao")
    private Date dataOperacao;

    @Column(name = "qtd_alterada")
    private Integer qtdAlterada;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_produto_estoque")
    private ProdutoEstoque produto_estoque;

    @ManyToOne
    @JoinColumn(name = "id_tipo")
    private TipoOperacao tipo;

    public Operacao()  { /*empty*/ }

    public Operacao(Integer idOperacao, Date dataOperacao, Integer qtdAlterada, Usuario usuario, ProdutoEstoque produto_estoque, TipoOperacao tipo) {
        this.idOperacao = idOperacao;
        this.dataOperacao = dataOperacao;
        this.qtdAlterada = qtdAlterada;
        this.usuario = usuario;
        this.produto_estoque = produto_estoque;
        this.tipo = tipo;
    }

    public Integer getIdOperacao() {
        return idOperacao;
    }

    public Date getDataOperacao() {
        return dataOperacao;
    }

    public void setDataOperacao(Date dataOperacao) {
        this.dataOperacao = dataOperacao;
    }

    public Integer getQtdAlterada() {
        return qtdAlterada;
    }

    public void setQtdAlterada(Integer qtdAlterada) {
        this.qtdAlterada = qtdAlterada;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ProdutoEstoque getProduto_estoque() {
        return produto_estoque;
    }

    public void setProduto_estoque(ProdutoEstoque produto_estoque) {
        this.produto_estoque = produto_estoque;
    }

    public TipoOperacao getTipo() {
        return tipo;
    }

    public void setTipo(TipoOperacao tipo) {
        this.tipo = tipo;
    }
}
