
import Generador.GeneradordeDatos;
import model.Instituto;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println();
        // Este map esta compuesto por el id del instituto y el instituto.
        Map<Integer, Instituto> mapadeInstitutos = new HashMap<>(GeneradordeDatos.listaInstitutos.get());
        //  Inicio ----->
        mapadeInstitutos.entrySet().forEach(System.out::println);

    }
}
