package co.edu.usbcali.aerolinea.utility;

import co.edu.usbcali.aerolinea.domain.Trayecto;
import co.edu.usbcali.aerolinea.dto.TrayectoDTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


public class TrayectoUtilTest {
    public static Integer CODIGO1 = 1;
    public static String FECHA_FUTURO1 = "2023-09-29 02:00";
    public static String FECHA_FUTURO2 = "2023-05-14 14:00";
    public static String PATTERN_FECHA = "yyyy-MM-dd HH:mm";
    public static Date FECHA_FUTURO_DATE1;
    public static Date FECHA_FUTURO_DATE2;
    public static String HORASALIDA_NULL = "La hora de salida es invalida!";
    public static String ID_INVALID = "El trayecto con id %s no existe";

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

    public static Trayecto trayecto1 = Trayecto.builder()
            .idTrayecto(1).idAvion(AvionUtilTest.Avion1).aeropuertoOrigen(AeropuertoUtilTest.Aeropuerto1).aeropuertoDestino(AeropuertoUtilTest.Aeropuerto2).horaSalida(FECHA_FUTURO_DATE1).horaLlegada(FECHA_FUTURO_DATE2).idVuelo(VueloUtilTest.vuelo1).estado("A").build();
    public static Trayecto trayecto2 = Trayecto.builder()
            .idTrayecto(2).idAvion(AvionUtilTest.Avion1).aeropuertoOrigen(AeropuertoUtilTest.Aeropuerto1).aeropuertoDestino(AeropuertoUtilTest.Aeropuerto2).horaSalida(FECHA_FUTURO_DATE1).horaLlegada(FECHA_FUTURO_DATE2).idVuelo(VueloUtilTest.vuelo1).estado("A").build();
    public static TrayectoDTO trayectoDTO1 = TrayectoDTO.builder()
            .idTrayecto(1).idAvion(AvionUtilTest.Avion1.getIdAvion()).idAeropuertoOrigen(AeropuertoUtilTest.Aeropuerto1.getIdAeropuerto()).idAeropuertoDestino(AeropuertoUtilTest.Aeropuerto2.getIdAeropuerto()).horaSalida(FECHA_FUTURO_DATE1).horaLlegada(FECHA_FUTURO_DATE2).idVuelo(VueloUtilTest.vuelo1.getIdVuelo()).estado("A").build();
    public static TrayectoDTO TRAYECTO_MALO = TrayectoDTO.builder()
            .idTrayecto(1).idAvion(AvionUtilTest.Avion1.getIdAvion()).idAeropuertoOrigen(AeropuertoUtilTest.Aeropuerto1.getIdAeropuerto()).idAeropuertoDestino(AeropuertoUtilTest.Aeropuerto2.getIdAeropuerto()).horaSalida(null).horaLlegada(FECHA_FUTURO_DATE2).idVuelo(VueloUtilTest.vuelo2.getIdVuelo()).estado("A").build();

    public static List<TrayectoDTO> trayectosDTOs = Arrays.asList(trayectoDTO1);
    public static List<TrayectoDTO> trayectoDTO_vacio = Arrays.asList();
}
