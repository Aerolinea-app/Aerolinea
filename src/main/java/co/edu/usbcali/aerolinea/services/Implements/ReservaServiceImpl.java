package co.edu.usbcali.aerolinea.services.Implements;

import co.edu.usbcali.aerolinea.domain.Reserva;
import co.edu.usbcali.aerolinea.dto.ReservaDTO;
import co.edu.usbcali.aerolinea.mappers.ReservaMapper;
import co.edu.usbcali.aerolinea.repository.ReservaRepository;
import co.edu.usbcali.aerolinea.services.Interfaces.ReservaService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ReservaServiceImpl implements ReservaService {
    private final ReservaRepository reservaRepository;
    private final ModelMapper modelMapper;
    public ReservaServiceImpl(ReservaRepository reservaRepository, ModelMapper modelMapper) {
        this.reservaRepository = reservaRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public List<ReservaDTO> obtenerReservas() {
        return ReservaMapper.domainToDTOList(reservaRepository.findAll());
    }
    @Override
    public ReservaDTO obtenerReserva(Integer id) throws Exception {
        if (reservaRepository.findById(Long.valueOf(id)).isEmpty()) {
            throw new Exception("El id " + id + " no corresponde a ninguna reserva!");
        }
        return ReservaMapper.domainToDTO(reservaRepository.findById(Long.valueOf(id)).get());
    }
    @Override
    public ReservaDTO agregarReserva(ReservaDTO reservaDTO) throws Exception {
        if (reservaDTO == null) {
            throw new Exception("La reserva es invalida!");
        } if (reservaDTO.getPrecioTotal() < 0) {
            throw new Exception("El precio de la reserva no puede ser negativo!");
        } if (reservaDTO.getEstadoPago() == null || reservaDTO.getEstadoPago().isBlank() || reservaDTO.getEstadoPago().trim().isEmpty()) {
            throw new Exception("El estado de pago de la reserva es invalido!");
        } if (reservaDTO.getFecha() == null) {
            throw new Exception("La fecha de la reserva es invalida!");
        } if (reservaDTO.getEstado() == null || reservaDTO.getEstado().isBlank() || reservaDTO.getEstado().trim().isEmpty()) {
            throw new Exception("El estado de la reserva es invalido!");
        }
        Reserva reserva = ReservaMapper.dtoToDomain(reservaDTO);
        return ReservaMapper.domainToDTO(reservaRepository.save(reserva));
    }
}
