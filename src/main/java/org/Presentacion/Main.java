package org.Presentacion;

import org.Aplicacion.ServicioLibreria;
import org.Dominio.Entidades.Libro;
import org.Dominio.Entidades.Prestamo;
import org.Dominio.Entidades.Usuario;
import org.Dominio.Tipos.TipoUsuario;
import org.Infraestructura.Persistencia.JsonRepositorio;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<Usuario> usuarios = Arrays.asList(
                new Usuario("U1", "Juan Pérez", TipoUsuario.DOCENTE),
                new Usuario("U2", "Ana Gomez", TipoUsuario.ESTUDIANTE),
                new Usuario("U3", "Carlos Ruiz", TipoUsuario.EMPLEADO)
        );

        List<Libro> libros = Arrays.asList(
                new Libro("B1", "El Quijote"),
                new Libro("B2", "Cien Años de Soledad")

        );
        List<Prestamo>  prestamos = Arrays.asList(
                new Prestamo("L1", "U1", "B1", LocalDate.of(2024,5,1), LocalDate.of(2024,5,7), LocalDate.of(2024,5,10)),
                new Prestamo("L2", "U2", "B2", LocalDate.of(2024,5,3), LocalDate.of(2024,5,9), LocalDate.of(2024,5,9)),
                new Prestamo("L3", "U3", "B1", LocalDate.of(2024,5,11), LocalDate.of(2024,5,18), LocalDate.of(2024,5,21))
        );

        String archivoUsuario = "usuarios.json";
        String archivoLibro = "libros.json";
        String archivoPrestamo = "prestamos.json";
        String archivoMultas = "multas.json";

        var repo = new JsonRepositorio(archivoUsuario, archivoLibro, archivoPrestamo, archivoMultas);

        repo.guardarUsuarios(usuarios);
        repo.guardarLibros(libros);
        repo.guardarPrestamos(prestamos);

        ServicioLibreria servicioLibreria = new ServicioLibreria(repo);

        servicioLibreria.GuardarMultas();

        System.out.println("=== Libros ===");
        servicioLibreria.mostrarLibros();
        System.out.println("\n=== Usuarios ===");
        servicioLibreria.mostrarUsuarios();
        System.out.println("\n=== Préstamos ===");
        servicioLibreria.mostrarPrestamos();
        System.out.println("\n=== Multas (guardadas en archivo) ===");
        servicioLibreria.mostrarMultasJson();



    }
}