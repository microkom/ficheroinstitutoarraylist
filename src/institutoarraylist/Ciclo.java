package institutoarraylist;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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
    public String imprimirTodo() {
        File dir = new File(this.nombreCiclo);

        // if the directory does not exist, create it
        if (dir.exists()) {
            try {
                String[] entries = dir.list();
                for (String s : entries) {
                    File currentFile = new File(dir.getPath(), s);
                    System.out.println(currentFile.getName());
                    currentFile.delete();
                }
            } catch (SecurityException se) {
                System.out.println(se.getMessage());
            }
        }else{
            try {
                dir.mkdir();
            } catch (SecurityException se) {
                System.out.println(se.getMessage());
            }
        }

        String textoFichero = "", textoPantalla = "";
        
        
        for (Alumno pupil : nombreAlumno) {
            File fileName = new File(dir.getName(), pupil.getNombre() + ".txt");
            textoPantalla += pupil.toString();
            textoFichero = pupil.toString();
            WriteFile(fileName, textoFichero);
        }
        return textoPantalla;

    }

    public String toString() {
        return "\tCiclo: " + this.nombreCiclo;
    }

    public static void WriteFile(File fileName, String texto) {
        //This method reads from one file and then writes its
        //content into another one without wiping its original content

        //necesario para crear un objeto del mismo tipo
        //File fileWritten = null;
        FileWriter fileToWrite = null;
        BufferedWriter bufferWillWrite = null;

        try {
            //creacion de estructura de escritura
            //fileWritten = new File(fileName);
            fileToWrite = new FileWriter(fileName); //true: permite agregar info sin borrar el archivo

            bufferWillWrite = new BufferedWriter(fileToWrite);
            try {
                bufferWillWrite.write(texto + "\n");

            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                try {
                    if (fileToWrite != null) {
                        bufferWillWrite.close();
                    }
                } catch (Exception er) {
                    System.out.println(er.getMessage());
                }
            }
        } catch (Exception err) {
            System.out.println(err.getMessage());
        } finally {

        }
    }

}
