package br.ufrn.imd.sistemaestoque.controller;

import br.ufrn.imd.sistemaestoque.domain.Operacao;
import br.ufrn.imd.sistemaestoque.service.OperacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/operacoes")
public class OperacaoController {
    @Autowired
    private OperacaoService operacaoService;

    @GetMapping
    public List<Operacao> getOperacoes() {
        return operacaoService.getOperacoes();
    }

    @GetMapping("/{id}")
    public Operacao getOperacaoById(@PathVariable Long id) {
        return operacaoService.getOperacaoById(id);
    }

    @PostMapping
    public Operacao createOperacao(@RequestBody Operacao operacao) {
        return operacaoService.createOperacao(operacao);
    }

    @PutMapping("/{id}")
    public Operacao updateOperacao(@PathVariable Long id, @RequestBody Operacao updatedOperacao) {
        return operacaoService.updateOperacao(id, updatedOperacao);
    }

    @DeleteMapping("/{id}")
    public void deleteOperacao(@PathVariable Long id) {
        operacaoService.deleteOperacao(id);
    }
}
