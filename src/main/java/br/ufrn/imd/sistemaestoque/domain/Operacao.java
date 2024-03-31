package br.ufrn.imd.sistemaestoque.domain;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Operacao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_operacao")
    private Long idOperacao;

    @Column(name = "data_operacao")
    private Date dataOperacao;

    @Column(name = "qtd_alterada")
    private Integer qtdAlterada;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_produto_estoque")
    private ProdutoEstoque produtoEstoque;

    @ManyToOne
    @JoinColumn(name = "id_tipo")
    private TipoOperacao tipo;

    public Operacao()  { /*empty*/ }

    public Operacao(Date dataOperacao, Integer qtdAlterada, Usuario usuario, ProdutoEstoque produtoEstoque, TipoOperacao tipo) {
        this.dataOperacao = dataOperacao;
        this.qtdAlterada = qtdAlterada;
        this.usuario = usuario;
        this.produtoEstoque = produtoEstoque;
        this.tipo = tipo;
    }

    public Long getIdOperacao() {
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

    public ProdutoEstoque getProdutoEstoque() {
        return produtoEstoque;
    }

    public void setProdutoEstoque(ProdutoEstoque produtoEstoque) {
        this.produtoEstoque = produtoEstoque;
    }

    public TipoOperacao getTipo() {
        return tipo;
    }

    public void setTipo(TipoOperacao tipo) {
        this.tipo = tipo;
    }
}
