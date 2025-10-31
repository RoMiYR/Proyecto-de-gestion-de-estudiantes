package Funciones.CalcularPromedioGeneral;

import Funciones.Agregar_Estudiante.Estudiante;
import javax.swing.JOptionPane;

/**
 *
 * @author josue
 */
public class Calcular_Promedio_General {

    //Este metodo calcula el promedio general, verifica que la lista no este vacia, si no lo esta, realiza la operacion y muestra un mensaje con el promedio general.
    public static void calcularPromedioGeneral() {

        double suma = 0;

        if (Estudiante.getEstudiantes().size() == 0) {
            JOptionPane.showMessageDialog(null, "No hay alumnos registrados para hacer el calculo");
            return;
        } else {
            for (int i = 0; i < Estudiante.getEstudiantes().size(); i++) {
                suma += Estudiante.getEstudiantes().get(i).getPromedio();
            }
            JOptionPane.showMessageDialog(null, "El promedio general es de " + (suma / Estudiante.getEstudiantes().size()));

        }

    }

}
