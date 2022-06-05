package co.edu.unbosque.proyectoFinal.rest;


import co.edu.unbosque.proyectoFinal.dto.ZonaRequest;
import co.edu.unbosque.proyectoFinal.entities.Material;
import co.edu.unbosque.proyectoFinal.entities.OrdenTrabajo;
import co.edu.unbosque.proyectoFinal.repository.MaterialRepository;
import co.edu.unbosque.proyectoFinal.repository.OrdenTrabajoRepository;
import co.edu.unbosque.proyectoFinal.service.MaterialService;
import co.edu.unbosque.proyectoFinal.service.OrdenTrabajoService;
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
@RequestMapping("/api/material")
public class MaterialController {

    private final Logger log = LoggerFactory.getLogger(MaterialController.class);
    private MaterialService materialService;
    @Autowired
    private OrdenTrabajoRepository ordenTrabajoRepository;
    private OrdenTrabajoService ordenTrabajoService;
    private OrdenTrabajo ordenTrabajo;

    @Autowired
    private MaterialRepository materialRepository;

    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }

    // Crud

    //Buscar zona por id
    /**
     * http://localhost:8085/api/zona/1
     * @param id
     * @return
     */
    @GetMapping("/material/{id}")
    @ApiOperation("Buscar zona por id")
    public ResponseEntity<Material> findById(@ApiParam("Clave primaria zona") @PathVariable Long id) {
        log.info("REST request to find one city");
        Optional<Material> material0pt = this.materialService.findById(id);
        return material0pt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Buscar todas las zonas
    /**
     * http://localhost:8085/api/zonas
     * @return
     */
    @GetMapping("/material")
    public List<Material> findAll() {
        log.info("REST request to find all cities");
        System.out.println("entro");
        return this.materialService.findAll();
    }



    // Crear zona

    /**
     * http://localhost:8085/api/zona
     *
     * @return
     */
    @PostMapping("/crear/material")
    public  ResponseEntity<Material> create(@RequestBody Material material) {
        log.info("REST request to create a city");
        if (material.getId() != null) {
            log.warn("Zone already exists");
            return ResponseEntity.badRequest().build();

        }

        return ResponseEntity.ok(this.materialService.save(material));
    }

//    @PostMapping("/creer")
//    public Material creer(@RequestBody ZonaRequest request){
//        System.out.println("hols");
//        return ordenTrabajoRepository.save(request.getCiudad());
//    }

    // Actualizar zona

    /**
     *
     * @param material
     * @return
     */
    @PutMapping("/material")
    public ResponseEntity<Material> update(@RequestBody Material material) {
        log.info("REST request to update a Zone");
        if(material.getId() == null) {
            log.warn("Zone does not exist");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(this.materialService.save(material));
    }
    //Eliminar por id
    /**
     * http://localhost:8085/api/zona/1
     * @param id
     * @return
     */
    @DeleteMapping("/material/{id}")
    public ResponseEntity<Material> delete(@PathVariable Long id) {
        log.info("REST request to delete a Zone");
        this.materialService.deletebyId(id);
        return ResponseEntity.noContent().build();
    }

}
