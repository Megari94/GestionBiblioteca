

public interface SistemaBiblioteca
{
    //Métodos CRUD para usuarios
    public void agregarUsuario(Usuario usuario);
    public void mostrarUsuarios();
    Usuario buscarUsuario(String id);
    public void actualizarUsuario(String id, Usuario usuario);
    public void eliminarUsuario(String id);
    
    //Métodos CRUD para libros
    public void agregarLibro(Libro libro);
    public void mostrarLibrosDisponibles();
    Libro buscarLibro(String isbn);
    public void actualizarLibro(String isbn, Libro libro);
    public void eliminarLibro(String ibsn);
    
}  //fin de la interfaz SistemaBiblioteca
