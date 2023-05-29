package co.edu.usbcali.aerolinea.services.Interfaces;

import co.edu.usbcali.aerolinea.dto.AeropuertoDTO;
import co.edu.usbcali.aerolinea.dto.TipoAsientoDTO;
import co.edu.usbcali.aerolinea.dto.TrayectoDTO;

import java.util.List;

public interface TrayectoService {
    List<TrayectoDTO> obtenerTrayectos();
    TrayectoDTO obtenerTrayecto(Integer id) throws Exception;
    TrayectoDTO agregarTrayecto(TrayectoDTO trayectoDTO) throws Exception;
    List<TrayectoDTO> obtenerTrayectosActivos();
    TrayectoDTO updateTrayecto(TrayectoDTO trayectoDTO) throws Exception;
    TrayectoDTO deleteTrayecto(Integer id) throws Exception;
}
