package co.com.personas.repositories;

import co.com.personas.models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Jacevedo
 */
public interface IPersonaRepository extends JpaRepository<Persona, Long> {

    Persona findByTipoDocumentoAndDocumento(String tipoDocumento, String documento);

}
