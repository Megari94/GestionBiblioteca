import java.io.Serializable;

public class Bibliotecario extends Usuario implements Serializable {
    //Atributos
    private String turno;

    // Getters y setters
    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    // Constructor vacío
    public Bibliotecario() {
    }

    // Constructor con parámetros
    public Bibliotecario(String id, String nombre, String apellido, String dni, String direccion, String celular, String email, String turno) {
        super(id, nombre, apellido, dni, direccion, celular, email);
        this.turno = turno;
    }
    
    
    @Override
    public String toString() {
        return super.toString() + " Turno: " + turno;
    }

}  //fin de la subclase Bibliotecario
