package org.Dominio.Entidades;

import java.time.LocalDate;

public class Prestamo {
    private String idPrestamo;
    private String idUsuario;
    private String idLibro;
    private LocalDate fechaInicioPrestamo;
    private LocalDate fechaVencimientoPrestamo;
    private LocalDate fechaRegresoLibro;

    public Prestamo(String idPrestamo, String idUsuario, String idLibro, LocalDate fechaInicioPrestamo, LocalDate fechaVencimientoPrestamo,  LocalDate fechaRegresoLibro) {
        this.idPrestamo = idPrestamo;
        this.idUsuario = idUsuario;
        this.idLibro = idLibro;
        this.fechaInicioPrestamo = fechaInicioPrestamo;
        this.fechaVencimientoPrestamo = fechaVencimientoPrestamo;
        this.fechaRegresoLibro = fechaRegresoLibro;

    }

    public String getIdPrestamo() {return idPrestamo;}
    public String getIdUsuario() {return idUsuario;}
    public String getIdLibro() {return idLibro;}
    public LocalDate getFechaInicioPrestamo() {return fechaInicioPrestamo;}
    public LocalDate getFechaVencimientoPrestamo() {return fechaVencimientoPrestamo;}
    public LocalDate getFechaRegresoLibro() {return fechaRegresoLibro;}
}
