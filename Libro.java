import java.io.Serializable;

public class Libro implements Serializable{
    //Atributos
    private String isbn;
    private String titulo;
    private String autor;
    private String edicion;
    private String editorial;
    private String categoria;
    private String idioma;
    private int anio;
    private int numeroPaginas;

    // Métodos getter y setter
    public String getIsbn(){
        return isbn; 
    }
    
    public void setIsbn(String isbn){
        this.isbn = isbn;
    }
    
    public String getTitulo(){
        return titulo; 
    }
    
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    
    public String getAutor(){
        return autor; 
    }
    
    public void setAutor(String autor){
        this.autor = autor;
    }
    
    public String getEdicion(){
        return edicion; 
    }
    
    public void setEdicion(String edicion){
        this.edicion = edicion;
    }
    
    public String getEditorial(){
        return editorial; 
    }
    
    public void setEditorial(String editorial){
        this.editorial = editorial;
    }
    
    public String getCategoria(){
        return categoria; 
    }
    
    public void setCategoria(String Categoria){
        this.categoria = categoria;
    }
    
    public String getIdioma(){ 
        return idioma; 
    }
    
    public void setIdioma(String idioma){
        this.idioma = idioma;
    }
    
    public int getAnio(){
        return anio; 
    }
    
    public void setAnio(int anio){
        this.anio = anio;
    }
    
    public int getNumeroPaginas(){
        return numeroPaginas = numeroPaginas;
    }
    
    public void setNumeroPaginas(int numeroPaginas){
        this.numeroPaginas = numeroPaginas;
    }
    
    //Constructor vacio
    public Libro(){  
    }
    
    // Constructor
    public Libro(String isbn, String titulo, String autor, String edicion, String editorial, String categoria, String idioma, int anio, int numerpPaginas) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.edicion = edicion;
        this.editorial = editorial;
        this.categoria = categoria;
        this.idioma = idioma;
        this.anio = anio;
        this.numeroPaginas = numeroPaginas;
    }
    
    //constructor
    public Libro(String isbn, String titulo, String autor){
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;   
    }
    
    @Override
    public String toString() {
        return titulo + " por " + autor + " ISBN: " + isbn;
    }
    
}  //fin de la clase Libro

