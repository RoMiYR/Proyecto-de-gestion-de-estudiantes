package Main;

import Menu_Principal.Menu_Principal;

/**
 *
 * @author josue
 */
public class Main {

    public static void main(String[] args) {
        
        /*
        Este programa es un registro de alumnos, actualmente no manejo base de datos, por lo que mi programa no tiene la capacidad de guardar datos despues de cerrarlo
        durante el proceso de creacion de este programa tuve que aprender a usar el try-catch para poder manejar errores y los ArrayList para hacer el programa un poco
        mas dinamico.
        */

        //Invocamos el metodo principal para iniciar el programa, al ser estatico, no necesitamos crear un objeto de la clase que contiene el metodo.
        Menu_Principal.menuPrincipal();

    }
}
