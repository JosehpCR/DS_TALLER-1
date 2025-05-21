package org.Dominio.Entidades;

public class Multa {
    private String idPrestamo;
    private String idUsuario;
    private int precioMulta;

    public  Multa(String idPrestamo, String idUsuario, int precioMulta) {
        this.idPrestamo = idPrestamo;
        this.idUsuario = idUsuario;
        this.precioMulta = precioMulta;
    }

    public String getIdPrestamo() {return idPrestamo;}
    public String getIdUsuario() {return idUsuario;}
    public int getPrecioMulta() {return precioMulta;}
}
