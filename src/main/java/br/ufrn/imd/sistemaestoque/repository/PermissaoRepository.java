package br.ufrn.imd.sistemaestoque.repository;

import br.ufrn.imd.sistemaestoque.domain.Permissao;
import org.springframework.data.repository.CrudRepository;

public interface PermissaoRepository  extends CrudRepository<Permissao, Long> {
}
