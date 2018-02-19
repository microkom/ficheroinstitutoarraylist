/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package institutoarraylist;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Dni. Nombre; Fecha de nacimiento. Notas: Se almacena información del listado
 * de notas de un alumno
 */
public class Alumno extends Persona {

    private ArrayList<Nota> arrayNotas = new ArrayList<Nota>();

    public Alumno(String dni, String nombre, Fecha fechaNac) {
        super(dni, nombre, fechaNac);
    }

    public ArrayList<Nota> getArrayNotas() {
        return this.arrayNotas;
    }

    public void setarrayNotas(ArrayList<Nota> notas) {
        this.arrayNotas = notas;
    }

    public void addPupil(Nota moduloMasNota) {
        boolean encontrado = false;
        try {
            if (moduloMasNota.getNota() < 0 || moduloMasNota.getNota() > 10) {
                //Si la nota no es correcta se pone como -1
                moduloMasNota.setNota((float) -1);
                this.arrayNotas.add(moduloMasNota);
                String nombre = moduloMasNota.getNombre().getNombreModulo();
                Error error1 = new Error("\tNota menor que 1 o mayor que 10 en el modulo " + nombre);
                throw error1;
            } else {
                try {
                    Iterator<Nota> iterator = arrayNotas.iterator();
                    Nota notas = null;

                    int i = 0;
                    while (iterator.hasNext() && (!(encontrado))) {
                        notas = iterator.next();

                        if ((notas.getNombre().getNombreModulo().equalsIgnoreCase(moduloMasNota.getNombre().getNombreModulo()))) {
                            encontrado = true;
                            String nombred = moduloMasNota.getNombre().getNombreModulo();
                            Error error2 = new Error("\tEl modulo  " + nombred + " ya Existe");
                            throw error2;
                        }
                    }
                    if (!(encontrado)) {
                        this.arrayNotas.add(moduloMasNota);
                    }
                } catch (Error error2) {
                    System.out.printf(error2.getMessage());
                }
            }
        } catch (Error error1) {

            System.out.printf(error1.getMessage());
        }
    }

//comprobacion por alumno: todos los módulos están aprobados?
    public boolean todosModulosAprobados() {
        boolean todos = true;

        Iterator<Nota> it = this.arrayNotas.iterator();
        Nota obj = null;
        while (it.hasNext() && (todos)) {
            obj = it.next();
            if (obj.getNota() < 5) {
                todos = false;
            }
        }
        return todos;
    }

    //nota media por alumno
    public float notaMedia() {
        float med = 0;

        for (Nota nota : this.arrayNotas) {
            med += nota.getNota();
        }
        return med / this.arrayNotas.size();
    }

    //menor de edad
    public String menorDeEdad() {
        String texto = "";
        texto += "\n" + super.toString();
        if (super.getFechaNac().mayorDe(18)) {
            texto += "| Es mayor de edad   |\n";
        } else {
            texto += "| Es menor de edad   |\n";
        }
        return texto;
    }

    public String toString() {
         final String ROJO="\033[31;1m";
        //linea de la tabla
        String linea = "\t+" + hy(61, "-") + "+";

        //linea separadora de alumnos
        String texto = "";

        //Es mayor de eadad?
        texto += menorDeEdad();

        //información de los módulos y el alumno
        texto += linea + "\n\t| Modulo                 | Ciclo   | Profesor      | Nota     |\n" + linea;
        //nota y nota media
        float med = 0;

        for (Nota nota : this.arrayNotas) {
            //notas de cada módulo
            texto += "\n\t" + nota.toString();

            med += nota.getNota();
        }
        //cálculo de la nota media
        float notaMedia = (float) med / this.arrayNotas.size();

        //linea
        String leftAlignFormat = "\t| %-20s     %-2.2f %-29s |";

        texto += "\n\t+" + hy(61, "-") + "+";
        //dar formato a un valor en medio de una concatenació
        String textoAux = String.format(leftAlignFormat, "Nota media alumno: ", notaMedia, " ");
        texto += "\n" + textoAux + "\n";
        texto += "\t+" + hy(61, "-") + "+\n";
        return texto;
    }

    //metodo estático para crear una linea de guiones
    public static String hy(int cant, String caracter) {
        String hyphen = "";
        for (int i = 0; i < cant; i++) {
            hyphen += caracter;
        }
        return hyphen;
    }
}
