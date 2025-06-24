package mx.edu.uteq.idgs09.eval2.service;

import mx.edu.uteq.idgs09.eval2.model.entity.TipoRequisito;
import mx.edu.uteq.idgs09.eval2.model.repository.TipoRequisitoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TipoRequisitoService {
    
    @Autowired
    private TipoRequisitoRepository repository;

    @Transactional(readOnly = true)
    public List<TipoRequisito> buscarTodos(boolean soloActivos) {
        if (soloActivos) {
            return repository.findByActivoTrue();
        }
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<TipoRequisito> buscarPorId(int id) {
        return repository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<TipoRequisito> buscarPorNombre(String nombre) {
        return repository.findByNombreContaining(nombre);
    }

    @Transactional
    public TipoRequisito crear(TipoRequisito tipoRequisito) {
        return repository.save(tipoRequisito);
    }

    @Transactional
    public Optional<TipoRequisito> editar(int id, TipoRequisito tipoRequisito) {
        Optional<TipoRequisito> opt = repository.findById(id);
        if (opt.isPresent()) {
            TipoRequisito tr = opt.get();
            tr.setNombre(tipoRequisito.getNombre());
            tr.setActivo(tipoRequisito.isActivo());
            return Optional.of(repository.save(tr));
        }
        return opt;
    }

    @Transactional
    public boolean borrar(int id) {
        Optional<TipoRequisito> opt = repository.findById(id);
        if (opt.isPresent()) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Transactional
    public boolean desactivar(int id) {
        Optional<TipoRequisito> opt = repository.findById(id);
        if (opt.isPresent()) {
            TipoRequisito tr = opt.get();
            tr.setActivo(false);
            repository.save(tr);
            return true;
        }
        return false;
    }
}