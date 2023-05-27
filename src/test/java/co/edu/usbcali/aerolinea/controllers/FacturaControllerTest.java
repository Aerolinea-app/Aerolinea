package co.edu.usbcali.aerolinea.controllers;

import co.edu.usbcali.aerolinea.dto.FacturaDTO;
import co.edu.usbcali.aerolinea.services.Interfaces.FacturaService;
import co.edu.usbcali.aerolinea.utility.FacturaUtilTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class FacturaControllerTest {
    @Autowired
    private FacturaController facturaController;

    @MockBean
    private FacturaService facturaService;

    //Prueba buena
    @Test
    public void guardarFactura() throws Exception {
        when(facturaService.agregarFactura(any())).thenReturn(FacturaUtilTest.facturaDTO);

        ResponseEntity<FacturaDTO> response = facturaController.guardarFactura(FacturaUtilTest.facturaDTO);

        verify(facturaService).agregarFactura(eq(FacturaUtilTest.facturaDTO));

        assertEquals(HttpStatus.OK.value(), response.getStatusCode().value());
    }
    //Prueba mala
    @Test
    public void guardarFactura_mala() {
        try {
            facturaController.guardarFactura(FacturaUtilTest.FACTURADTO_FECHA_NULL);
        } catch (Exception e) {
            assertEquals(FacturaUtilTest.FECHA_INVALID, e.getMessage());
        }
    }
    //Prueba buena
    @Test
    public void obtenerFacturas() {
        when(facturaService.obtenerFacturas()).thenReturn(FacturaUtilTest.facturaDTOList);

        ResponseEntity<List<FacturaDTO>> response = facturaController.obtenerFacturas();

        assertEquals(response.getStatusCode().value(), HttpStatus.OK.value());
        assertEquals(2, response.getBody().size());
    }
    //Prueba mala
    @Test
    public void obtenerFacturas_malo() {
        when(facturaService.obtenerFacturas()).thenReturn(FacturaUtilTest.facturas_vacio);

        ResponseEntity<List<FacturaDTO>> response = facturaController.obtenerFacturas();

        assertEquals(response.getStatusCode().value(), HttpStatus.OK.value());
        assertEquals(0, response.getBody().size());
    }
    //Prueba buena
    @Test
    public void obtenerFactura() throws Exception {
        when(facturaService.obtenerFactura(any())).thenReturn(FacturaUtilTest.facturaDTO);

        ResponseEntity<FacturaDTO> response = facturaController.obtenerFactura(FacturaUtilTest.CODIGO1);

        assertEquals(HttpStatus.OK.value(), response.getStatusCode().value());
    }
    //Prueba mala
    @Test
    public void obtenerFactura_malo() {
        try {
            facturaController.obtenerFactura(FacturaUtilTest.CODIGO2);
        } catch (Exception e) {
            assertEquals(String.format(FacturaUtilTest.ID_INVALID, FacturaUtilTest.CODIGO2), e.getMessage());
        }
    }
}
