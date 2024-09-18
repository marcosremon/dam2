import java.lang.reflect.Array;
import java.util.*;

public class Ejercicios00 {
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
                default:
                    System.out.println("introdujiste un ejercicio que no esta disponible");
                    break;
            }
            scanner.close();
        }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej1() {
        //Ej1. Crear una lista de Strings y añadir elementos a ella. Luego, imprimir todos los
        //elementos de la lista usando un bucle for-each.

        List<String> listaStrings = new ArrayList<>();
        listaStrings.add("hola");
        listaStrings.add("puto");
        listaStrings.add("mundo");
        for (String i : listaStrings) {
            System.out.println(i);
        }
    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej2() {
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

//----------------------------------------------------------------------------------------------------------------------

    private static void ej3() {
        //Ej3. Dada una lista de Strings, escribir una función que devuelva la longitud del
        //string más largo en la lista.

        List<String> nombresList = new ArrayList<>(Arrays.asList("Hola", "Adios", "Mario", "Palomo"));

        nombresList.sort(Comparator.comparing(String::length).reversed());
        System.out.println(nombresList.get(0));
    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej4() {
        //Ej4. Crear un Set de Strings y añadir elementos a él. Luego, imprimir todos los
        //elementos del Set. ¿Qué observas acerca del orden de los elementos?

        Set<String> set = new HashSet<>(Arrays.asList("arbeloa", "benito", "arbeloa"));
        System.out.println(set);
    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej5() {
        //Ej5. Dada una lista de números enteros, escribir una función que devuelva un Set
        //que contenga solo los números únicos de la lista original.

        Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 1, 1, 2, 3, 4));
        System.out.println(set);
    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej6() {
        //Ej6. Dada una lista de Strings, escribir una función que devuelva un Set que
        //contenga solo los Strings únicos de la lista original.

        List<String> stringsList = new ArrayList<>(Arrays.asList("hola", "hola", "adios", "aaaa"));

        Set<String> set = new HashSet<>(stringsList);
        System.out.println(set);
    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej7() {
        //Ej7. Crear un Map que asocie nombres de países con sus capitales. Luego, imprimir
        //todos los pares de clave-valor del Map.

        Map<String, String> paisesCapitales = new HashMap<>();
        paisesCapitales.put("España", "Madrid");
        paisesCapitales.put("Francia", "Paris");
        paisesCapitales.put("Alemania", "Berlin");

        System.out.println(paisesCapitales);
    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej8() {
        //Ej8. Dada una lista de Strings, escribir una función que devuelva un Map donde las
        //claves son los Strings únicos de la lista y los valores son el número de veces que cada
        //String aparece en la lista.

        Map<Integer, String> map = new HashMap<>();
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
            map.put(contador, i);
        }
        System.out.println(map);
    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej9() {
        //Ej9. Dada una lista de estudiantes (donde cada estudiante es un objeto con
        //propiedades como nombre, edad, grado, etc.), escribir una función que devuelva un
        //Map donde las claves son los nombres de los estudiantes y los valores son los objetos
        //de los estudiantes.

        Map<String, String> estudiantes = new HashMap<>();

        Estudiante estudiante1 = new Estudiante("juan", 20, "informatica");
        Estudiante estudiante2 = new Estudiante("manuel Moro", 20, "mecanica");
        Estudiante estudiante3 = new Estudiante("alex", 20, "cocina");
        List<Estudiante> estudiantesList = new ArrayList<>(Arrays.asList(estudiante1, estudiante2, estudiante3));

        estudiantesList.forEach(e -> estudiantes.put(e.getNombre() + " ", " " + e.getEdad() + " " + e.getgrado()));
        System.out.println(estudiantes);
    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej10() {
        //Ej10. Calculadora con funciones lambda: Crea una interfaz funcional “Calculator” con un
        //método “calculate()”. Este método debe tomar dos números enteros y devolver un número
        //entero. Luego, en tu método “main()”, crea varias instancias de “Calculator” utilizando
        //funciones lambda para implementar operaciones como suma, resta, multiplicación y división.
        //Finalmente, prueba tus calculadoras con algunos números.

        Calculator suma = (a, b) -> a + b;
        Calculator resta = (a, b) -> a - b;
        Calculator multiplicacion = (a, b) -> a * b;
        Calculator division = (a, b) -> a / b;

        System.out.println("la suma es: " + suma.calculate(5, 5));
        System.out.println("la resta es: " + resta.calculate(6, 5));
        System.out.println("la multiplicacion es: " + multiplicacion.calculate(5, 5));
        System.out.println("la division es: " + division.calculate(10, 5));
    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej11() {
        //Ej11. Filtrado de lista con funciones lambda: Crea una lista de Strings que contenga
        //varios nombres. Luego, utiliza una función lambda para filtrar esta lista y crear una nueva lista
        //que solo contenga los nombres que comienzan con una letra específica (por ejemplo, "A"). Para
        //hacer esto, puedes utilizar el método “removeIf()” de “ArrayList”, que toma un “Predicate” (que
        //es una interfaz funcional que puedes implementar con una función lambda).

        List<String> nombresList = new ArrayList<>(Arrays.asList("Hola", "Adios", "Mario", "Palomo"));

        nombresList.removeIf(nombre -> !nombre.startsWith("A"));
        System.out.println(nombresList);
    }
}