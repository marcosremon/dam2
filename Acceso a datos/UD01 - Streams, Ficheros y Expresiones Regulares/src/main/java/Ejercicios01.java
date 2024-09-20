import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Ejercicios01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("¿que ejercicio quieres ejecutar? ");
        int ejercicio = scanner.nextInt();

        switch (ejercicio) {
            case 1:
                ej1();
                break;
            case 2:
                ej2();
                break;
            case 3:
                ej3();
                break;
            case 4:
                ej4();
                break;
            case 5:
                ej5();
                break;
            case 6:
                ej6();
                break;
            default:
                System.out.println("introdujiste un ejercicio que no esta disponible");
                break;
        }
        scanner.close();
    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej1() {
        //Ej1. Filtrar números impares: Crea una lista de números enteros. Utiliza un “Predicate”
        //para filtrar la lista y eliminar todos los números impares.

        List<Integer> listaIns = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        Predicate<Integer> filtro = n -> n % 2 != 0;
        listaIns.removeIf(filtro);
        System.out.println(listaIns);
    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej2() {
        //Ej2. Imprimir todos los elementos de una lista: Crea una lista de cadenas. Utiliza un
        //“Consumer” para imprimir cada cadena en la lista.

        List<String> listaStrings = new ArrayList<>(Arrays.asList("hola", "manolo", "javier"));
        Consumer<String> imprimir = l -> System.out.println(l);
        listaStrings.forEach(imprimir);
    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej3() {
        //Ej3. Transformar una lista de números: Crea una lista de números enteros. Utiliza una
        //“Function” para transformar cada número en la lista a su cubo.

        List<Integer> listaIns = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        Function<Integer, Integer> numeroAlCubo = n -> (int) Math.pow(n, 3);
        List<Integer> listaMod = listaIns.stream().map(numeroAlCubo).collect(Collectors.toUnmodifiableList());
        System.out.println(listaMod);
    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej4() {
        //Ej4. Generar una secuencia de números aleatorios: Utiliza un “Supplier” para generar e
        //imprimir una secuencia de diez números aleatorios.

    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej5() {
        //Ej5. Filtrar nombres que comienzan con una letra específica: Crea una lista de
        //nombres. Utiliza un “Predicate” para filtrar la lista y mantener solo los nombres
        //que comienzan con una letra específica (por ejemplo, "A").

    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej6() {
        //Ej6. Aplicar una operación a cada elemento de una lista: Crea una lista de números
        //enteros. Utiliza un “Consumer” para aplicar una operación a cada número en la
        //lista (por ejemplo, multiplicar cada número por 2).

    }
}