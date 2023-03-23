package co.edu.usbcali.aerolinea.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "trayecto")
public class Trayecto {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_trayecto", nullable = false, unique = true)
    private Integer idTrayecto;
    @ManyToOne
    @JoinColumn(name = "id_avion", referencedColumnName = "id_avion")
    private Avion idAvion;
    @ManyToOne
    @JoinColumn(name = "id_aeropuerto_destino", referencedColumnName = "id_aeropuerto")
    private Aeropuerto aeropuertoDestino;
    @ManyToOne
    @JoinColumn(name = "id_aeropuerto_origen", referencedColumnName = "id_aeropuerto")
    private Aeropuerto aeropuertoOrigen;
    @Column(name = "hora_salida", nullable = false)
    private Date horaSalida;
    @Column(name = "hora_llegada", nullable = false)
    private Date horaLlegada;
    @ManyToOne
    @JoinColumn(name = "id_vuelo", referencedColumnName = "id_vuelo")
    private Vuelo idVuelo;
    @Column(name = "estado", nullable = false, length = 1)
    private String estado;
}
