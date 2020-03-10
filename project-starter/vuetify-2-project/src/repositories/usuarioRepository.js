import Repository from "./Repository";

const resource = "/usuarios";

export default {
    getByAutenticacao() {
        return Repository.get(`${resource}/usuario`);
    },

    getAll() {
      return Repository.get(`${resource}`)
    },
    save(usuario){
        return Repository.post(`${resource}`, usuario)
    },

    atualizar(usuario){
        return Repository.put(`${resource}`, usuario)
    },
    deletar(id){
        return Repository.delete(`${resource}/${id}`)
    }
}
