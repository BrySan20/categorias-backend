package mx.edu.uteq.idgs09.categorias.model.dto;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class RequisitoDTO {
    private int id;
    private String nombre;
    private boolean activo;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
    private TipoRequisitoDTO tipoRequisito;
    private CategoriaDTO categoria;
}
