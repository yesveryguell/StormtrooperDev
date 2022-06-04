package co.edu.unbosque.proyectoFinal.repository;

import co.edu.unbosque.proyectoFinal.entities.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
}
