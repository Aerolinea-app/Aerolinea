package co.edu.usbcali.aerolinea.utility;

import co.edu.usbcali.aerolinea.domain.RolUsuario;
import co.edu.usbcali.aerolinea.domain.TipoAsiento;
import co.edu.usbcali.aerolinea.dto.RolUsuarioDTO;
import co.edu.usbcali.aerolinea.dto.TipoAsientoDTO;
import co.edu.usbcali.aerolinea.mappers.RolUsuarioMapper;
import co.edu.usbcali.aerolinea.mappers.TipoAsientoMapper;

import java.util.Arrays;
import java.util.List;

public class TipoAsientoUtilTest {
    public static Integer CODIGO_UNO = 1;
    public static Integer CODIGO_DOS = 2;
    public static String DESCRIPCION1 = "Tuista";
    public static String ESTADO1 = "A";
    public static String DESCRIPCION_INVALID = "La descripción es invalida";
    public static String ID_INVALID = "El tipo de asiento con id %s no existe";

    public static TipoAsiento Tipoasiento1 =
            TipoAsiento.builder().idTipoa(CODIGO_UNO).descripcion(DESCRIPCION1).estado(ESTADO1).build();
    public static TipoAsientoDTO TipoasientoDTO =
            TipoAsientoDTO.builder().idTipoa(CODIGO_UNO).descripcion(DESCRIPCION1).estado(ESTADO1).build();
    public static TipoAsientoDTO TipoAsientoDTO_No_Descrip =
            TipoAsientoDTO.builder().idTipoa(CODIGO_UNO).descripcion(null).estado(ESTADO1).build();

    public static List<TipoAsiento> tipoAsientoList = Arrays.asList(Tipoasiento1);
    public static List<TipoAsientoDTO> tipoasientosDTOS = TipoAsientoMapper.domainToDTOList(tipoAsientoList);
    public static List<TipoAsientoDTO> tipoAsiento_vacio = Arrays.asList();
}
