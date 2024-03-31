package br.ufrn.imd.sistemaestoque.controller;

import br.ufrn.imd.sistemaestoque.domain.ProdutoEstoque;
import br.ufrn.imd.sistemaestoque.service.ProdutoEstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto-estoque")
public class ProdutoEstoqueController {
    @Autowired
    private ProdutoEstoqueService produtoEstoqueService;

    @GetMapping
    public List<ProdutoEstoque> getProdutosEstoque() {
        return produtoEstoqueService.getProdutosEstoque();
    }

    @GetMapping("/{id}")
    public ProdutoEstoque getProdutoEstoqueById(@PathVariable Long id) {
        return produtoEstoqueService.getProdutoEstoqueById(id);
    }

    @PostMapping
    public ProdutoEstoque createProdutoEstoque(@RequestBody ProdutoEstoque produtoEstoque) {
        return produtoEstoqueService.createProdutoEstoque(produtoEstoque);
    }

    @PutMapping("/{id}")
    public ProdutoEstoque updateProdutoEstoque(@PathVariable Long id, @RequestBody ProdutoEstoque updatedProdutoEstoque) {
        return produtoEstoqueService.updateProdutoEstoque(id, updatedProdutoEstoque);
    }

    @DeleteMapping("/{id}")
    public void deleteProdutoEstoque(@PathVariable Long id) {
        produtoEstoqueService.deleteProdutoEstoque(id);
    }
}
