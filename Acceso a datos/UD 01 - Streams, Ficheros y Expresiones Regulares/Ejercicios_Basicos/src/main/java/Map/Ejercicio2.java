package Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ejercicio2 {
    public static void main(String[] args) {
        //Ej2. Dada una lista de Strings, escribir una función que devuelva un Map donde las
        //claves son los Strings únicos de la lista y los valores son el número de veces que cada
        //String aparece en la lista.

        Map<String, Integer> map = new HashMap<>();
        List<String> palabras = new ArrayList<>();
        palabras.add("hola");
        palabras.add("hola");
        palabras.add("hola");
        palabras.add("hola");
        palabras.add("palomo");
        palabras.add("adios");

        for (String i : palabras) {
            int contador = 0;
            for (String j : palabras) {
                if (i == j) {
                    contador++;
                }
            }
        }
    }
}
