package mx.edu.uteq.idgs09.categorias.model.repository;

import mx.edu.uteq.idgs09.eval2.model.entity.TipoRequisito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TipoRequisitoRepository extends JpaRepository<TipoRequisito, Integer> {
    
    List<TipoRequisito> findByActivoTrue();

    @Query("SELECT tr FROM TipoRequisito tr WHERE tr.nombre LIKE %:nombre%")
    List<TipoRequisito> findByNombreContaining(@Param("nombre") String nombre);
}
