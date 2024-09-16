package Set;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ejercicio2 {
    public static void main(String[] args) {
        //Ej2. Dada una lista de números enteros, escribir una función que devuelva un Set
        //que contenga solo los números únicos de la lista original.
        List<Integer> numerosList = new ArrayList<>();
        numerosList.add(1);
        numerosList.add(1);
        numerosList.add(2);
        numerosList.add(3);

        Set<Integer> set = new HashSet<>(numerosList);
        System.out.println(set);
    }
}