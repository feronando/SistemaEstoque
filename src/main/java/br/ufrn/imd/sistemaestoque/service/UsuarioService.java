package br.ufrn.imd.sistemaestoque.service;

import br.ufrn.imd.sistemaestoque.domain.Usuario;
import br.ufrn.imd.sistemaestoque.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getUsuarios() {
        return (List<Usuario>) usuarioRepository.findAll();
    }

    public Usuario getUsuarioById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario createUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario updateUsuario(Long id, Usuario updatedUsuario) {
        return usuarioRepository.findById(id).map(usuario -> {
            usuario.setNome(updatedUsuario.getNome());
            usuario.setEmail(updatedUsuario.getEmail());
            usuario.setSenha(updatedUsuario.getSenha());
            usuario.setOperacoes(updatedUsuario.getOperacoes());
            usuario.setNivelAcesso(updatedUsuario.getNivelAcesso());
            usuario.setCargos(updatedUsuario.getCargos());
            return usuarioRepository.save(usuario);
        }).orElseGet(() -> {
            return createUsuario(updatedUsuario);
        });
    }

    public void deleteUsuario(Long id) {
        Usuario usuario = getUsuarioById(id);
        usuarioRepository.delete(usuario);
    }
}
