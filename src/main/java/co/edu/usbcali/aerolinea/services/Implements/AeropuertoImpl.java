package co.edu.usbcali.aerolinea.services.Implements;

import co.edu.usbcali.aerolinea.DTO.AeropuertoDTO;
import co.edu.usbcali.aerolinea.services.Interfaces.AeropuertoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AeropuertoImpl implements AeropuertoService {

    ArrayList aeropuertos = new ArrayList();

    AeropuertoDTO aeropuerto1 = new AeropuertoDTO(1, "José María Córdova", "Medellín");
    AeropuertoDTO aeropuerto2 = new AeropuertoDTO(2, "Rafael Núñez", "Cartagena");
    AeropuertoDTO aeropuerto3 = new AeropuertoDTO(3, "Ernesto Cortissoz", "Barranquilla");
    AeropuertoDTO aeropuerto4 = new AeropuertoDTO(4, "Alfonso Bonilla Aragón", "Cali");
    AeropuertoDTO aeropuerto5 = new AeropuertoDTO(5, "Gustavo Rojas Pinilla", "San andrés");
    AeropuertoDTO aeropuerto6 = new AeropuertoDTO(6, "Matecaña", "Pereira");
    AeropuertoDTO aeropuerto7 = new AeropuertoDTO(7, "Palonegro", "Bucaramanga");
    AeropuertoDTO aeropuerto8 = new AeropuertoDTO(8, "El Edén", "Armenia");


    @Override
    public AeropuertoDTO agregarAeropuerto(AeropuertoDTO aeropuertoDTO) throws Exception {

        if (aeropuertoDTO.getIdAeropuerto() == null){
            throw new Exception("El id del aeropuerto es invalido!");
        }
        if (aeropuertoDTO.getIdAeropuerto() < 0){
            throw new Exception("El id del aeropuerto no puede ser negativo!");
        }
        if (aeropuertoDTO.getNombre() == null){
            throw new Exception("El nombre del aeropuerto es invalido!");
        }
        if (aeropuertoDTO.getNombre() == ""){
            throw new Exception("El nombre del aeropuerto es invalido!");
        }
        if (aeropuertoDTO.getUbicacion() == null){
            throw new Exception("La ubicacion del aeropuerto es invalido!");
        }
        if (aeropuertoDTO.getUbicacion() == ""){
            throw new Exception("La ubicacion del aeropuerto es invalido!");
        }
        return aeropuertoDTO;
    }

    @Override
    public AeropuertoDTO obtenerAeropuerto() {
        return aeropuerto1;
    }

    @Override
    public List<AeropuertoDTO> obtenerAeropuertos() {
        aeropuertos.add(aeropuerto1);
        aeropuertos.add(aeropuerto2);
        aeropuertos.add(aeropuerto3);
        aeropuertos.add(aeropuerto4);
        aeropuertos.add(aeropuerto5);
        aeropuertos.add(aeropuerto6);
        aeropuertos.add(aeropuerto8);
        return aeropuertos;
    }
}
