/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package institutoarraylist;

/**
 * Nombre. 
 * Horas: horas de clase del módulo. 
 * Ciclo al que pertenece. 
 * Profesor que imparte el módulo.
 */
public class Modulo {
    
    private String nombreModulo;
    private int horas;
    private Ciclo nombreCiclo;
    private Profesor nombreProfesor;

    public Modulo(String nombreModulo, int horas, Ciclo nombreCiclo, Profesor nombreProfesor) {
        this.nombreModulo=nombreModulo;
        this.horas=horas;
        this.nombreCiclo = nombreCiclo;
        this.nombreProfesor = nombreProfesor;
    }

    //getters
    public String getNombreModulo(){
        return this.nombreModulo;
    }
    public int getHoras(){
        return this.horas;
    }
    
    public Ciclo getNombreCiclo() {
        return this.nombreCiclo;
    }

    public Profesor getNombreProfesor() {
        return this.nombreProfesor;
    }

    //setters
    public void setNombreModulo(String nombreModulo){
        this.nombreModulo=nombreModulo;
    }
    
    public void setHoras(int horas){
        this.horas=horas;
    }
    
    public void setNombreCiclo(Ciclo nombreCiclo) {
        this.nombreCiclo = nombreCiclo;
    }

    public void setNombreProfesor(Profesor nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }

    public String toString() {
        String texto = "";
        
        String leftAlignFormat = "| %-22s |  %-6s |  %-12s |  ";
        
        texto+=String.format(leftAlignFormat,this.nombreModulo, this.nombreCiclo.getNombre() ,this.nombreProfesor.getNombre() );
        return texto;
    }   
}
