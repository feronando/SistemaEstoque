package br.ufrn.imd.sistemaestoque.repository;

import br.ufrn.imd.sistemaestoque.domain.Estoque;
import org.springframework.data.repository.CrudRepository;

public interface EstoqueRepository extends CrudRepository<Estoque, Long> {
}
