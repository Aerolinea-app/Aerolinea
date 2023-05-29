package co.edu.usbcali.aerolinea.services.Implements;

import co.edu.usbcali.aerolinea.domain.Aeropuerto;
import co.edu.usbcali.aerolinea.domain.Avion;
import co.edu.usbcali.aerolinea.domain.Trayecto;
import co.edu.usbcali.aerolinea.dto.AeropuertoDTO;
import co.edu.usbcali.aerolinea.dto.TrayectoDTO;
import co.edu.usbcali.aerolinea.mappers.AeropuertoMapper;
import co.edu.usbcali.aerolinea.mappers.TrayectoMapper;
import co.edu.usbcali.aerolinea.repository.AeropuertoRepository;
import co.edu.usbcali.aerolinea.repository.AvionRepository;
import co.edu.usbcali.aerolinea.repository.TrayectoRepository;
import co.edu.usbcali.aerolinea.services.Interfaces.TrayectoService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class TrayectoServiceImpl implements TrayectoService {
    private final TrayectoRepository trayectoRepository;
    private final AvionRepository avionRepository;
    private final AeropuertoRepository aeropuertoRepository;
    private final ModelMapper modelMapper;
    public TrayectoServiceImpl(TrayectoRepository trayectoRepository, AvionRepository avionRepository, AeropuertoRepository aeropuertoRepository, ModelMapper modelMapper) {
        this.trayectoRepository = trayectoRepository;
        this.avionRepository = avionRepository;
        this.aeropuertoRepository = aeropuertoRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public TrayectoDTO obtenerTrayecto(Integer id) throws Exception {
        if (!trayectoRepository.existsById(id)) {
            throw new Exception("El id " + id + " no corresponde a ningun trayecto!");
        }
        return TrayectoMapper.domainToDTO(trayectoRepository.getReferenceById(id));
    }
    @Override
    public TrayectoDTO agregarTrayecto(TrayectoDTO trayectoDTO) throws Exception {
        if (trayectoDTO == null) {
            throw new Exception("El trayecto es invalido!");
        }
        if (trayectoDTO.getHoraSalida() == null) {
            throw new Exception("La hora de salida del trayecto es invalido!");
        }
        if (trayectoDTO.getHoraLlegada() == null) {
            throw new Exception("La hora de llegada del trayecto es invalido!");
        }
        if (trayectoDTO.getEstado() == null || trayectoDTO.getEstado().isBlank() || trayectoDTO.getEstado().trim().isEmpty()) {
            throw new Exception("El estado del trayecto es invalido!");
        }
        if(trayectoRepository.findById(trayectoDTO.getIdTrayecto()).isPresent()){
            throw new Exception("Ya existe el id del trayecto!");
        }
        Trayecto trayecto = TrayectoMapper.dtoToDomain(trayectoDTO);

        Avion avion = avionRepository.getReferenceById(trayectoDTO.getIdAvion());
        Aeropuerto aeropuerto_origen = aeropuertoRepository.getReferenceById(trayectoDTO.getIdAeropuertoOrigen());
        Aeropuerto aeropuerto_destino = aeropuertoRepository.getReferenceById(trayectoDTO.getIdAeropuertoDestino());

        trayecto.setIdAvion(avion);
        trayecto.setAeropuertoOrigen(aeropuerto_origen);
        trayecto.setAeropuertoDestino(aeropuerto_destino);

        return TrayectoMapper.domainToDTO(trayectoRepository.save(trayecto));
    }
    @Override
    public List<TrayectoDTO> obtenerTrayectos() {
        return TrayectoMapper.domainToDTOList(trayectoRepository.findAll());
    }
    @Override
    public List<TrayectoDTO> obtenerTrayectosActivos() {
        return TrayectoMapper.domainToDTOList(trayectoRepository.findAllByEstado("A"));
    }

    @Override
    public TrayectoDTO updateTrayecto(TrayectoDTO trayectoDTO) throws Exception {
        if (trayectoDTO == null) {
            throw new Exception("El trayecto es invalido!");
        }
        if (trayectoDTO.getHoraSalida() == null) {
            throw new Exception("La hora de salida del trayecto es invalido!");
        }
        if (trayectoDTO.getHoraLlegada() == null) {
            throw new Exception("La hora de llegada del trayecto es invalido!");
        }
        if (trayectoDTO.getEstado() == null || trayectoDTO.getEstado().isBlank() || trayectoDTO.getEstado().trim().isEmpty()) {
            throw new Exception("El estado del trayecto es invalido!");
        }

        Trayecto trayecto = TrayectoMapper.dtoToDomain(trayectoDTO);

        Avion avion = avionRepository.getReferenceById(trayectoDTO.getIdAvion());
        Aeropuerto aeropuerto_origen = aeropuertoRepository.getReferenceById(trayectoDTO.getIdAeropuertoOrigen());
        Aeropuerto aeropuerto_destino = aeropuertoRepository.getReferenceById(trayectoDTO.getIdAeropuertoDestino());

        trayecto.setIdAvion(avion);
        trayecto.setAeropuertoOrigen(aeropuerto_origen);
        trayecto.setAeropuertoDestino(aeropuerto_destino);

        return TrayectoMapper.domainToDTO(trayectoRepository.save(trayecto));
    }

    @Override
    public TrayectoDTO deleteTrayecto(Integer id) throws Exception {
        Optional<Trayecto> trayectoOptional = trayectoRepository.findById(id);

        if (trayectoOptional.isPresent()) {

            Trayecto trayecto = trayectoOptional.get();
            trayectoRepository.deleteById(id);

            return TrayectoMapper.domainToDTO(trayecto);
        } else {
            throw new Exception("No se encontró el trayecto con ese id!");
        }
    }
}
