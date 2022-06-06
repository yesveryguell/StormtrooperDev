package co.edu.unbosque.proyectoFinal.service.lmpl;

import co.edu.unbosque.proyectoFinal.service.CiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.unbosque.proyectoFinal.entities.Ciudad;
import co.edu.unbosque.proyectoFinal.repository.CiudadRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@Service
public class CiudadServicelmpl implements CiudadService {

    @Autowired
    private CiudadRepository ciudadRepository;

    private final Logger log = LoggerFactory.getLogger(CiudadServicelmpl.class);

    public CiudadServicelmpl(CiudadRepository ciudadRepository) {
        this.ciudadRepository = ciudadRepository;
    }


    public List<Ciudad> findAll() {
        log.info("Request to get all Citys");
        return this.ciudadRepository.findAll();
    }

    @Override
    public Ciudad findBynombre(String nombre) {
        return ciudadRepository.findBynombre(nombre);
    }

    @Override
    public Optional<Ciudad> findById(Long id) {
        log.info("Executing findById");
        return this.ciudadRepository.findById(id);
    }

    @Override
    public Ciudad save(Ciudad ciudad) {
        log.info("Creating new City");
        if(!this.validate(ciudad))
            return null;
        Ciudad ciudadDB = this.ciudadRepository.save(ciudad);
        return ciudadDB;
    }



    private boolean validate(Ciudad ciudad) {
        if(ciudad == null) {
            log.warn("Trying to create null city");
            return false;
        }
        return true;
    }

    @Override
    public void deletebyId(Long id) {
        log.info("Deleting City");
        if(id == null || id < 0 || id ==0) {
            log.warn("Trying to delete city with wrong id");
            return;
        }
        try {
            this.ciudadRepository.deleteById(id);
        } catch (Exception e) {
            log.warn("Error trying to delete city by id {}", id, e);
        }
    }


}
