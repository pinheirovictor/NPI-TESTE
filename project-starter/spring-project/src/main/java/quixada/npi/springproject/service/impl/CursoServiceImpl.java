package quixada.npi.springproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quixada.npi.springproject.model.Curso;
import quixada.npi.springproject.repository.CursoRepository;
import quixada.npi.springproject.service.CursoService;

import java.util.List;
@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public Curso save(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public Curso findById(Integer id) {
        return cursoRepository.findById(id).get();
    }

    @Override
    public Curso findByNome(String nome) {
        return cursoRepository.findByNome(nome);
    }

    @Override
    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        cursoRepository.deleteById(id);
    }
}
