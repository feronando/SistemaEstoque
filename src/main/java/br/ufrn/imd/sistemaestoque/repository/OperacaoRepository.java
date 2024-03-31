package br.ufrn.imd.sistemaestoque.repository;

import br.ufrn.imd.sistemaestoque.domain.Operacao;
import org.springframework.data.repository.CrudRepository;

public interface OperacaoRepository extends CrudRepository<Operacao, Long> {
}
