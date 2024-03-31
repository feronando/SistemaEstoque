package br.ufrn.imd.sistemaestoque.repository;

import br.ufrn.imd.sistemaestoque.domain.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
}
