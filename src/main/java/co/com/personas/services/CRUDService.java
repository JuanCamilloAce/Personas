package co.com.personas.services;

import co.com.personas.dtos.PersonaDTO;
import co.com.personas.mappers.IPersonaMapper;
import co.com.personas.models.Persona;
import co.com.personas.repositories.IPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jacevedo
 */
@Service
public class CRUDService {

    @Autowired
    private IPersonaRepository iPersonaRepository;
    @Autowired
    private IPersonaMapper iPersonaMapper;

    public ResponseEntity consultar(String tipoDocumento, String documento){
        return new ResponseEntity(iPersonaMapper.EntityToDTO(iPersonaRepository.findByTipoDocumentoAndDocumento(tipoDocumento, documento)), HttpStatus.OK);
    }

    public ResponseEntity registrar(PersonaDTO personaDTO){
        Persona persona = iPersonaRepository.save(iPersonaMapper.DTOtoEntity(personaDTO));
        return new ResponseEntity(iPersonaMapper.EntityToDTO(persona), HttpStatus.OK);
    }

    public ResponseEntity actualizar(PersonaDTO personaDTO){
        Persona persona = iPersonaRepository.findByTipoDocumentoAndDocumento(personaDTO.getTipoDocumento(), personaDTO.getDocumento());
        iPersonaMapper.updateEntity(persona, personaDTO);
        iPersonaRepository.save(persona);
        return new ResponseEntity(iPersonaMapper.EntityToDTO(persona), HttpStatus.OK);
    }

    public ResponseEntity eliminar(Long id){
        iPersonaRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
