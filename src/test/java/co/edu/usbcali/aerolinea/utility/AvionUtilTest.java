package co.edu.usbcali.aerolinea.utility;

import co.edu.usbcali.aerolinea.domain.Aeropuerto;
import co.edu.usbcali.aerolinea.domain.Avion;
import co.edu.usbcali.aerolinea.dto.AeropuertoDTO;
import co.edu.usbcali.aerolinea.dto.AvionDTO;
import co.edu.usbcali.aerolinea.mappers.AeropuertoMapper;
import co.edu.usbcali.aerolinea.mappers.AvionMapper;

import java.util.Arrays;
import java.util.List;

public class AvionUtilTest {
    public static Integer CODIGO_UNO = 1;
    public static String AEROLINEA1 = "Avianca";
    public static String ESTADO1 = "A";
    public static Integer CODIGO_DOS = 2;
    public static String AEROLINEA2 = "Avianca";
    public static String ESTADO2 = "I";

    public static Avion Avion1 =
            Avion.builder().idAvion(CODIGO_UNO).aerolineaAvion(AEROLINEA1).estado(ESTADO1).build();
    public static Avion Avion2 =
            Avion.builder().idAvion(CODIGO_DOS).aerolineaAvion(AEROLINEA2).estado(ESTADO2).build();
    public static AvionDTO AvionDTO1 =
            AvionDTO.builder().idAvion(CODIGO_UNO).aerolineaAvion(AEROLINEA1).estado(ESTADO1).build();
    public static AvionDTO AvionDTO2_No_id =
            AvionDTO.builder().aerolineaAvion(AEROLINEA2).estado(ESTADO2).build();

    public static List<Avion> aviones = Arrays.asList(Avion1, Avion2);
    public static List<AvionDTO> avionDTOS = AvionMapper.domainToDTOList(aviones);
}
