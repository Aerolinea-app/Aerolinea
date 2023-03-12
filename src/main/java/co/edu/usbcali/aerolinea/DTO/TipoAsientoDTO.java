package co.edu.usbcali.aerolinea.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@Builder
@ToString
public class TipoAsientoDTO {
    private int idAsiento;
    private String ubicacion;
    private String estado;
}
