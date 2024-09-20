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
            case 7:
                ej7();
                break;
            case 8:
                ej8();
                break;
            case 9:
                ej9();
                break;
            case 10:
                ej10();
                break;
            case 11:
                ej11();
                break;
            case 12:
                ej12();
                break;
            case 13:
                ej13();
                break;
            case 14:
                ej14();
                break;
            case 15:
                ej15();
                break;
            case 16:
                ej16();
                break;
            case 17:
                ej17();
                break;
            case 18:
                ej18();
                break;
            case 19:
                ej19();
                break;
            case 20:
                ej20();
                break;
            case 21:
                ej21();
                break;
            case 22:
                ej22();
                break;
            case 23:
                ej23();
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

//----------------------------------------------------------------------------------------------------------------------

    private static void ej7() {
        //Ej7. Crea una clase Fruta con al menos dos atributos, nombre y color.
        //Crea una lista con diferentes frutas. Llámala frutería
        //Obtén una lista de Strings, que contenga el nombre de las frutas que contenía la frutería.

    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej8() {
        //Ej8. Utiliza la misma estructura del ejercicio 1, y ahora imprime por pantalla los colores de las
        //diferentes frutas. (No pueden aparecer colores repetidos.)

    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej9() {
        //Ej9. Crea una lista de números.
        //Usando stream, calcula la suma de los cuadrados de todos los números de la lista.

    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej10() {
        //Ej10. Crea la clase persona con al menos los atributos nombre y edad.
        //- Ordenar una lista de personas por edad de forma descendente
        //- Imprimimos la lista de personas ordenada por nombre de forma ascendente

    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej11() {
        //Ej11. Crea la clase empleado con al menos los atributos: nombre, departamento.
        //- Crea varios empleados y agrupar la lista de empleados por departamento.
        //- Agrupamos los empleados por departamento y contamos cuantos empleados hay en cada departamento.
        //- Dado un departamento mostraremos sus empleados. Por ejemplo, muestra los empleados de ventas.
        //- Dado un nombre de empleado, mostraremos su departamento.

    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej12() {
        //Ej11. Contar el número de líneas en un archivo: Escribir un programa en Java que lea un
        //archivo de texto y cuente el número de líneas que contiene. El programa debe imprimir el
        //número de líneas en la consola.

    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej13() {
        //Ej12. Copiar un archivo: Escribir un programa en Java que copie el contenido de un archivo en
        //otro archivo. El programa debe tomar como entrada el nombre del archivo de origen y el
        //nombre del archivo de destino

    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej14() {
        //Ej13. Cifrado y descifrado de archivos: Escribir un programa en Java que permita cifrar y
        //descifrar un archivo utilizando un algoritmo de cifrado. El programa debe tomar como
        //entrada el nombre del archivo de origen, el nombre del archivo de destino, y una clave de
        //cifrado. El cifrado debe ser reversible, es decir, el archivo cifrado debe poder ser
        //descifrado con la misma clave. Puedes usar el algoritmo de cifrado AES

    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej15() {
        //Ej14. Combinación de archivos en uno solo: Escribir un programa en Java que permita
        //combinar varios archivos en uno solo. El programa debe tomar como entrada una lista de
        //archivos de origen y el nombre del archivo de destino. El programa debe leer cada archivo
        //de origen y escribir su contenido en el archivo de destino en el orden en que se
        //especificaron en la lista

    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej16() {
        //Ej15. Crea una clase Producto con los siguientes atributos:
            //private int id;
            //private String nombre;
            //private double precio;
            //private boolean descuento;
            //private char tipo;
        //Crea un programa que cree 5 productos, los meta en un ArrayList. Ahora recorra el
        //arrayList y que guarde los productos en un fichero de acceso aleatorio.
        //Ahora debes de leer y mostrar por consola el contenido del fichero.

    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej17() {
        //Ej16. Devuelve todas las rutas a partir de un directorio dado que cumplen una condición. Por
        //ejemplo, busca todos los archivos “*.txt”

    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej18() {
        //Ej17. Al ejercicio anterior, añádele una profundidad máxima, por ejemplo de 3, es decir si la
        //ruta que le has dicho es /home/Juanma, si la profundidad es 3 solo escanearía 3 niveles
        //de directorios interiores.

    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej19() {
        //Ej19. Extraer todas las direcciones IP de un texto:
        //Descripción: Dado un texto, extraer todas las direcciones IP válidas.

    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej20() {
        //Ej20. Descripción: Validar si una cadena es un número de teléfono en el formato (XXX) XXX-XXXX.

    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej21() {
        //Ej21. Extraer todas las fechas en formato DD/MM/YYYY:
        //Descripción: Dado un texto, extraer todas las fechas en el formato DD/MM/YYYY.

    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej22() {
        //Ej22. Validar una contraseña: (complicado)
        //Descripción: Validar si una cadena cumple con los requisitos de una contraseña segura
        //(al menos 8 caracteres, una letra mayúscula, una letra minúscula, un número y un
        //carácter especial).

    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej23() {
        //Ej23. Extraer todas las palabras que empiezan con una letra mayúscula:
        //Descripción: Dado un texto, extraer todas las palabras que empiezan con una letra
        //mayúscula.

    }
}