package mx.edu.uteq.idgs09.categorias.model.dto;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class CategoriaDTO {
    private int id;
    private String nombre;
    private String nombreCategoriaAnterior;
    private String nombreCategoriaFederal;
    private String nombreCategoriaEstatal;
    private boolean activo;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
    private List<RequisitoDTO> requisitos;
}
