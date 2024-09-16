package Lists;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio1 {
    public static void main(String[] args) {
        //Ej1. Crear una lista de Strings y añadir elementos a ella. Luego, imprimir todos los
        //elementos de la lista usando un bucle for-each.

        List<String> listaStrings = new ArrayList<>();
        listaStrings.add("hola");
        listaStrings.add("puto");
        listaStrings.add("mundo");
        for (String i : listaStrings) {
            System.out.println(i);
        }
    }
}