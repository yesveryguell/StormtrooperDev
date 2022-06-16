package co.edu.unbosque.proyectoFinal.service.lmpl;

import co.edu.unbosque.proyectoFinal.entities.EmpresaProveedora;
import co.edu.unbosque.proyectoFinal.repository.EmpresaProveedoraRepository;
import co.edu.unbosque.proyectoFinal.service.EmpresaProveedoraService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaProveedoraServicelmpl implements EmpresaProveedoraService {

    @Autowired
    private EmpresaProveedoraRepository empresaProveedoraRepository;
    private final Logger log = LoggerFactory.getLogger(EmpresaProveedoraServicelmpl.class);

    public EmpresaProveedoraServicelmpl(EmpresaProveedoraRepository empresaProveedoraRepository) {
        this.empresaProveedoraRepository = empresaProveedoraRepository;
    }


    @Override
    public List<EmpresaProveedora> findAll() {
        log.info("Request to get all EmpresaProveedoras");
        return this.empresaProveedoraRepository.findAll();
    }

    @Override
    public EmpresaProveedora findBynombre(String nombre) {
        return empresaProveedoraRepository.findBynombre(nombre);
    }

    @Override
    public Optional<EmpresaProveedora> findById(Long id) {
        log.info("Executing findById");
        return this.empresaProveedoraRepository.findById(id);
    }

    @Override
    public EmpresaProveedora save(EmpresaProveedora empresaProveedora) {
        log.info("Creating new EmpresaProveedora");
        if (!this.validate(empresaProveedora))
            return null;
        EmpresaProveedora empresaProveedoraDB = this.empresaProveedoraRepository.save(empresaProveedora);
        return empresaProveedoraDB;
    }

    private boolean validate(EmpresaProveedora empresaProveedora) {
        if (empresaProveedora == null) {
            log.warn("Trying to create null EmpresaProveedora");
            return false;
        }
        return true;
    }


    @Override
    public void deletebyId(Long id) {
        log.info("Deleting empresa provvedora");
        if (id == null || id < 0 || id == 0) {
            log.warn("Trying to delete empresa provvedora with wrong id");
            return;
        }
        try {
            this.empresaProveedoraRepository.deleteById(id);
        } catch (Exception e) {
            log.warn("Error trying to delete empresa proveedora by id {}", id, e);
        }
    }
}
