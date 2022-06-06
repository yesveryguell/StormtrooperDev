package co.edu.unbosque.proyectoFinal.rest;

import co.edu.unbosque.proyectoFinal.entities.Cuadrilla;
import co.edu.unbosque.proyectoFinal.entities.EmpresaProveedora;
import co.edu.unbosque.proyectoFinal.entities.Zona;
import co.edu.unbosque.proyectoFinal.repository.CuadrillaRepository;
import co.edu.unbosque.proyectoFinal.repository.EmpresaProveedoraRepository;
import co.edu.unbosque.proyectoFinal.service.CuadrillaService;
import co.edu.unbosque.proyectoFinal.service.EmpresaProveedoraService;
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
@RequestMapping("/api/cuadrilla")
public class CuadrillaController {

    private final Logger log = LoggerFactory.getLogger(CuadrillaController.class);
    private CuadrillaService cuadrillaService;
    @Autowired
    private EmpresaProveedoraRepository empresaProveedoraRepository;
    private EmpresaProveedoraService empresaProveedoraService;
    private EmpresaProveedora empresaProveedora;

    @Autowired
    private CuadrillaRepository cuadrillaRepository;

    public CuadrillaController(CuadrillaService cuadrillaService) {
        this.cuadrillaService = cuadrillaService;
    }
    // Crud

    //Buscar cuadrilla por id
    /**
     * http://localhost:8085/api/cuadrilla/1
     * @param id
     * @return
     */
    @GetMapping("/cuadrilla/{id}")
    @ApiOperation("Buscar cuadrilla por id")
    public ResponseEntity<Cuadrilla> findById(@ApiParam("Clave primaria cuadrilla") @PathVariable Long id) {
        log.info("REST request to find one city");
        Optional<Cuadrilla> cuadrilla0pt = this.cuadrillaService.findById(id);
        return cuadrilla0pt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Buscar todas las cuadrillas
    /**
     * http://localhost:8085/api/cuadrilla/cuadrillas
     * @return
     */
    @GetMapping("/cuadrillas")
    public List<Cuadrilla> findAll() {
        log.info("REST request to find all cuadrillas");
        System.out.println("entro");
        return this.cuadrillaService.findAll();
    }



    // Crear Cuadrilla

    /**
     * http://localhost:8085/api/cuadrilla/crear/cuadrilla
     *
     * @return
     */
    @PostMapping("/crear/cuadrilla")
    public  ResponseEntity<Cuadrilla> create(@RequestBody Cuadrilla cuadrilla) {
        log.info("REST request to create a city");
        if (cuadrilla.getId() != null) {
            log.warn("Zone already exists");
            return ResponseEntity.badRequest().build();

        }

        return ResponseEntity.ok(this.cuadrillaService.save(cuadrilla));
    }


    // Actualizar Cuadrilla

    /**
     * http://localhost:8085/api/zona
     * @param cuadrilla
     * @return
     */
    @PutMapping("/cuadrilla")
    public ResponseEntity<Cuadrilla> update(@RequestBody Cuadrilla cuadrilla) {
        log.info("REST request to update a Cuadrilla");
        if(cuadrilla.getId() == null) {
            log.warn("Cuadrilla does not exist");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(this.cuadrillaService.save(cuadrilla));
    }
    //Eliminar por id

    /**
     * http://localhost:8085/api/cuadrilla/1
     * @param id
     * @return
     */
    @DeleteMapping("/cuadrilla/{id}")
    public ResponseEntity<Cuadrilla> delete(@PathVariable Long id) {
        log.info("REST request to delete a Zone");
        this.cuadrillaService.deletebyId(id);
        return ResponseEntity.noContent().build();
    }

}
