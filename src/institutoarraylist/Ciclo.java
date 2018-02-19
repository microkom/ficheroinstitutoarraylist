package institutoarraylist;

import java.util.ArrayList;

/**
 * Nombre. Horas: horas de clase del ciclo Alumnos: Listado de alumnos que se
 * han matriculado al ciclo. (Es aconsejable utilizar un arrayList).
 */
public class Ciclo {

    private String nombreCiclo;
    private int horas;
    private ArrayList<Alumno> nombreAlumno = new ArrayList<Alumno>();

    public Ciclo(String nombre, int horas) {
        this.nombreCiclo = nombre;
        this.horas = horas;
    }

    public Ciclo(String nombre) {
        this.nombreCiclo = nombre;
    }

    //getters
    public String getNombre() {
        return this.nombreCiclo;
    }

    public int getHoras() {
        return this.horas;
    }

    public ArrayList<Alumno> getAlumno() {
        return this.nombreAlumno;
    }

    //setters
    public void setNombre(String nombre) {
        this.nombreCiclo = nombre;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public void setNombreAlumno(ArrayList<Alumno> alumno) {
        this.nombreAlumno = alumno;
    }

    //Alumno con nota máxima de todo el ciclo
    public Alumno personaNotaMaxima() {

        Alumno max = this.nombreAlumno.get(0);
        for (Alumno obj : nombreAlumno) {
            if (obj.notaMedia() > max.notaMedia()) {
                max = obj;
            }
        }
        return max;
    }
    
    //Alumno con nota mínima de todo el ciclo
    public Alumno personaNotaMinima() {
        
        Alumno min = this.nombreAlumno.get(0);
        for (Alumno obj : nombreAlumno) {
            if (obj.notaMedia() < min.notaMedia()) {
                min = obj;
            }
        }
        return min;
    }

    //porcentaje de alumnos aprobados en todo el ciclo
    public float porcentajeAprobadosCiclo() {

        int contUp = 0, contDown = 0;

        for (Alumno pupil : nombreAlumno) {
            if (pupil.todosModulosAprobados()) {
                contUp++;
            } else {
                contDown++;
            }
        }
        return ((float) (100 / (contDown + contUp) * contUp));

    }

    //informacion de todo el ciclo
    public String imprimirTodo(){
        String texto="";
        for (Alumno pupil: nombreAlumno){
            texto+=pupil.toString();
        }
        return texto;
    }
    
    public String toString() {
        return "\tCiclo: " + this.nombreCiclo;
    }
}
