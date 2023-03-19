package co.edu.usbcali.aerolinea.services.Interfaces;

import co.edu.usbcali.aerolinea.dto.AsientoDTO;

import java.util.List;

public interface AsientoService {
    List<AsientoDTO> obtenerAsientos();
    AsientoDTO obtenerAsiento(Integer id) throws Exception;

    //No se si hacer el metodo de agregar asientos, porque lo podriamos dejar definido
    AsientoDTO agregarAsiento(AsientoDTO asientoDTO) throws Exception;
}
