package br.ufrn.imd.sistemaestoque.service;

import br.ufrn.imd.sistemaestoque.domain.NivelAcesso;
import br.ufrn.imd.sistemaestoque.repository.NivelAcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NivelAcessoService {
    @Autowired
    private NivelAcessoRepository nivelAcessoRepository;

    public List<NivelAcesso> getNiveisAcesso() {
        return (List<NivelAcesso>) nivelAcessoRepository.findAll();
    }

    public NivelAcesso getNivelAcessoById(Long id) {
        return nivelAcessoRepository.findById(id).orElse(null);
    }

    public NivelAcesso createNivelAcesso(NivelAcesso nivelAcesso) {
        return nivelAcessoRepository.save(nivelAcesso);
    }

    public NivelAcesso updateNivelAcesso(Long id, NivelAcesso updatedNivelAcesso) {
        return nivelAcessoRepository.findById(id).map(nivelAcesso -> {
            nivelAcesso.setDescricao(updatedNivelAcesso.getDescricao());
            nivelAcesso.setUsuarios(updatedNivelAcesso.getUsuarios());
            return nivelAcessoRepository.save(nivelAcesso);
        }).orElseGet(() -> {
            return createNivelAcesso(updatedNivelAcesso);
        });
    }

    public void deleteNivelAcesso(Long id) {
        NivelAcesso nivelAcesso = getNivelAcessoById(id);
        nivelAcessoRepository.delete(nivelAcesso);
    }
}
