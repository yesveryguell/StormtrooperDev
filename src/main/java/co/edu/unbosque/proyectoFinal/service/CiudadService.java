package co.edu.unbosque.proyectoFinal.service;

import co.edu.unbosque.proyectoFinal.entities.Ciudad;

import java.util.List;
import java.util.Optional;

public interface CiudadService {
    List<Ciudad> findAll();
    Ciudad findBynombre(String nombre);
    Optional<Ciudad> findById(Long id);
    Ciudad save(Ciudad ciudad);
    void deletebyId(Long id);
}
