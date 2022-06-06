package co.edu.unbosque.proyectoFinal.rest;

import co.edu.unbosque.proyectoFinal.entities.Ciudad;
import co.edu.unbosque.proyectoFinal.service.CiudadService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ciudad")
public class CiudadController {
    private final Logger log = LoggerFactory.getLogger(CiudadController.class);

    private CiudadService ciudadService;

    public CiudadController(CiudadService ciudadService) {
        this.ciudadService = ciudadService;
    }

    // Crud

    //Buscar ciudad por id
    /**
     * http://localhost:8085/api/ciudad/1
     * @param id
     * @return
     */
    @GetMapping("/ciudad/{id}")
    @ApiOperation("Buscar ciudad por id")
    public ResponseEntity<Ciudad> findById(@ApiParam("Clave primaria ciuadad") @PathVariable Long id) {
        log.info("REST request to find one city");
        Optional<Ciudad> ciudad0pt = this.ciudadService.findById(id);
        return ciudad0pt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Buscar todas las ciudades
    /**
     * http://localhost:8085/api/ciudad
     * @return
     */
    @GetMapping("/ciudades")
    public List<Ciudad> findAll() {
        log.info("REST request to find all cities");
        return this.ciudadService.findAll();
    }

    // Crear ciudad
    @PostMapping("/ciudad")
    public  ResponseEntity<Ciudad> create(@RequestBody Ciudad ciudad) {
        log.info("REST request to create a city");
        if(ciudad.getId() != null) {
            log.warn("City already exists");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(this.ciudadService.save(ciudad));
    }

    // Actualizar ciudad

    /**
     * http://localhost:8085/api/ciudad
     * @param ciudad
     * @return
     */
    @PutMapping("/ciudad")
    public ResponseEntity<Ciudad> update(@RequestBody Ciudad ciudad) {
        log.info("REST request to update a city");
        if(ciudad.getId() == null) {
            log.warn("City does not exist");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(this.ciudadService.save(ciudad));
    }
    //Eliminar por id
    /**
     * http://localhost:8085/api/ciudad/1
     * @param id
     * @return
     */
    @DeleteMapping("/ciudad/{id}")
    public ResponseEntity<Ciudad> delete(@PathVariable Long id) {
        log.info("REST request to delete a city");
        this.ciudadService.deletebyId(id);
        return ResponseEntity.noContent().build();
    }




}
