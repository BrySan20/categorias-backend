package mx.edu.uteq.idgs09.eval2.service;

import mx.edu.uteq.idgs09.eval2.model.entity.Categoria;
import mx.edu.uteq.idgs09.eval2.model.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository repository;

    @Transactional(readOnly = true)
    public List<Categoria> buscarTodos(boolean soloActivos) {
        if (soloActivos) {
            return repository.findByActivoTrue();
        }
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Categoria> buscarPorId(int id) {
        return repository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Categoria> buscarPorNombre(String nombre) {
        return repository.findByNombreContaining(nombre);
    }

    @Transactional(readOnly = true)
    public List<Categoria> buscarPorNombreFederal(String nombreFederal) {
        return repository.findByNombreCategoriaFederal(nombreFederal);
    }

    @Transactional(readOnly = true)
    public List<Categoria> buscarPorNombreEstatal(String nombreEstatal) {
        return repository.findByNombreCategoriaEstatal(nombreEstatal);
    }

    @Transactional
    public Categoria crear(Categoria categoria) {
        return repository.save(categoria);
    }

    @Transactional
    public Optional<Categoria> editar(int id, Categoria categoria) {
        Optional<Categoria> opt = repository.findById(id);
        if (opt.isPresent()) {
            Categoria c = opt.get();
            c.setNombre(categoria.getNombre());
            c.setNombreCategoriaAnterior(categoria.getNombreCategoriaAnterior());
            c.setNombreCategoriaFederal(categoria.getNombreCategoriaFederal());
            c.setNombreCategoriaEstatal(categoria.getNombreCategoriaEstatal());
            c.setActivo(categoria.isActivo());
            return Optional.of(repository.save(c));
        }
        return opt;
    }

    @Transactional
    public boolean borrar(int id) {
        Optional<Categoria> opt = repository.findById(id);
        if (opt.isPresent()) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Transactional
    public boolean desactivar(int id) {
        Optional<Categoria> opt = repository.findById(id);
        if (opt.isPresent()) {
            Categoria c = opt.get();
            c.setActivo(false);
            repository.save(c);
            return true;
        }
        return false;
    }
}