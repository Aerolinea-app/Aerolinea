package co.edu.usbcali.aerolinea.controllers;

import co.edu.usbcali.aerolinea.dto.AeropuertoDTO;
import co.edu.usbcali.aerolinea.services.Interfaces.AeropuertoService;
import co.edu.usbcali.aerolinea.utility.AeropuertoUtilTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
@SpringBootTest
public class AeropuertoControllerTest {
    @Autowired
    private AeropuertoController aeropuertoController;

    @MockBean
    private AeropuertoService aeropuertoService;

    //Prueba Buena
    @Test
    public void obtenerAeropuertos() throws Exception {
        when(aeropuertoService.obtenerAeropuertos()).thenReturn(AeropuertoUtilTest.aeropuertosDTOS);

        ResponseEntity<List<AeropuertoDTO>> response = aeropuertoController.obtenerAeropuertos();

        assertEquals(response.getStatusCode().value(), HttpStatus.OK.value());
        assertEquals(2, response.getBody().size());
    }

    //Prueba Mala
    @Test
    public void obtenerAeropuertos_malo() throws Exception {
        when(aeropuertoService.obtenerAeropuertos()).thenReturn(AeropuertoUtilTest.AEROPUERTOS_NULL);

        ResponseEntity<List<AeropuertoDTO>> response = aeropuertoController.obtenerAeropuertos();

        assertEquals(response.getStatusCode().value(), HttpStatus.OK.value());
        assertEquals(0, response.getBody().size());
    }

    //Prueba buena
    @Test
    public void obtenerAeropuerto() throws Exception {
        when(aeropuertoService.obtenerAeropuerto(any())).thenReturn(AeropuertoUtilTest.AeropuertoDTO1);

        ResponseEntity<AeropuertoDTO> response = aeropuertoController.obtenerAeropuerto(AeropuertoUtilTest.CODIGO_UNO);

        assertEquals(HttpStatus.OK.value(), response.getStatusCode().value());
    }
    //Prueba mala
    @Test
    public void obtenerAeropuerto_malo() {
        try {
            aeropuertoController.obtenerAeropuerto(AeropuertoUtilTest.CODIGO_DOS);
        } catch (Exception e) {
            assertEquals(String.format(AeropuertoUtilTest.ID_NO_ENCONTRADO, AeropuertoUtilTest.CODIGO_DOS), e.getMessage());
        }
    }
}
