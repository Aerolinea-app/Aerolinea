package co.edu.usbcali.aerolinea.services.Interfaces;

import co.edu.usbcali.aerolinea.dto.ReservaDTO;

import java.util.List;

public interface ReservaService {
    List<ReservaDTO> obtenerReservas();
    ReservaDTO obtenerReserva(Integer id) throws Exception;
    ReservaDTO agregarReserva(ReservaDTO reservaDTO) throws Exception;
}
