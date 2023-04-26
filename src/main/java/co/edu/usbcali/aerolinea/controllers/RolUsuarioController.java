package co.edu.usbcali.aerolinea.controllers;

import co.edu.usbcali.aerolinea.dto.AeropuertoDTO;
import co.edu.usbcali.aerolinea.dto.AvionDTO;
import co.edu.usbcali.aerolinea.dto.MensajeDTO;
import co.edu.usbcali.aerolinea.dto.RolUsuarioDTO;
import co.edu.usbcali.aerolinea.services.Interfaces.AeropuertoService;
import co.edu.usbcali.aerolinea.services.Interfaces.RolUsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/rolUsuario")
public class RolUsuarioController {
    private RolUsuarioService rolUsuarioService;
    public RolUsuarioController(RolUsuarioService rolUsuarioService) {
        this.rolUsuarioService = rolUsuarioService;
    }
    @GetMapping("/obtenerTodos")
    public ResponseEntity<List<RolUsuarioDTO>> obtenerTodos() throws Exception {
        return new ResponseEntity(rolUsuarioService.obtenerRolUsuarios(), HttpStatus.OK);
    }
    @GetMapping("/obtenerRolUsuario/{idRolusuario}")
    public ResponseEntity<RolUsuarioDTO> obtenerRolUsuario(@PathVariable("idRolusuario") Integer idRolusuario) {
        try {
            return new ResponseEntity(rolUsuarioService.obtenerRolUsuario(idRolusuario), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(MensajeDTO.builder().mensaje(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping(path = "/guardarRolUsuario",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity guardarRolUsuario(@RequestBody RolUsuarioDTO rolUsuarioDTO) {
        try {
            return new ResponseEntity(rolUsuarioService.guardarRolUsuario(rolUsuarioDTO), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(MensajeDTO.builder().mensaje(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }

    }
}
