

public interface Prestamo
{
    public void solicitarPrestamo(String isbn, String id);
    public void devolverLibro(String isbn);
    public void mostrarPrestamos();
}
