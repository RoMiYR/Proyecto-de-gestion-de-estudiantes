package Funciones.EliminarEstudiante;

import Funciones.Agregar_Estudiante.Estudiante;
import Funciones.Agregar_Estudiante.ManejoDeErrores;
import javax.swing.JOptionPane;

/**
 *
 * @author josue
 */
//Este metodo elimina a un estudiante seleccionado.
public class EliminarEstudiante {

    public static void eliminarEstudiante() {

        //Verificamos que la lista no este vacia.
        if (Estudiante.getEstudiantes().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Aun no hay alumnos registrados");
            //Si en la lista solo hay un alumno, entonces solo mostramos las opciones de ese alumno.
        } else if (Estudiante.getEstudiantes().size() == 1) {

            while (true) {
                int opcionElegida = JOptionPane.showOptionDialog(null, "Deseas eliminar al alumno " + Estudiante.getEstudiantes().get(0).getNombre() + "?", "Eliminacion de estudiante", 1, 1, null, new Object[]{"Si", "No", "Datos"}, "Si");

                switch (opcionElegida) {
                    case 0 -> {
                        Estudiante.getEstudiantes().remove(0);
                        JOptionPane.showMessageDialog(null, "Alumno eliminado con exito");
                        return;
                    }
                    case 2 -> {
                        JOptionPane.showMessageDialog(null, Estudiante.getEstudiantes().get(0).obtenerDatos(), "Datos", 1);
                    }
                    default -> {
                        JOptionPane.showMessageDialog(null, "Operacion cancelada");
                        return;
                    }
                }

            }

            //Si hay mas de un alumno, entonces le pedimos al usuario el indice del alumno que quiera eliminar, verificamos que no exceda los limites.
        } else {

            while (true) {
                //Pedimos el indice del alumno a eliminar.
                int indiceElegido = ManejoDeErrores.obtenerEnteroConLimites("indice del alumno a eliminar", 0, Estudiante.getEstudiantes().size() - 1);
                if (indiceElegido == -1) {
                    return;
                }
                int opcionElegida = JOptionPane.showOptionDialog(null, "Deseas eliminar al alumno " + Estudiante.getEstudiantes().get(indiceElegido).getNombre() + "?", "Eliminacion de estudiante", 1, 1, null, new Object[]{"Si", "No", "Datos"}, "Si");
                switch (opcionElegida) {
                    case 0 -> {
                        Estudiante.getEstudiantes().remove(indiceElegido);
                        JOptionPane.showMessageDialog(null, "Alumno eliminado con exito");
                        return;

                    }
                    case 2 -> {
                        JOptionPane.showMessageDialog(null, Estudiante.getEstudiantes().get(indiceElegido).obtenerDatos(), "Datos", 1);
                    }
                    default -> {
                        JOptionPane.showMessageDialog(null, "Operacion cancelada");
                        return;
                    }

                }

            }

        }

    }

}
