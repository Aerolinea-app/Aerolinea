package co.edu.usbcali.aerolinea.services.Implements;

import co.edu.usbcali.aerolinea.domain.Factura;
import co.edu.usbcali.aerolinea.domain.Usuario;
import co.edu.usbcali.aerolinea.repository.FacturaRepository;
import co.edu.usbcali.aerolinea.repository.UsuarioRepository;
import co.edu.usbcali.aerolinea.services.Interfaces.FacturaService;
import lombok.extern.slf4j.Slf4j;
import co.edu.usbcali.aerolinea.dto.FacturaDTO;
import co.edu.usbcali.aerolinea.mappers.FacturaMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class FacturaServiceImpl implements FacturaService {
    private final FacturaRepository facturaRepository;
    private final UsuarioRepository usuarioRepository;
    private final ModelMapper modelMapper;

    public FacturaServiceImpl(FacturaRepository facturaRepository, UsuarioRepository usuarioRepository, ModelMapper modelMapper) {
        this.facturaRepository = facturaRepository;
        this.usuarioRepository = usuarioRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public List<FacturaDTO> obtenerFacturas() {
        return FacturaMapper.domainToDTOList(facturaRepository.findAll());
    }
    @Override
    public FacturaDTO obtenerFactura(Integer id) throws Exception {
        if (!facturaRepository.existsById(id)) {
            throw new Exception("El id " + id + " no corresponde a ninguna factura");
        }
        return FacturaMapper.domainToDTO(facturaRepository.getReferenceById(id));
    }
    @Override
    public FacturaDTO agregarFactura(FacturaDTO facturaDTO) throws Exception {
        if (facturaDTO == null) {
            throw new Exception("La factura es invalida!");
        }
        if (facturaDTO.getIdFactura() == null ) {
            throw new Exception("El id de la factura es invalido!");
        }
        if (facturaDTO.getEstado() == null || facturaDTO.getEstado().isBlank() || facturaDTO.getEstado().trim().isEmpty()) {
            throw new Exception("El estado es invalido!");
        }
        if(facturaRepository.findById(facturaDTO.getIdFactura()).isPresent()){
            throw new Exception("Ya existe el id de la factura!");
        }
        Factura factura = FacturaMapper.dtoToDomain(facturaDTO);

        Usuario usuario = usuarioRepository.getReferenceById(facturaDTO.getIdUsuario());
        factura.setIdUsuario(usuario);

        return FacturaMapper.domainToDTO(facturaRepository.save(factura));
    }
}
