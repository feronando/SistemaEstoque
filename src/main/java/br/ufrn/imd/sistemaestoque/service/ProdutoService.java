package br.ufrn.imd.sistemaestoque.service;

import br.ufrn.imd.sistemaestoque.domain.Produto;
import br.ufrn.imd.sistemaestoque.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> getProdutos() {
        return (List<Produto>) produtoRepository.findAll();
    }

    public Produto getProdutoById(Long id) {
        return produtoRepository.findById(id).orElse(null);
    }

    public Produto createProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto updateProduto(Long id, Produto updatedProduto) {
        return produtoRepository.findById(id).map(produto -> {
            produto.setNome(updatedProduto.getNome());
            produto.setDescricao(updatedProduto.getDescricao());
            produto.setprecoCusto(updatedProduto.getprecoCusto());
            produto.setprecoVenda(updatedProduto.getprecoVenda());
            produto.setProdutoEstoque(updatedProduto.getProdutoEstoque());
            return produtoRepository.save(produto);
        }).orElseGet(() -> {
            return createProduto(updatedProduto);
        });
    }

    public void deleteProduto(Long id) {
        Produto produto = getProdutoById(id);
        produtoRepository.delete(produto);
    }
}
