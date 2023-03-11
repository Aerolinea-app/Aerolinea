package co.edu.usbcali.aerolinea.Controllers;

import co.edu.usbcali.aerolinea.DTO.AvionDTO;
import co.edu.usbcali.aerolinea.DTO.MensajeDTO;
import co.edu.usbcali.aerolinea.services.Interfaces.AvionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/aviones")
public class AvionesController {

    private AvionService avionService;

    public AvionesController(AvionService avionService) {
        this.avionService = avionService;
    }

    @GetMapping("/obtenerAvion")
    public ResponseEntity<AvionDTO> obtenerAvion() {
        return new ResponseEntity(avionService.obtenerAvion(), HttpStatus.OK);
    }

    @GetMapping("/obtenerAviones")
    public ResponseEntity<List<AvionDTO>> obtenerAviones() {
        return new ResponseEntity(avionService.obtenerAviones(), HttpStatus.OK);
    }

    @PostMapping(path = "/agregarAvion",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity agregarAvion(@RequestBody AvionDTO avionDTO) {
        try {
            return new ResponseEntity(avionService.agregarAvion(avionDTO), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(MensajeDTO.builder().mensaje(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }

    }
}

