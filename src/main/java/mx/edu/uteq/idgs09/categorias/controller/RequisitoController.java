package mx.edu.uteq.idgs09.categorias.controller;

import java.util.List;
import mx.edu.uteq.idgs09.eval2.model.dto.RequisitoDTO;
import mx.edu.uteq.idgs09.eval2.service.RequisitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import mx.edu.uteq.idgs09.eval2.model.entity.Requisito;
import mx.edu.uteq.idgs09.eval2.model.entity.TipoRequisito;

@RestController
@RequestMapping("/api/requisitos")
public class RequisitoController {
    @Autowired private RequisitoService requisitoService;

    @GetMapping
    public List<Requisito> listar() {
        return requisitoService.listar();
    }

    @PostMapping
    public Requisito crear(@RequestBody RequisitoDTO dto) {
        return requisitoService.guardar(dto);
    }
}
