package br.ufrn.imd.sistemaestoque.repository;

import br.ufrn.imd.sistemaestoque.domain.Cargo;
import org.springframework.data.repository.CrudRepository;

public interface CargoRepository extends CrudRepository<Cargo, Long> {
}
