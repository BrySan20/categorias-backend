package mx.edu.uteq.idgs09.eval2.service;

import mx.edu.uteq.idgs09.eval2.model.entity.Requisito;
import mx.edu.uteq.idgs09.eval2.model.entity.Categoria;
import mx.edu.uteq.idgs09.eval2.model.entity.TipoRequisito;
import mx.edu.uteq.idgs09.eval2.model.repository.RequisitoRepository;
import mx.edu.uteq.idgs09.eval2.model.repository.CategoriaRepository;
import mx.edu.uteq.idgs09.eval2.model.repository.TipoRequisitoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RequisitoService {
    
    @Autowired
    private RequisitoRepository repository;
    
    @Autowired
    private CategoriaRepository categoriaRepository;
    
    @Autowired
    private TipoRequisitoRepository tipoRequisitoRepository;

    @Transactional(readOnly = true)
    public List<Requisito> buscarTodos(boolean soloActivos) {
        if (soloActivos) {
            return repository.findByActivoTrue();
        }
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Requisito> buscarPorId(int id) {
        return repository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Requisito> buscarPorCategoria(int categoriaId) {
        return repository.findByCategoriaId(categoriaId);
    }

    @Transactional(readOnly = true)
    public List<Requisito> buscarPorTipoRequisito(int tipoRequisitoId) {
        return repository.findByTipoRequisitoId(tipoRequisitoId);
    }

    @Transactional(readOnly = true)
    public List<Requisito> buscarPorNombre(String nombre) {
        return repository.findByNombreContaining(nombre);
    }

    @Transactional
    public Optional<Requisito> crear(Requisito requisito, int categoriaId, int tipoRequisitoId) {
        Optional<Categoria> categoriaOpt = categoriaRepository.findById(categoriaId);
        Optional<TipoRequisito> tipoRequisitoOpt = tipoRequisitoRepository.findById(tipoRequisitoId);
        
        if (categoriaOpt.isPresent() && tipoRequisitoOpt.isPresent()) {
            requisito.setCategoria(categoriaOpt.get());
            requisito.setTipoRequisito(tipoRequisitoOpt.get());
            return Optional.of(repository.save(requisito));
        }
        return Optional.empty();
    }

    @Transactional
    public Optional<Requisito> editar(int id, Requisito requisito) {
        Optional<Requisito> opt = repository.findById(id);
        if (opt.isPresent()) {
            Requisito r = opt.get();
            r.setNombre(requisito.getNombre());
            r.setActivo(requisito.isActivo());
            
            // Actualizar relaciones si es necesario
            if (requisito.getCategoria() != null) {
                Optional<Categoria> categoriaOpt = categoriaRepository.findById(requisito.getCategoria().getId());
                if (categoriaOpt.isPresent()) {
                    r.setCategoria(categoriaOpt.get());
                }
            }
            
            if (requisito.getTipoRequisito() != null) {
                Optional<TipoRequisito> tipoRequisitoOpt = tipoRequisitoRepository.findById(requisito.getTipoRequisito().getId());
                if (tipoRequisitoOpt.isPresent()) {
                    r.setTipoRequisito(tipoRequisitoOpt.get());
                }
            }
            
            return Optional.of(repository.save(r));
        }
        return opt;
    }

    @Transactional
    public boolean borrar(int id) {
        Optional<Requisito> opt = repository.findById(id);
        if (opt.isPresent()) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Transactional
    public boolean desactivar(int id) {
        Optional<Requisito> opt = repository.findById(id);
        if (opt.isPresent()) {
            Requisito r = opt.get();
            r.setActivo(false);
            repository.save(r);
            return true;
        }
        return false;
    }
}