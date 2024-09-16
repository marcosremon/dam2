package Map;

import java.util.HashMap;
import java.util.Map;

public class Ejercicio1 {
    public static void main(String[] args) {
        //Ej1. Crear un Map que asocie nombres de países con sus capitales. Luego, imprimir
        //todos los pares de clave-valor del Map.

        Map<String, String> paisesCapitales = new HashMap<>();
        paisesCapitales.put("España", "Madrid");
        paisesCapitales.put("Francia", "Paris");
        paisesCapitales.put("Alemania", "Berlin");

        System.out.println(paisesCapitales);
    }
}
