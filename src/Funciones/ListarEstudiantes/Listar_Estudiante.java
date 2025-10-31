package Funciones.ListarEstudiantes;

import Funciones.Agregar_Estudiante.Estudiante;
import javax.swing.JOptionPane;

/**
 *
 * @author josue
 */
public class Listar_Estudiante {

    //Este metodo lista a los estudiante que esten registrados
    public static void listarEstudiantes() {
        String mensajeReturn = "Operacion cancelada";

        //Verificamos que la lista no este vacia.
        if (Estudiante.getEstudiantes().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay estudiantes registrados");
            //Comprobamos si la lista tiene un tamaño de 1.
        } else if (Estudiante.getEstudiantes().size() == 1) {
            //Mostramos los datos del estudiante.
            JOptionPane.showMessageDialog(null, Estudiante.getEstudiantes().get(0).obtenerDatos() + "\nIndice -> " + 0, "Datos de estudiantes", 1);
        } else {

            //Si hay mas de uno en la lista, usamos un while(true) y con ayuda de un iterador, vamos recorriendo la lista.
            int i = 0;
            while (true) {
                int opcion;

                //Si a la izquierda ya no hay elementos,mostramos lo siguiente.
                if (i - 1 < 0) {
                    opcion = JOptionPane.showOptionDialog(null, Estudiante.getEstudiantes().get(i).obtenerDatos() + "\nIndice -> " + i, "Estudiantes registrados", 0, 1, null, new Object[]{"Cerrar", "->"}, "Cerrar");

                    switch (opcion) {

                        case 0 -> {
                            JOptionPane.showMessageDialog(null, mensajeReturn);
                            return;
                        }
                        case 1 -> {
                            i++;
                        }
                        default -> {
                            JOptionPane.showMessageDialog(null, mensajeReturn);
                            return;
                        }
                    }

                    //Verificamos que hay un objeto a la derecha y a la izquierda, si lo hay, mostramos lo siguiente,
                } else if (i - 1 >= 0 && i + 1 < Estudiante.getEstudiantes().size()) {
                    opcion = JOptionPane.showOptionDialog(null, Estudiante.getEstudiantes().get(i).obtenerDatos() + "\nIndice -> " + i, "Estudiantes registrados", 0, 0, null, new Object[]{"<-", "Cerrar", "->"}, "Cerrar");

                    switch (opcion) {
                        case 0 -> {
                            i--;

                        }
                        case 1 -> {
                            JOptionPane.showMessageDialog(null, mensajeReturn);
                            return;

                        }
                        case 2 -> {
                            i++;
                        }
                        default -> {
                            JOptionPane.showMessageDialog(null, mensajeReturn);
                            return;
                        }

                    }

                } else {
                    //Al ser la ultima comprobacion, por descarte solo quedaria que a la derecha ya no haya elementos.
                    opcion = JOptionPane.showOptionDialog(null, Estudiante.getEstudiantes().get(i).obtenerDatos() + "\nIndice -> " + i, "Estudiantes registrados", 0, 0, null, new Object[]{"<-", "Cerrar"}, "Cerrar");

                    switch (opcion) {

                        case 0 -> {
                            i--;
                        }
                        case 1 -> {
                            JOptionPane.showMessageDialog(null, mensajeReturn);
                            return;
                        }
                        default -> {
                            JOptionPane.showMessageDialog(null, mensajeReturn);
                            return;
                        }

                    }

                }

            }

        }

    }

}
