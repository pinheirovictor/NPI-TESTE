package quixada.npi.springproject.service;

import quixada.npi.springproject.model.Usuario;

import java.util.List;

public interface UsuarioService {

    Usuario save(Usuario usuario);

    Usuario findById(Integer id);

    Usuario findByEmail(String email);

    List<Usuario> findAll();

    boolean deleteById(Integer id);
}
