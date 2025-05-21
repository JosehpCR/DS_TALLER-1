package org.Dominio.Entidades;

import org.Dominio.Tipos.TipoUsuario;

public class Usuario {
    private String idUsuario;
    private String nombreUsuario;
    private TipoUsuario rolUsuario;

    public Usuario(String idUsuario, String nombreUsuario, TipoUsuario rolUsuario) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.rolUsuario = rolUsuario;
    }
    public String getIdUsuario() {return idUsuario;}
    public String getNombreUsuario() {return nombreUsuario;}
    public TipoUsuario getRolUsuario() {return rolUsuario;}
}

