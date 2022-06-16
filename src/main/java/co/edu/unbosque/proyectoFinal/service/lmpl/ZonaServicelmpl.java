package co.edu.unbosque.proyectoFinal.service.lmpl;

import co.edu.unbosque.proyectoFinal.entities.Ciudad;
import co.edu.unbosque.proyectoFinal.entities.Zona;
import co.edu.unbosque.proyectoFinal.repository.ZonaRepository;
import co.edu.unbosque.proyectoFinal.service.CiudadService;
import co.edu.unbosque.proyectoFinal.service.ZonaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ZonaServicelmpl implements ZonaService {
    private final Logger log = LoggerFactory.getLogger(ZonaServicelmpl.class);
    private ZonaRepository zonaRepository;
    @Autowired
    private CiudadService ciudadService;
    private Ciudad ciudad;

    public ZonaServicelmpl(ZonaRepository zonaRepository) {
        this.zonaRepository = zonaRepository;
    }


    @Override
    public List<Zona> findAll() {
        log.info("Request to get all Zones");
        System.out.println("*x*x*x*x*x*x*");
        return this.zonaRepository.findAll();
    }

    @Override
    public Optional<Zona> findById(Long id) {
        log.info("Executing findById");
        return this.zonaRepository.findById(id);
    }

    @Override
    public Zona save(Zona zona) {
        log.info("Creating new Zona");
        Zona nZona = zona.getZona();
        if (!this.validate(zona))
            return null;
        Zona zonaDB = this.zonaRepository.save(zona);
        return null;
    }

    private boolean validate(Zona zona) {
        if (zona == null) {
            log.warn("Trying to create null zone");
            return false;
        }
        return true;
    }


    @Override
    public void deletebyId(Long id) {
        log.info("Deleting Zona");
        if (id == null || id < 0 || id == 0) {
            log.warn("Trying to delete zone with wrong id");
            return;
        }
        try {
            this.zonaRepository.deleteById(id);
        } catch (Exception e) {
            log.warn("Trying to delete zone with wrong id", id, e);
        }

    }
}

