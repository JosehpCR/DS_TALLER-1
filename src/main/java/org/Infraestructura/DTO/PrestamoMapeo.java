package org.Infraestructura.DTO;

import org.Dominio.Entidades.Prestamo;

import java.time.LocalDate;


public class PrestamoMapeo {

    public static PrestamoDTO conversorDto (Prestamo prestamo) {
        PrestamoDTO prestamoDTO = new PrestamoDTO();
        prestamoDTO.idPrestamo = prestamo.getIdPrestamo();
        prestamoDTO.idUsuario = prestamo.getIdUsuario();
        prestamoDTO.idLibro = prestamo.getIdLibro();
        prestamoDTO.fechaInicioPrestamo = prestamo.getFechaInicioPrestamo().toString();
        prestamoDTO.fechaVencimientoPrestamo = prestamo.getFechaVencimientoPrestamo().toString();
        prestamoDTO.fechaRegresoLibro = prestamo.getFechaRegresoLibro() != null ? prestamo.getFechaRegresoLibro().toString() : null;
        return prestamoDTO;

    }
    public static Prestamo conversorEntidad (PrestamoDTO prestamoDTO) {
        return new Prestamo(
                prestamoDTO.idPrestamo,
                prestamoDTO.idUsuario,
                prestamoDTO.idLibro,
                LocalDate.parse(prestamoDTO.fechaInicioPrestamo),
                LocalDate.parse(prestamoDTO.fechaVencimientoPrestamo),
                prestamoDTO.fechaRegresoLibro != null ? LocalDate.parse(prestamoDTO.fechaRegresoLibro) : null
        );
    }
}
