package co.edu.usbcali.aerolinea.services;

import co.edu.usbcali.aerolinea.domain.TipoAsiento;
import co.edu.usbcali.aerolinea.dto.TipoAsientoDTO;
import co.edu.usbcali.aerolinea.repository.TipoAsientoRepository;
import co.edu.usbcali.aerolinea.services.Interfaces.TipoAsientoService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TipoAsientoServiceImplTest {
    @Autowired
    private TipoAsientoService tipoAsientoService;
    @MockBean
    private TipoAsientoRepository tipoAsientoRepository;
    //Prueba unitaria buena
    @Test
    void obtenerTipoAsiento() throws Exception{
        TipoAsiento tipoAsientoTest = TipoAsiento.builder()
                .idTipoa(1)
                .descripcion("Prueba")
                .estado("A")
                .build();

        Mockito.when(tipoAsientoRepository.existsById(1)).thenReturn(true);
        Mockito.when(tipoAsientoRepository.getReferenceById(1)).thenReturn(tipoAsientoTest);

        // Llamado al método a probar
        TipoAsientoDTO tipoAsientoDTO = tipoAsientoService.obtenerTipoAsiento(1);

        // Verificación del resultado esperado
        assertEquals(1, tipoAsientoDTO.getIdTipoa());
    }
    //Prueba unitaria menos probable (mala)
    @Test
    void obtenerTipoAsiento_estadoNoActivo() throws Exception {
        TipoAsiento tipoAsientoTest = TipoAsiento.builder()
                .idTipoa(1)
                .descripcion("Prueba")
                .estado("D")
                .build();

        Mockito.when(tipoAsientoRepository.existsById(1)).thenReturn(true);
        Mockito.when(tipoAsientoRepository.getReferenceById(1)).thenReturn(tipoAsientoTest);

        // Llamado al método a probar
        TipoAsientoDTO tipoAsientoDTO = tipoAsientoService.obtenerTipoAsiento(1);

        // Verificación del resultado esperado
        assertEquals("D", tipoAsientoDTO.getEstado());
    }

    //Prueba unitaria buena
    @Test
    void obtenerTipoAsientos() throws Exception {

        List<TipoAsiento> tipoAsientoList = Arrays.asList(TipoAsiento.builder()
                        .idTipoa(1)
                        .descripcion("Prueba Tipo1")
                        .estado("A")
                        .build(),
                TipoAsiento.builder()
                        .idTipoa(2)
                        .descripcion("Prueba Tipo2")
                        .estado("D")
                        .build());

        // Mock de la respuesta del repositorio
        Mockito.when(tipoAsientoRepository.findAll()).thenReturn(tipoAsientoList);

        List<TipoAsientoDTO> tipoAsientoDTOSList = tipoAsientoService.obtenerTipoAsientos();

        assertEquals(2, tipoAsientoDTOSList.size());
        assertEquals("Prueba Tipo2", tipoAsientoDTOSList.get(1).getDescripcion());

    }

    //Prueba unitaria mala
    @Test
    void obtenerTipoAsientos_listaVacia() throws Exception {
        List<TipoAsiento> tipoAsientoList = new ArrayList<>();

        // Mock de la respuesta del repositorio
        Mockito.when(tipoAsientoRepository.findAll()).thenReturn(tipoAsientoList);

        List<TipoAsientoDTO> tipoAsientoDTOS = tipoAsientoService.obtenerTipoAsientos();

        assertTrue(tipoAsientoDTOS.isEmpty());
    }
}
