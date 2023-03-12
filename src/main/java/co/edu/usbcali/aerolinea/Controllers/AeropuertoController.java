package co.edu.usbcali.aerolinea.Controllers;

import co.edu.usbcali.aerolinea.DTO.AeropuertoDTO;
import co.edu.usbcali.aerolinea.DTO.AvionDTO;
import co.edu.usbcali.aerolinea.DTO.MensajeDTO;
import co.edu.usbcali.aerolinea.services.Interfaces.AeropuertoService;
import co.edu.usbcali.aerolinea.services.Interfaces.AvionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aeropuerto")
public class AeropuertoController {
    private AeropuertoService aeropuertoService;
    public AeropuertoController(AeropuertoService aeropuertoService) {
        this.aeropuertoService = aeropuertoService;
    }

    @GetMapping("/obtenerAeropuerto")
    public ResponseEntity<AeropuertoDTO> obtenerAeropuerto() {
        return new ResponseEntity(aeropuertoService.obtenerAeropuerto(), HttpStatus.OK);
    }

    @GetMapping("/obtenerAeropuertos")
    public ResponseEntity<List<AeropuertoDTO>> obtenerAeropuertos() {
        return new ResponseEntity(aeropuertoService.obtenerAeropuertos(), HttpStatus.OK);
    }

    @PostMapping(path = "/agregarAeropuerto",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity agregarAvion(@RequestBody AeropuertoDTO aeropuertoDTO) {
        try {
            return new ResponseEntity(aeropuertoService.agregarAeropuerto(aeropuertoDTO), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(MensajeDTO.builder().mensaje(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }

    }
}

