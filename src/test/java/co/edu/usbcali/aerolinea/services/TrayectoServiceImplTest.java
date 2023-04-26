package co.edu.usbcali.aerolinea.services;

import co.edu.usbcali.aerolinea.domain.*;
import co.edu.usbcali.aerolinea.dto.TrayectoDTO;
import co.edu.usbcali.aerolinea.repository.TrayectoRepository;
import co.edu.usbcali.aerolinea.services.Interfaces.TrayectoService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TrayectoServiceImplTest {
    @Autowired
    private TrayectoService trayectoService;
    @MockBean
    private TrayectoRepository trayectoRepository;
    //Prueba unitaria buena
    @Test
    void obtenerTrayecto() throws Exception{
        Avion avion = Avion.builder().idAvion(1).aerolineaAvion("Avianca").estado("A").build();
        Aeropuerto aeropuertoOrigen = Aeropuerto.builder().idAeropuerto(1).nombre("Cali").iata("DTW").ubicacion("Cali").estado("A").build();
        Aeropuerto aeropuertoDestino = Aeropuerto.builder().idAeropuerto(2).nombre("Medellin").iata("MDL").ubicacion("Medellin").estado("A").build();
        Vuelo vuelo = Vuelo.builder().idVuelo(1).idAeropuertoOrigen(aeropuertoOrigen).idAeropuertoDestino(aeropuertoDestino).precio(10000).fechaHoraSalida(new Date()).fechaHoraLlegada(new Date()).precioAsientoPreferencial(80000).precioAsientoVip(60000).precioAsientoTurista(30000).estado("A").build();

        Trayecto trayectoTest = Trayecto.builder()
                .idTrayecto(1)
                .idAvion(avion)
                .aeropuertoOrigen(aeropuertoOrigen)
                .aeropuertoDestino(aeropuertoDestino)
                .horaSalida(new Date())
                .horaLlegada(new Date())
                .idVuelo(vuelo)
                .estado("A")
                .build();

        Mockito.when(trayectoRepository.existsById(1)).thenReturn(true);
        Mockito.when(trayectoRepository.getReferenceById(1)).thenReturn(trayectoTest);

        // Llamado al método a probar
        TrayectoDTO trayectoDTO = trayectoService.obtenerTrayecto(1);

        // Verificación del resultado esperado
        assertEquals(1, trayectoDTO.getIdTrayecto());
    }
    //Prueba Unitaria menos probable (mala)
    @Test
    void obtenerTrayecto_estadoNoActivo() throws Exception {
        Avion avion = Avion.builder().idAvion(1).aerolineaAvion("Avianca").estado("A").build();
        Aeropuerto aeropuertoOrigen = Aeropuerto.builder().idAeropuerto(1).nombre("Cali").iata("DTW").ubicacion("Cali").estado("A").build();
        Aeropuerto aeropuertoDestino = Aeropuerto.builder().idAeropuerto(2).nombre("Medellin").iata("MDL").ubicacion("Medellin").estado("A").build();
        Vuelo vuelo = Vuelo.builder().idVuelo(1).idAeropuertoOrigen(aeropuertoOrigen).idAeropuertoDestino(aeropuertoDestino).precio(10000).fechaHoraSalida(new Date()).fechaHoraLlegada(new Date()).precioAsientoPreferencial(80000).precioAsientoVip(60000).precioAsientoTurista(30000).estado("A").build();

        Trayecto trayectoTest = Trayecto.builder()
                .idTrayecto(1)
                .idAvion(avion)
                .aeropuertoOrigen(aeropuertoOrigen)
                .aeropuertoDestino(aeropuertoDestino)
                .horaSalida(new Date())
                .horaLlegada(new Date())
                .idVuelo(vuelo)
                .estado("D")
                .build();

        Mockito.when(trayectoRepository.existsById(1)).thenReturn(true);
        Mockito.when(trayectoRepository.getReferenceById(1)).thenReturn(trayectoTest);

        // Llamado al método a probar
        TrayectoDTO trayectoDTO = trayectoService.obtenerTrayecto(1);

        // Verificación del resultado esperado
        assertEquals("D", trayectoDTO.getEstado());
    }

    //Prueba unitaria buena
    @Test
    void obtenerTrayectos() throws Exception {
        Avion avion = Avion.builder().idAvion(1).aerolineaAvion("Avianca").estado("A").build();
        Aeropuerto aeropuertoOrigen = Aeropuerto.builder().idAeropuerto(1).nombre("Cali").iata("DTW").ubicacion("Cali").estado("A").build();
        Aeropuerto aeropuertoDestino = Aeropuerto.builder().idAeropuerto(2).nombre("Medellin").iata("MDL").ubicacion("Medellin").estado("A").build();
        Vuelo vuelo = Vuelo.builder().idVuelo(1).idAeropuertoOrigen(aeropuertoOrigen).idAeropuertoDestino(aeropuertoDestino).precio(10000).fechaHoraSalida(new Date()).fechaHoraLlegada(new Date()).precioAsientoPreferencial(80000).precioAsientoVip(60000).precioAsientoTurista(30000).estado("A").build();

        List<Trayecto> trayectoList = Arrays.asList(Trayecto.builder()
                    .idTrayecto(1)
                    .idAvion(avion)
                    .aeropuertoOrigen(aeropuertoOrigen)
                    .aeropuertoDestino(aeropuertoDestino)
                    .horaSalida(new Date())
                    .horaLlegada(new Date())
                    .idVuelo(vuelo)
                    .estado("D")
                    .build(),
                Trayecto.builder()
                        .idTrayecto(2)
                        .idAvion(avion)
                        .aeropuertoOrigen(aeropuertoOrigen)
                        .aeropuertoDestino(aeropuertoDestino)
                        .horaSalida(new Date())
                        .horaLlegada(new Date())
                        .idVuelo(vuelo)
                        .estado("A")
                        .build());

        // Mock de la respuesta del repositorio
        Mockito.when(trayectoRepository.findAll()).thenReturn(trayectoList);

        List<TrayectoDTO> trayectoDTOList = trayectoService.obtenerTrayectos();

        assertEquals(2, trayectoDTOList.size());
        assertEquals("A", trayectoDTOList.get(1).getEstado());

    }

    //Prueba unitaria mala
    @Test
    void obtenerTrayectos_listaVacia() throws Exception {
        List<Trayecto> trayectoList = new ArrayList<>();

        // Mock de la respuesta del repositorio
        Mockito.when(trayectoRepository.findAll()).thenReturn(trayectoList);

        List<TrayectoDTO> trayectoDTOList = trayectoService.obtenerTrayectos();

        assertTrue(trayectoDTOList.isEmpty());
    }
}
