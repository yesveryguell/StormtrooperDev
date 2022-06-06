package co.edu.unbosque.proyectoFinal.service;

import co.edu.unbosque.proyectoFinal.entities.Cuadrilla;

import java.util.List;
import java.util.Optional;

public interface CuadrillaService {
    List<Cuadrilla> findAll();
    Optional<Cuadrilla> findById(Long id);
    Cuadrilla save(Cuadrilla cuadrilla);
    void deletebyId(Long id);
}
