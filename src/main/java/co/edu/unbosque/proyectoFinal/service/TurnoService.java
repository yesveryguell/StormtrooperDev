package co.edu.unbosque.proyectoFinal.service;

import co.edu.unbosque.proyectoFinal.entities.Turno;
import co.edu.unbosque.proyectoFinal.entities.TurnoCuadrilla;

import java.util.List;
import java.util.Optional;

public interface TurnoService {
    List<Turno> findAll();

    Turno findByjornada(String jornada);

    Optional<Turno> findById(Long id);

    Turno save(Turno turno);

    void deletebyId(Long id);
}
