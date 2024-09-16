package Set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ejercicio3 {
    public static void main(String[] args) {
        //Ej3. Dada una lista de Strings, escribir una función que devuelva un Set que
        //contenga solo los Strings únicos de la lista original.
        List<String> stringsList = new ArrayList<>();
        stringsList.add("hola");
        stringsList.add("hola");
        stringsList.add("adios");
        stringsList.add("aaaa");

        Set<String> set = new HashSet<>(stringsList);
        System.out.println(set);
    }
}