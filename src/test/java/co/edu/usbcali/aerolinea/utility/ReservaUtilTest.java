package co.edu.usbcali.aerolinea.utility;

import co.edu.usbcali.aerolinea.domain.Reserva;
import co.edu.usbcali.aerolinea.dto.ReservaDTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ReservaUtilTest {
    public static Integer CODIGO1 = 1;
    public static long PRECIO_TOTAL_UNO = 100000;
    public static String ESTADO_PAGO_UNO = "A";
    public static Date FECHA_UNO = new Date();
    public static String ESTADO_UNO = "A";
    public static Integer CODIGO2 = 2;
    public static String FECHA_FUTURO = "2023-11-27 08:00";
    public static String PATTERN_FECHA = "yyyy-MM-dd HH:mm";
    public static Date FECHA_FUTURO_DATE;
    public static String FECHA_MALA = "La fecha de la reserva no puede ser nula";
    public static String ID_INVALID = "La reserva con id %s no existe";

    static {
        try {
            FECHA_FUTURO_DATE = new SimpleDateFormat(PATTERN_FECHA).parse(FECHA_FUTURO);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }


    public static Reserva reserva1 = Reserva.builder()
            .idReserva(1)
            .idVuelo(VueloUtilTest.vuelo1)
            .idAsiento(AsientoUtilTest.asiento1)
            .idUsuario(UsuarioUtilTest.Usuario1)
            .precioTotal(100000)
            .estadoPago("A")
            .fecha(FECHA_FUTURO_DATE)
            .estado("A")
            .build();

    public static Reserva reserva2 = Reserva.builder()
            .idReserva(2)
            .idVuelo(VueloUtilTest.vuelo1)
            .idAsiento(AsientoUtilTest.asiento1)
            .idUsuario(UsuarioUtilTest.Usuario1)
            .precioTotal(150000)
            .estadoPago("A")
            .fecha(FECHA_FUTURO_DATE)
            .estado("A")
            .build();

    public static ReservaDTO reservaDTO1 = ReservaDTO.builder()
            .idReserva(1)
            .idVuelo(VueloUtilTest.vuelo1.getIdVuelo())
            .idAsiento(AsientoUtilTest.asiento1.getIdAsiento())
            .idUsuario(UsuarioUtilTest.Usuario1.getIdUsuario())
            .precioTotal(100000)
            .estadoPago("A")
            .fecha(FECHA_FUTURO_DATE)
            .estado("A")
            .build();

    public static ReservaDTO reservaDTO2 = ReservaDTO.builder()
            .idReserva(2)
            .idVuelo(VueloUtilTest.vuelo1.getIdVuelo())
            .idAsiento(AsientoUtilTest.asiento1.getIdAsiento())
            .idUsuario(UsuarioUtilTest.Usuario1.getIdUsuario())
            .precioTotal(150000)
            .estadoPago("A")
            .fecha(FECHA_FUTURO_DATE)
            .estado("A")
            .build();

    public static ReservaDTO reservaDTO_null = ReservaDTO.builder()
            .idReserva(1)
            .idVuelo(VueloUtilTest.vuelo1.getIdVuelo())
            .idAsiento(AsientoUtilTest.asiento1.getIdAsiento())
            .idUsuario(UsuarioUtilTest.Usuario1.getIdUsuario())
            .precioTotal(100000)
            .estadoPago("A")
            .fecha(null)
            .estado("A")
            .build();

    public static List<Reserva> reservas = Arrays.asList(reserva1, reserva2);

    public static List<ReservaDTO> reservasDTOS = Arrays.asList(reservaDTO1, reservaDTO2);

    public static List<ReservaDTO> reservaDTO_vacio = Arrays.asList();

}
