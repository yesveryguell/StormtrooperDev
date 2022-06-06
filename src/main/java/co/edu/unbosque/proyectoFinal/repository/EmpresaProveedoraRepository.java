package co.edu.unbosque.proyectoFinal.repository;

import co.edu.unbosque.proyectoFinal.entities.EmpresaProveedora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpresaProveedoraRepository extends JpaRepository<EmpresaProveedora, Long> {

    List<EmpresaProveedora> findAll();
    List<EmpresaProveedora> findAllById(Long id);
    EmpresaProveedora findBynombre(String nombre);
}
