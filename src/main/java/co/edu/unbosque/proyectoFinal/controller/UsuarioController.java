package co.edu.unbosque.proyectoFinal.controller;

import co.edu.unbosque.proyectoFinal.entities.Usuario;
import co.edu.unbosque.proyectoFinal.repository.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UsuarioController {
    private final Logger log = LoggerFactory.getLogger(UsuarioController.class);
    private UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    //Buscar Usuarios

    /**
     * http://localhost:8080/api/usuarios
     *
     * @return
     */
    @GetMapping("/api/usuarios")
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    //Buscar Usuario por id

    /**
     * http://localhost:8080/api/usuarios/{id}
     *
     * @param id
     * @return
     */
    @GetMapping("/api/usuarios/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent())
            return ResponseEntity.ok(usuario.get());
        else
            return ResponseEntity.notFound().build();

    }
    // Crear Usuario

    /**
     * http://localhost:8080/api/usuarios
     *
     * @param usuario
     * @return
     */
    @PostMapping("/api/usuarios")
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario, @RequestHeader HttpHeaders headers) {
        if (usuario.getId() != null) {
            log.warn("User with id {} already exists");
            return ResponseEntity.badRequest().build();
        }
        Usuario result = usuarioRepository.save(usuario);
        return ResponseEntity.ok(result);
    }
    //Actualizar Usuario

    /**
     * http://localhost:8080/api/usuarios
     *
     * @param usuario
     * @return
     */
    @PutMapping("/api/usuarios")
    public ResponseEntity<Usuario> update(@RequestBody Usuario usuario) {
        if (usuario.getId() == null) {
            log.warn("User with id {} already exists");
            return ResponseEntity.badRequest().build();
        }
        if (!usuarioRepository.existsById(usuario.getId())) {
            log.warn("User with id {} not found");
            return ResponseEntity.notFound().build();
        }
        Usuario result = usuarioRepository.save(usuario);
        return ResponseEntity.ok(result);
    }
    //Eliminar Usuario

    /**
     * http://localhost:8080/api/usuarios/{id}
     * @param id
     * @return
     */
    @DeleteMapping("/api/usuarios/{id}")
    public ResponseEntity<Usuario> delete(@PathVariable Long id) {
        if (!usuarioRepository.existsById(id)) {
            log.warn("User with id {} not found");
            return ResponseEntity.notFound().build();
        }
        usuarioRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}





