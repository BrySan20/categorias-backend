package mx.edu.uteq.idgs09.categorias.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import mx.edu.uteq.idgs09.eval2.service.CategoriaService;
import mx.edu.uteq.idgs09.eval2.model.entity.Categoria;

@RestController
@RequestMapping("api/categorias")
public class CategoriaController {
    
        @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> obtenerCategorias() {
        return categoriaService.listar();
    }

    @PostMapping
    public Categoria crearCategoria(@RequestBody Categoria categoria){
        return categoriaService.guardar(categoria);
    }
    
}
