package co.edu.usbcali.aerolinea.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@Builder
@ToString
public class UsuarioDTO {
    private String nombre;
    private String cedula;
    private String correo;
}
