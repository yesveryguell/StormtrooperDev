package co.edu.unbosque.proyectoFinal.service;

import co.edu.unbosque.proyectoFinal.entities.Ciudad;
import co.edu.unbosque.proyectoFinal.entities.OrdenTrabajo;

import java.util.List;
import java.util.Optional;

public interface OrdenTrabajoService {
    List<OrdenTrabajo> findAll();
    OrdenTrabajo findBynombretrabajo(String nombretrabajo);
    Optional<OrdenTrabajo> findById(Long id);
    OrdenTrabajo save(OrdenTrabajo ordenTrabajo);
    void deletebyId(Long id);
}
