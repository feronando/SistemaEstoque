package br.ufrn.imd.sistemaestoque.service;

import br.ufrn.imd.sistemaestoque.domain.Estoque;
import br.ufrn.imd.sistemaestoque.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstoqueService {
    @Autowired
    private EstoqueRepository estoqueRepository;

    public List<Estoque> getEstoques() {
        return (List<Estoque>) estoqueRepository.findAll();
    }

    public Estoque getEstoqueById(Long id) {
        return estoqueRepository.findById(id).orElse(null);
    }

    public Estoque createEstoque(Estoque estoque) {
        return estoqueRepository.save(estoque);
    }

    public Estoque updateEstoque(Long id, Estoque updatedEstoque) {
        return estoqueRepository.findById(id).map(estoque -> {
            estoque.setIdLoja(updatedEstoque.getIdLoja());
            estoque.setProdutoEstoque(updatedEstoque.getProdutoEstoque());
            return estoqueRepository.save(estoque);
        }).orElseGet(() -> {
            return createEstoque(updatedEstoque);
        });
    }

    public void deleteEstoque(Long id) {
        Estoque estoque = getEstoqueById(id);
        estoqueRepository.delete(estoque);
    }
}
