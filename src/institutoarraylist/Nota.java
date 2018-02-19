/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package institutoarraylist;

/**
 * Modulo. 
 * Nota obtenida
 */
public class Nota {

    private Modulo modulo;
    private float nota;

    public Nota(Modulo nombre, float nota) {
        this.modulo = nombre;
        this.nota = nota;
    }

    public Nota(Modulo nombre) {
        this.modulo = nombre;
        this.nota = 0;
    }

    public Modulo getNombre() {
        return this.modulo;
    }

    public float getNota() {
        return this.nota;
    }
    
    
    
    public void setNombre(Modulo nombre) {
        this.modulo = nombre;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }
    
    //Impresion de las notas por modulo
    public String toString() {
        String texto = "";
         String leftAlignFormat = " %-6s |  ";
        texto =  this.modulo.toString() ;
        texto+= String.format(leftAlignFormat,this.nota);
        return texto;
    }
}
