package mx.edu.uteq.idgs09.categorias.model.repository;

import mx.edu.uteq.idgs09.categorias.model.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
   
    List<Categoria> findByActivoTrue();

    @Query("SELECT c FROM Categoria c WHERE c.nombre LIKE %:nombre%")
    List<Categoria> findByNombreContaining(@Param("nombre") String nombre);

    @Query("SELECT c FROM Categoria c WHERE c.nombreCategoriaFederal = :nombreFederal")
    List<Categoria> findByNombreCategoriaFederal(@Param("nombreFederal") String nombreFederal);

    @Query("SELECT c FROM Categoria c WHERE c.nombreCategoriaEstatal = :nombreEstatal")
    List<Categoria> findByNombreCategoriaEstatal(@Param("nombreEstatal") String nombreEstatal);
}
