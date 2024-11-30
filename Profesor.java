import java.io.Serializable;

public class Profesor extends Usuario implements Serializable{
    //Atributo
    private String materia;

    //Getter y setter
    public String getMateria() { 
        return materia; 
    }
    
    public void setMateria(String materia){
        this.materia = materia;
    }
    
    //constructor vacío
    public Profesor(){
        
    }
    
    //constructor
    public Profesor(String id, String nombre, String apellido, String dni, String direccion, String celular, String email, String materia) {
        super(id, nombre, apellido, dni, direccion, celular, email);
        this.materia = materia;
    }

    @Override
    public String toString() {
        return super.toString() + " (Materia: " + materia + ")";
    }
    
}  //fin de la subclase Profesor
