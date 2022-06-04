package co.edu.unbosque.proyectoFinal.repository;
import co.edu.unbosque.proyectoFinal.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository  extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByCorreo(String username);
    Boolean existsByCorreo(String correo);

}
