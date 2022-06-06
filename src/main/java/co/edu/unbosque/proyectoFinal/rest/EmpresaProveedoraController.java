package co.edu.unbosque.proyectoFinal.rest;

import co.edu.unbosque.proyectoFinal.entities.Ciudad;
import co.edu.unbosque.proyectoFinal.entities.EmpresaProveedora;
import co.edu.unbosque.proyectoFinal.service.EmpresaProveedoraService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/empresaProveedora")
public class EmpresaProveedoraController {
    private final Logger log = LoggerFactory.getLogger(EmpresaProveedoraController.class);

    private EmpresaProveedoraService empresaProveedoraService;

    public EmpresaProveedoraController(EmpresaProveedoraService empresaProveedoraService) {
        this.empresaProveedoraService = empresaProveedoraService;
    }

    // Crud

    //Buscar empresaProveedora por id
    /**
     * http://localhost:8085/api/ciudad/1
     * @param id
     * @return
     */
    @GetMapping("/empresaProveedora/{id}")
    @ApiOperation("Buscar empresaProveedora por id")
    public ResponseEntity<EmpresaProveedora> findById(@ApiParam("Clave primaria empresaProveedora") @PathVariable Long id) {
        log.info("REST request to find one EmpresaProveedora");
        Optional<EmpresaProveedora> empresaProveedora0pt = this.empresaProveedoraService.findById(id);
        return empresaProveedora0pt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Buscar todas las EmpresaProveedoras
    /**
     * http://localhost:8085/api/ciudad
     * @return
     */
    @GetMapping("/EmpresaProveedoras")
    public List<EmpresaProveedora> findAll() {
        log.info("REST request to find all cities");
        return this.empresaProveedoraService.findAll();
    }

    // Crear ciudad
    @PostMapping("/empresaProveedora")
    public  ResponseEntity<EmpresaProveedora> create(@RequestBody EmpresaProveedora empresaProveedora) {
        log.info("REST request to create a EmpresaProveedora");
        if(empresaProveedora.getId() != null) {
            log.warn("EmpresaProveedora already exists");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(this.empresaProveedoraService.save(empresaProveedora));
    }

    // Actualizar EmpresaProveedora

    /**
     * http://localhost:8085/api/EmpresaProveedora
     * @param empresaProveedora
     * @return
     */
    @PutMapping("/empresaProveedora")
    public ResponseEntity<EmpresaProveedora> update(@RequestBody EmpresaProveedora empresaProveedora) {
        log.info("REST request to update a EmpresaProveedora");
        if(empresaProveedora.getId() == null) {
            log.warn("EmpresaProveedora does not exist");
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(this.empresaProveedoraService.save(empresaProveedora));
    }
    //Eliminar por id

    /**
     * http://localhost:8085/api/empresaProveedora/1
     * @param id
     * @return
     */
    @DeleteMapping("/empresaProveedora/{id}")
    public ResponseEntity<EmpresaProveedora> delete(@PathVariable Long id) {
        log.info("REST request to delete a city");
        this.empresaProveedoraService.deletebyId(id);
        return ResponseEntity.noContent().build();
    }

}
