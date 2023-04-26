package co.edu.usbcali.aerolinea.repository;

import co.edu.usbcali.aerolinea.domain.Aeropuerto;
import co.edu.usbcali.aerolinea.domain.Trayecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrayectoRepository extends JpaRepository<Trayecto, Integer> {
}
