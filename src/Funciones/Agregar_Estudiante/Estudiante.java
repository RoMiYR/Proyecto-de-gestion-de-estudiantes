package Funciones.Agregar_Estudiante;

import java.util.ArrayList;

/**
 *
 * @author josue
 */
public class Estudiante {

    //Creamos un ArrayList que guarde solo objetos de la clase "Estudiante" y lo hacemos privado y estatico,
    //para poder usar el mismo ArrayList en todas las clases y no tener problemas por crear uno nuevo con una direccion diferente y que
    //esto genere errores..
    private static ArrayList<Estudiante> estudiantes = new ArrayList<>();

    //Declaramos sus atributos
    private int id;
    private String nombre;
    private int edad;
    private String genero;
    String estado;
    double promedio;

    //Declaramos un constructor vacio por buena practica.
    public Estudiante() {

    }

    //Declaramos el constructor que vamos a usar para crear los objetos de manera directa y sin usar tanto codigo.
    public Estudiante(int id, String nombre, int edad, String genero, String estado, double promedio) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
        this.estado = estado;
        this.promedio = promedio;
    }

    //Declaramos los metodos.
    public String obtenerDatos() {
        String datos = "Los siguientes datos corresponden al alumno " + nombre + "\n"
                + "Id -> " + id + "\n"
                + "Edad -> " + edad + "\n"
                + "Genero -> " + genero + "\n"
                + "Estado -> " + estado;
        return datos;
    }

    //Este metodo es uno de los mas importantes, ya que permite el acceso a el ArrayList original.
    public static ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public static void setEstudiantes(ArrayList<Estudiante> estudiantes) {
        Estudiante.estudiantes = estudiantes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

}
