package quixada.npi.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import quixada.npi.springproject.model.Curso;

import java.util.List;

public interface CursoRepository extends JpaRepository<Curso, Integer> {
    Curso findByNome(String nome);

    @Query("SELECT new Curso(c.nome, c.turno, c.sigla) FROM Curso c")
    List<Curso> findAll();
}
