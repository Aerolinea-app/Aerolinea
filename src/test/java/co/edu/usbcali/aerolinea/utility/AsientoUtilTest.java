package co.edu.usbcali.aerolinea.utility;

import co.edu.usbcali.aerolinea.domain.Asiento;
import co.edu.usbcali.aerolinea.dto.AsientoDTO;

import java.util.Arrays;
import java.util.List;

public class AsientoUtilTest {
    public static Integer CODIGO1 = 1;
    public static String UBICACION = "Primera fila";
    public static long PRECIO = 100000;
    public static String ESTADO = "A";

    public static Asiento asiento1 = Asiento.builder()
            .idAsiento(CODIGO1).idTipoa(TipoAsientoUtilTest.Tipoasiento1).idAvion(AvionUtilTest.Avion1).ubicacion(UBICACION).precio(PRECIO).estado(ESTADO).build();
    public static Asiento asiento_malo = Asiento.builder()
            .idTipoa(TipoAsientoUtilTest.Tipoasiento1).idAvion(AvionUtilTest.Avion1).ubicacion(UBICACION).precio(PRECIO).estado(ESTADO).build();

    public static List<Asiento> asientoList = Arrays.asList(asiento1, asiento_malo);

    public static AsientoDTO asientoDTO = AsientoDTO.builder()
            .idAsiento(CODIGO1).idTipoa(TipoAsientoUtilTest.CODIGO_UNO).idAvion(AvionUtilTest.CODIGO_UNO).ubicacion(UBICACION).precio(PRECIO).estado(ESTADO).build();
}
