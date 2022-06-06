package co.edu.unbosque.proyectoFinal.service.lmpl;

import co.edu.unbosque.proyectoFinal.entities.Material;

import co.edu.unbosque.proyectoFinal.entities.OrdenTrabajo;
import co.edu.unbosque.proyectoFinal.repository.MaterialRepository;
import co.edu.unbosque.proyectoFinal.service.MaterialService;
import co.edu.unbosque.proyectoFinal.service.OrdenTrabajoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialServicelmpl implements MaterialService {
    private final Logger log = LoggerFactory.getLogger(MaterialServicelmpl.class);
    private MaterialRepository materialRepository;
    @Autowired
    private OrdenTrabajoService ordenTrabajoService;
    private OrdenTrabajo ordenTrabajo;

    public MaterialServicelmpl(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    @Override
    public List<Material> findAll() {
        log.info("Request to get all Zones");
        System.out.println("*x*x*x*x*x*x*");
        return this.materialRepository.findAll();
    }

    @Override
    public Optional<Material> findById(Long id) {
        log.info("Executing findById");
        return this.materialRepository.findById(id);
    }

    @Override
    public Material save(Material material) {
        log.info("Creating new Zona");
        Material nMaterial = material.getMaterial();
        if(!this.validate(material))
            return null;
        Material materialDB = this.materialRepository.save(material);
        return null;
    }

    private boolean validate(  Material material) {
        if(material == null) {
            log.warn("Trying to create null zone");
            return false;
        }
        return true;
    }


    @Override
    public void deletebyId(Long id) {
        log.info("Deleting Zona");
        if(id == null || id < 0 || id ==0) {
            log.warn("Trying to delete zone with wrong id");
            return;
        }
        try {
            this.materialRepository.deleteById(id);
        } catch (Exception e) {
            log.warn("Trying to delete zone with wrong id", id, e);
        }

    }
}

