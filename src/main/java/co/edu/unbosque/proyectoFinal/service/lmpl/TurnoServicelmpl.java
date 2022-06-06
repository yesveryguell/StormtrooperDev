package co.edu.unbosque.proyectoFinal.service.lmpl;

import co.edu.unbosque.proyectoFinal.entities.Ciudad;
import co.edu.unbosque.proyectoFinal.entities.Turno;
import co.edu.unbosque.proyectoFinal.entities.TurnoCuadrilla;
import co.edu.unbosque.proyectoFinal.repository.TurnoRepository;
import co.edu.unbosque.proyectoFinal.service.TurnoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoServicelmpl implements TurnoService {

    @Autowired
    private TurnoRepository turnoRepository;

    private final Logger log = LoggerFactory.getLogger(TurnoServicelmpl.class);

    public TurnoServicelmpl(TurnoRepository turnoRepository) {
        this.turnoRepository = turnoRepository;
    }

    @Override
    public List<Turno> findAll() {
        log.info("Request to get all Turno");
        return this.turnoRepository.findAll();
    }

    @Override
    public Turno findByjornada(String jornada) {
        return turnoRepository.findByjornada(jornada);
    }

    @Override
    public Optional<Turno> findById(Long id) {
        log.info("Executing findById");
        return this.turnoRepository.findById(id);
    }

    @Override
    public Turno save(Turno turno) {
        log.info("Creating new Turno");

        if(!this.validate(turno))
            return null;
        Turno turnoDB = this.turnoRepository.save(turno);
        return turnoDB;
    }

    private boolean validate(Turno turno) {
        if(turno == null) {
            log.warn("Trying to create null turno");
            return false;
        }
        return true;
    }

    @Override
    public void deletebyId(Long id) {
        log.info("Deleting turno");
        if(id == null || id < 0 || id ==0) {
            log.warn("Trying to delete turno with wrong id");
            return;
        }
        try {
            this.turnoRepository.deleteById(id);
        } catch (Exception e) {
            log.warn("Error trying to delete turno by id {}", id, e);
        }
    }
}
