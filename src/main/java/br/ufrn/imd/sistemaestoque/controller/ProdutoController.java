package br.ufrn.imd.sistemaestoque.controller;

import br.ufrn.imd.sistemaestoque.domain.Produto;
import br.ufrn.imd.sistemaestoque.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> getProdutos() {
        return produtoService.getProdutos();
    }

    @GetMapping("/{id}")
    public Produto getProdutoById(@PathVariable Long id) {
        return produtoService.getProdutoById(id);
    }

    @PostMapping
    public Produto createProduto(@RequestBody Produto produto) {
        return produtoService.createProduto(produto);
    }

    @PutMapping("/{id}")
    public Produto updateProduto(@PathVariable Long id, @RequestBody Produto updatedProduto) {
        return produtoService.updateProduto(id, updatedProduto);
    }

    @DeleteMapping("/{id}")
    public void deleteProduto(@PathVariable Long id) {
        produtoService.deleteProduto(id);
    }
}
