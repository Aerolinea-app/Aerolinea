package co.edu.usbcali.aerolinea.utility;

import co.edu.usbcali.aerolinea.domain.Avion;
import co.edu.usbcali.aerolinea.domain.Factura;
import co.edu.usbcali.aerolinea.dto.AvionDTO;
import co.edu.usbcali.aerolinea.dto.FacturaDTO;
import co.edu.usbcali.aerolinea.mappers.AvionMapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class FacturaUtilTest {
    public static Integer CODIGO1 = 1;
    public static Date FECHA1 = new Date();
    public static String ESTADO1 = "A";
    public static Integer CODIGO2 = 2;
    public static Date FECHA2 = new Date();
    public static String ESTADO2 = "I";

    public static String FECHA_FUTURO = "2023-11-27 08:00";
    public static String PATTERN_FECHA = "yyyy-MM-dd HH:mm";
    public static Date FECHA_FUTURO_DATE;

    static {
        try {
            FECHA_FUTURO_DATE = new SimpleDateFormat(PATTERN_FECHA).parse(FECHA_FUTURO);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static Factura Factura1 = Factura.builder()
            .idFactura(CODIGO1)
            .idUsuario(UsuarioUtilTest.Usuario1)
            .fecha(FECHA1)
            .estado(ESTADO1)
            .build();

    public static Factura Factura2 = Factura.builder()
            .idFactura(CODIGO2)
            .idUsuario(UsuarioUtilTest.Usuario1)
            .fecha(FECHA2)
            .estado(ESTADO2)
            .build();

    public static FacturaDTO facturaDTO = FacturaDTO.builder()
            .idFactura(1)
            .idUsuario(UsuarioUtilTest.CODIGO1)
            .fecha(FECHA_FUTURO_DATE)
            .estado("A")
            .build();

    public static List<Factura> facturaList = Arrays.asList(Factura1, Factura2);

    public static List<Factura> facturas_vacio = Arrays.asList();
}
