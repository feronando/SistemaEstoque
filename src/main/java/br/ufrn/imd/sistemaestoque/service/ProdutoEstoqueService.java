package br.ufrn.imd.sistemaestoque.service;

import br.ufrn.imd.sistemaestoque.domain.ProdutoEstoque;
import br.ufrn.imd.sistemaestoque.repository.ProdutoEstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoEstoqueService {
    @Autowired
    private ProdutoEstoqueRepository produtoEstoqueRepository;

    public List<ProdutoEstoque> getProdutosEstoque() {
        return (List<ProdutoEstoque>) produtoEstoqueRepository.findAll();
    }

    public ProdutoEstoque getProdutoEstoqueById(Long id) {
        return produtoEstoqueRepository.findById(id).orElse(null);
    }

    public ProdutoEstoque createProdutoEstoque(ProdutoEstoque produtoEstoque) {
        return produtoEstoqueRepository.save(produtoEstoque);
    }

    public ProdutoEstoque updateProdutoEstoque(Long id, ProdutoEstoque updatedProdutoEstoque) {
        return produtoEstoqueRepository.findById(id).map(produtoEstoque -> {
            produtoEstoque.setQtdProduto(updatedProdutoEstoque.getQtdProduto());
            produtoEstoque.setProduto(updatedProdutoEstoque.getProduto());
            produtoEstoque.setEstoque(updatedProdutoEstoque.getEstoque());
            produtoEstoque.setOperacoes(updatedProdutoEstoque.getOperacoes());
            return produtoEstoqueRepository.save(produtoEstoque);
        }).orElseGet(() -> {
            return createProdutoEstoque(updatedProdutoEstoque);
        });
    }

    public void deleteProdutoEstoque(Long id) {
        ProdutoEstoque produtoEstoque = getProdutoEstoqueById(id);
        produtoEstoqueRepository.delete(produtoEstoque);
    }
}
