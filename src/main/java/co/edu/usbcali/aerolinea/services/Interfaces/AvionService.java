package co.edu.usbcali.aerolinea.services.Interfaces;

import co.edu.usbcali.aerolinea.DTO.AvionDTO;
import co.edu.usbcali.aerolinea.DTO.VueloDTO;

import java.util.List;

public interface AvionService {
    AvionDTO agregarAvion(AvionDTO avionDTO) throws Exception;
    AvionDTO obtenerAvion();
    List<AvionDTO> obtenerAviones();
}
