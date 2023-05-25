package co.edu.usbcali.aerolinea.utility;

import co.edu.usbcali.aerolinea.domain.Vuelo;
import co.edu.usbcali.aerolinea.dto.VueloDTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class VueloUtilTest {
    public static Integer CODIGO1 = 1;
    public static long PRECIO1 = 100000;
    public static Date HORA_SALIDA = new Date();
    public static Date HORA_LLEGADA = new Date();
    public static Integer CODIGO2 = 2;
    public static String FECHA_FUTURO1 = "2023-11-27 08:00";
    public static String FECHA_FUTURO2 = "2023-12-27 10:00";
    public static String PATTERN_FECHA = "yyyy-MM-dd HH:mm";
    public static Date FECHA_FUTURO_DATE1;
    public static Date FECHA_FUTURO_DATE2;
    public static String HORA_MALA = "La hora de salida del vuelo no puede ser nula";
    public static String ID_INVALID = "El vuelo con id %s no existe";


    static {
        try {
            FECHA_FUTURO_DATE1 = new SimpleDateFormat(PATTERN_FECHA).parse(FECHA_FUTURO1);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    static {
        try {
            FECHA_FUTURO_DATE2 = new SimpleDateFormat(PATTERN_FECHA).parse(FECHA_FUTURO2);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static Vuelo vuelo1 = Vuelo.builder()
            .idVuelo(1)
            .idAeropuertoOrigen(AeropuertoUtilTest.Aeropuerto1)
            .idAeropuertoDestino(AeropuertoUtilTest.Aeropuerto2)
            .precio(100000)
            .fechaHoraSalida(FECHA_FUTURO_DATE1)
            .fechaHoraLlegada(FECHA_FUTURO_DATE2)
            .precioAsientoPreferencial(50000)
            .precioAsientoVip(30000)
            .precioAsientoTurista(10000)
            .estado("A")
            .build();

    public static Vuelo vuelo2 = Vuelo.builder()
            .idVuelo(2)
            .idAeropuertoOrigen(AeropuertoUtilTest.Aeropuerto1)
            .idAeropuertoDestino(AeropuertoUtilTest.Aeropuerto2)
            .precio(150000)
            .fechaHoraSalida(FECHA_FUTURO_DATE1)
            .fechaHoraLlegada(FECHA_FUTURO_DATE2)
            .precioAsientoPreferencial(80000)
            .precioAsientoVip(50000)
            .precioAsientoTurista(30000)
            .estado("A")
            .build();

    public static VueloDTO vueloDTO1 = VueloDTO.builder()
            .idVuelo(1)
            .idAeropuertoOrigen(AeropuertoUtilTest.Aeropuerto1.getIdAeropuerto())
            .idAeropuertoDestino(AeropuertoUtilTest.Aeropuerto2.getIdAeropuerto())
            .precio(100000)
            .fechaHoraSalida(FECHA_FUTURO_DATE1)
            .fechaHoraLlegada(FECHA_FUTURO_DATE2)
            .precioAsientoPreferencial(50000)
            .precioAsientoVip(30000)
            .precioAsientoTurista(10000)
            .estado("A")
            .build();

    public static VueloDTO vueloDTO2 = VueloDTO.builder()
            .idVuelo(2)
            .idAeropuertoOrigen(AeropuertoUtilTest.Aeropuerto1.getIdAeropuerto())
            .idAeropuertoDestino(AeropuertoUtilTest.Aeropuerto2.getIdAeropuerto())
            .precio(150000)
            .fechaHoraSalida(FECHA_FUTURO_DATE1)
            .fechaHoraLlegada(FECHA_FUTURO_DATE2)
            .precioAsientoPreferencial(80000)
            .precioAsientoVip(50000)
            .precioAsientoTurista(30000)
            .estado("A")
            .build();

    public static VueloDTO vueloDTO_malo = VueloDTO.builder()
            .idVuelo(1)
            .idAeropuertoOrigen(AeropuertoUtilTest.Aeropuerto1.getIdAeropuerto())
            .idAeropuertoDestino(AeropuertoUtilTest.Aeropuerto2.getIdAeropuerto())
            .precio(100000)
            .fechaHoraSalida(null)
            .fechaHoraLlegada(FECHA_FUTURO_DATE2)
            .precioAsientoPreferencial(50000)
            .precioAsientoVip(30000)
            .precioAsientoTurista(10000)
            .estado("A")
            .build();

    public static List<Vuelo> vuelos = Arrays.asList(vuelo1, vuelo2);

    public static List<VueloDTO> vuelosDTOS = Arrays.asList(vueloDTO1, vueloDTO2);

    public static List<VueloDTO> vuelosDTOS_vacio = Arrays.asList();

}
