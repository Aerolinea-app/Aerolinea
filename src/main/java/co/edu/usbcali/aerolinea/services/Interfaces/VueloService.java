package co.edu.usbcali.aerolinea.services.Interfaces;

import co.edu.usbcali.aerolinea.DTO.VueloDTO;

import java.util.List;

public interface VueloService {
    VueloDTO guardarVuelo(VueloDTO vuelDTO) throws Exception;
    VueloDTO obtenerVuelo();
    List<VueloDTO> obtenerVuelos();

}
