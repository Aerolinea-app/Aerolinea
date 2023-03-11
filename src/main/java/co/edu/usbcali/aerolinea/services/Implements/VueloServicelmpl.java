package co.edu.usbcali.aerolinea.services.Implements;

import co.edu.usbcali.aerolinea.DTO.VueloDTO;
import co.edu.usbcali.aerolinea.services.Interfaces.VueloService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class VueloServicelmpl implements VueloService {

    ArrayList vuelos = new ArrayList();

    VueloDTO vuelo1 = VueloDTO.builder().origen("Cali").destino("Buenaventura").fechaHoraSalida(new Date()).fechaHoraLlegada(new Date()).id("1234").idAvion("13658").build();
    VueloDTO vuelo2 = new VueloDTO("San Andres","Medellin",328000, new Date(),new Date(),"1417","8675");
    VueloDTO vuelo3 = new VueloDTO("Cartagena","Bogota",600000, new Date(), new Date(),"1418","478");
    VueloDTO vuelo4 = new VueloDTO("Barranquilla","Bucaramanga",200000, new Date(), new Date(),"5647","1212");
    VueloDTO vuelo5 = new VueloDTO("Cali", "Bogota",414000, new Date(), new Date(),"7597","111");
    VueloDTO vuelo6 = new VueloDTO("Bogota","Medellin", 305000, new Date(), new Date(),"9898","2303");

    @Override
    public VueloDTO guardarVuelo(VueloDTO vuelDTO) throws Exception{
        if (vuelDTO == null){
            throw new Exception("El vuelo viene con datos nulos :(");
        }
        if (vuelDTO.getId() == null || vuelDTO.getId().trim().equals("")){
            throw new Exception("El Id es invalido!");
        }
        if (vuelDTO.getOrigen() == null || vuelDTO.getOrigen().trim().equals("")){
            throw new Exception("Origen del vuelo es invalido!");
        }
        if (vuelDTO.getDestino() == null || vuelDTO.getDestino().trim().equals("")){
            throw new Exception("Destino del vuelo es invalido!");
        }
        if (vuelDTO.getIdAvion() == null || vuelDTO.getIdAvion().trim().equals("")){
            throw new Exception("El ID del avion es invalido!");
        }
        if (vuelDTO.getPrecio() == null || vuelDTO.getPrecio() < 0){
            throw new Exception("El precio es invalido!");
        }

        return vuelDTO;

    }

    @Override
    public VueloDTO obtenerVuelo() {

        return vuelo1;

    }

    @Override
    public List<VueloDTO> obtenerVuelos() {

        vuelos.add(vuelo1);
        vuelos.add(vuelo2);
        vuelos.add(vuelo3);
        vuelos.add(vuelo4);
        vuelos.add(vuelo5);
        vuelos.add(vuelo6);

        return vuelos;

    }

}
