package co.edu.usbcali.aerolinea.services.Interfaces;

import co.edu.usbcali.aerolinea.DTO.AvionDTO;
import co.edu.usbcali.aerolinea.DTO.UsuarioDTO;

import java.util.List;

public interface UsuarioService {
    UsuarioDTO agregarUsuario(UsuarioDTO usuarioDTO) throws Exception;
    List<UsuarioDTO> obtenerUsuarios();
    UsuarioDTO obtenerUsuario();
}
