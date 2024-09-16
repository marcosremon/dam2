package Lists;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio3 {
    public static void main(String[] args) {
        //Ej3. Dada una lista de Strings, escribir una función que devuelva la longitud del
        //string más largo en la lista.

        List<String> listaStr = new ArrayList<>();
        listaStr.add("hola");
        listaStr.add("mercadona");
        listaStr.add("mundo");
        devolverPalabraMasLarga(listaStr);
    }

    private static void devolverPalabraMasLarga(List<String> listaStr) {
        int elMasGrande = 0;
        String palabraMasLarga = null;
        for (String i : listaStr) {
            int contador = 0;
            for (char j : i.toCharArray()) {
                contador++;
                if (contador > elMasGrande) {
                    elMasGrande = contador;
                    palabraMasLarga = i;
                }
            }
        }
        System.out.println("la palabra mas larga es: " + palabraMasLarga + " y tiene " + elMasGrande + " letras");
    }
}