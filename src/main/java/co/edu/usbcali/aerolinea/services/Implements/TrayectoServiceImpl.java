package co.edu.usbcali.aerolinea.services.Implements;

import co.edu.usbcali.aerolinea.domain.Trayecto;
import co.edu.usbcali.aerolinea.dto.TrayectoDTO;
import co.edu.usbcali.aerolinea.mappers.TrayectoMapper;
import co.edu.usbcali.aerolinea.repository.TrayectoRepository;
import co.edu.usbcali.aerolinea.services.Interfaces.TrayectoService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TrayectoServiceImpl implements TrayectoService {
    private final TrayectoRepository trayectoRepository;
    private final ModelMapper modelMapper;
    public TrayectoServiceImpl(TrayectoRepository trayectoRepository, ModelMapper modelMapper) {
        this.trayectoRepository = trayectoRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public TrayectoDTO obtenerTrayecto(Integer id) throws Exception {
        if (trayectoRepository.findById(Long.valueOf(id)).isEmpty()) {
            throw new Exception("El id " + id + " no corresponde a ningun trayecto!");
        }
        return TrayectoMapper.domainToDTO(trayectoRepository.findById(Long.valueOf(id)).get());
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
        Trayecto trayecto = TrayectoMapper.dtoToDomain(trayectoDTO);
        return TrayectoMapper.domainToDTO(trayectoRepository.save(trayecto));
    }
    @Override
    public List<TrayectoDTO> obtenerTrayectos() {
        return TrayectoMapper.domainToDTOList(trayectoRepository.findAll());
    }
}
