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
            case 12:
                ej12();
                break;
            case 13:
                ej13();
                break;
            default:
                System.out.println("introdujiste un ejercicio que no esta disponible");
                break;
        }
        scanner.close();
    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej1() {
        //1. Realiza un programa que pida al usuario introducir los lados de un rectángulo y calcule su área.

        Scanner scanner = new Scanner(System.in);
        System.out.print("introduce la base del rectangulo: ");
        int base = scanner.nextInt();
        System.out.print("introduce la altura del rectangulo: ");
        int altura = scanner.nextInt();

        System.out.println("el area del rectangulo es: " + (base * altura));
    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej2() {
        //2. Realiza un programa que pida al usuario introducir su nombre y después lo salude usuario diciéndole
        //“Hola” y su nombre.

        Scanner scanner = new Scanner(System.in);
        System.out.print("introduce tu nombre: ");
        String nombre = scanner.next();
        System.out.println("hola " + nombre);
    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej3() {
        // 3. Consulta la tabla de códigos ASCII y localiza los rangos de valores para las letras del
        //alfabeto A-Z y a-z. Crea un programa que pida al usuario que introduzca un número en
        //esos rangos y muestre por pantalla la letra correspondiente y si es o no una vocal.

        Scanner scanner = new Scanner(System.in);

        System.out.print("introduce un numero y te digo la letra que es en ascii: ");
        int numero = scanner.nextInt();
        Character caracter = (char) numero;

        System.out.println("el numero: " + numero + " es la letra: " + caracter);
    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej4() {
        //4. Realiza un programa que pida al usuario introducir un número y devuelva su raíz
        //cuadrada. Ayuda: la clase Math tiene una función (sqrt) que calcula la raíz cuadrada.

        Scanner scanner = new Scanner(System.in);

        System.out.print("introduce un numero: ");
        double numero = scanner.nextInt();
        double raiz = Math.sqrt(numero);

        System.out.println("la raiz cuadrada de " + numero + " es: " + raiz);
    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej5() {
        //5. El método ramdom de la clase Math devuelve números reales aleatorios entre 0 y 1.
            //a. Basándote en este comportamiento crea un programa que devuelva un
            //   número entero aleatorio entero entre 0 y 100.
            //b. Modifica el programa para pedir al usuario un número entero positivo y el
            //   programa devuelva tres números enteros aleatorios entre 0 y el número
            //   elegido por el usuario.
            //c. Modifica el programa para pedir al usuario dos números enteros positivos y el
            //   programa devuelva tres números enteros aleatorios entre los dos números
            //   elegidos por el usuario.

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            System.out.print("introduce un numero: ");
            int numero1 = scanner.nextInt();
            System.out.print("introduce otro numero: ");
            int numero2 = scanner.nextInt();

            if (numero1 >= 0 && numero2 >= 0) {
                for (int i = 0; i < 3; i++) {
                    int numeroAleatorio = random.nextInt(Math.min(numero1, numero2), Math.max(numero1, numero2));
                    System.out.println(numeroAleatorio);
                }
                break;
            }
        }
    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej6() {
        //6. Realiza un programa que pida al usuario introducir dos números enteros y que muestre:
            //1. el mayor
            //2. el menor
            //3. si el mayor es múltiplo del menor

        Scanner scanner = new Scanner(System.in);

        System.out.print("introduce un numero: ");
        int numero1 = scanner.nextInt();
        System.out.print("introduce otro numero: ");
        int numero2 = scanner.nextInt();

        int elMayor = Math.max(numero1, numero2);
        int elMenor = Math.min(numero1, numero2);

        System.out.println("el mayor es: " + elMayor);
        System.out.println("el menor es: " + elMenor);

        if (elMenor != 0 && elMayor % elMayor == 0) {
            System.out.println("el mayor es multiplo del menor");
        } else {
            System.out.println("el mayor no es multiplo del menor");
        }
    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej7() {
        //7. ¿Qué método de la clase Math utilizarías para realizar el producto de dos enteros y
        //asegurarte de que el resultado no hace overflow? Haz un programa que lo pruebe.

        Scanner scanner = new Scanner(System.in);

        System.out.print("introduce un numero: ");
        int numero1 = scanner.nextInt();
        System.out.print("introduce otro numero: ");
        int numero2 = scanner.nextInt();

        try {
            int productor = Math.multiplyExact(numero1, numero2);
            System.out.println("el producto sin overflow es: " + productor);
        } catch (ArithmeticException e) {
            System.out.println("hay overflow");
        }
    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej8() {
        //8. Realiza un programa que pida al usuario introducir dos números, calcule el cociente
        //entre ambos y muestre el resultado con una precisión de 3 decimales.

        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el primer número: ");
        double numero1 = scanner.nextDouble();
        System.out.print("Introduce el segundo número: ");
        double numero2 = scanner.nextDouble();

        if (numero2 == 0) {
            System.out.println("Error: División por cero no está permitida.");
        } else {
            // Calcular el cociente
            double cociente = numero1 / numero2;

            // Redondear a 3 decimales
            double cocienteRedondeado = Math.round(cociente * 1000.0) / 1000.0;

            System.out.println("El cociente es: " + cocienteRedondeado);
        }
    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej9() {
        //9. Realiza un programa que pida al usuario introducir dos números y muestre el resultado
        //de elevar el primero al segundo.

        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el primer número: ");
        double numero1 = scanner.nextDouble();
        System.out.print("Introduce el segundo número: ");
        double numero2 = scanner.nextDouble();

        System.out.println("el numero1 elevado al numero2 es: " + Math.pow(numero1, numero2));
    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej10() {
        //10. Realiza un programa que genere letras mayúsculas aleatoriamente y determine si son vocales o consonantes.

        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();

        System.out.print("cuantas letras quieres: ");
        int numeroLetras = scanner.nextInt();

        for (int i = 0; i < numeroLetras; i++) {
            char letraAleatoria = (char) ('A' + random.nextInt(26));
            stringBuilder.append(letraAleatoria);
        }
        System.out.println(stringBuilder);
    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej11() {
        //11. Crea un programa para procesar datos de viviendas; define las siguientes variables
        //enteras precio y superficie y la variable booleana tieneGaraje. El programa deberá
        //pedir al usuario que introduzca los valores para estas tres variables. Declara la variable
        //booleana meInteresa cuyo valor será:
            // Verdadero. Si el precio es menor a 150.000 €, la superficie es mayor que 80m2 y la
            //  vivienda tiene garaje.
            // Falso. En caso contrario.
            //  El programa mostrará el valor de meInteresa por consola para visualizar si estamos o
            //  no interesados en la vivienda.

        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el precio de la vivienda (€): ");
        int precio = scanner.nextInt();

        System.out.print("Introduce la superficie de la vivienda (m²): ");
        int superficie = scanner.nextInt();

        System.out.print("¿La vivienda tiene garaje? (true/false): ");
        boolean tieneGaraje = scanner.nextBoolean();

        boolean meInteresa = (precio < 150000) && (superficie > 80) && tieneGaraje;
        System.out.println("¿Estamos interesados en la vivienda? " + meInteresa);
    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej12() {
        //12. Realiza un programa en Java que pida introducir 5 números enteros al usuario
        //por la consola. El programa deberá mostrar:
            //a) Por cada número, si dicho número es impar. (1 punto)
            //b) Por cada número, si dicho número es mayor o igual que 5 y menor que 10. (1 punto)
            //c) Por cada número, exceptuando el primero, si dicho número ha sido introducido por el usuario en
            //los números anteriores. (2 puntos)
            //d) La media aritmética en números reales (con decimales) de los 5 números introducidos. (2 puntos)

        Scanner scanner = new Scanner(System.in);
        List<Integer> numeros = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            System.out.print("Introduce un número: ");
            int numero = scanner.nextInt();
            numeros.add(numero);
        }

        for (Integer i : numeros) {
            if (i % 2 != 0) {
                System.out.println("el numero " + i + " es impar");
            } else System.out.println("el numero " + i + " es par");

            if (i <= 5 && i < 10) {
                System.out.println("el numero " + i + " es mayor o igual que 5 y menor de 10");
            } else System.out.println("el numero " + i + " no es mayor o igual que 5 y menor de 10");
        }

        for (int i = 1; i < numeros.size(); i++) {
            int numeroActual = numeros.get(i);
            boolean esRepetido = false;

            for (int j = 0; j < i; j++) {
                if (numeros.get(j) == numeroActual) {
                    esRepetido = true;
                    break;
                }
            }

            if (esRepetido) {
                System.out.println("El número " + numeroActual + " ha sido introducido anteriormente.");
            } else {
                System.out.println("El número " + numeroActual + " es único hasta este punto.");
            }
        }

        double suma = 0;
        for (Integer i : numeros) {
            suma += i;
        }
        double media = suma / numeros.size();
        System.out.println("La media aritmética de los números introducidos es: " + media);
    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej13() {
        //13. Realiza un programa en Java que pida introducir 3 números enteros al usuario
        //por la consola. El programa deberá mostrar los números ordenados de mayor
        //a menor. (4 puntos)

        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el primer número: ");
        int numero1 = scanner.nextInt();
        System.out.print("Introduce el segundo número: ");
        int numero2 = scanner.nextInt();
        System.out.print("Introduce el tercer número: ");
        int numero3 = scanner.nextInt();

        List<Integer> numeros = new ArrayList<>(Arrays.asList(numero1, numero2, numero3));
        System.out.println(numeros);
        numeros.sort(Comparator.naturalOrder());
        System.out.println(numeros);
    }
}