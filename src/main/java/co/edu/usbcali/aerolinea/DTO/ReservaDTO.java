package co.edu.usbcali.aerolinea.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@Builder
@ToString
public class ReservaDTO {
    private int idReserva;
    private int idVuelo;
    private int precioTotal;
    private String estadoPago;
}
