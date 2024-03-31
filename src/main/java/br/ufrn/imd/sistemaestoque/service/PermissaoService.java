package br.ufrn.imd.sistemaestoque.service;

import br.ufrn.imd.sistemaestoque.domain.Permissao;
import br.ufrn.imd.sistemaestoque.repository.PermissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissaoService {
    @Autowired
    private PermissaoRepository permissaoRepository;

    public List<Permissao> getPermissoes() {
        return (List<Permissao>) permissaoRepository.findAll();
    }

    public Permissao getPermissaoById(Long id) {
        return permissaoRepository.findById(id).orElse(null);
    }

    public Permissao createPermissao(Permissao permissao) {
        return permissaoRepository.save(permissao);
    }

    public Permissao updatePermissao(Long id, Permissao updatedPermissao) {
        return permissaoRepository.findById(id).map(permissao -> {
            permissao.setDescricao(updatedPermissao.getDescricao());
            permissao.setCargos(updatedPermissao.getCargos());
            return permissaoRepository.save(permissao);
        }).orElseGet(() -> {
            return createPermissao(updatedPermissao);
        });
    }

    public void deletePermissao(Long id) {
        Permissao permissao = getPermissaoById(id);
        permissaoRepository.delete(permissao);
    }
}
