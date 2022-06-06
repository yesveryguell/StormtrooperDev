package co.edu.unbosque.proyectoFinal.repository;

import co.edu.unbosque.proyectoFinal.entities.OrdenTrabajo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdenTrabajoRepository extends JpaRepository<OrdenTrabajo, Long> {
        List<OrdenTrabajo> findAll();
        List<OrdenTrabajo> findAllById(Long id);
        OrdenTrabajo findBynombretrabajo(String nombretrabajo);
}


