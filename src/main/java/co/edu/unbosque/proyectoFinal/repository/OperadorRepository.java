package co.edu.unbosque.proyectoFinal.repository;

import co.edu.unbosque.proyectoFinal.entities.Operador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperadorRepository extends JpaRepository<Operador, Long> {

}
