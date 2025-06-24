package mx.edu.uteq.idgs09.categorias.client;

import java.util.List;

import mx.edu.uteq.idgs09.categorias.model.entity.Categoria;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "ms-catalogo-categorias", url = "localhost:8001")
public interface CategoriaClientRest {

    @GetMapping("/api/categoria")
    ResponseEntity<List<Categoria>> buscarTodos(@RequestParam boolean soloActivos);

    @GetMapping("/api/categoria/{id}")
    ResponseEntity<Categoria> buscarPorId(@PathVariable int id);

    @PostMapping("/api/categoria")
    ResponseEntity<Categoria> crear(@RequestBody Categoria categoria);

    @PutMapping("/api/categoria/{id}")
    ResponseEntity<Categoria> editar(@PathVariable int id, @RequestBody Categoria categoria);

    @DeleteMapping("/api/categoria/{id}")
    ResponseEntity<Void> eliminar(@PathVariable int id);

    @GetMapping("/api/categoria/buscar-por-nombre")
    ResponseEntity<List<Categoria>> buscarPorNombre(@RequestParam String nombre);

    @GetMapping("/api/categoria/buscar-por-federal")
    ResponseEntity<List<Categoria>> buscarPorNombreFederal(@RequestParam String nombreFederal);

    @GetMapping("/api/categoria/buscar-por-estatal")
    ResponseEntity<List<Categoria>> buscarPorNombreEstatal(@RequestParam String nombreEstatal);
}
