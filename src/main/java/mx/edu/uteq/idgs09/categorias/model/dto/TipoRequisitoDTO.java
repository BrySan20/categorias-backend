package mx.edu.uteq.idgs09.categorias.model.dto;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class TipoRequisitoDTO {
    private int id;
    private String nombre;
    private boolean activo;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
}
