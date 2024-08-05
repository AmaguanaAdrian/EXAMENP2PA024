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
/**
 *
 * @author USER
 */
public class AutorControlador {

    private ConexionBDD conexion;
    private Connection connection;

    public AutorControlador() {
        conexion = new ConexionBDD();
        connection = conexion.conectar();
    }

    public int crearAutor(Autor autor) {
        int idGenerado = -1;
        try {
            String consultaSQL = "INSERT INTO Autores(nombres, apellidos, fechaNace) VALUES (?, ?, ?);";
            PreparedStatement ejecutar = connection.prepareStatement(consultaSQL, PreparedStatement.RETURN_GENERATED_KEYS);
            ejecutar.setString(1, autor.getNombres());
            ejecutar.setString(2, autor.getApellidos());
            ejecutar.setString(3, autor.getFechaNace());
            int res = ejecutar.executeUpdate();

            if (res > 0) {
                ResultSet rs = ejecutar.getGeneratedKeys();
                if (rs.next()) {
                    idGenerado = rs.getInt(1);
                    System.out.println("El Autor ha sido creado con éxito con ID: " + idGenerado);
                }
                rs.close();
            } else {
                System.out.println("Favor ingresar correctamente los datos solicitados");
            }
            ejecutar.close();
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
        return idGenerado;
    }

    public List<Autor> listarAutores() {
        List<Autor> autores = new ArrayList<>();
        try {
            String consultaSQL = "SELECT * FROM Autores;";
            PreparedStatement ejecutar = connection.prepareStatement(consultaSQL);
            ResultSet resultado = ejecutar.executeQuery();
            while (resultado.next()) {
                Autor autor = new Autor(
                        resultado.getInt("idAutor"),
                        resultado.getString("nombres"),
                        resultado.getString("apellidos"),
                        resultado.getString("fechaNace")
                );
                autores.add(autor);
            }
            ejecutar.close();
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
        return autores;
    }

    public void mostrarListaAutores() {
        List<Autor> autores = listarAutores();
        for (Autor autor : autores) {
            System.out.println("ID: " + autor.getIdAutor() + " - " + autor.getNombres() + " " + autor.getApellidos());
        }
    }

    public Autor buscarAutorPorId(int id) {
        Autor autor = null;
        try {
            String consultaSQL = "SELECT * FROM Autores WHERE idAutor = ?;";
            PreparedStatement ejecutar = connection.prepareStatement(consultaSQL);
            ejecutar.setInt(1, id);
            ResultSet resultado = ejecutar.executeQuery();
            if (resultado.next()) {
                autor = new Autor(
                        resultado.getInt("idAutor"),
                        resultado.getString("nombres"),
                        resultado.getString("apellidos"),
                        resultado.getString("fechaNace")
                );
            }
            ejecutar.close();
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
        return autor;
    }
}
