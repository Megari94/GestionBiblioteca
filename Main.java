
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorBiblioteca gestor = new GestorBiblioteca();

    int opcion = 0;

        do {
            try{
                System.out.println("\n--- Menú del Sistema de Biblioteca ---");
                System.out.println("1. Agregar Usuario (Alumno, Profesor o Bibliotecario)");
                System.out.println("2. Mostrar Usuarios Registrados");
                System.out.println("3. Buscar Usuario");
                System.out.println("4. Actualizar Usuario");
                System.out.println("5. Eliminar Usuario");
                System.out.println("6. Agregar Libro");
                System.out.println("7. Mostrar Libros Disponibles");
                System.out.println("8. Buscar Libro");
                System.out.println("9. Actualizar Libro");
                System.out.println("10. Eliminar Libro");
                System.out.println("11. Solicitar Préstamo");
                System.out.println("12. Devolver Libro");
                System.out.println("13. Mostrar Préstamos Activos");
                System.out.println("14. Guargar Datos");
                System.out.println("15. Cargar Datos");
                System.out.println("16. Salir");
                System.out.print("Seleccione una opción: ");
                
                opcion = scanner.nextInt();
                scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    agregarUsuario(gestor, scanner);
                    break;
                case 2: 
                    gestor.mostrarUsuarios();
                    break;
                case 3:
                    buscarUsuario(gestor, scanner);
                    break;
                case 4:
                    actualizarUsuario(gestor, scanner);
                    break;
                case 5:
                    eliminarUsuario(gestor, scanner);
                    break;
                case 6:
                    agregarLibro(gestor, scanner);
                    break;
                case 7: 
                    gestor.mostrarLibrosDisponibles();
                    break;
                case 8:
                    buscarLibro(gestor, scanner);
                    break;
                case 9:
                    actualizarLibro(gestor, scanner);
                    break;
                case 10:
                    eliminarLibro(gestor, scanner);
                    break;
                case 11:
                    solicitarPrestamo(gestor, scanner);
                    break;
                case 12:
                    devolverLibro(gestor, scanner);
                    break;
                case 13:
                    mostrarPrestamosActivos(gestor);
                    break;
                case 14:
                    gestor.guardarDatos();
                    break;
                case 15:
                    gestor.cargarDatos();
                    break;
                case 16:
                    System.out.println("Saliendo del sistema...");
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } catch (InputMismatchException e){
            System.out.println("Error: Por favor ingrese un número válido.");
            scanner.nextLine(); //se limpia el buffer para evitar un bucle infinito
        } catch (NullPointerException e){
            System.out.println("Error: El dato ingresado no existe en el sistema.");
        } catch (Exception e){
            System.out.println("Error inesperado: " + e.getMessage());
        }
                
    } while (opcion != 16);

        scanner.close();
    }

    // Métodos para manejar las opciones del menú
    private static void agregarUsuario(GestorBiblioteca gestor, Scanner scanner) {
        System.out.println("Seleccione el tipo de usuario: 1. Alumno, 2. Profesor, 3. Bibliotecario");
        int tipoUsuario = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese el ID: ");
        String id = scanner.nextLine();
        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Ingrese el DNI: ");
        String dni = scanner.nextLine();
        System.out.print("Ingrese la dirección: ");
        String direccion = scanner.nextLine();
        System.out.print("Ingrese el celular: ");
        String celular = scanner.nextLine();
        System.out.print("Ingrese el email: ");
        String email = scanner.nextLine();

        if (tipoUsuario == 1) {
            System.out.print("Ingrese el legajo: ");
            String legajo = scanner.nextLine();
            System.out.print("Ingrese la carrera: ");
            String carrera = scanner.nextLine();
            Estudiante estudiante = new Estudiante(id, nombre, apellido, dni, direccion, celular, email, legajo, carrera);
            gestor.agregarUsuario(estudiante);
        } else if (tipoUsuario == 2) {
            System.out.print("Ingrese la materia: ");
            String materia = scanner.nextLine();
            Profesor profesor = new Profesor(id, nombre, apellido, dni, direccion, celular, email, materia);
            gestor.agregarUsuario(profesor);
        } else if (tipoUsuario == 3) {
            System.out.print("Ingrese el turno: ");
            String turno = scanner.nextLine();
            Bibliotecario bibliotecario = new Bibliotecario(id, nombre, apellido, dni, direccion, celular, email, turno);
            gestor.agregarUsuario(bibliotecario);
        } else {
            System.out.println("Tipo de usuario no válido.");
        }
    }

    private static void buscarUsuario(GestorBiblioteca gestor, Scanner scanner) {
        System.out.print("Ingrese el ID del usuario a buscar: ");
        String id = scanner.nextLine();
        Usuario usuario = gestor.buscarUsuario(id);
        if (usuario != null) {
            System.out.println("Usuario encontrado: " + usuario);
        }
    }

    private static void actualizarUsuario(GestorBiblioteca gestor, Scanner scanner) {
        System.out.print("Ingrese el ID del usuario a actualizar: ");
        String id = scanner.nextLine();
        Usuario usuarioActualizado = gestor.buscarUsuario(id);
        if (usuarioActualizado != null) {
            System.out.println("1. Modificar nombre");
            System.out.println("2. Modificar apellido");
            System.out.println("3. Modificar DNI");
            System.out.println("4. Modificar correo");
            System.out.println("5. Modificar telefono");
            /*System.out.print("Ingrese el nuevo nombre: ");
            String nombre = scanner.nextLine();
            usuarioActualizado.setNombre(nombre);
            gestor.actualizarUsuario(id, usuarioActualizado);*/

            int opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion){
                case 1:
                    System.out.print("Ingrese el nuevo nombre: ");
                    String nombre = scanner.nextLine();
                    usuarioActualizado.setNombre(nombre);
                    gestor.actualizarUsuario(id, usuarioActualizado);
                    break;
                case 2:
                    System.out.print("Ingrese el nuevo apellido: ");
                    String apellido = scanner.nextLine();
                    usuarioActualizado.setApellido(apellido);
                    gestor.actualizarUsuario(id, usuarioActualizado);
                    break;
                case 3:
                    System.out.print("Ingrese el nuevo DNI: ");
                    String dni = scanner.nextLine();
                    usuarioActualizado.setDni(dni);
                    gestor.actualizarUsuario(id, usuarioActualizado);
                    break;
                case 4:
                    System.out.print("Ingrese el nuevo correo: ");
                    String correo = scanner.nextLine();
                    usuarioActualizado.setEmail(correo);
                    gestor.actualizarUsuario(id, usuarioActualizado);
                    break;
                case 5:
                    System.out.print("Ingrese el nuevo telefono: ");
                    String telefono = scanner.nextLine();
                    usuarioActualizado.setCelular(telefono);
                    gestor.actualizarUsuario(id, usuarioActualizado);
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
    }

    private static void eliminarUsuario(GestorBiblioteca gestor, Scanner scanner) {
        System.out.print("Ingrese el ID del usuario a eliminar: ");
        String id = scanner.nextLine();
        gestor.eliminarUsuario(id);
    }

    private static void agregarLibro(GestorBiblioteca gestor, Scanner scanner) {
        System.out.print("Ingrese el ISBN del libro: ");
        String isbn = scanner.nextLine();
        System.out.print("Ingrese el título: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese el autor: ");
        String autor = scanner.nextLine();
        Libro libro = new Libro(isbn, titulo, autor) ;
        gestor.agregarLibro(libro);
    }

    private static void buscarLibro(GestorBiblioteca gestor, Scanner scanner) {
        System.out.print("Ingrese el ISBN del libro a buscar: ");
        String isbn = scanner.nextLine();
        Libro libro = gestor.buscarLibro(isbn);
        if (libro != null) {
            System.out.println("Libro encontrado: " + libro);
        }
    }

    private static void actualizarLibro(GestorBiblioteca gestor, Scanner scanner) {
        System.out.print("Ingrese el ISBN del libro a actualizar: ");
        String isbn = scanner.nextLine();
        Libro libroActualizado = gestor.buscarLibro(isbn);
        if (libroActualizado != null) {
            System.out.print("Ingrese el nuevo título: ");
            String titulo = scanner.nextLine();
            libroActualizado.setTitulo(titulo);
            gestor.actualizarLibro(isbn, libroActualizado);
        }
    }

    private static void eliminarLibro(GestorBiblioteca gestor, Scanner scanner) {
        System.out.print("Ingrese el ISBN del libro a eliminar: ");
        String isbn = scanner.nextLine();
        gestor.eliminarLibro(isbn);
    }
    
    // Método para solicitar préstamo
    private static void solicitarPrestamo(GestorBiblioteca gestor, Scanner scanner) {
        System.out.print("Ingrese el ISBN del libro a solicitar: ");
        String isbn = scanner.nextLine();
        System.out.print("Ingrese el ID del usuario que solicita el préstamo: ");
        String idUsuario = scanner.nextLine();
        gestor.solicitarPrestamo(isbn, idUsuario);
    }

    // Método para devolver libro
    private static void devolverLibro(GestorBiblioteca gestor, Scanner scanner) {
        System.out.print("Ingrese el ISBN del libro a devolver: ");
        String isbn = scanner.nextLine();
        gestor.devolverLibro(isbn);
    }

    // Método para mostrar préstamos activos
    private static void mostrarPrestamosActivos(GestorBiblioteca gestor) {
        gestor.mostrarPrestamos();
    }



    } //fin del main
