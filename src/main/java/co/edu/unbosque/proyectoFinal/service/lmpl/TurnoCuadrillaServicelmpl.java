package co.edu.unbosque.proyectoFinal.service.lmpl;

import co.edu.unbosque.proyectoFinal.entities.Turno;
import co.edu.unbosque.proyectoFinal.entities.TurnoCuadrilla;
import co.edu.unbosque.proyectoFinal.entities.Zona;
import co.edu.unbosque.proyectoFinal.repository.TurnoCuadrillaRepository;
import co.edu.unbosque.proyectoFinal.service.TurnoCuadrillaService;
import co.edu.unbosque.proyectoFinal.service.TurnoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoCuadrillaServicelmpl implements TurnoCuadrillaService {
    private final Logger log = LoggerFactory.getLogger(TurnoCuadrillaServicelmpl.class);
    private TurnoCuadrillaRepository turnoCuadrillaRepository;
    @Autowired
    private TurnoService turnoService;
    private Turno turno;

    public TurnoCuadrillaServicelmpl(TurnoCuadrillaRepository turnoCuadrillaRepository) {
        this.turnoCuadrillaRepository = turnoCuadrillaRepository;
    }


    @Override
    public List<TurnoCuadrilla> findAll() {
        log.info("Request to get all TurnoCuadrilla");
        return this.turnoCuadrillaRepository.findAll();
    }

    @Override
    public Optional<TurnoCuadrilla> findById(Long id) {
        log.info("Executing findById");
        return this.turnoCuadrillaRepository.findById(id);
    }

    @Override
    public TurnoCuadrilla save(TurnoCuadrilla turnoCuadrilla) {
        log.info("Creating new Zona");
        TurnoCuadrilla nTurnoCuadrilla = turnoCuadrilla.getTurnoCuadrilla();
        if(!this.validate(turnoCuadrilla))
            return null;
        TurnoCuadrilla turnoCuadrillaDB = this.turnoCuadrillaRepository.save(turnoCuadrilla);
        return null;
    }

    private boolean validate(  TurnoCuadrilla turnoCuadrilla) {
        if(turnoCuadrilla == null) {
            log.warn("Trying to create null zone");
            return false;
        }
        return true;
    }

    @Override
    public void deletebyId(Long id) {

    }
}
