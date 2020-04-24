package co.com.personas.mappers;

import co.com.personas.dtos.PersonaDTO;
import co.com.personas.models.Persona;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

/**
 *
 * @author Jacevedo
 */
@Mapper(componentModel = "spring")
public interface IPersonaMapper {

    Persona DTOtoEntity(PersonaDTO personaDTO);

    PersonaDTO EntityToDTO(Persona persona);

    void updateEntity(@MappingTarget Persona persona, PersonaDTO personaDTO);
}
