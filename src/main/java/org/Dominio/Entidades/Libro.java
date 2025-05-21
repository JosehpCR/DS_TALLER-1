package org.Dominio.Entidades;

public class Libro {

    private String idLibro;
    private String nombreLibro;

    public Libro(String idLibro, String nombreLibro) {
        this.idLibro = idLibro;
        this.nombreLibro = nombreLibro;
    }
    public String getIdLibro() {return idLibro;}
    public String getNombreLibro() {return nombreLibro;}

}
