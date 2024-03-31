package br.ufrn.imd.sistemaestoque.controller;

import br.ufrn.imd.sistemaestoque.domain.Loja;
import br.ufrn.imd.sistemaestoque.service.LojaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lojas")
public class LojaController {
    @Autowired
    private LojaService lojaService;

    @GetMapping
    public List<Loja> getLojas() {
        return lojaService.getLojas();
    }

    @GetMapping("/{id}")
    public Loja getLojaById(@PathVariable Long id) {
        return lojaService.getLojaById(id);
    }

    @PostMapping
    public Loja createLoja(@RequestBody Loja loja) {
        return lojaService.createLoja(loja);
    }

    @PutMapping("/{id}")
    public Loja updateLoja(@PathVariable Long id, @RequestBody Loja updatedLoja) {
        return lojaService.updateLoja(id, updatedLoja);
    }

    @DeleteMapping("/{id}")
    public void deleteLoja(@PathVariable Long id) {
        lojaService.deleteLoja(id);
    }
}
