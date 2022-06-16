package co.edu.unbosque.proyectoFinal.repository;

import co.edu.unbosque.proyectoFinal.entities.TurnoCuadrilla;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TurnoCuadrillaRepository extends JpaRepository<TurnoCuadrilla, Long> {
    List<TurnoCuadrilla> findAll();

    List<TurnoCuadrilla> findAllById(Long id);
}
