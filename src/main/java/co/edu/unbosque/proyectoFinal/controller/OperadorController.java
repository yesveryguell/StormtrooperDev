package co.edu.unbosque.proyectoFinal.controller;

import co.edu.unbosque.proyectoFinal.entities.Operador;
import co.edu.unbosque.proyectoFinal.repository.OperadorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class OperadorController {

    private final Logger log = LoggerFactory.getLogger(OperadorController.class);

    private OperadorRepository operadorRepository;

    public OperadorController(OperadorRepository operadorRepository) {
        this.operadorRepository = operadorRepository;
    }
    //buscar operador

    /**
     * http://localhost:8080/api/operadores
     * @return
     */
    @GetMapping("/api/operadores")
    public List<Operador> FindAll(){
        return operadorRepository.findAll();
    }

    //buscar operador por id

    /**
     * http://localhost:8080/api/operadores/{id}
     * Request
     * Response
     * @param id
     * @return
     */
    @GetMapping("/api/operadores/{id}")
    public ResponseEntity<Operador> findById(@PathVariable Long id){
        Optional<Operador> operador = operadorRepository.findById(id);
       if (operador.isPresent())
           return ResponseEntity.ok(operador.get());
       else
           return ResponseEntity.notFound().build();

    }
    //crear operador

    /**
     * http://localhost:8080/api/operadores
     * @param operador
     * @param headers
     * @return
     */
    @PostMapping("/api/operadores")
    public ResponseEntity<Operador> create (@RequestBody Operador operador, @RequestHeader HttpHeaders headers){
        if (operador.getId() != null){
            log.warn("Operador with id {} already exists");
            return ResponseEntity.badRequest().build();
        }
        Operador result = operadorRepository.save(operador);
        return ResponseEntity.ok(result);
    }
    //actualizar operador
    /**
     * http://localhost:8080/api/operadores/{id}
     * @param operador
     * @return
     */
    @PutMapping("/api/operadores")
    public ResponseEntity<Operador> update (@RequestBody Operador operador){
        if (operador.getId() == null){
            log.warn("Operador with id {} already exists");
            return ResponseEntity.badRequest().build();
        }
        if(!operadorRepository.existsById(operador.getId())){
            log.warn("Try to update a non existing operador");
            return ResponseEntity.notFound().build();
        }
        Operador result = operadorRepository.save(operador);
        return ResponseEntity.ok(result);
    }
    //eliminar operador
    /**
     * http://localhost:8080/api/operadores/{id}
     * @param id
     * @return
     */
    @DeleteMapping("/api/operadores/{id}")
    public ResponseEntity<Operador> delete (@PathVariable Long id){
        if(!operadorRepository.existsById(id)){
            log.warn("Try to delete a non existing operador");
            return ResponseEntity.notFound().build();
        }
        operadorRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}

