package co.edu.usbcali.aerolinea.services.Implements;

import co.edu.usbcali.aerolinea.DTO.AvionDTO;
import co.edu.usbcali.aerolinea.services.Interfaces.AvionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AvionServiceImpl implements AvionService {

    ArrayList aviones = new ArrayList();

    AvionDTO avion1 = AvionDTO.builder().idAvion("0001").aerolineaAvion("Avianca").imgAvion("rutaImagen").build();
    AvionDTO avion2 = new AvionDTO("0002","VivaAir","rutaImagen");
    AvionDTO avion3 = new AvionDTO("0003","Iberia","rutaImagen");
    AvionDTO avion4 = new AvionDTO("0004","Latam","rutaImagen");
    AvionDTO avion5 = new AvionDTO("0005", "Iberia","rutaImagen");


    @Override
    public AvionDTO agregarAvion(AvionDTO avionDTO) throws Exception {

        if (avionDTO == null) {
            throw new Exception("El avion viene con datos nulos :(");
        }
        if (avionDTO.getIdAvion() == null){
            throw new Exception("El id del avion es invalido!");
        }
        if (avionDTO.getAerolineaAvion() == null) {
            throw new Exception("La aerolinea del avion es invalido!");
        }
        return avionDTO;
    }

    @Override
    public AvionDTO obtenerAvion() {
        return avion1;
    }

    @Override
    public List<AvionDTO> obtenerAviones() {

        aviones.add(avion1);
        aviones.add(avion2);
        aviones.add(avion3);
        aviones.add(avion4);
        aviones.add(avion5);

        return aviones;
    }
}
