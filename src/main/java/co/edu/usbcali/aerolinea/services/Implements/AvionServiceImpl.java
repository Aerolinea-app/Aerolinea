package co.edu.usbcali.aerolinea.services.Implements;

import co.edu.usbcali.aerolinea.domain.Avion;
import co.edu.usbcali.aerolinea.dto.AvionDTO;
import co.edu.usbcali.aerolinea.mappers.AvionMapper;
import co.edu.usbcali.aerolinea.repository.AvionRepository;
import co.edu.usbcali.aerolinea.services.Interfaces.AvionService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AvionServiceImpl implements AvionService {
    private final AvionRepository avionRepository;
    private final ModelMapper modelMapper;
    public AvionServiceImpl(AvionRepository avionRepository, ModelMapper modelMapper) {
        this.avionRepository = avionRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public List<AvionDTO> obtenerAviones() {
        return AvionMapper.domainToDTOList(avionRepository.findAll());
    }
    @Override
    public AvionDTO obtenerAvion(Integer id) throws Exception {
        if (!avionRepository.existsById(id)) {
            throw new Exception("El id " + id + " no corresponde a ningun avion!");
        }
        return AvionMapper.domainToDTO(avionRepository.getReferenceById(id));
    }
    @Override
    public AvionDTO agregarAvion(AvionDTO avionDTO) throws Exception {
        if (avionDTO == null) {
            throw new Exception("El avión es invalido!");
        }
        if (avionDTO.getIdAvion() == null || avionDTO.getIdAvion() < 0) {
            throw new Exception("El id del avion es invalido!");
        }
        if (avionDTO.getAerolineaAvion() == null || avionDTO.getAerolineaAvion().isBlank() || avionDTO.getAerolineaAvion().trim().isEmpty()) {
            throw new Exception("Debe ingresar el nombre de la aerolinea a la que pertenece el avion!");
        }
        if (avionDTO.getEstado() == null || avionDTO.getEstado().isBlank() || avionDTO.getEstado().trim().isEmpty()) {
            throw new Exception("El estado es invalido!");
        }
        if(avionRepository.findById(avionDTO.getIdAvion()).isPresent()){
            throw new Exception("Ya existe el id del avion!");
        }
        Avion avion = AvionMapper.dtoToDomain(avionDTO);
        return AvionMapper.domainToDTO(avionRepository.save(avion));
    }

    @Override
    public List<AvionDTO> obtenerAvionesActivos() {
        return AvionMapper.domainToDTOList(avionRepository.findAllByEstado("A"));
    }
}
