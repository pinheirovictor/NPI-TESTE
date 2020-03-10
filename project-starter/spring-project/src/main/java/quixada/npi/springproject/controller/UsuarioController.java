package quixada.npi.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import quixada.npi.springproject.model.Usuario;
import quixada.npi.springproject.service.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("")
    public ResponseEntity<List<Usuario>> findAll() {
        return ResponseEntity.ok(usuarioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Usuario>> find(@PathVariable Integer id) {
        return ResponseEntity.ok().build();
    }

    @PostMapping("")
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.save(usuario));
    }

    @RequestMapping(value = {"/{id}"}, method = {RequestMethod.DELETE})
    public boolean delete(@PathVariable Integer id) {
        usuarioService.deleteById(id);
        return true;

    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@RequestBody Usuario usuario) {
        Usuario usuarioUpdate = usuarioService.findById(usuario.getId());
        ModelAndView mv = new ModelAndView("/usuarios");
        usuarioService.save(usuarioUpdate);
        return ResponseEntity.ok().build();
    }

}
