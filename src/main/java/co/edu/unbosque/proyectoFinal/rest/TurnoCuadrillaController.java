package co.edu.unbosque.proyectoFinal.rest;

import co.edu.unbosque.proyectoFinal.entities.Turno;
import co.edu.unbosque.proyectoFinal.entities.TurnoCuadrilla;
import co.edu.unbosque.proyectoFinal.entities.Zona;
import co.edu.unbosque.proyectoFinal.repository.TurnoCuadrillaRepository;
import co.edu.unbosque.proyectoFinal.repository.TurnoRepository;
import co.edu.unbosque.proyectoFinal.service.TurnoCuadrillaService;
import co.edu.unbosque.proyectoFinal.service.TurnoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/turno")
public class TurnoCuadrillaController {

    private final Logger log = LoggerFactory.getLogger(TurnoCuadrillaController.class);
    private TurnoCuadrillaService turnoCuadrillaService;
    @Autowired
    private TurnoRepository turnoRepository;
    private TurnoService turnoService;
    private Turno turno;

    @Autowired
    private TurnoCuadrillaRepository turnoCuadrillaRepository;

    public TurnoCuadrillaController(TurnoCuadrillaService turnoCuadrillaService) {
        this.turnoCuadrillaService = turnoCuadrillaService;
    }
    // Crud

    //Buscar turno cuadrilla por id

    /**
     * http://localhost:8085/api/zona/1
     *
     * @param id
     * @return
     */
    @GetMapping("/turnoCuadrilla/{id}")
    @ApiOperation("Buscar turnoCuadrilla por id")
    public ResponseEntity<TurnoCuadrilla> findById(@ApiParam("Clave primaria turnoCuadrilla") @PathVariable Long id) {
        log.info("REST request to find one city");
        Optional<TurnoCuadrilla> turnoCuadrilla0pt = this.turnoCuadrillaService.findById(id);
        return turnoCuadrilla0pt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Buscar todas las turnos Cuadrillas

    /**
     * http://localhost:8085/api/zonas
     *
     * @return
     */
    @GetMapping("/turnoCuadrilla")
    public List<TurnoCuadrilla> findAll() {
        log.info("REST request to find all turnoCuadrilla");
        System.out.println("entro");
        return this.turnoCuadrillaService.findAll();
    }


    // Crear zona

    /**
     * http://localhost:8085/api/zona
     *
     * @return
     */
    @PostMapping("/crear/turnoCuadrilla")
    public ResponseEntity<TurnoCuadrilla> create(@RequestBody TurnoCuadrilla turnoCuadrilla) {
        log.info("REST request to create a turnoCuadrilla");
        if (turnoCuadrilla.getId() != null) {
            log.warn("Zone already exists");
            return ResponseEntity.badRequest().build();

        }

        return ResponseEntity.ok(this.turnoCuadrillaService.save(turnoCuadrilla));
    }

    // Actualizar zona

    /**
     * http://localhost:8085/api/zona
     *
     * @param turnoCuadrilla
     * @return
     */
    @PutMapping("/turnoCuadrilla")
    public ResponseEntity<TurnoCuadrilla> update(@RequestBody TurnoCuadrilla turnoCuadrilla) {
        log.info("REST request to update a Zone");
        if (turnoCuadrilla.getId() == null) {
            log.warn("Zone does not exist");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(this.turnoCuadrillaService.save(turnoCuadrilla));
    }
    //Eliminar por id

    /**
     * http://localhost:8085/api/zona/1
     *
     * @param id
     * @return
     */
    @DeleteMapping("/turnoCuadrilla/{id}")
    public ResponseEntity<TurnoCuadrilla> delete(@PathVariable Long id) {
        log.info("REST request to delete a Zone");
        this.turnoCuadrillaService.deletebyId(id);
        return ResponseEntity.noContent().build();
    }


}
