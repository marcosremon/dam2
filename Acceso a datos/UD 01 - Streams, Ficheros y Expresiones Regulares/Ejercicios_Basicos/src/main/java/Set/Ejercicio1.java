package Set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Ejercicio1 {
    public static void main(String[] args) {
        //Ej1. Crear un Set de Strings y añadir elementos a él. Luego, imprimir todos los
        //elementos del Set. ¿Qué observas acerca del orden de los elementos?

        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("a");
        set.add("b");
        System.out.println(set);
    }
}