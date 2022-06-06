package co.edu.unbosque.proyectoFinal.service;

import co.edu.unbosque.proyectoFinal.entities.TurnoCuadrilla;

import java.util.List;
import java.util.Optional;

public interface TurnoCuadrillaService {
    List<TurnoCuadrilla> findAll();
    Optional<TurnoCuadrilla> findById(Long id);
    TurnoCuadrilla save(TurnoCuadrilla turnoCuadrilla);
    void deletebyId(Long id);

}
