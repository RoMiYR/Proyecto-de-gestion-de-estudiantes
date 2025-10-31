package Menu_Principal;

import Funciones.Agregar_Estudiante.Agregar_Estudiante;
import Funciones.BuscarEstudiantePorNombre.BuscarEstudiantePorNombre;
import Funciones.CalcularPromedioGeneral.Calcular_Promedio_General;
import Funciones.EliminarEstudiante.EliminarEstudiante;
import Funciones.ListarEstudiantes.Listar_Estudiante;
import javax.swing.JOptionPane;

/**
 *
 * @author josue
 */
public class Menu_Principal {

    //Esta clase es la clase principal, la que se encarga de manejar el codigo con el metodo que hay dentro de ella.
    public static void menuPrincipal() {

        String opcionString;
        int opcionEntero;

        //Creamos un bucle que no se detenga hasta que se ingrese el valor 0 en el menu de opciones o se cierre directamente en el JOptionPane.showInputDialog().
        do {

            //Mostramos el menu de opciones.
            opcionString = JOptionPane.showInputDialog(null, """
                                                             Eliga una de las siguientes opciones
                                                             1 -> Agregar Estudiante
                                                             2 -> Listar Estudiantes
                                                             3 -> Eliminar Estudiante
                                                             4 -> Buscar estudiante por nombre
                                                             5 -> Calcular promedio general
                                                             6 -> Salir del programa""", "Menu Principal", 1);

            //Verificamos que no se haya cancelado la operacion.
            if (opcionString == null) {
                JOptionPane.showMessageDialog(null, "Cerrando programa...");
                return;
                //Verificamos que no haya dejado en blanco el campo.
            } else if (opcionString.trim().isBlank()) {
                JOptionPane.showMessageDialog(null, "Debes elegir una opcion!");
            } else {

                //Verificamos que se haya ingresado un valor entero numerico y no una letra o cadena de caracteres.
                try {
                    //Intentamos convetir, si se logra, entra al switch.
                    opcionEntero = Integer.parseInt(opcionString);

                    //Aqui se invoca el metodo correspondiente a la opcion elegida.
                    switch (opcionEntero) {
                        case 1 -> {
                            Agregar_Estudiante.agregarEstudiante();
                        }
                        case 2 -> {
                            Listar_Estudiante.listarEstudiantes();
                        }
                        case 3 -> {
                            EliminarEstudiante.eliminarEstudiante();
                        }
                        case 4 -> {
                            BuscarEstudiantePorNombre.buscarEstudiante();
                        }
                        case 5 -> {
                            Calcular_Promedio_General.calcularPromedioGeneral();
                        }
                        case 6 -> {
                            //Si la opcion elegida es la de salir, mostramos un mensjae y cerramos el programa.
                            JOptionPane.showMessageDialog(null, "Cerrando programa, que tenga un buen dia!");
                            return;

                        }
                        default -> {
                            //Si la opcion elegida no existe, mostramos un mensaje.
                            JOptionPane.showMessageDialog(null, "Debes elegir una opcion valida!");
                        }

                    }
                } catch (NumberFormatException error) {
                    //Mostramos mensaje de error en caso de que se haya ingresado un dato no numerico.
                    JOptionPane.showMessageDialog(null, "Debes ingresar un valor entero numerico!");
                }

            }

        } while (true);

    }

}
