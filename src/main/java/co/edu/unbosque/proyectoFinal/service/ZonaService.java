package co.edu.unbosque.proyectoFinal.service;

import co.edu.unbosque.proyectoFinal.entities.Zona;

import java.util.List;
import java.util.Optional;

public interface ZonaService {
   // boolean addZona(Long id);
    List<Zona> findAll();
    Optional<Zona> findById(Long id);
    Zona save(Zona ciudad);
    void deletebyId(Long id);
}
