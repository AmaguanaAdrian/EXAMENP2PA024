/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author USER
 */
public class Autor {
    private int idAutor;
    private String nombres;
    private String apellidos;
    private String fechaNace;

    public Autor(int idAutor, String nombres, String apellidos, String fechaNace) {
        this.idAutor = idAutor;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNace = fechaNace;
    }

    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFechaNace() {
        return fechaNace;
    }

    public void setFechaNace(String fechaNace) {
        this.fechaNace = fechaNace;
    }
}

