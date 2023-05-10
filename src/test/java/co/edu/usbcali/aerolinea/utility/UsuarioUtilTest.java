package co.edu.usbcali.aerolinea.utility;

import co.edu.usbcali.aerolinea.domain.Usuario;
import co.edu.usbcali.aerolinea.dto.UsuarioDTO;

import java.util.Arrays;
import java.util.List;

public class UsuarioUtilTest {
    public static Integer CODIGO1 = 1;
    public static Integer CODIGO2 = 2;
    public static String CEDULA = "32123522";
    public static String NOMBRE = "Arturo";
    public static String PELLIDO = "Barona";
    public static String CORREO = "prueba@gmail.com";
    public static String ESTADO = "A";

    public static Usuario Usuario1 = Usuario.builder()
            .idUsuario(CODIGO1).idRolUsuario(RolUsuarioUtilTest.Rolusuario1).nombre(NOMBRE).apellido(PELLIDO).cedula(CEDULA).correo(CORREO).estado(ESTADO).build();
    public static UsuarioDTO UsuarioDTO_Malo = UsuarioDTO.builder()
            .idRolusuario(RolUsuarioUtilTest.CODIGO_UNO).nombre(NOMBRE).apellido(PELLIDO).cedula(CEDULA).correo(CORREO).estado(ESTADO).build();

    public static List<Usuario> usuarioList = Arrays.asList(Usuario1);

    public static UsuarioDTO usuarioDTO = UsuarioDTO.builder()
            .idUsuario(CODIGO1).idRolusuario(RolUsuarioUtilTest.CODIGO_UNO).nombre(NOMBRE).apellido(PELLIDO).cedula(CEDULA).correo(CORREO).estado(ESTADO).build();
}
