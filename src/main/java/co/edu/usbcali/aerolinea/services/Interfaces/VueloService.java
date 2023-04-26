package co.edu.usbcali.aerolinea.services.Interfaces;

import co.edu.usbcali.aerolinea.dto.VueloDTO;

import java.util.List;

public interface VueloService {
    VueloDTO guardarVuelo(VueloDTO vuelDTO) throws Exception;
    VueloDTO obtenerVuelo(Integer id) throws Exception;
    List<VueloDTO> obtenerVuelos();

}
