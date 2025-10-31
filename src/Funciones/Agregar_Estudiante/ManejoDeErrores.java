package Funciones.Agregar_Estudiante;

import javax.swing.JOptionPane;

/**
 *
 * @author josue
 */
public class ManejoDeErrores {

    /*
    En esta clase estan todos los metodos genericos, los que hacen el trabajo de varias lineas y se invocan llamando al metodo,
    asi evito la duplicacion de codigo innecesario, todos los codigos estan dentro de un while(true), que obliga al usuario a ingresar el dato
    correcto.
     */
 /*
    El siguiente metodo ayuda a obtener un dato de numero entero (int), a este metodo se le pasa un mensajeDato, para saber que cosa es la que va a introducir
    primero se verifica la entrada con un string para evitar que el dato introducido no sea un espacio vacio
    o que se haya detenido el programa cerrando la ventana, despues maneja el error con un try-catch que se encarga de que el dato introducio sea un entero numerico,
    al final regresa el entero despues de haber verificado los errores posibles de entrada.
     */
    public static int obtenerEntero(String mensajeDato) {
        String mensajeReturn = "Operacion cancelada";

        do {
            String datoString = JOptionPane.showInputDialog("Ingresa " + mensajeDato);

            if (datoString == null) {
                JOptionPane.showMessageDialog(null, mensajeReturn);
                return -1;
            } else if (datoString.trim().isBlank()) {
                JOptionPane.showMessageDialog(null, "No puedes dejar el campo vacio!");
            } else {

                try {
                    int numeroTemporal = Integer.parseInt(datoString);
                    return numeroTemporal;
                } catch (NumberFormatException error) {
                    JOptionPane.showMessageDialog(null, "Debes ingresar un valor numerico entero!");
                }

            }

        } while (true);

    }

    /*
    El siguiente metodo al igual que el anterior, retorna un numero entero, pero este recibe un mensajeDato, que es la "cosa" que va a introducir,
    tambien recibe lo limites, despues verifica las entradas como string, que no sea nulo o vacio, asi evitamos que quede vacio o que el codigo
    se rompa por que hayan cerrado la ventana, despues con un try-catch se maneja el posible error de que el dato introducido no sea
    un valor entero numerico, al final regresa el entero.
     */
    public static int obtenerEnteroConLimites(String mensajeDato, int limiteA, int limiteB) {
        String mensajeReturn = "Operacion cancelada";

        do {
            String datoString = JOptionPane.showInputDialog("Ingresa " + mensajeDato);

            if (datoString == null) {
                JOptionPane.showMessageDialog(null, mensajeReturn);
                return -1;
            } else if (datoString.trim().isBlank()) {
                JOptionPane.showMessageDialog(null, "No puedes dejar el campo vacio!");
            } else {

                try {
                    int numeroTemporal = Integer.parseInt(datoString);
                    if (numeroTemporal < limiteA || numeroTemporal > limiteB) {
                        JOptionPane.showMessageDialog(null, "El valor ingresado no puede ser menor que " + limiteA + " o mayor que " + limiteB);
                    } else {
                        return numeroTemporal;
                    }
                } catch (NumberFormatException error) {
                    JOptionPane.showMessageDialog(null, "Debes ingresar un valor numerico entero!");
                }

            }

        } while (true);

    }

    /*
    El siguiente metodo retorna un String despues de haber verificado todos los posibles errores de entrada,
    tambien recibe el "mensajeDato" para saber que es la "cosa" que introducira, al final devuelve el String.
     */
    public static String obtenerString(String mensajeDato) {
        String mensajeReturn = "Operacion cancelada";
        do {
            String stringTemporal = JOptionPane.showInputDialog("Ingresa " + mensajeDato);
            if (stringTemporal == null) {
                JOptionPane.showMessageDialog(null, mensajeReturn);
                return "-1";
            } else if (stringTemporal.trim().isBlank()) {
                JOptionPane.showMessageDialog(null, "No puedes dejar el campo en blanco!");
            } else {
                return stringTemporal;
            }

        } while (true);

    }

