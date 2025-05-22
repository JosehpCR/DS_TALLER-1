package org.Infraestructura.Persistencia;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.Dominio.Entidades.Libro;
import org.Dominio.Entidades.Multa;
import org.Dominio.Entidades.Prestamo;
import org.Dominio.Entidades.Usuario;
import org.Dominio.Repositorio.IRepositorio;
import org.Aplicacion.DTO.PrestamoDTO;
import org.Aplicacion.DTO.PrestamoMapeo;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

public class JsonRepositorio implements IRepositorio {

    private String archivoUsuario;
    private String archivoLibro;
    private String archivoPrestamo;
    private String archivoMulta;

    private Gson json = new Gson();

    public JsonRepositorio(String archivoUsuario, String archivoLibro, String archivoPrestamo, String archivoMulta) {
        this.archivoUsuario = archivoUsuario;
        this.archivoLibro = archivoLibro;
        this.archivoPrestamo = archivoPrestamo;
        this.archivoMulta = archivoMulta;
    }
    @Override
    public List<Usuario> getUsuarios() {
        return leerLista(archivoUsuario, new TypeToken<List<Usuario>>(){}.getType());
    }
    @Override
    public List<Libro> getLibros() {
        return leerLista(archivoLibro, new TypeToken<List<Libro>>(){}.getType());
    }
    @Override
    public List<Prestamo> getPrestamos() {
        List<PrestamoDTO> prestamosDTO = leerLista(archivoPrestamo, new TypeToken<List<PrestamoDTO>>(){}.getType());
        return prestamosDTO.stream().map(PrestamoMapeo::conversorEntidad).collect(Collectors.toList());
    }
    @Override
    public List<Multa> getMultas() {
        return leerLista(archivoMulta, new TypeToken<List<Multa>>(){}.getType());
    }
    @Override
    public void guardarUsuarios(List<Usuario> usuarios) {
        escribirLista(archivoUsuario, usuarios);
    }
    @Override
    public void guardarLibros(List<Libro> libros) {
        escribirLista(archivoLibro, libros);
    }
    @Override
    public void guardarPrestamos(List<Prestamo> prestamos) {
        List<PrestamoDTO> prestamoDTOS = prestamos.stream().map(PrestamoMapeo::conversorDto).collect(Collectors.toList());
        escribirLista(archivoPrestamo, prestamoDTOS);
    }
    @Override
    public void guardarMultas(List<Multa> multas) {
        escribirLista(archivoMulta, multas);
    }

    private <T> List<T> leerLista(String archivo, Type type) {
        try (Reader reader = new FileReader(archivo)) {
            return json.fromJson(reader, type);
        } catch (FileNotFoundException e){
            return new java.util.ArrayList<>();

        } catch (IOException e) {
            throw new RuntimeException("Error leyendo archivo " + archivo, e);
        }
    }

    private <T> void escribirLista(String archivo, List<T> lista) {
        try (Writer writer = new FileWriter(archivo)) {
            json.toJson(lista, writer);
        } catch (IOException e) {
            throw new RuntimeException("Error escribendo archivo " + archivo, e);
        }
    }
}
