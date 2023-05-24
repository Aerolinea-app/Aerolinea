package co.edu.usbcali.aerolinea.services.Interfaces;

import co.edu.usbcali.aerolinea.dto.RolUsuarioDTO;

import java.util.List;

public interface RolUsuarioService {
    List<RolUsuarioDTO> obtenerRolUsuarios();
    RolUsuarioDTO obtenerRolUsuario(Integer id) throws Exception;
    RolUsuarioDTO guardarRolUsuario(RolUsuarioDTO rolUsuarioDTO) throws Exception;
    List<RolUsuarioDTO> obtenerRolUsuariosActivos();
}

