package co.edu.unbosque.proyectoFinal.service;

import co.edu.unbosque.proyectoFinal.entities.Material;

import java.util.List;
import java.util.Optional;

public interface MaterialService {
    List<Material> findAll();
    Optional<Material> findById(Long id);
    Material save(Material material);
    void deletebyId(Long id);
}