    /*
    El siguiente metodo al igual que el anterior, retorna un String despues de haber validado las entradas, la diferencia es que a este se le pueden asignar las variantes y sus
    abreviaciones de estas mismas, asi comprobara que la entrada se asemejar para ser valido, despues de comprobar, regresa el nombre de la variante a la que pertenece.
     */
    public static String obtenerStringConLimite(String abreviacionVarianteA, String varianteA, String abreviacionVarianteB, String varianteB, String mensajeDato) {
        String mensajeReturn = "Operacion cancelada";
        do {
            String StringTemporal = JOptionPane.showInputDialog("Ingresa " + mensajeDato);
            if (StringTemporal == null) {
                JOptionPane.showMessageDialog(null, mensajeReturn);
                return "-1";
            } else if (StringTemporal.trim().isBlank()) {
                JOptionPane.showMessageDialog(null, "No puedes dejar el campo en blanco!");
            } else if (!StringTemporal.equalsIgnoreCase(abreviacionVarianteA) && !StringTemporal.equalsIgnoreCase(varianteA) && !StringTemporal.equalsIgnoreCase(abreviacionVarianteB) && !StringTemporal.equalsIgnoreCase(varianteB)) {
                JOptionPane.showMessageDialog(null, "Debes elegir una opcion valida \n"
                        + "" + abreviacionVarianteA + "/" + varianteA + " " + abreviacionVarianteB + "/" + varianteB);
            } else {
                if (StringTemporal.equalsIgnoreCase(abreviacionVarianteA) || StringTemporal.equalsIgnoreCase(varianteA)) {

                    return varianteA;
                } else {

                    return varianteB;
                }
            }
        } while (true);

    }

    /*
    Este metodo corrige el nombre y devuelve el nombre corregido, por ejemplo, si ingresas "JosUe SaNCHEz", regresara "Josue Sanchez".
     */
    public static String corregirNombre(String nombre) {

        String[] nombreDividido = nombre.trim().split(" ");
        String nombreCorregido = "";
        for (String nombreAModificar : nombreDividido) {
            nombreCorregido += nombreAModificar.substring(0, 1).toUpperCase() + nombreAModificar.substring(1).toLowerCase() + " ";
        }

        return nombreCorregido.trim();
    }

    /*
    El siguiente metodo calcula el promedio del alumno, primero ingresaras  el numero de califaciones
    y despues las calificaciones, el metodo verificara todos los posibles errores empezando por los
    errores del string, como entradas vacias o cierres de ventana, eso devuelve null, despues de verificar eso, se intentara convertir a entero, y se manejara
    este error con un try-catch, si todo sale bien, regresara el promedio del alumno,

     */
    public static double promedio() {

        String mensajeReturn = "Operacion cancelada";
        String numeroDeCalificacionesString, calificacionString;
        int numeroDeCalificaciones;
        double suma = 0, contador = 0, calificacion;

        do {

            numeroDeCalificacionesString = JOptionPane.showInputDialog("Ingresa el numero de calificaciones a registrar");
            if (numeroDeCalificacionesString == null) {
                JOptionPane.showMessageDialog(null, mensajeReturn);
                return -1;
            } else if (numeroDeCalificacionesString.trim().isBlank()) {
                JOptionPane.showMessageDialog(null, "No puedes dejar este campo vacio!");
            } else {

                try {
                    numeroDeCalificaciones = Integer.parseInt(numeroDeCalificacionesString);
                    if (numeroDeCalificaciones < 1 || numeroDeCalificaciones > 10) {
                        JOptionPane.showMessageDialog(null, "Solo se pueden introducir un minimo de 1 calificacion y un maximo de 10 calificaciones");
                    } else {
                        suma = 0;
                        do {
                            calificacionString = JOptionPane.showInputDialog("Ingresa la calificacion numero " + (contador + 1));
                            if (calificacionString == null) {
                                JOptionPane.showMessageDialog(null, mensajeReturn);
                                return -1;
                            } else if (calificacionString.trim().isBlank()) {
                                JOptionPane.showMessageDialog(null, "No puedes dejar este campo vacio!");
                            } else {
                                try {
                                    calificacion = Double.parseDouble(calificacionString);
                                    if (calificacion < 1 || calificacion > 10) {
                                        JOptionPane.showMessageDialog(null, "Las calificaciones ingresadas solo pueden ser valores desde el 1 al 10!");
                                    } else {
                                        suma += calificacion;
                                        contador++;
                                    }
                                } catch (NumberFormatException error) {
                                    JOptionPane.showMessageDialog(null, "Debes ingresar un valor numerico!");
                                }
                            }

                        } while (contador < numeroDeCalificaciones);
                        return suma / numeroDeCalificaciones;

                    }
                } catch (NumberFormatException error) {
                    JOptionPane.showMessageDialog(null, "Debes ingresar un valor entero numerico");
                }

            }

        } while (true);

    }

    //Este metodo determina el estado del alumno, recibe la calificacion, a travez de eso se determina el estado.
    public static String determinarEstado(double calificacion) {
        double calificacionReal = Math.round(calificacion);

        if (calificacionReal >= 6) {
            return Estados.APROBADO.name();
        } else {
            return Estados.REPROBADO.name();
        }

    }

}
