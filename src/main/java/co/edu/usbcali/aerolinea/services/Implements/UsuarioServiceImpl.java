package co.edu.usbcali.aerolinea.services.Implements;

import co.edu.usbcali.aerolinea.DTO.AvionDTO;
import co.edu.usbcali.aerolinea.DTO.UsuarioDTO;
import co.edu.usbcali.aerolinea.services.Interfaces.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    ArrayList usuarios = new ArrayList();

    UsuarioDTO usuario1 = UsuarioDTO.builder().nombre("Laura Sofia").cedula("1183522").correo("laura739@gmail.com").build();
    UsuarioDTO usuario2 = new UsuarioDTO("Valeria Giraldo","2672528","vale.2639@gmail.com");
    UsuarioDTO usuario3 = new UsuarioDTO("Arturo Barona","86465274","baro.13@gmail.com");
    UsuarioDTO usuario4 = new UsuarioDTO("Paola Garcia","875242","paoGar@gmail.com");

    @Override
    public UsuarioDTO agregarUsuario(UsuarioDTO usuarioDTO) throws Exception {

        if (usuarioDTO == null){
            throw new Exception("El usuario es invalido!");
        }
        if (usuarioDTO.getNombre() == null ){
            throw new Exception("El nombre del usuario es invalido!");
        }
        if (usuarioDTO.getNombre() == "" ){
            throw new Exception("El nombre del usuario es invalido!");
        }
        if (usuarioDTO.getCedula() == null){
            throw new Exception("La cedula del usuario es invalida!");
        }
        if (usuarioDTO.getCedula() == ""){
            throw new Exception("La cedula del usuario es invalida!");
        }
        if (usuarioDTO.getCorreo() == null){
            throw new Exception("El correo del usuario es invalido!");
        }
        if (usuarioDTO.getCorreo() == ""){
            throw new Exception("El correo del usuario es invalido!");
        }

        return usuarioDTO;
    }

    @Override
    public List<UsuarioDTO> obtenerUsuarios() {

        usuarios.add(usuario1);
        usuarios.add(usuario2);
        usuarios.add(usuario3);
        usuarios.add(usuario4);

        return usuarios;
    }

    @Override
    public UsuarioDTO obtenerUsuario() {
        return usuario1;
    }
}
