/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Autor;
import modelo.Libro;
/**
 *
 * @author USER
 */
public class LibroControlador {

    private ConexionBDD conexion;
    private Connection connection;
    private AutorControlador autorControlador;

    public LibroControlador(AutorControlador autorControlador) {
        this.autorControlador = autorControlador;
        conexion = new ConexionBDD();
        connection = conexion.conectar();
    }

    public void agregarLibro(int autorId, Libro libro) {
        try {
            String consultaSQL = "INSERT INTO Libros(titulo, isbn, autorId) VALUES (?, ?, ?);";
            PreparedStatement ejecutar = connection.prepareStatement(consultaSQL);
            ejecutar.setString(1, libro.getTitulo());
            ejecutar.setString(2, libro.getIsbn());
            ejecutar.setInt(3, autorId);
            int res = ejecutar.executeUpdate();
            if (res > 0) {
                System.out.println("El Libro ha sido agregado con éxito");
            } else {
                System.out.println("Favor ingresar correctamente los datos solicitados");
            }
            ejecutar.close();
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
    }

    public List<Libro> listarLibrosDeAutor(int autorId) {
        List<Libro> libros = new ArrayList<>();
        try {
            String consultaSQL = "SELECT * FROM Libros WHERE autorId = ?;";
            PreparedStatement ejecutar = connection.prepareStatement(consultaSQL);
            ejecutar.setInt(1, autorId);
            ResultSet resultado = ejecutar.executeQuery();
            while (resultado.next()) {
                Libro libro = new Libro(
                        resultado.getInt("idLibro"),
                        resultado.getString("titulo"),
                        resultado.getString("isbn"),
                        autorControlador.buscarAutorPorId(autorId)
                );
                libros.add(libro);
            }
            ejecutar.close();
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
        return libros;
    }

    public void mostrarLibrosDeAutor(int autorId) {
        List<Libro> libros = listarLibrosDeAutor(autorId);
        for (Libro libro : libros) {
            libro.imprimir();
        }
    }
}
