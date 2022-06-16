package co.edu.unbosque.proyectoFinal.service;

import co.edu.unbosque.proyectoFinal.entities.EmpresaProveedora;

import java.util.List;
import java.util.Optional;

public interface EmpresaProveedoraService {
    List<EmpresaProveedora> findAll();

    EmpresaProveedora findBynombre(String nombre);

    Optional<EmpresaProveedora> findById(Long id);

    EmpresaProveedora save(EmpresaProveedora empresaProveedora);

    void deletebyId(Long id);
}
