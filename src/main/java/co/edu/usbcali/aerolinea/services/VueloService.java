package co.edu.usbcali.aerolinea.services;

import co.edu.usbcali.aerolinea.DTO.vueloDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface VueloService {
    vueloDTO guardarVuelo(vueloDTO vuelDTO) throws Exception;
    vueloDTO obtenerVuelo();
    List<vueloDTO> obtenerVuelos();

}
