package br.ufrn.imd.sistemaestoque.repository;

import br.ufrn.imd.sistemaestoque.domain.ProdutoEstoque;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoEstoqueRepository extends CrudRepository<ProdutoEstoque, Long> {
}
