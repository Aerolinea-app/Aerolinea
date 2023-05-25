package co.edu.usbcali.aerolinea.controllers;

import co.edu.usbcali.aerolinea.dto.TrayectoDTO;
import co.edu.usbcali.aerolinea.services.Interfaces.TrayectoService;
import co.edu.usbcali.aerolinea.utility.TrayectoUtilTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TrayectoControllerTest {
    @Autowired
    private TrayectoController trayectoController;

    @MockBean
    private TrayectoService trayectoService;

    //Prueba buena
    @Test
    public void guardarTrayecto() throws Exception {
        when(trayectoService.agregarTrayecto(any())).thenReturn(TrayectoUtilTest.trayectoDTO1);

        ResponseEntity<TrayectoDTO> response = trayectoController.guardarTrayecto(TrayectoUtilTest.trayectoDTO1);

        verify(trayectoService).agregarTrayecto(eq(TrayectoUtilTest.trayectoDTO1));

        assertEquals(HttpStatus.OK.value(), response.getStatusCode().value());
    }
    //Prueba mala
    @Test
    public void guardarTrayecto_malo() {
        try {
            trayectoController.guardarTrayecto(TrayectoUtilTest.TRAYECTO_MALO);
        } catch (Exception e) {
            assertEquals(TrayectoUtilTest.HORASALIDA_NULL, e.getMessage());
        }
    }
    //Prueba buena
    @Test
    public void obtenerTrayectos() {
        when(trayectoService.obtenerTrayectos()).thenReturn(TrayectoUtilTest.trayectosDTOs);

        ResponseEntity<List<TrayectoDTO>> response = trayectoController.obtenerTrayectos();

        assertEquals(response.getStatusCode().value(), HttpStatus.OK.value());
        assertEquals(2, response.getBody().size());
    }
    //Prueba mala
    @Test
    public void obtenerTrayectos_malo() {
        when(trayectoService.obtenerTrayectos()).thenReturn(TrayectoUtilTest.trayectoDTO_vacio);

        ResponseEntity<List<TrayectoDTO>> response = trayectoController.obtenerTrayectos();

        assertEquals(response.getStatusCode().value(), HttpStatus.OK.value());
        assertEquals(0, response.getBody().size());
    }
    //Pruebas buena
    @Test
    public void obtenerTrayecto() throws Exception {
        when(trayectoService.obtenerTrayecto(any())).thenReturn(TrayectoUtilTest.trayectoDTO1);

        ResponseEntity<TrayectoDTO> response = trayectoController.obtenerTrayecto(TrayectoUtilTest.CODIGO1);

        assertEquals(HttpStatus.OK.value(), response.getStatusCode().value());
    }
    //Prueba mala
    @Test
    public void obtenerTrayecto_mala() {
        try {
            trayectoController.obtenerTrayecto(TrayectoUtilTest.CODIGO1);
        } catch (Exception e) {
            assertEquals(String.format(TrayectoUtilTest.ID_INVALID, TrayectoUtilTest.CODIGO2), e.getMessage());
        }
    }
}
