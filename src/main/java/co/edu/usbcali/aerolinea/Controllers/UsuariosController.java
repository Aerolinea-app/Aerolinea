package co.edu.usbcali.aerolinea.Controllers;

import co.edu.usbcali.aerolinea.DTO.AvionDTO;
import co.edu.usbcali.aerolinea.DTO.MensajeDTO;
import co.edu.usbcali.aerolinea.DTO.UsuarioDTO;
import co.edu.usbcali.aerolinea.services.Interfaces.AvionService;
import co.edu.usbcali.aerolinea.services.Interfaces.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    private UsuarioService usuarioService;

    public UsuariosController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/obtenerUsuario")
    public ResponseEntity<UsuarioDTO> obtenerUsuario() {
        return new ResponseEntity(usuarioService.obtenerUsuario(), HttpStatus.OK);
    }

    @GetMapping("/obtenerUsuarios")
    public ResponseEntity<List<UsuarioDTO>> obtenerUsuarios() {
        return new ResponseEntity(usuarioService.obtenerUsuarios(), HttpStatus.OK);
    }

    @PostMapping(path = "/agregarUsuario",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity agregarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        try {
            return new ResponseEntity(usuarioService.agregarUsuario(usuarioDTO), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(MensajeDTO.builder().mensaje(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }

    }

}
