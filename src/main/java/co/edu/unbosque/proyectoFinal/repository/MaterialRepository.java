package co.edu.unbosque.proyectoFinal.repository;

import co.edu.unbosque.proyectoFinal.entities.Material;
import co.edu.unbosque.proyectoFinal.entities.Zona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Long> {
    List<Material> findAll();

    List<Material> findAllById(Long id);
}


