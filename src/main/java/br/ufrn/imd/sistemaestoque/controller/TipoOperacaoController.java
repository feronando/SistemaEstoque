package br.ufrn.imd.sistemaestoque.controller;

import br.ufrn.imd.sistemaestoque.domain.TipoOperacao;
import br.ufrn.imd.sistemaestoque.service.TipoOperacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipos-operacao")
public class TipoOperacaoController {
    @Autowired
    private TipoOperacaoService tipoOperacaoService;

    @GetMapping
    public List<TipoOperacao> getTiposOperacao() {
        return tipoOperacaoService.getTiposOperacao();
    }

    @GetMapping("/{id}")
    public TipoOperacao getTipoOperacaoById(@PathVariable Long id) {
        return tipoOperacaoService.getTipoOperacaoById(id);
    }

    @PostMapping
    public TipoOperacao createTipoOperacao(@RequestBody TipoOperacao tipoOperacao) {
        return tipoOperacaoService.createTipoOperacao(tipoOperacao);
    }

    @PutMapping("/{id}")
    public TipoOperacao updateTipoOperacao(@PathVariable Long id, @RequestBody TipoOperacao updatedTipoOperacao) {
        return tipoOperacaoService.updateTipoOperacao(id, updatedTipoOperacao);
    }

    @DeleteMapping("/{id}")
    public void deleteTipoOperacao(@PathVariable Long id) {
        tipoOperacaoService.deleteTipoOperacao(id);
    }
}
