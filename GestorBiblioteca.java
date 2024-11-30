import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.io.*;

public class GestorBiblioteca implements Serializable, SistemaBiblioteca, Prestamo {

    private HashMap<String, Usuario> usuarios; // para almacenar usuarios con id como clave
    private HashMap<String, Libro> libros; // para almacenar libros con isbn como clave
    private HashMap<String, Libro> prestamos; // para almacenar libros prestados usando isbn como clave
    private final String path= "gestorBiblioteca_data.ser"; //Esto significa que no podes modificar en otra instancia esto jiji
    // Constructor
    public GestorBiblioteca() {
        usuarios = new HashMap<>();
        libros = new HashMap<>();
        prestamos = new HashMap<>();

    }

    //Metodo para guardar archivos
    public void guardarDatos(){
        cargarDatos(); //Combinar datos con los ya existentes
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))){
            oos.writeObject(usuarios);
            oos.writeObject(libros);
            oos.writeObject(prestamos);
            System.out.println("Datos guardados correctamente ");
        } catch (IOException e) {
            System.err.println("Error al guardar los datos: " + e.getMessage());
        }
    }

    //Metodo para cargar archivos
    @SuppressWarnings("unchecked") //es para que no te molesten los cartelitos jiji
    public void cargarDatos() {
        File archivo = new File(path);
        if (!archivo.exists()) {
            // Si el archivo no existe, inicializar los HashMap vacíos
            usuarios = new HashMap<>();
            libros = new HashMap<>();
            prestamos = new HashMap<>();
            System.out.println("No se encontraron datos previos. Se han inicializado nuevos registros.");
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            // Leer los objetos del archivo en el mismo orden en que fueron escritos
            usuarios = (HashMap<String, Usuario>) ois.readObject();
            libros = (HashMap<String, Libro>) ois.readObject();
            prestamos = (HashMap<String, Libro>) ois.readObject();

            System.out.println("Datos cargados correctamente desde " + path);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar los datos: " + e.getMessage());
        }
    }

    // Métodos CRUD para usuarios
    @Override
    public void agregarUsuario(Usuario usuario) {
        if (usuario == null){
            throw new IllegalArgumentException("El usuario no puede ser nulo.");
        }
        usuarios.put(usuario.getId(), usuario);
        System.out.println("Usuario agregado: " + usuario);
    }
    
    @Override
    public void mostrarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
        }else{
            System.out.println("Listado de usuarios registrados:");
            for (Usuario usuario : usuarios.values()) {
                System.out.println(usuario);
            }
        }
    }
    
    
    @Override
    public Usuario buscarUsuario(String id) {
        if(id == null || id.isEmpty()){
            throw new IllegalArgumentException("El ID del usuario no puede estar vacío.");
        }
        Usuario usuario = usuarios.get(id); //Búsqueda directa en el Map
        if (usuario == null) {
            throw new NullPointerException("Usuario no encontrado con ID: " + id);
        }
        return usuario;
    }
        
    
    @Override
    public void actualizarUsuario(String id, Usuario usuarioActualizado) {
        if (usuarios.containsKey(id)){
            usuarios.put(id, usuarioActualizado);
            System.out.println("Usuario actualizado: " + usuarioActualizado);
        }else{
            System.out.println("No se encontró el usuario con ID: " + id);
        }
    }

    @Override
    public void eliminarUsuario(String id) {
        if (usuarios.remove(id) != null) {
            System.out.println("Usuario eliminado con ID: " + id);
        }else{
           System.out.println("No se encontró el usuario con ID: " + id); 
        }
    }

    // Métodos CRUD para libros
    @Override
    public void agregarLibro(Libro libro) {
        libros.put(libro.getIsbn(), libro);
        System.out.println("Libro agregado: " + libro);
    }

    @Override
    public void mostrarLibrosDisponibles(){
        if(libros.isEmpty()){
            System.out.println("No hay libros disponibles.");
        }else{
            System.out.println("Listado de libros disponibles: ");
            for (Libro libro : libros.values()) {
                if(!prestamos.containsKey(libro.getIsbn())){ //Solo muestra libros que no están prestados
                    System.out.println(libro);
                }
            }
        }
    }
    
    @Override
    public Libro buscarLibro(String isbn) {
        Libro libro = libros.get(isbn); //Búsqueda directa en el Map
        if (libro == null) {
            System.out.println("Libro no encontrado con ISBN: " + isbn);
            }
            return libro;
    }

    @Override
    public void actualizarLibro(String isbn, Libro libroActualizado) {
        if (libros.containsKey(isbn)) {
                libros.put(isbn, libroActualizado);
                System.out.println("Libro actualizado: " + libroActualizado);
        }else{
            System.out.println("No se encontró el libro con ISBN: " + isbn);
        }
    }

    @Override
    public void eliminarLibro(String isbn) {
        if(libros.remove(isbn) != null){
           System.out.println("Libro eliminado con ISBN: " + isbn); 
        }else{
           System.out.println("No se encontró el libro con ISBN: " + isbn);
        }
    }

    // Métodos de la interfaz Prestamo
    @Override
    public void solicitarPrestamo(String isbn, String id) {
        if (isbn == null || isbn.isEmpty() || id == null || id.isEmpty()) {
            throw new IllegalArgumentException("ISBN y ID de usuario no pueden estar vacíos.");
        }
        
        Usuario usuario = buscarUsuario(id);
        Libro libro = buscarLibro(isbn);

        if (!prestamos.containsKey(isbn)) {
            prestamos.put(isbn, libro);
            System.out.println("Préstamo realizado: " + libro + " a " + usuario);
        } else {
            System.out.println("No se pudo realizar el préstamo: libro no disponible o usuario no encontrado.");
        }
    }

    @Override
    public void devolverLibro(String isbn) {
        if (prestamos.remove(isbn) != null) {
            System.out.println("Libro devuelto con ISBN: " + isbn);
        } else {
            System.out.println("No se encontró el libro en la lista de préstamos.");
        }
    }

    @Override
    public void mostrarPrestamos() {
        if (prestamos.isEmpty()) {
            System.out.println("No hay préstamos activos.");
        } else {
            System.out.println("Listado de préstamos actuales:");
            for (Libro libro : prestamos.values()) {
                System.out.println(libro);
            }
        }
    }
    
}  //fin de la clase GestorBiblioteca

    

    