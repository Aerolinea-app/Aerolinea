package co.edu.usbcali.aerolinea.services.Implements;

import co.edu.usbcali.aerolinea.domain.Usuario;
import co.edu.usbcali.aerolinea.dto.UsuarioDTO;
import co.edu.usbcali.aerolinea.mappers.UsuarioMapper;
import co.edu.usbcali.aerolinea.repository.UsuarioRepository;
import co.edu.usbcali.aerolinea.services.Interfaces.UsuarioService;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final ModelMapper modelMapper;
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, ModelMapper modelMapper) {
        this.usuarioRepository = usuarioRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public UsuarioDTO agregarUsuario(UsuarioDTO usuarioDTO) throws Exception {
        if (usuarioDTO == null) {
            throw new Exception("El usuario es invalido!");
        }
        if (usuarioDTO.getCedula() == null || usuarioDTO.getCedula().isBlank() || usuarioDTO.getNombre().trim().isEmpty()) {
            throw new Exception("La cédula del usuario es invalida!");
        }
        if (usuarioDTO.getNombre() == null || usuarioDTO.getNombre().isBlank() || usuarioDTO.getNombre().trim().isEmpty()) {
            throw new Exception("El nombre del usuario es invalido!");
        }
        if (usuarioDTO.getApellido() == null || usuarioDTO.getApellido().isBlank() || usuarioDTO.getApellido().trim().isEmpty()) {
            throw new Exception("El apellido del usuario es invalido!");
        }
        if (usuarioDTO.getCorreo() == null || usuarioDTO.getCorreo().isBlank() || usuarioDTO.getCorreo().trim().isEmpty()) {
            throw new Exception("El correo del usuario es invalido!");
        }
        if (usuarioDTO.getEstado() == null || usuarioDTO.getEstado().isBlank() || usuarioDTO.getEstado().trim().isEmpty()) {
            throw new Exception("El estado del usuario es invalido!");
        }
        if(usuarioRepository.findById(usuarioDTO.getIdUsuario()).isPresent()){
            throw new Exception("Ya existe el id del usuario!");
        }
        Usuario usuario = UsuarioMapper.dtoToDomain(usuarioDTO);
        return UsuarioMapper.domainToDTO(usuarioRepository.save(usuario));
    }
    @Override
    public List<UsuarioDTO> obtenerUsuarios() {
        return UsuarioMapper.domainToDTOList(usuarioRepository.findAll());
    }
    @Override
    public UsuarioDTO obtenerUsuario(Integer id) throws Exception {
        if (usuarioRepository.findById(id).isEmpty()) {
            throw new Exception("El id " + id + " no corresponde a ningun usuario!");
        }

        return UsuarioMapper.domainToDTO(usuarioRepository.findById(id).get());
    }
}
