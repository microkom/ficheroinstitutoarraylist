/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package institutoarraylist;

import static institutoarraylist.Alumno.hy;

/**
 *
 * @author DAW
 */
public class Persona {

    private String dni;
    private String nombre;
    private Fecha fechaNac;

    //constructor
    public Persona(String dni, String nombre, Fecha fechaNac) {
        this.dni = dni;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
    }

    //getters
    public String getDni() {
        return this.dni;
    }

    public String getNombre() {
        return this.nombre;
    }

    public Fecha getFechaNac() {
        return this.fechaNac;
    }

    //setters
    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaNac(Fecha fechaNac) {
        this.fechaNac = fechaNac;
    }
    
  
    public String toString() {
        String texto = "";
        texto += "\n\t+" + hy(61,"-")+"+\n";
        texto += "\t|  DNI: " + this.dni ;
        texto+="\t|  Nombre: "+this.nombre +"\t ";
        
        return texto;
    }
}
