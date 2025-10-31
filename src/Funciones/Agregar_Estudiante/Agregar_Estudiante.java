package Funciones.Agregar_Estudiante;

import javax.swing.JOptionPane;

/**
 *
 * @author josue
 */
//Este metodo permite agregar estudiantes.
public class Agregar_Estudiante {

    public static void agregarEstudiante() {

        //Obtenemos el id del estudiante con un metodo de la clase "ManejoDeErrores".
        int idTemporal = ManejoDeErrores.obtenerEntero("la id del estudiante");
        //Verificamos que no se haya cancelado la operacion con el siguiente if que verifica el return.
        if (idTemporal == -1) {
            return;
        }

        //Obtenemos el nombre del estudiante con un metodo de la clase "ManejoDeErrores".
        String nombreTemporal = ManejoDeErrores.obtenerString("nombre del alumno");
        //Verificamos que no se haya cancelado la operacion con el siguiente if que verifica el return.
        if (nombreTemporal.equals("-1")) {
            return;
        }
        //Convertimos la primera letra del nombre en mayuscula.
        nombreTemporal = ManejoDeErrores.corregirNombre(nombreTemporal);

        //Obtenemos la edad del estudiante con un metodo de la clase "ManejoDeErrores".
        int edadTemporal = ManejoDeErrores.obtenerEnteroConLimites("la edad del estudiante", 12, 30);
        //Verificamos que no se haya cancelado la operacion con el siguiente if que verifica el return.
        if (edadTemporal == -1) {
            return;
        }
        //Obtenemos el genero del estudiante con un metodo de la clase "ManejoDeErrores".
        String generoTemporal = ManejoDeErrores.obtenerStringConLimite("M", "Masculino", "F", "Femenino", "el genero del alumno");
        //Verificamos que no se haya cancelado la operacion con el siguiente if que verifica el return.
        if (generoTemporal.equals("-1")) {
            return;
        }

        //Obtenemos el promedio del alumno con un metodo de la clase "ManejoDeErrores".
        double promedioTemporal = ManejoDeErrores.promedio();

        //Obtenemos el estado del estudiante con un metodo de la clase "ManejoDeErrores".
        String estadoTemporal = ManejoDeErrores.determinarEstado(promedioTemporal);

        //Creamos un objeto de la clase Estudiante y la agregamos al arrayList.
        Estudiante nuevoEstudiante = new Estudiante(idTemporal, nombreTemporal, edadTemporal, generoTemporal, estadoTemporal, promedioTemporal);
        Estudiante.getEstudiantes().add(nuevoEstudiante);

        //Mostramos el estado con el cual fue registrado el alumno (APROBADO, REPROBADO).
        JOptionPane.showMessageDialog(null, "El estado del alumno fue " + estadoTemporal);

    }

}
