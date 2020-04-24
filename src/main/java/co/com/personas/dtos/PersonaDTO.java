package co.com.personas.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 *
 * @author Jacevedo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDTO implements Serializable {

    private String tipoDocumento;
    private String documento;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;

}
