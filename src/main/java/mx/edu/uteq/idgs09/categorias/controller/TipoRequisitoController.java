package mx.edu.uteq.idgs09.categorias.controller;

import mx.edu.uteq.idgs09.eval2.model.entity.TipoRequisito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import mx.edu.uteq.idgs09.eval2.service.TipoRequisitoService;

@RestController
@RequestMapping("/api/tipo-requisitos")
public class TipoRequisitoController {
    @Autowired private TipoRequisitoService tipoService;

    @GetMapping
    public List<TipoRequisito> obtenerTipos(){
        return tipoService.listar();
    }

    @PostMapping
    public TipoRequisito crearTipo(@RequestBody TipoRequisito tipo){
        return tipoService.guardar(tipo);
    }
}
