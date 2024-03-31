package br.ufrn.imd.sistemaestoque.controller;

import br.ufrn.imd.sistemaestoque.domain.Estoque;
import br.ufrn.imd.sistemaestoque.service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estoques")
public class EstoqueController {
    @Autowired
    private EstoqueService estoqueService;

    @GetMapping
    public List<Estoque> getEstoques() {
        return estoqueService.getEstoques();
    }

    @GetMapping("/{id}")
    public Estoque getEstoqueById(@PathVariable Long id) {
        return estoqueService.getEstoqueById(id);
    }

    @PostMapping
    public Estoque createEstoque(@RequestBody Estoque estoque) {
        return estoqueService.createEstoque(estoque);
    }

    @PutMapping("/{id}")
    public Estoque updateEstoque(@PathVariable Long id, @RequestBody Estoque updatedEstoque) {
        return estoqueService.updateEstoque(id, updatedEstoque);
    }

    @DeleteMapping("/{id}")
    public void deleteEstoque(@PathVariable Long id) {
        estoqueService.deleteEstoque(id);
    }
}
