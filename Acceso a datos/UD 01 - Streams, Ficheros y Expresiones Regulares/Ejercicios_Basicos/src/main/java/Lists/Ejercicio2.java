package Lists;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio2 {
    public static void main(String[] args) {
        //Ej2. Dada una lista de números enteros, escribir una función que devuelva una nueva
        //lista que contenga solo los números pares de la lista original.

        List<Integer> listaInts = new ArrayList<>();
        List<Integer> listaPares = new ArrayList<>();
        listaInts.add(1);
        listaInts.add(2);
        listaInts.add(3);
        listaInts.add(4);
        for (int i : listaInts) {
            if (i % 2 == 0) {
                listaPares.add(i);
            }
        }
        System.out.println(listaPares);
    }
}