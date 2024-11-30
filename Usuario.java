
//Clase padre abstracta Usuario 
public abstract class Usuario {
    //Atributos
    protected String id;
    protected String nombre;
    protected String apellido;
    protected String dni;
    protected String direccion;
    protected String celular;
    protected String email;

    // Métodos getter y setter
    public String getId() { 
        return id; 
    }
    
    public void setId(String id) {
        this.id = id; 
    }
    
    public String getNombre() { 
        return nombre; 
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre; 
    }
    
    public String getApellido() { 
        return apellido; 
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public String getDni() { 
        return dni; 
    }
    
    public void setDni(String dni) { 
        this.dni = dni;
    }
    
    public String getDireccion() { 
        return direccion; 
    }
    
    public void setDireccion(String direccion) { 
        this.direccion = direccion; 
    }
    
    public String getCelular() {
        return celular; 
    }
    
    public void setCelular(String celular) { 
        this.celular = celular; 
    }
    
    public String getEmail() { 
        return email; 
    } 
    
    public void setEmail(String email) {
        this.email = email;
    }
    
        //Constructor vacío
    public Usuario(){}

    // Constructor
    public Usuario(String id, String nombre, String apellido, String dni, String direccion, String celular, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.direccion = direccion;
        this.celular = celular;
        this.email = email;
    }
    
    @Override
    public String toString() {
        return nombre + " , " + apellido + " , ID: " + id;
    }
    
} //fin clase Usuario
