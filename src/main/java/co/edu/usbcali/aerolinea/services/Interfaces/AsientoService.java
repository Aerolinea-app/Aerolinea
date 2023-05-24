package co.edu.usbcali.aerolinea.services.Interfaces;

import co.edu.usbcali.aerolinea.dto.AsientoDTO;

import java.util.List;

public interface AsientoService {
    List<AsientoDTO> obtenerAsientos();
    AsientoDTO obtenerAsiento(Integer id) throws Exception;
    List<AsientoDTO> obtenerAsientosActivos();
    AsientoDTO agregarAsiento(AsientoDTO asientoDTO) throws Exception;
}
