package co.edu.unbosque.proyectoFinal.service.lmpl;

import co.edu.unbosque.proyectoFinal.entities.OrdenTrabajo;

import co.edu.unbosque.proyectoFinal.service.OrdenTrabajoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.unbosque.proyectoFinal.repository.OrdenTrabajoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@Service
public class OrdenTrabajoServicelmpl implements OrdenTrabajoService {


    @Autowired
    private OrdenTrabajoRepository ordenTrabajoRepository;

    private final Logger log = LoggerFactory.getLogger(OrdenTrabajoServicelmpl.class);

    public OrdenTrabajoServicelmpl(OrdenTrabajoRepository ordenTrabajoRepository) {
        this.ordenTrabajoRepository = ordenTrabajoRepository;
    }

    @Override
    public List<OrdenTrabajo> findAll() {
        log.info("Request to get all Citys");
        return this.ordenTrabajoRepository.findAll();
    }

    @Override
    public OrdenTrabajo findBynombretrabajo(String nombretrabajo) {
        return ordenTrabajoRepository.findBynombretrabajo(nombretrabajo);
    }

    @Override
    public Optional<OrdenTrabajo> findById(Long id) {
        log.info("Executing findById");
        return this.ordenTrabajoRepository.findById(id);
    }

    @Override
    public OrdenTrabajo save(OrdenTrabajo ordenTrabajo) {
        log.info("Creating ordenTrabajo");
        if (!this.validate(ordenTrabajo))
            return null;
        OrdenTrabajo ordenTrabajoBD = this.ordenTrabajoRepository.save(ordenTrabajo);
        return ordenTrabajoBD;
    }


    private boolean validate(OrdenTrabajo ordenTrabajo) {
        if (ordenTrabajo == null) {
            log.warn("Trying to create null ordenTrabajo");
            return false;
        }
        return true;
    }

    @Override
    public void deletebyId(Long id) {
        log.info("Deleting ordenTrabajo");
        if (id == null || id < 0 || id == 0) {
            log.warn("Trying to delete ordenTrabajo with wrong id");
            return;
        }
        try {
            this.ordenTrabajoRepository.deleteById(id);
        } catch (Exception e) {
            log.warn("Error trying to delete car by id {}", id, e);
        }
    }

}
