package co.edu.unbosque.proyectoFinal.repository;

import co.edu.unbosque.proyectoFinal.entities.Cuadrilla;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CuadrillaRepository extends JpaRepository<Cuadrilla, Long> {
    List<Cuadrilla> findAll();
    List <Cuadrilla> findAllById(Long id);
}
