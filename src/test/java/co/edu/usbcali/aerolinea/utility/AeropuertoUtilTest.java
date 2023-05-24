package co.edu.usbcali.aerolinea.utility;

import co.edu.usbcali.aerolinea.domain.Aeropuerto;
import co.edu.usbcali.aerolinea.dto.AeropuertoDTO;
import co.edu.usbcali.aerolinea.mappers.AeropuertoMapper;

import java.util.Arrays;
import java.util.List;

public class AeropuertoUtilTest {
    public static Integer CODIGO_UNO = 1;
    public static String IATA_1 = "BLE";
    public static String NOMBRE1 = "Boyacá";
    public static String UBICACION1 = "Boyacá";
    public static String ESTADO1 = "A";
    public static Integer CODIGO_DOS = 2;
    public static String IATA_2 = "IAT";
    public static String NOMBRE2 = "Boyacá";
    public static String UBICACION2 = "Boyacá";
    public static String ESTADO2 = "A";
    public static String ID_NO_ENCONTRADO = "El aeropuerto con id %s no existe";

    public static Aeropuerto Aeropuerto1 =
            Aeropuerto.builder().idAeropuerto(CODIGO_UNO).iata(IATA_1).nombre(NOMBRE1).ubicacion(UBICACION1).estado(ESTADO1).build();
    public static Aeropuerto Aeropuerto2 =
            Aeropuerto.builder().idAeropuerto(CODIGO_DOS).iata(IATA_2).nombre(NOMBRE2).ubicacion(UBICACION2).estado(ESTADO2).build();
    public static AeropuertoDTO AeropuertoDTO1 =
            AeropuertoDTO.builder().idAeropuerto(CODIGO_UNO).iata(IATA_1).nombre(NOMBRE1).ubicacion(UBICACION1).estado(ESTADO1).build();
    public static AeropuertoDTO AeropuertoDTO2_No_id =
            AeropuertoDTO.builder().iata(IATA_1).nombre(NOMBRE1).ubicacion(UBICACION1).estado(ESTADO1).build();

    public static List<Aeropuerto> aeropuertos = Arrays.asList(Aeropuerto1, Aeropuerto2);

    public static List<AeropuertoDTO> aeropuertosDTOS = AeropuertoMapper.domainToDTOList(aeropuertos);
    public static List<AeropuertoDTO> AEROPUERTOS_NULL = Arrays.asList();
}
