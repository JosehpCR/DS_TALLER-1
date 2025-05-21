package org.Dominio.Repositorio;

import org.Dominio.Entidades.Libro;
import org.Dominio.Entidades.Multa;
import org.Dominio.Entidades.Prestamo;
import org.Dominio.Entidades.Usuario;

import java.util.List;

public interface IRepositorio {
    List<Usuario> getUsuarios();
    List<Libro> getLibros();
    List<Prestamo> getPrestamos();
    List<Multa> getMultas();

    void guardarUsuarios(List<Usuario> usuarios);
    void guardarLibros(List<Libro> libros);
    void guardarPrestamos(List<Prestamo> prestamos);
    void guardarMultas(List<Multa> multas);
}
