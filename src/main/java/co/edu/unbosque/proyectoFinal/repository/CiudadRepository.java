package co.edu.unbosque.proyectoFinal.repository;

import co.edu.unbosque.proyectoFinal.dto.ZonaResponse;
import co.edu.unbosque.proyectoFinal.entities.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CiudadRepository extends JpaRepository<Ciudad, Long> {

    //  List<ZonaResponse> getJoinInformation();
    List<Ciudad> findAll();

    List<Ciudad> findAllById(Long id);

    Ciudad findBynombre(String nombre);

}




