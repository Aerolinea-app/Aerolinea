package co.edu.usbcali.aerolinea.controllers;

import co.edu.usbcali.aerolinea.dto.AvionDTO;
import co.edu.usbcali.aerolinea.dto.FacturaDTO;
import co.edu.usbcali.aerolinea.dto.MensajeDTO;
import co.edu.usbcali.aerolinea.services.Interfaces.FacturaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/factura")
@CrossOrigin(origins = "*", methods= { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT })
@Slf4j
public class FacturaController {
    private final FacturaService facturaService;
    public FacturaController(FacturaService facturaService) {
        this.facturaService = facturaService;
    }
    @GetMapping("/obtenerFacturas")
    public ResponseEntity<List<FacturaDTO>> obtenerFacturas() {
        return new ResponseEntity(facturaService.obtenerFacturas(), HttpStatus.OK);
    }

    @GetMapping("/obtenerFactura/{idFactura}")
    public ResponseEntity<FacturaDTO> obtenerFactura(@PathVariable("idFactura") Integer idFactura) {
        try {
            return new ResponseEntity(facturaService.obtenerFactura(idFactura), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(MensajeDTO.builder().mensaje(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/obtenerFacturasActivas")
    public ResponseEntity<List<FacturaDTO>> obtenerFacturasActivas() {
        return new ResponseEntity(facturaService.obtenerFacturasActivas(), HttpStatus.OK);
    }

    @PostMapping(path = "/agregarFactura",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity guardarFactura(@RequestBody FacturaDTO facturaDTO) {
        try {
            return new ResponseEntity(facturaService.agregarFactura(facturaDTO), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(MensajeDTO.builder().mensaje(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(path = "/updateFactura",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateFactura(@RequestBody FacturaDTO facturaDTO) {
        try {
            return new ResponseEntity(facturaService.updateFactura(facturaDTO), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(MensajeDTO.builder().mensaje(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/deleteFactura/{idFactura}")
    public ResponseEntity deleteFactura(@PathVariable("idFactura") Integer idFactura) {
        try {
            return new ResponseEntity(facturaService.deleteFactura(idFactura), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(MensajeDTO.builder().mensaje(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }
}
