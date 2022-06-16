package co.edu.unbosque.proyectoFinal.service.lmpl;

import co.edu.unbosque.proyectoFinal.entities.Cuadrilla;
import co.edu.unbosque.proyectoFinal.entities.EmpresaProveedora;
import co.edu.unbosque.proyectoFinal.entities.Zona;
import co.edu.unbosque.proyectoFinal.repository.CuadrillaRepository;
import co.edu.unbosque.proyectoFinal.service.CuadrillaService;
import co.edu.unbosque.proyectoFinal.service.EmpresaProveedoraService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CuadrillaServicelmpl implements CuadrillaService {

    private final Logger log = LoggerFactory.getLogger(CuadrillaServicelmpl.class);
    private CuadrillaRepository cuadrillaRepository;
    @Autowired
    private EmpresaProveedoraService empresaProveedoraService;
    private EmpresaProveedora empresaProveedora;

    public CuadrillaServicelmpl(CuadrillaRepository cuadrillaRepository) {
        this.cuadrillaRepository = cuadrillaRepository;
    }

    @Override
    public List<Cuadrilla> findAll() {
        log.info("Request to get all Cuadrillas");
        return this.cuadrillaRepository.findAll();
    }

    @Override
    public Optional<Cuadrilla> findById(Long id) {
        log.info("Executing findById");
        return this.cuadrillaRepository.findById(id);
    }

    @Override
    public Cuadrilla save(Cuadrilla cuadrilla) {
        log.info("Creating new Zona");
        Cuadrilla nCuadrilla = cuadrilla.getCuadrilla();
        if (!this.validate(cuadrilla))
            return null;
        Cuadrilla cuadrillaDB = this.cuadrillaRepository.save(cuadrilla);
        return null;
    }

    private boolean validate(Cuadrilla cuadrilla) {
        if (cuadrilla == null) {
            log.warn("Trying to create null zone");
            return false;
        }
        return true;
    }


    @Override
    public void deletebyId(Long id) {
        log.info("Deleting cuadrilla");
        if (id == null || id < 0 || id == 0) {
            log.warn("Trying to delete zone with wrong id");
            return;
        }
        try {
            this.cuadrillaRepository.deleteById(id);
        } catch (Exception e) {
            log.warn("Trying to delete zone with wrong id", id, e);
        }

    }

}
