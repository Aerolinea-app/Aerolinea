package co.edu.usbcali.aerolinea.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@Builder
@ToString
public class TrayectoDTO {
    private int idAeropuertoOrigen;
    private int idAeropuertoDestino;
    private int idVuelo;
}
