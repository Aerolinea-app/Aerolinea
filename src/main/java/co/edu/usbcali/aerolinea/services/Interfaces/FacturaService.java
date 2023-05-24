package co.edu.usbcali.aerolinea.services.Interfaces;

import co.edu.usbcali.aerolinea.dto.FacturaDTO;

import java.util.List;

public interface FacturaService {
    List<FacturaDTO> obtenerFacturas();
    FacturaDTO obtenerFactura(Integer id) throws Exception;
    FacturaDTO agregarFactura(FacturaDTO facturaDTO) throws Exception;
    List<FacturaDTO> obtenerFacturasActivas();
}
