package institutoarraylist;

/**
 * De los profesores se almacena la siguiente información: 
 * Dni.
 * Nombre;
 * Fecha de nacimiento. 
 * Titulación. 
 * Emai
 */
public class Profesor extends Persona {

    private String titulacion;
    private String email;
    
    //constructor completo
    public Profesor(String dni, String nombre, Fecha fechaNac, String titulacion, String email) {
        super(dni, nombre, fechaNac);
        this.titulacion = titulacion;
        this.email = email;
    }
    
    //constructor sin email
    public Profesor(String dni, String nombre, Fecha fechaNac, String titulacion) {
        super(dni, nombre, fechaNac);
        this.titulacion = titulacion;
    }

    //getters
    public String getNombreProfesor(){
        return super.getNombre();
    }
    
    public String getTitulacion() {
        return this.titulacion;
    }

    public String getEmail() {
        return this.email;
    }
    
    //setters
    public void setTitulacion(String titulacion){
        this.titulacion=titulacion;
    }
    
    public void setEmail(){
        this.email=email;
    }
    
    
    public String toString() {
        String texto = super.toString();
        texto += "\tTitulación: " + this.titulacion + "\n"
                + "\tEmail: " + this.email + "\n";
        return texto;
    }
}
