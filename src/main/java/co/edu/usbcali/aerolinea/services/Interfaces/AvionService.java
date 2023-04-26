package co.edu.usbcali.aerolinea.services.Interfaces;

import co.edu.usbcali.aerolinea.dto.AvionDTO;

import java.util.List;

public interface AvionService {
    List<AvionDTO> obtenerAviones();
    AvionDTO obtenerAvion(Integer id) throws Exception;
    AvionDTO agregarAvion(AvionDTO avionDTO) throws Exception;
}
