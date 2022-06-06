package co.edu.unbosque.proyectoFinal.rest;

import co.edu.unbosque.proyectoFinal.dto.ZonaRequest;
import co.edu.unbosque.proyectoFinal.entities.Ciudad;
import co.edu.unbosque.proyectoFinal.entities.Usuario;
import co.edu.unbosque.proyectoFinal.entities.Zona;
import co.edu.unbosque.proyectoFinal.repository.CiudadRepository;
import co.edu.unbosque.proyectoFinal.repository.ZonaRepository;
import co.edu.unbosque.proyectoFinal.service.CiudadService;
import co.edu.unbosque.proyectoFinal.service.ZonaService;
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
@RequestMapping("/api/zona")
public class ZonaController {

    private final Logger log = LoggerFactory.getLogger(ZonaController.class);
    private ZonaService zonaService;
    @Autowired
    private CiudadRepository ciudadRepository;
    private CiudadService ciudadService;
    private Ciudad ciudad;

    @Autowired
    private ZonaRepository zonaRepository;



    public ZonaController(ZonaService zonaService) {
        this.zonaService = zonaService;
    }
    // Crud

    //Buscar zona por id
    /**
     * http://localhost:8085/api/zona/1
     * @param id
     * @return
     */
    @GetMapping("/zona/{id}")
    @ApiOperation("Buscar zona por id")
    public ResponseEntity<Zona> findById(@ApiParam("Clave primaria zona") @PathVariable Long id) {
        log.info("REST request to find one city");
        Optional<Zona> zona0pt = this.zonaService.findById(id);
        return zona0pt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Buscar todas las zonas
    /**
     * http://localhost:8085/api/zonas
     * @return
     */
    @GetMapping("/zonas")
    public List<Zona> findAll() {
        log.info("REST request to find all cities");
        System.out.println("entro");
        return this.zonaService.findAll();
    }



    // Crear zona

    /**
     * http://localhost:8085/api/zona
     *
     * @return
     */
    @PostMapping("/crear/zona")
    public  ResponseEntity<Zona> create(@RequestBody Zona zona) {
        log.info("REST request to create a city");
        if (zona.getId() != null) {
            log.warn("Zone already exists");
            return ResponseEntity.badRequest().build();

        }

        return ResponseEntity.ok(this.zonaService.save(zona));
    }

//    @PostMapping("/creer")
//    public Ciudad creer(@RequestBody ZonaRequest request){
//        System.out.println("hols");
//        return ciudadRepository.save(request.getCiudad());
//    }




    // Actualizar zona

    /**
     * http://localhost:8085/api/zona
     * @param zona
     * @return
     */
    @PutMapping("/zona")
    public ResponseEntity<Zona> update(@RequestBody Zona zona) {
        log.info("REST request to update a Zone");
        if(zona.getId() == null) {
            log.warn("Zone does not exist");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(this.zonaService.save(zona));
    }
    //Eliminar por id
    /**
     * http://localhost:8085/api/zona/1
     * @param id
     * @return
     */
    @DeleteMapping("/zona/{id}")
    public ResponseEntity<Zona> delete(@PathVariable Long id) {
        log.info("REST request to delete a Zone");
        this.zonaService.deletebyId(id);
        return ResponseEntity.noContent().build();
    }



}
