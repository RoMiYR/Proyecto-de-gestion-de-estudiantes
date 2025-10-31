package Funciones.BuscarEstudiantePorNombre;

import Funciones.Agregar_Estudiante.Estudiante;
import Funciones.Agregar_Estudiante.ManejoDeErrores;
import javax.swing.JOptionPane;

/**
 *
 * @author josue
 */
public class BuscarEstudiantePorNombre {

    //Este metodo busca a un estudiante segun el nombre o prefijo que eligas, esta dentro de un while(true), para que no se detenga a menor que lo eligas o cierres la ventana.
    public static void buscarEstudiante() {

        //Primero verificamos que haya al menos un estudiante, si lo hay, verificamos que sea mas de 1.
        if (Estudiante.getEstudiantes().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Aun no hay alumnos registrados!");
            return;
        } else if (Estudiante.getEstudiantes().size() == 1) {
            JOptionPane.showMessageDialog(null, "Actualmente solo hay un alumno registrado, no se puede realizar la busqueda!");
            return;
        }

        while (true) {
            //Solicitamos el String que sera el nombre o prefijo con un metodo de la clase "ManejoDeErrores", con el que buscaremos coincidencias en el ArrayList.
            String nombreABuscar = ManejoDeErrores.obtenerString("el nombre del alumno a buscar");
            //verificamos que no se haya cerrado la ventana.
            if (nombreABuscar.equals("-1")) {
                return;
            } else {

                //Usamos un StringBuilder para crear un nuevo String que contenga tanto el indice entre corchetes [indice], y el nombre.
                StringBuilder indicesSimilaresSB = new StringBuilder();
                for (int i = 0; i < Estudiante.getEstudiantes().size(); i++) {
                    if (Estudiante.getEstudiantes().get(i).getNombre().equalsIgnoreCase(nombreABuscar)) {
                        indicesSimilaresSB.append(i).append(" ");
                    }
                }

                //Verificamos si el StringBuilder esta vacio, lo que quiere decir que no hay alumnos con ese nombre o prefijo.
                if (indicesSimilaresSB.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No hay alumnos registrados con el nombre " + nombreABuscar);
                } else {

                    //Separamos el string en una matriz.
                    String indicesSimilaresString = indicesSimilaresSB.toString().trim();
                    String[] indicesSeparados = indicesSimilaresString.split(" ");
                    int[] indiceSeleccionado = new int[indicesSeparados.length];
                    String mensaje = "";

                    //Convertimos los indices a entero;
                    for (int i = 0; i < indicesSeparados.length; i++) {
                        indiceSeleccionado[i] = Integer.parseInt(indicesSeparados[i]);
                        mensaje += "[" + i + "] " + Estudiante.getEstudiantes().get(i).getNombre() + "\n";
                    }

                    //Mostramos a los alumnos que coincidieron con el nombre o prefijo.
                    JOptionPane.showMessageDialog(null, "A continuacion se te mostraran los resultados mas cercanos a " + nombreABuscar);
                    while (true) {
                        int IndiceSeleccionado = ManejoDeErrores.obtenerEnteroConLimites("el indice del alumno al que deseas acceder\n" + mensaje, 0, indiceSeleccionado.length - 1);
                        if (IndiceSeleccionado == -1) {
                            return;
                        } else {

                            //Dentro de un while(true) obtenemos la accion que desea realizar con un OptionDialog, y en el switch realizamos la accion correspondiente.
                            while (true) {

                                int opcionElegidaInterna = JOptionPane.showOptionDialog(null, "Que deseas hacer con este alumno", "Opciones", 1, 1, null, new Object[]{"Eliminar", "Obtener datos", "Volver"}, "Eliminar");

                                switch (opcionElegidaInterna) {
                                    case 0 -> {
                                        Estudiante.getEstudiantes().remove(IndiceSeleccionado);
                                        JOptionPane.showMessageDialog(null, "Alumno eliminado con exito");
                                    }
                                    case 1 -> {
                                        JOptionPane.showMessageDialog(null, Estudiante.getEstudiantes().get(IndiceSeleccionado).obtenerDatos());
                                    }
                                    default -> {
                                        JOptionPane.showMessageDialog(null, "Operacion Cancelada");
                                        return;
                                    }

                                }

                            }

                        }

                    }

                }

            }

        }

    }

}
