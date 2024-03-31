package br.ufrn.imd.sistemaestoque.service;

import br.ufrn.imd.sistemaestoque.domain.Loja;
import br.ufrn.imd.sistemaestoque.repository.LojaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LojaService {
    @Autowired
    private LojaRepository lojaRepository;

    public List<Loja> getLojas() {
        return (List<Loja>) lojaRepository.findAll();
    }

    public Loja getLojaById(Long id) {
        return lojaRepository.findById(id).orElse(null);
    }

    public Loja createLoja(Loja loja) {
        return lojaRepository.save(loja);
    }

    public Loja updateLoja(Long id, Loja updatedLoja) {
        return lojaRepository.findById(id).map(loja -> {
            loja.setNome(updatedLoja.getNome());
            loja.setEndereco(updatedLoja.getEndereco());
            loja.setEstoques(updatedLoja.getEstoques());
            return lojaRepository.save(loja);
        }).orElseGet(() -> {
            return createLoja(updatedLoja);
        });
    }

    public void deleteLoja(Long id) {
        Loja loja = getLojaById(id);
        lojaRepository.delete(loja);
    }
}
