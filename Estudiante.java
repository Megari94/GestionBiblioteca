import java.io.Serializable;

public class Estudiante extends Usuario implements Serializable{
    //Atributos
    private String legajo;
    private String carrera;
    
    //Getters y setters
    public String getLegajo() { 
        return legajo; 
    }
    
    public void setLegajo(String legajo){
        this.legajo = legajo;
    }
    
    public String getCarrera() {
        return carrera;
    }
    
    public void setCarrera(String carrera){
        this.carrera = carrera;
    }

    //Constructor vacío
    public Estudiante(){}
    
    //Constructor con parametros
    public Estudiante(String id, String nombre, String apellido, String dni, String direccion, String celular, String email, String legajo, String carrera) {
        super(id, nombre, apellido, dni, direccion, celular, email);
        this.legajo = legajo;
        this.carrera = carrera;
    }
    
    @Override
    public String toString() {
        return super.toString() + " (Legajo: " + legajo + ", Carrera: " + carrera + ")";
    }
}  // fin de la subclase Estudiante

