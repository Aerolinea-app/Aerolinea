package co.edu.usbcali.aerolinea.services;

import co.edu.usbcali.aerolinea.domain.Aeropuerto;
import co.edu.usbcali.aerolinea.dto.AeropuertoDTO;
import co.edu.usbcali.aerolinea.repository.AeropuertoRepository;
import co.edu.usbcali.aerolinea.services.Interfaces.AeropuertoService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AeropuertoServiceImplTest {
    @Autowired
    private AeropuertoService aeropuertoService;
    @MockBean
    private AeropuertoRepository aeropuertoRepository;

    //Pureba unitaria buena
    @Test
    void obtenerAeropuerto() throws Exception{
        Aeropuerto aeropuertoTest = Aeropuerto.builder()
                .idAeropuerto(1)
                .nombre("FlowAir")
                .iata("FAR")
                .ubicacion("Cali")
                .estado("A")
                .build();

        Mockito.when(aeropuertoRepository.existsById(1)).thenReturn(true);
        Mockito.when(aeropuertoRepository.getReferenceById(1)).thenReturn(aeropuertoTest);

        // Llamado al método a probar
        AeropuertoDTO aeropuertoDTO = aeropuertoService.obtenerAeropuerto(1);

        // Verificación del resultado esperado
        assertEquals(1, aeropuertoDTO.getIdAeropuerto());
    }

    //Prueba unitaria menos probable (mala)
    @Test
    void obtenerAeropuerto_estadoNoActivo() throws Exception {
        // Configuración del mock
        Aeropuerto aeropuertoTest = Aeropuerto.builder()
                .idAeropuerto(1)
                .nombre("FlowAir")
                .iata("FAR")
                .ubicacion("Cali")
                .estado("I")
                .build();

        Mockito.when(aeropuertoRepository.existsById(1)).thenReturn(true);
        Mockito.when(aeropuertoRepository.getReferenceById(1)).thenReturn(aeropuertoTest);

        // Llamado al método a probar
        AeropuertoDTO aeropuertoDTO = aeropuertoService.obtenerAeropuerto(1);

        // Verificación del resultado esperado
        assertEquals("I", aeropuertoDTO.getEstado());
    }

    //Prueba unitaria Buena
    @Test
    void obtenerAeropuertos() throws Exception {

        List<Aeropuerto> aeropuertoList = Arrays.asList(Aeropuerto.builder()
                        .idAeropuerto(1)
                        .nombre("FlowAir")
                        .iata("FLW")
                        .ubicacion("Cali")
                        .estado("D")
                        .build(),
                Aeropuerto.builder()
                        .idAeropuerto(2)
                        .nombre("VivaAir")
                        .iata("VAR")
                        .ubicacion("Cali")
                        .estado("D")
                        .build());

        // Mock de la respuesta del repositorio
        Mockito.when(aeropuertoRepository.findAll()).thenReturn(aeropuertoList);

        List<AeropuertoDTO> aeropuertos = aeropuertoService.obtenerAeropuertos();

        assertEquals(2, aeropuertos.size());
        assertEquals("VivaAir", aeropuertos.get(1).getNombre());

    }


    //Prueba unitaria mala
    @Test
    void obtenerAeropuertos_listaVacia() throws Exception {
        List<Aeropuerto> aeropuertoList = new ArrayList<>();

        // Mock de la respuesta del repositorio
        Mockito.when(aeropuertoRepository.findAll()).thenReturn(aeropuertoList);

        List<AeropuertoDTO> aeropuertos = aeropuertoService.obtenerAeropuertos();

        assertTrue(aeropuertos.isEmpty());
    }


}
