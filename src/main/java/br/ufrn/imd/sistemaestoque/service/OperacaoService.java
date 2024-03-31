package br.ufrn.imd.sistemaestoque.service;

import br.ufrn.imd.sistemaestoque.domain.Operacao;
import br.ufrn.imd.sistemaestoque.repository.OperacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperacaoService {
    @Autowired
    private OperacaoRepository operacaoRepository;

    public List<Operacao> getOperacoes() {
        return (List<Operacao>) operacaoRepository.findAll();
    }

    public Operacao getOperacaoById(Long id) {
        return operacaoRepository.findById(id).orElse(null);
    }

    public Operacao createOperacao(Operacao operacao) {
        return operacaoRepository.save(operacao);
    }

    public Operacao updateOperacao(Long id, Operacao updatedOperacao) {
        return operacaoRepository.findById(id).map(operacao -> {
            operacao.setDataOperacao(updatedOperacao.getDataOperacao());
            operacao.setQtdAlterada(updatedOperacao.getQtdAlterada());
            operacao.setUsuario(updatedOperacao.getUsuario());
            operacao.setProdutoEstoque(updatedOperacao.getProdutoEstoque());
            operacao.setTipo(updatedOperacao.getTipo());
            return operacaoRepository.save(operacao);
        }).orElseGet(() -> {
            return createOperacao(updatedOperacao);
        });
    }

    public void deleteOperacao(Long id) {
        Operacao operacao = getOperacaoById(id);
        operacaoRepository.delete(operacao);
    }
}
