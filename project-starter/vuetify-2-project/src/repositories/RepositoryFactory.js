import UsuarioRepository from "./usuarioRepository";
import CursoRepository from "./cursoRepository";
import AlunoRepository from "./alunoRepository";

const repositories = {
    usuario: UsuarioRepository,
    curso: CursoRepository,
    aluno: AlunoRepository
};

export const RepositoryFactory = {
    get: name => repositories[name]
};
