package co.edu.usbcali.aerolinea.services;

import co.edu.usbcali.aerolinea.DTO.vueloDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class VueloServicelmpl implements VueloService{

    ArrayList vuelos = new ArrayList();

    vueloDTO vuelo1 = vueloDTO.builder().origen("Cali").destino("Buenaventura").fechaHoraSalida(new Date()).fechaHoraLlegada(new Date()).id("1234").idAvion("8080").build();
    vueloDTO vuelo2 = new vueloDTO("San Andres","Medellin", new Date(),new Date(),"1417","7777");
    vueloDTO vuelo3 = new vueloDTO("Cartagena","Bogota", new Date(), new Date(),"1418","478");
    vueloDTO vuelo4 = new vueloDTO("Barranquilla","Bucaramanga", new Date(), new Date(),"5647","1212");
    vueloDTO vuelo5 = new vueloDTO("Cali", "Bogota", new Date(), new Date(),"7597","111");
    vueloDTO vuelo6 = new vueloDTO("Bogota","Medellin", new Date(), new Date(),"9898","2303");

    @Override
    public vueloDTO guardarVuelo(vueloDTO vuelDTO) throws Exception{
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
        //Aqui se llama al repositorio pero no entiendo

        return vuelDTO;

    }

    @Override
    public vueloDTO obtenerVuelo() {

        return vuelo1;

    }

    @Override
    public List<vueloDTO> obtenerVuelos() {

        vuelos.add(vuelo1);
        vuelos.add(vuelo2);
        vuelos.add(vuelo3);
        vuelos.add(vuelo4);
        vuelos.add(vuelo5);
        vuelos.add(vuelo6);

        return vuelos;

    }

}
