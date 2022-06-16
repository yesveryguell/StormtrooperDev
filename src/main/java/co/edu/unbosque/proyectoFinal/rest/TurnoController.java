package co.edu.unbosque.proyectoFinal.rest;

import co.edu.unbosque.proyectoFinal.entities.Ciudad;
import co.edu.unbosque.proyectoFinal.entities.Turno;
import co.edu.unbosque.proyectoFinal.service.TurnoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/turno")
public class TurnoController {
    private final Logger log = LoggerFactory.getLogger(TurnoController.class);

    private TurnoService turnoService;

    public TurnoController(TurnoService turnoService) {
        this.turnoService = turnoService;
    }

    // Crud

    //Buscar turno por id
    /**
     * http://localhost:8085/api/ciudad/1
     * @param id
     * @return
     */
    @GetMapping("/turno/{id}")
    @ApiOperation("Buscar turno por id")
    public ResponseEntity<Turno> findById(@ApiParam("Clave primaria turno") @PathVariable Long id) {
        log.info("REST request to find one turno");
        Optional<Turno> turno0pt = this.turnoService.findById(id);
        return turno0pt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Buscar todas las turnos
    /**
     * http://localhost:8085/api/ciudad
     * @return
     */
    @GetMapping("/turnos")
    public List<Turno> findAll() {
        log.info("REST request to find all cities");
        return this.turnoService.findAll();
    }

    // Crear turno
    @PostMapping("/turno")
    public  ResponseEntity<Turno> create(@RequestBody Turno turno) {
        log.info("REST request to create a city");
        if(turno.getId() != null) {
            log.warn("turno already exists");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(this.turnoService.save(turno));
    }

    // Actualizar turno

    /**
     * http://localhost:8085/api/turno
     * @param turno
     * @return
     */
    @PutMapping("/turno")
    public ResponseEntity<Turno> update(@RequestBody Turno turno) {
        log.info("REST request to update a turno");
        if(turno.getId() == null) {
            log.warn("turno does not exist");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(this.turnoService.save(turno));
    }
    //Eliminar por id
    /**
     * http://localhost:8085/api/ciudad/1
     * @param id
     * @return
     */
    @DeleteMapping("/turno/{id}")
    public ResponseEntity<Turno> delete(@PathVariable Long id) {
        log.info("REST request to delete a turno");
        this.turnoService.deletebyId(id);
        return ResponseEntity.noContent().build();
    }


}
