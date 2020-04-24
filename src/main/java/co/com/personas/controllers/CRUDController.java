package co.com.personas.controllers;

import co.com.personas.dtos.PersonaDTO;
import co.com.personas.services.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Jacevedo
 */
@RestController
@RequestMapping("/crud")
public class CRUDController {

    @Autowired
    private Environment env;
    @Autowired
    private CRUDService crudService;

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public ResponseEntity info() {
        return new ResponseEntity<>(env.getProperty("build.version"), HttpStatus.OK);
    }

    @GetMapping(value = "/consultar")
    public ResponseEntity consultar(@RequestParam String tipoDocumento, @RequestParam String documento) {
        return crudService.consultar(tipoDocumento, documento);
    }

    @PostMapping(value = "/registrar")
    public ResponseEntity registrar(@RequestBody PersonaDTO persona){
        return crudService.registrar(persona);
    }

    @PutMapping(value = "/actualizar")
    public ResponseEntity actualizar(@RequestBody PersonaDTO persona){
        return crudService.actualizar(persona);
    }

    @DeleteMapping(value = "/eliminar")
    public ResponseEntity eliminar(@RequestParam Long id){
        return crudService.eliminar(id);
    }
}
