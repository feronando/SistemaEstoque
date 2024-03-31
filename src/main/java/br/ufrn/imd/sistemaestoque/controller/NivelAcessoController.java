package br.ufrn.imd.sistemaestoque.controller;

import br.ufrn.imd.sistemaestoque.domain.NivelAcesso;
import br.ufrn.imd.sistemaestoque.service.NivelAcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/niveis-acesso")
public class NivelAcessoController {
    @Autowired
    private NivelAcessoService nivelAcessoService;

    @GetMapping
    public List<NivelAcesso> getNiveisAcesso() {
        return nivelAcessoService.getNiveisAcesso();
    }

    @GetMapping("/{id}")
    public NivelAcesso getNivelAcessoById(@PathVariable Long id) {
        return nivelAcessoService.getNivelAcessoById(id);
    }

    @PostMapping
    public NivelAcesso createNivelAcesso(@RequestBody NivelAcesso nivelAcesso) {
        return nivelAcessoService.createNivelAcesso(nivelAcesso);
    }

    @PutMapping("/{id}")
    public NivelAcesso updateNivelAcesso(@PathVariable Long id, @RequestBody NivelAcesso updatedNivelAcesso) {
        return nivelAcessoService.updateNivelAcesso(id, updatedNivelAcesso);
    }

    @DeleteMapping("/{id}")
    public void deleteNivelAcesso(@PathVariable Long id) {
        nivelAcessoService.deleteNivelAcesso(id);
    }
}
