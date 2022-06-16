package co.edu.unbosque.proyectoFinal.rest;

import co.edu.unbosque.proyectoFinal.entities.Ciudad;
import co.edu.unbosque.proyectoFinal.entities.OrdenTrabajo;
import co.edu.unbosque.proyectoFinal.service.OrdenTrabajoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ordenTabajo")
public class OrdenTrabajoController {
    private final Logger log = LoggerFactory.getLogger(OrdenTrabajoController.class);
    private OrdenTrabajoService ordenTrabajoService;

    public OrdenTrabajoController(OrdenTrabajoService ordenTrabajoService) {
        this.ordenTrabajoService = ordenTrabajoService;
    }

    // Crud

    //Buscar orden de trabajo por id

    /**
     * http://localhost:8085/api/ordenTabajo/1
     *
     * @param id
     * @return
     */
    @GetMapping("/ordenTrabajo/{id}")
    @ApiOperation("Buscar ordenTrabajo por id")
    public ResponseEntity<OrdenTrabajo> findById(@ApiParam("Clave primaria ordenTrabajo") @PathVariable Long id) {
        log.info("REST request to find one ordenTrabajo");
        Optional<OrdenTrabajo> ordenTrabajo0pt = this.ordenTrabajoService.findById(id);
        return ordenTrabajo0pt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Buscar todas las Ordenes de trabajo

    /**
     * http://localhost:8085/api/ordenTrabajo
     *
     * @return
     */
    @GetMapping("/OrdenesTrabajo")
    public List<OrdenTrabajo> findAll() {
        log.info("REST request to find all OrdenesTrabajo");
        return this.ordenTrabajoService.findAll();
    }

    // Crear OrdenTrabajo

    /**
     * http://localhost:8085/api/ordenTrabajo
     *
     * @param ordenTrabajo
     * @return
     */
    @PostMapping("/ordenTrabajo")
    public ResponseEntity<OrdenTrabajo> create(@RequestBody OrdenTrabajo ordenTrabajo) {
        log.info("REST request to create a OrdenTrabajo");
        if (ordenTrabajo.getId() != null) {
            log.warn("OrdenTrabajo already exists");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(this.ordenTrabajoService.save(ordenTrabajo));
    }

    // Actualizar OrdenTrabajo

    /**
     * http://localhost:8085/api/ordenTrabajo/
     *
     * @param ordenTrabajo
     * @return
     */
    @PutMapping("/ordenTrabajo")
    public ResponseEntity<OrdenTrabajo> update(@RequestBody OrdenTrabajo ordenTrabajo) {
        log.info("REST request to update a OrdenTrabajo");
        if (ordenTrabajo.getId() == null) {
            log.warn("OrdenTrabajo does not exist");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(this.ordenTrabajoService.save(ordenTrabajo));
    }
    //Eliminar  OrdenTrabajo por id

    /**
     * http://localhost:8085/api/ordenTrabajo/1
     *
     * @param id
     * @return
     */
    @DeleteMapping("/ordenTrabajo/{id}")
    public ResponseEntity<OrdenTrabajo> delete(@PathVariable Long id) {
        log.info("REST request to delete a OrdenTrabajo");
        this.ordenTrabajoService.deletebyId(id);
        return ResponseEntity.noContent().build();
    }


}
