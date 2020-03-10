package quixada.npi.springproject.service;

import quixada.npi.springproject.model.Curso;

import java.util.List;

public interface CursoService {
    Curso save(Curso curso);

    Curso findById(Integer id);

    Curso findByNome(String nome);

    List<Curso> findAll();

    void deleteById(Integer id);
}
