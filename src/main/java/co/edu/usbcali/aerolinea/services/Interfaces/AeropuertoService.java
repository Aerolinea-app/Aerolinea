package co.edu.usbcali.aerolinea.services.Interfaces;

import co.edu.usbcali.aerolinea.DTO.AeropuertoDTO;
import co.edu.usbcali.aerolinea.DTO.AvionDTO;

import java.util.List;

public interface AeropuertoService {
    AeropuertoDTO agregarAeropuerto(AeropuertoDTO aeropuertoDTO) throws Exception;
    AeropuertoDTO obtenerAeropuerto();
    List<AeropuertoDTO> obtenerAeropuertos();
}
