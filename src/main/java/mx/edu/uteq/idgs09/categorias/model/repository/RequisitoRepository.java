package mx.edu.uteq.idgs09.categorias.model.repository;

import mx.edu.uteq.idgs09.categorias.model.entity.Requisito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RequisitoRepository extends JpaRepository<Requisito, Integer> {
    
    List<Requisito> findByActivoTrue();

    @Query("SELECT r FROM Requisito r WHERE r.categoria.id = :categoriaId")
    List<Requisito> findByCategoriaId(@Param("categoriaId") int categoriaId);

    @Query("SELECT r FROM Requisito r WHERE r.tipoRequisito.id = :tipoRequisitoId")
    List<Requisito> findByTipoRequisitoId(@Param("tipoRequisitoId") int tipoRequisitoId);
    
    @Query("SELECT r FROM Requisito r WHERE r.nombre LIKE %:nombre%")
    List<Requisito> findByNombreContaining(@Param("nombre") String nombre);
}
