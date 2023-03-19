package co.edu.usbcali.aerolinea.repository;

import co.edu.usbcali.aerolinea.domain.RolUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolUsuarioRepository extends JpaRepository<RolUsuario, Long> {

}