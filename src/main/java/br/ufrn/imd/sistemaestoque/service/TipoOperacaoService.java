package br.ufrn.imd.sistemaestoque.service;

import br.ufrn.imd.sistemaestoque.domain.TipoOperacao;
import br.ufrn.imd.sistemaestoque.repository.TipoOperacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoOperacaoService {
    @Autowired
    private TipoOperacaoRepository tipoOperacaoRepository;

    public List<TipoOperacao> getTiposOperacao() {
        return (List<TipoOperacao>) tipoOperacaoRepository.findAll();
    }

    public TipoOperacao getTipoOperacaoById(Long id) {
        return tipoOperacaoRepository.findById(id).orElse(null);
    }

    public TipoOperacao createTipoOperacao(TipoOperacao tipoOperacao) {
        return tipoOperacaoRepository.save(tipoOperacao);
    }

    public TipoOperacao updateTipoOperacao(Long id, TipoOperacao updatedTipoOperacao) {
        return tipoOperacaoRepository.findById(id).map(tipoOperacao -> {
            tipoOperacao.setDescricao(updatedTipoOperacao.getDescricao());
            tipoOperacao.setOperacoes(updatedTipoOperacao.getOperacoes());
            return tipoOperacaoRepository.save(tipoOperacao);
        }).orElseGet(() -> {
            return createTipoOperacao(updatedTipoOperacao);
        });
    }

    public void deleteTipoOperacao(Long id) {
        TipoOperacao tipoOperacao = getTipoOperacaoById(id);
        tipoOperacaoRepository.delete(tipoOperacao);
    }
}
