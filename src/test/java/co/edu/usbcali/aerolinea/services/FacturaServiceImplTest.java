package co.edu.usbcali.aerolinea.services;

import co.edu.usbcali.aerolinea.domain.Factura;
import co.edu.usbcali.aerolinea.domain.RolUsuario;
import co.edu.usbcali.aerolinea.domain.Usuario;
import co.edu.usbcali.aerolinea.dto.FacturaDTO;
import co.edu.usbcali.aerolinea.repository.FacturaRepository;
import co.edu.usbcali.aerolinea.services.Interfaces.FacturaService;
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
public class FacturaServiceImplTest {
    @Autowired
    private FacturaService facturaService;
    @MockBean
    private FacturaRepository facturaRepository;

    //Prueba unitaria Buena
    @Test
    void obtenerFactura() throws Exception{
        RolUsuario rolUsuario = RolUsuario.builder().idRolusuario(1).descripcion("RolPrueba").estado("A").build();
        Usuario usuario = Usuario.builder().idUsuario(1).idRolUsuario(rolUsuario).cedula("1112243").nombre("Prueba").apellido("APrueba").correo("prueba@gmail.com").estado("A").build();
        Factura facturaTest = Factura.builder()
                .idFactura(1)
                .idUsuario(usuario)
                .fecha(new Date())
                .estado("A")
                .build();

        Mockito.when(facturaRepository.existsById(1)).thenReturn(true);
        Mockito.when(facturaRepository.getReferenceById(1)).thenReturn(facturaTest);

        // Llamado al método a probar
        FacturaDTO facturaDTO = facturaService.obtenerFactura(1);

        // Verificación del resultado esperado
        assertEquals(1, facturaDTO.getIdFactura());
    }

    //Prueba unitaria menos probable (mala)
    @Test
    void obtenerFactura_estadoNoActivo() throws Exception {
        RolUsuario rolUsuario = RolUsuario.builder().idRolusuario(1).descripcion("RolPrueba").estado("A").build();
        Usuario usuario = Usuario.builder().idUsuario(1).idRolUsuario(rolUsuario).cedula("1112243").nombre("Prueba").apellido("APrueba").correo("prueba@gmail.com").estado("A").build();
        Factura facturaTest = Factura.builder()
                .idFactura(1)
                .idUsuario(usuario)
                .fecha(new Date())
                .estado("D")
                .build();

        Mockito.when(facturaRepository.existsById(1)).thenReturn(true);
        Mockito.when(facturaRepository.getReferenceById(1)).thenReturn(facturaTest);

        // Llamado al método a probar
        FacturaDTO facturaDTO = facturaService.obtenerFactura(1);

        // Verificación del resultado esperado
        assertEquals("D", facturaDTO.getEstado());
    }

    //Prueba unitaria Buena
    @Test
    void obtenerFacturas() throws Exception {
        RolUsuario rolUsuario = RolUsuario.builder().idRolusuario(1).descripcion("RolPrueba").estado("A").build();
        Usuario usuario = Usuario.builder().idUsuario(1).idRolUsuario(rolUsuario).cedula("1112243").nombre("Prueba").apellido("APrueba").correo("prueba@gmail.com").estado("A").build();
        List<Factura> facturasList = Arrays.asList(Factura.builder()
                        .idFactura(1)
                        .idUsuario(usuario)
                        .fecha(new Date())
                        .estado("A")
                        .build(),
                Factura.builder()
                        .idFactura(2)
                        .idUsuario(usuario)
                        .fecha(new Date())
                        .estado("D")
                        .build());

        // Mock de la respuesta del repositorio
        Mockito.when(facturaRepository.findAll()).thenReturn(facturasList);

        List<FacturaDTO> facturaDTOList = facturaService.obtenerFacturas();

        assertEquals(2, facturaDTOList.size());
        assertEquals(2, facturaDTOList.get(1).getIdFactura());

    }

    //Prueba unitaria mala
    @Test
    void obtenerFactura_listaVacia() throws Exception {
        List<Factura> facturaList = new ArrayList<>();

        // Mock de la respuesta del repositorio
        Mockito.when(facturaRepository.findAll()).thenReturn(facturaList);

        List<FacturaDTO> facturas = facturaService.obtenerFacturas();

        assertTrue(facturas.isEmpty());
    }
}
