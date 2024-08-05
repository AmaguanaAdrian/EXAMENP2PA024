/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;
import Controlador.AutorControlador;
import Controlador.LibroControlador;
import modelo.Autor;
import modelo.Libro;
import java.util.Scanner;
/**
 *
 * @author USER
 */
public class main {

    public static void main(String[] args) {
        Scanner es = new Scanner(System.in);
        AutorControlador autorControlador = new AutorControlador();
        LibroControlador libroControlador = new LibroControlador(autorControlador);

        int op1;
        do {
            menuLibros();

            while (true) {
                try {
                    op1 = Integer.parseInt(es.nextLine());
                    if (op1 >= 0 && op1 <= 3) {
                        break;
                    } else {
                        System.out.println("Opción no válida, por favor elija una opción entre 0 y 3.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Entrada no válida. Por favor, ingrese un número.");
                }
            }

            if (op1 == 1) {
                // Insertar libro
                String titulo, isbn;
                int autorId;
                boolean datosCorrectos = true;

                while (true) {
                    System.out.println("Ingrese el título del libro:");
                    titulo = es.nextLine();
                    if (!titulo.isEmpty() && !titulo.matches(".*\\d.*")) {
                        break;
                    } else {
                        System.out.println("Título no puede estar vacío ni contener números. ¿Volver a intentarlo? (si/no):");
                        if (!es.nextLine().equalsIgnoreCase("si")) {
                            datosCorrectos = false;
                            break;
                        }
                    }
                }

                if (!datosCorrectos) {
                    continue;
                }

                while (true) {
                    System.out.println("Ingrese el ISBN del libro:");
                    isbn = es.nextLine();
                    if (isbn.matches("\\d{13}")) {
                        break;
                    } else {
                        System.out.println("ISBN debe contener exactamente 13 dígitos. ¿Volver a intentarlo? (si/no):");
                        if (!es.nextLine().equalsIgnoreCase("si")) {
                            datosCorrectos = false;
                            break;
                        }
                    }
                }

                if (!datosCorrectos) {
                    continue;
                }

                // Mostrar autores disponibles
                autorControlador.mostrarListaAutores();
                System.out.println("Seleccione el ID del autor:");
                autorId = Integer.parseInt(es.nextLine());
                Autor autor = autorControlador.buscarAutorPorId(autorId);

                if (autor == null) {
                    System.out.println("Autor no encontrado. Asegúrese de seleccionar un autor válido.");
                } else {
                    Libro nuevoLibro = new Libro(0, titulo, isbn, autor);
                    libroControlador.agregarLibro(autorId, nuevoLibro);
                }

            } else if (op1 == 3) {
                // Mostrar lista de libros de un autor
                System.out.println("Lista de autores disponibles:");
                autorControlador.mostrarListaAutores();
                System.out.println("Ingrese el ID del autor para ver sus libros:");
                int autorId = Integer.parseInt(es.nextLine());
                libroControlador.mostrarLibrosDeAutor(autorId);

            } else if (op1 == 2) {
                // Insertar autor
                String nombres, apellidos, fechaNace;
                System.out.println("Ingrese los nombres del autor:");
                nombres = es.nextLine();
                System.out.println("Ingrese los apellidos del autor:");
                apellidos = es.nextLine();
                System.out.println("Ingrese la fecha de nacimiento del autor (yyyy-mm-dd):");
                fechaNace = es.nextLine();

                Autor nuevoAutor = new Autor(0, nombres, apellidos, fechaNace);
                int idAutorGenerado = autorControlador.crearAutor(nuevoAutor);

                if (idAutorGenerado != -1) {
                    System.out.println("Autor agregado exitosamente con ID: " + idAutorGenerado);
                } else {
                    System.out.println("Error al agregar el autor.");
                }

                } else if (op1 == 0) {
                System.out.println("Saliendo del menú...");
                break;
            }
        } while (op1 != 0);

        es.close();
    }
public static void menuLibros() {
  System.out.println(
                                "╔════════════════════════════════════════════════════════════╗\n" +
                                "║               Menú de Libros                      ║\n" +
                                "╠═══════════════════════════════════════════════════════════╣\n" +
                                "║  1.  Insertar libro                               ║\n" +
                                "║  2.  Insertar autor                               ║\n" +
                                "║  3.  Mostrar lista de libros de un autor          ║\n" +
                                "║  0.  Salir                                        ║\n" +
                                "╚═══════════════════════════════════════════════════════════╝\n" +
                                "Elija una opción: "
        );
}


}



//public class main {
//
//    public static void main(String[] args) {
//        Scanner es = new Scanner(System.in);
//        AutorControlador autorControlador = new AutorControlador();
//        LibroControlador libroControlador = new LibroControlador(autorControlador);
//
//        int op1;
//        do {
//            menuLibros();
//
//            while (true) {
//                try {
//                    op1 = Integer.parseInt(es.nextLine());
//                    if (op1 >= 0 && op1 <= 2) {
//                        break;
//                    } else {
//                        System.out.println("Opción no válida, por favor elija una opción entre 0 y 2.");
//                    }
//                } catch (NumberFormatException e) {
//                    System.out.println("Entrada no válida. Por favor, ingrese un número.");
//                }
//            }
//
//            if (op1 == 1) {
//                 Insertar libro
//                String titulo, isbn;
//                int autorId;
//                boolean datosCorrectos = true;
//
//                while (true) {
//                    System.out.println("Ingrese el título del libro:");
//                    titulo = es.nextLine();
//                    if (!titulo.isEmpty() && !titulo.matches(".*\\d.*")) {
//                        break;
//                    } else {
//                        System.out.println("Título no puede estar vacío ni contener números. ¿Volver a intentarlo? (si/no):");
//                        if (!es.nextLine().equalsIgnoreCase("si")) {
//                            datosCorrectos = false;
//                            break;
//                        }
//                    }
//                }
//
//                if (!datosCorrectos) {
//                    continue;
//                }
//
//                while (true) {
//                    System.out.println("Ingrese el ISBN del libro:");
//                    isbn = es.nextLine();
//                    if (isbn.matches("\\d{13}")) {
//                        break;
//                    } else {
//                        System.out.println("ISBN debe contener exactamente 13 dígitos. ¿Volver a intentarlo? (si/no):");
//                        if (!es.nextLine().equalsIgnoreCase("si")) {
//                            datosCorrectos = false;
//                            break;
//                        }
//                    }
//                }
//
//                if (!datosCorrectos) {
//                    continue;
//                }
//
//                 Mostrar autores disponibles
//                autorControlador.mostrarListaAutores();
//                System.out.println("Seleccione el ID del autor:");
//                autorId = Integer.parseInt(es.nextLine());
//
//                Libro nuevoLibro = new Libro(0, titulo, isbn, autorControlador.buscarAutorPorId(autorId));
//                libroControlador.agregarLibro(autorId, nuevoLibro);
//
//            } else if (op1 == 2) {
//                 Mostrar lista de libros de un autor
//                System.out.println("Ingrese el ID del autor:");
//                int autorId = Integer.parseInt(es.nextLine());
//                libroControlador.mostrarLibrosDeAutor(autorId);
//
//            } else if (op1 == 0) {
//                 Salir del menú
//                System.out.println("Saliendo del menú...");
//                break;
//            }
//        } while (op1 != 0);
//
//        es.close();
//    }
//
//    public static void menuLibros() {
//        System.out.println("Menú de Libros:");
//        System.out.println("1. Insertar libro");
//        System.out.println("2. Mostrar lista de libros de un autor");
//        System.out.println("0. Salir");
//    }
//}
//
