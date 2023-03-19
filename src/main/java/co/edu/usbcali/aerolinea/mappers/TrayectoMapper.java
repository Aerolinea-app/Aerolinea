package co.edu.usbcali.aerolinea.mappers;

import co.edu.usbcali.aerolinea.domain.Trayecto;
import co.edu.usbcali.aerolinea.dto.TrayectoDTO;

import java.util.List;
import java.util.stream.Collectors;

public class TrayectoMapper {
    public static TrayectoDTO domainToDTO(Trayecto trayecto) {
        return TrayectoDTO.builder()
                .idTrayecto(trayecto.getIdTrayecto())
                .idAvion(trayecto.getIdAvion() != null ? trayecto.getIdAvion().getIdAvion() : null)
                .idAeropuertoOrigen(Math.toIntExact(trayecto.getAeropuertoOrigen() != null ? trayecto.getAeropuertoOrigen().getIdAeropuerto() : null))
                .idAeropuertoDestino(Math.toIntExact(trayecto.getAeropuertoDestino() != null ? trayecto.getAeropuertoDestino().getIdAeropuerto() : null))
                .horaSalida(trayecto.getHoraSalida())
                .horaLlegada(trayecto.getHoraLlegada())
                .idVuelo(trayecto.getIdVuelo().getIdVuelo())
                .estado(trayecto.getEstado())
                .build();
    }

    public static List<TrayectoDTO> domainToDTOList(List<Trayecto> trayectos) {
        return trayectos.stream().map(trayecto -> domainToDTO(trayecto)).collect(Collectors.toList());
    }

    public static Trayecto dtoToDomain(TrayectoDTO trayectoDTO) {
        return Trayecto.builder()
                .idTrayecto(trayectoDTO.getIdTrayecto())
                .horaSalida(trayectoDTO.getHoraSalida())
                .horaLlegada(trayectoDTO.getHoraLlegada())
                .estado(trayectoDTO.getEstado())
                .build();
    }

    public static List<Trayecto> dtoToDomainList(List<TrayectoDTO> trayectosDTO) {
        return trayectosDTO.stream().map(trayectoDTO -> dtoToDomain(trayectoDTO)).collect(Collectors.toList());
    }
}
