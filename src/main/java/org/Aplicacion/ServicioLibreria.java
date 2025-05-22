package org.Aplicacion;

import org.Dominio.Entidades.Libro;
import org.Dominio.Entidades.Multa;
import org.Dominio.Entidades.Prestamo;
import org.Dominio.Entidades.Usuario;
import org.Dominio.Repositorio.IRepositorio;
import org.Dominio.Tipos.TipoUsuario;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class ServicioLibreria {
    private IRepositorio repositorio;

    private static Map<TipoUsuario, Integer> valorMultaDiaria = Map.of(
            TipoUsuario.DOCENTE, 5000,
            TipoUsuario.ESTUDIANTE, 1000,
            TipoUsuario.EMPLEADO, 2500
    );

    public ServicioLibreria(IRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public int calcularPrecioMulta(Prestamo prestamo) {
        Usuario usuario = repositorio.getUsuarios().stream().filter(u -> u.getIdUsuario().equals(prestamo.getIdUsuario())).findFirst().orElseThrow();
        if (prestamo.getFechaRegresoLibro() == null || !prestamo.getFechaRegresoLibro().isAfter(prestamo.getFechaVencimientoPrestamo())){
            return 0;
        }
        long diasAtrasados = prestamo.getFechaVencimientoPrestamo().until(prestamo.getFechaRegresoLibro()).getDays();
        return (int) diasAtrasados*valorMultaDiaria.get(usuario.getRolUsuario());
    }
    public List<Multa> calcularMultas() {
        return repositorio.getPrestamos().stream().map(prestamo -> {int monto = calcularPrecioMulta(prestamo);
            if (monto > 0){
                return new Multa(prestamo.getIdPrestamo(), prestamo.getIdUsuario(), monto);

            }
            return null;
        })
                .filter(Objects::nonNull).collect(Collectors.toList());
    }
    public void GuardarMultas() {
        List<Multa> multas = calcularMultas();
        repositorio.guardarMultas(multas);
    }
    public void mostrarLibros() {
        repositorio.getLibros().forEach(libro -> System.out.println(libro.getIdLibro() + " | " + libro.getNombreLibro() + "| "));

    }
    public void mostrarPrestamos() {
        repositorio.getPrestamos().forEach(prestamo -> System.out.println(prestamo.getIdPrestamo() + " | Usuario: " + prestamo.getIdUsuario() + " | " + " | Libro: " + prestamo.getIdLibro() +
                " | Fecha inicio: " + prestamo.getFechaInicioPrestamo() + "| Fecha vencimiento: " +prestamo.getFechaVencimientoPrestamo()+ " | Fecha devolución: " + prestamo.getFechaRegresoLibro())
        );
    }
    public void mostrarUsuarios() {
        repositorio.getUsuarios().forEach(usuario -> System.out.println(usuario.getIdUsuario() + " | " + usuario.getNombreUsuario() + " | " + usuario.getRolUsuario()));
    }

    public void mostrarMultasJson() {
        repositorio.getMultas().forEach(multa -> System.out.println("Prestamo " + multa.getIdPrestamo()+ ": Usuario " + multa.getIdUsuario() + ", Multa: $" +  multa.getPrecioMulta()));
    }


}
