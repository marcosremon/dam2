package Ejercicios;

import java.io.*;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import Classes.*;
import Metods.Metods;

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

        Supplier<Integer> randomSupplier = () -> new Random().nextInt();
        Stream.generate(randomSupplier).limit(10).forEach(System.out::println);
    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej5() {
        //Ej5. Filtrar nombres que comienzan con una letra específica: Crea una lista de
        //nombres. Utiliza un “Predicate” para filtrar la lista y mantener solo los nombres
        //que comienzan con una letra específica (por ejemplo, "A").

        List<String> listaStrings = new ArrayList<>(Arrays.asList("hola", "manolo", "javier", "andres"));
        Predicate<String> filtradoLetras = l -> !l.startsWith("a");
        listaStrings.removeIf(filtradoLetras);
        System.out.println(listaStrings);
    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej6() {
        //Ej6. Aplicar una operación a cada elemento de una lista: Crea una lista de números
        //enteros. Utiliza un “Consumer” para aplicar una operación a cada número en la
        //lista (por ejemplo, multiplicar cada número por 2).

        List<Integer> listaIns = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Consumer<Integer> consumer = n -> System.out.println(n * 2);
        listaIns.forEach(consumer);
    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej7() {
        //Ej7. Crea una clase Fruta con al menos dos atributos, nombre y color.
        //Crea una lista con diferentes frutas. Llámala frutería
        //Obtén una lista de Strings, que contenga el nombre de las frutas que contenía la frutería.

        Fruit fruta1 = new Fruit("manzana", "roja");
        Fruit fruta2 = new Fruit("pera", "verde");

        List<Fruit> fruteria = new ArrayList<>(Arrays.asList(fruta1, fruta2));
        List<String> nombreFruta = new ArrayList<>();

        fruteria.forEach(f -> nombreFruta.add(f.getName()));
        System.out.println(nombreFruta);
    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej8() {
        //Ej8. Utiliza la misma estructura del ejercicio 7, y ahora imprime por pantalla los colores de las
        //diferentes frutas. (No pueden aparecer colores repetidos.)

        Fruit fruta1 = new Fruit("manzana", "roja");
        Fruit fruta2 = new Fruit("pera", "verde");
        Fruit fruta3 = new Fruit("mandarina", "verde");

        List<Fruit> fruteria = new ArrayList<>(Arrays.asList(fruta1, fruta2));
        List<String> colorFrutas = new ArrayList<>();

        fruteria.forEach(f -> {
            if (!colorFrutas.contains(f.getColor())) {
                colorFrutas.add(f.getColor());
            }
        });
        System.out.println(colorFrutas);
    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej9() {
        //Ej9. Crea una lista de números.
        //Usando stream, calcula la suma de los cuadrados de todos los números de la lista.

        List<Integer> listaIns = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        int sumaNumeros = listaIns.stream().map(n -> n * n).reduce(0, Integer::sum);
        System.out.println(sumaNumeros);
    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej10() {
        //Ej10. Crea la clase persona con al menos los atributos nombre y edad.
        //- Ordenar una lista de personas por edad de forma descendente
        //- Imprimimos la lista de personas ordenada por nombre de forma ascendente

        Person3 persona1 = new Person3("juan", 25);
        Person3 persona2 = new Person3("alberto", 20);
        Person3 persona3 = new Person3("manue", 13);

        List<Person3> personas = new ArrayList<>(Arrays.asList(persona1, persona2, persona3));
        personas.sort(Comparator.comparingInt(Person3::getAge).reversed());
        System.out.println(personas);
        personas.sort(Comparator.comparing(Person3::getName));
        personas.forEach(p -> System.out.print(p.getName() + " "));
    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej11() {
        //Ej11. Crea la clase empleado con al menos los atributos: nombre, departamento.
        //- Crea varios empleados y agrupar la lista de empleados por departamento.
        //- Agrupamos los empleados por departamento y contamos cuantos empleados hay en cada departamento.
        //- Dado un departamento mostraremos sus empleados. Por ejemplo, muestra los empleados de ventas.
        //- Dado un nombre de empleado, mostraremos su departamento.

        Employed empleado1 = new Employed("Ana García", "Recursos Humanos");
        Employed empleado2 = new Employed("Luis Pérez", "IT");
        Employed empleado3 = new Employed("María López", "Marketing");
        Employed empleado4 = new Employed("Carlos Martínez", "Finanzas");
        Employed empleado5 = new Employed("Martin", "Finanzas");

        List<Employed> empleados = new ArrayList<>(Arrays.asList(empleado1, empleado2, empleado3, empleado4, empleado5));
        empleados.sort(Comparator.comparing(Employed::getDepartment));
        System.out.println(empleados);
        Map<String, Long> conadorDepartamentos = empleados.stream().collect(
                Collectors.groupingBy(Employed::getDepartment, Collectors.counting()));
        conadorDepartamentos.forEach((dep, cont) -> System.out.println("el departamento: " + dep + " aparece: " +
                cont + " veces"));
    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej12() {
        //Ej12. Contar el número de líneas en un archivo: Escribir un programa en Java que lea un
        //archivo de texto y cuente el número de líneas que contiene. El programa debe imprimir el
        //número de líneas en la consola.

        String filePath = Metods.importFiles("data.csv");
        try (BufferedReader br = new BufferedReader(new FileReader(new File(filePath)))) {
            String line = null;
            int contador = 0;
            while ((line = br.readLine()) != null) {
                contador++;
            }
            System.out.println("el archivo tiene " + contador + " palabras");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej13() {
        //Ej13. Copiar un archivo: Escribir un programa en Java que copie el contenido de un archivo en
        //otro archivo. El programa debe tomar como entrada el nombre del archivo de origen y el
        //nombre del archivo de destino

        String dataFile = Metods.importFiles("data.csv");
        String switchedFile = Metods.importFiles("data.csv");

        try (BufferedReader br = new BufferedReader(new FileReader(new File(dataFile)))) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(switchedFile)))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    bw.write(linea);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej14() {
        //Ej14. Cifrado y descifrado de archivos: Escribir un programa en Java que permita cifrar y
        //descifrar un archivo utilizando un algoritmo de cifrado. El programa debe tomar como
        //entrada el nombre del archivo de origen, el nombre del archivo de destino, y una clave de
        //cifrado. El cifrado debe ser reversible, es decir, el archivo cifrado debe poder ser
        //descifrado con la misma clave. Puedes usar el algoritmo de cifrado AES

    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej15() {
        //Ej15. Combinación de archivos en uno solo: Escribir un programa en Java que permita
        //combinar varios archivos en uno solo. El programa debe tomar como entrada una lista de
        //archivos de origen y el nombre del archivo de destino. El programa debe leer cada archivo
        //de origen y escribir su contenido en el archivo de destino en el orden en que se
        //especificaron en la lista

        File file1 = new File(Metods.importFiles("data.csv"));
        File file2 = new File(Metods.importFiles("congreso.csv"));
        File mergedFiles = new File(Metods.importFiles("ficheroConjunto.csv"));
        List<File> fileList = new ArrayList<>(Arrays.asList(file1, file2));

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(mergedFiles))) {
            for (File file : fileList) {
                try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                    String linea;
                    while ((linea = br.readLine()) != null) {
                        bw.write(linea);
                        bw.newLine();
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej16() {
        //Ej16. Crea una clase Producto con los siguientes atributos:
            //private int id;
            //private String nombre;
            //private double precio;
            //private boolean descuento;
            //private char tipo;
        //Crea un programa que cree 5 productos, los meta en un ArrayList. Ahora recorra el
        //arrayList y que guarde los productos en un fichero de acceso aleatorio.
        //Ahora debes de leer y mostrar por consola el contenido del fichero.

        Product producto1 = new Product(1, "Manzana", 0.50, true, 'A');
        Product producto2 = new Product(2, "Leche", 1.20, false, 'B');
        Product producto3 = new Product(3, "Pan", 0.80, true, 'B');
        Product producto4 = new Product(4, "Cereal", 2.50, false, 'C');
        Product producto5 = new Product(5, "Jugo de Naranja", 1.50, true, 'A');

        List<Product> productos = new ArrayList<>(Arrays.asList(producto1, producto2, producto3, producto4, producto5));
        File filePath = new File(Metods.importFiles("productos.dat"));

        //Escribir en el fichero
        try (RandomAccessFile raf = new RandomAccessFile(filePath, "rw")) {
            for (Product product : productos) {
                raf.writeInt(product.getId());
                raf.writeUTF(product.getName());
                raf.writeDouble(product.getPrice());
                raf.writeBoolean(product.isDiscount());
                raf.writeChar(product.getTipe());
            }

            //Leer Fichero
            try (RandomAccessFile raf2 = new RandomAccessFile(filePath, "r")){
                int blockLength = Integer.BYTES + 10 + Double.BYTES + 1 + Character.BYTES;
                raf2.seek(0);
                while (raf2.getFilePointer() < raf2.length()) {
                    int id = raf2.readInt();
                    String name = raf2.readUTF();
                    double price = raf2.readDouble();
                    boolean discount = raf2.readBoolean();
                    char type = raf2.readChar();

                    Product producto = new Product(id, name, price, discount, type);
                    System.out.println(producto);
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej17() {
        //Ej17. Devuelve todas las rutas a partir de un directorio dado que cumplen una condición. Por
        //ejemplo, busca todos los archivos “*.txt”


    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej18() {
        //Ej18. Al ejercicio anterior, añádele una profundidad máxima, por ejemplo de 3, es decir si la
        //ruta que le has dicho es /home/Juanma, si la profundidad es 3 solo escanearía 3 niveles
        //de directorios interiores.

    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej19() {
        //Ej19. Extraer todas las direcciones IP de un texto:
        //Descripción: Dado un texto, extraer todas las direcciones IP válidas.

        String filePath = Metods.importFiles("ips.txt");
        String regex = "^\\d{1,3}(\\.\\d{1,3}){3}$";
        Pattern pattern = Pattern.compile(regex);

        try (BufferedReader br = new BufferedReader(new FileReader(new File(filePath)))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    System.out.println(matcher.group());
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej20() {
        //Ej20. Descripción: Validar si una cadena es un número de teléfono en el formato (XXX) XXX-XXXX.

        String telefonNumber = "(618) 839-4699";
        String regex = "\\([1-9]{3}\\)\s[1-9]{3}-[1-9]{4}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(telefonNumber);

        if (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej21() {
        //Ej21. Extraer todas las fechas en formato DD/MM/YYYY:
        //Descripción: Dado un texto, extraer todas las fechas en el formato DD/MM/YYYY.

        String filePath = Metods.importFiles("fechasFormateadas.txt");
        String regex = "(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/[0-9]{4}";
        Pattern pattern = Pattern.compile(regex);


        try (BufferedReader br = new BufferedReader(new FileReader(new File(filePath)))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    System.out.println(matcher.group());
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej22() {
        //Ej22. Validar una contraseña: (complicado)
        //Descripción: Validar si una cadena cumple con los requisitos de una contraseña segura
        //(al menos 8 caracteres, una letra mayúscula, una letra minúscula, un número y un
        //carácter especial).

        String password = "holabuenA1*s";
        String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*()_+\\[\\]{};':\"\\\\|,.<>/?-]).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        if (matcher.find()) {
            System.out.println("felicidades");
        } else System.out.println("la contraseña es erronea");
    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej23() {
        //Ej23. Extraer todas las palabras que empiezan con una letra mayúscula:
        //Descripción: Dado un texto, extraer todas las palabras que empiezan con una letra
        //mayúscula.

        String filePath = Metods.importFiles("ficheroMayusculas.txt");
        String regex = "[A-Z]{1,}";
        Pattern pattern = Pattern.compile(regex);

        try (BufferedReader br = new BufferedReader(new FileReader(new File(filePath)))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                Arrays.stream(line.split("\\s+")).forEach(w -> {
                    Matcher matcher = pattern.matcher(w);
                    if (matcher.find()) {
                        System.out.println(w);
                    }
                });
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}