package br.ufrn.imd.sistemaestoque.repository;

import br.ufrn.imd.sistemaestoque.domain.Produto;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {
}
