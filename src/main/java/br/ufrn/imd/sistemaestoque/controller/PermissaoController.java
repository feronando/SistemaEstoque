package br.ufrn.imd.sistemaestoque.controller;

import br.ufrn.imd.sistemaestoque.domain.Permissao;
import br.ufrn.imd.sistemaestoque.service.PermissaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permissoes")
public class PermissaoController {
    @Autowired
    private PermissaoService permissaoService;

    @GetMapping
    public List<Permissao> getPermissoes() {
        return permissaoService.getPermissoes();
    }

    @GetMapping("/{id}")
    public Permissao getPermissaoById(@PathVariable Long id) {
        return permissaoService.getPermissaoById(id);
    }

    @PostMapping
    public Permissao createPermissao(@RequestBody Permissao permissao) {
        return permissaoService.createPermissao(permissao);
    }

    @PutMapping("/{id}")
    public Permissao updatePermissao(@PathVariable Long id, @RequestBody Permissao updatedPermissao) {
        return permissaoService.updatePermissao(id, updatedPermissao);
    }

    @DeleteMapping("/{id}")
    public void deletePermissao(@PathVariable Long id) {
        permissaoService.deletePermissao(id);
    }
}
