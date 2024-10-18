package Ejercicios;

import Classes.*;
import Metods.Metods;
import com.sun.source.tree.WhileLoopTree;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Ejercicios02 {
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
            default:
                System.out.println("introdujiste un ejercicio que no esta disponible");
                break;
        }
        scanner.close();
    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej1()  {
        //Ej1. Crea la clase producto con los siguientes atributos: id (int), nombre (String), precio (double),
        //descuento (boolean) y tipo (char)
        //Crea 5 o 6 productos e introdúcelos en una lista. Escribe con RandomAccessFile un fichero con los siguientes
        //datos de los productos:
            //• id (int)
            //• nombre (String, 10 caracteres)
            //• precio (double)
            //• descuento (boolean)
            //• tipo (char)
        //b) lee el archivo de acceso aleatorio y muestra su contenido por pantalla.

        Product producto1 = new Product(1, "Manzana", 0.50, true, 'A');
        Product producto2 = new Product(2, "Leche", 1.20, false, 'B');
        Product producto3 = new Product(3, "Pan", 0.80, true, 'B');
        Product producto4 = new Product(4, "Cereal", 2.50, false, 'C');
        Product producto5 = new Product(5, "Jugo de Naranja", 1.50, true, 'A');

        List<Product> products = new ArrayList<>(Arrays.asList(producto1, producto2, producto3, producto4, producto5));

        String randomFile = Metods.importFiles("products.dat");
        try (RandomAccessFile raf = new RandomAccessFile(randomFile, "rw")) {
            for (Product i : products) {
                raf.writeInt(i.getId());
                raf.writeUTF(i.getName());
                raf.writeDouble(i.getPrice());
                raf.writeBoolean(i.isDiscount());
                raf.writeChar(i.getTipe());
            }

            try (RandomAccessFile raf2 = new RandomAccessFile(randomFile, "r")) {
                raf2.seek(0);
                while (raf2.getFilePointer() < raf2.length()) {
                    int id = raf2.readInt();
                    String name = raf2.readUTF();
                    double price = raf2.readDouble();
                    boolean discount = raf2.readBoolean();
                    char type = raf2.readChar();
                    Product product = new Product(id, name, price, discount, type);
                    System.out.printf(product.toString());
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej2()  {
        //Ej2. Buscar y reemplazar texto en un archivo:
        //Objetivo: Crear una herramienta que busque una cadena de texto específica en un archivo y la
        //reemplace por otra. Consideraciones:
        //Utilizar java.io.BufferedReader y java.io.BufferedWriter para leer y escribir líneas de texto.
        //Implementar un algoritmo de búsqueda y reemplazo eficiente.
        //Crear un nuevo archivo con los cambios para preservar el original.

        String originalWord = ",";
        String remplacedWord = "(Jamon)";

        try (BufferedReader br = new BufferedReader(new FileReader(Metods.importFiles("data.txt")));
             BufferedWriter bw = new BufferedWriter(new FileWriter(Metods.importFiles("dataRemplazadas.txt")))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                line = line.replace(originalWord, remplacedWord);
                bw.write(line);
                bw.newLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej3() {
        //Ej3. Crea una lista de objetos Persona (con atributos nombre y edad) y:
        //• Calcula la edad promedio de las personas.
        //• Encuentra la persona más joven.
        //• Imprime una lista con los nombres de las personas mayores de 30 años

        List<Person3> peoples = new ArrayList<>(Arrays.asList(
                new Person3("Juan", 25),
                new Person3("María", 30),
                new Person3("Carlos", 22),
                new Person3("Ana", 28),
                new Person3("Luis", 35)));

        System.out.println("media edades");
        int average = peoples.stream().mapToInt(Person3::getAge).sum();
        System.out.println(average/peoples.size());
        System.out.println("------------------------------------------");
        System.out.println("persona mas joven");
        Optional<Person3> smolestPerson = peoples.stream().min(Comparator.comparing(Person3::getAge));
        System.out.println(smolestPerson);
        System.out.println("------------------------------------------");
        System.out.println("persona mas mayores de 30 años");
        peoples.stream().filter(p -> p.getAge() > 30).forEach(System.out::println);

    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej4()  {
        //Ej4. Lee un archivo CSV con datos de productos (nombre, precio, categoría) utiliza el contenido
        //leído para inicializar un arraylist:
        //• Calcula el producto más caro de cada categoría.
        //• Imprime una lista con los productos cuyo precio está entre 10 y 20 euros.

        List<Products2> products = new ArrayList<>();

        String filePath = Metods.importFiles("products.csv");
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line = null;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[1];
                double price = Double.parseDouble(parts[5]);
                int category = Integer.parseInt(parts[3]);
                products.add(new Products2(name, price, category));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("producto mas caro por categoria");
        Map<Integer, Optional<Products2>> theMostPrice = products.stream().collect(Collectors.groupingBy(Products2::getCategory,
                Collectors.maxBy(Comparator.comparing(Products2::getPrice))));
        for (Map.Entry<Integer, Optional<Products2>> i : theMostPrice.entrySet()) {
            System.out.println(i);
        }
        System.out.println("------------------------------------------");
        System.out.println("precio está entre 10 y 20 euros");
        products.stream().filter(p -> p.getPrice() >= 10 || p.getPrice() <= 20).forEach(System.out::println);
    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej5() {
        //Ej5. Crea un String con un contenido bastante largo. Ahora trabaja con dicho String para obtener
        //por medio de stream el número de ocurrencias de cada palabra.
        //Consejo: Si quieres simplificarlo mira los métodos de la clase Collectors
        //Ejemplo: String text = "este es un ejemplo de texto para contar palabras este texto puede ser todo lo largo
        //que quieras";
        //{que=1, ser=1, puede=1, de=1, lo=1, es=1, todo=1, texto=2, este=2, para=1, palabras=1, un=1,
        //quieras=1, largo=1, contar=1, ejemplo=1}

        String longText = "En un lugar de la Mancha, de cuyo nombre no quiero acordarme, " +
                "no ha mucho tiempo que vivía un hidalgo de los de lanza antigua, " +
                "rocín flaco y galgo corredor. Una olla de algo más vaca que carnero, " +
                "salpicón las más de las veces, algún palomino de añadidura, " +
                "y algún que otro plato de lo que la tierra daba, " +
                "que era muy poco. Todo esto sancho panza, " +
                "que era su criado, lo llevaba en su asno.";

        Map<String, Long> wordsCounter = Arrays.stream(longText.toLowerCase().split("\\W"))
                .collect(Collectors.groupingBy(w -> w, Collectors.counting()));
        wordsCounter.forEach((word, counter) -> System.out.println("la palabra: " + word + " se repite: " + counter +
                "veces"));
    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej6() {
        //Ej6. Tenemos una clase coche con al menos los siguientes atributos: marca, color, matrícula. Y una
        //clase Persona con al menos los siguientes atributos: nombre, dni y una lista de coches de su propiedad.
        //Realiza las siguientes búsquedas:
        //• Muestra la información de las personas que tiene un coche rojo
        //• Personas con un coche Opel.
        //• Encontrar a la persona con más coches.

        List<Car> carsPerson1 = new ArrayList<>();
        List<Car> carsPerson2 = new ArrayList<>();
        List<Car> carsPerson3 = new ArrayList<>();
        List<Car> carsPerson4 = new ArrayList<>();
        List<Car> carsPerson5 = new ArrayList<>();
        List<Car> carsPerson6 = new ArrayList<>();
        List<Car> carsPerson7 = new ArrayList<>();
        List<Car> carsPerson8 = new ArrayList<>();
        List<Car> carsPerson9 = new ArrayList<>();
        List<Car> carsPerson10 = new ArrayList<>();

        carsPerson1.add(new Car("Toyota", "Rojo", "ABC123"));
        carsPerson1.add(new Car("Honda", "Azul", "DEF456"));
        carsPerson2.add(new Car("Ford", "Negro", "GHI789"));
        carsPerson2.add(new Car("Opel", "Blanco", "JKL012"));
        carsPerson3.add(new Car("Nissan", "Verde", "MNO345"));
        carsPerson3.add(new Car("Hyundai", "Amarillo", "PQR678"));
        carsPerson4.add(new Car("Kia", "Gris", "STU901"));
        carsPerson4.add(new Car("Volkswagen", "Naranja", "VWX234"));
        carsPerson5.add(new Car("Mazda", "Cyan", "YZA567"));
        carsPerson5.add(new Car("Subaru", "Magenta", "BCD890"));
        carsPerson6.add(new Car("Mercedes", "Marrón", "EFG123"));
        carsPerson6.add(new Car("BMW", "Violeta", "HIJ456"));
        carsPerson7.add(new Car("Audi", "Plata", "KLM789"));
        carsPerson7.add(new Car("Porsche", "Oro", "NOP012"));
        carsPerson8.add(new Car("Fiat", "Rosa", "QRS345"));
        carsPerson8.add(new Car("Tesla", "Verde claro", "TUV678"));
        carsPerson9.add(new Car("Land Rover", "Beige", "WXY901"));
        carsPerson9.add(new Car("Jaguar", "Azul claro", "ZAB234"));
        carsPerson10.add(new Car("Lexus", "Negro mate", "CDE567"));
        carsPerson10.add(new Car("Mitsubishi", "Rojo", "FGH890"));

        List<Person> persons = new ArrayList<>(Arrays.asList(
            new Person("Nombre1", "DNI1", carsPerson1),
            new Person("Nombre2", "DNI2", carsPerson2),
            new Person("Nombre3", "DNI3", carsPerson3),
            new Person("Nombre4", "DNI4", carsPerson4),
            new Person("Nombre5", "DNI5", carsPerson5),
            new Person("Nombre6", "DNI6", carsPerson6),
            new Person("Nombre7", "DNI7", carsPerson7),
            new Person("Nombre8", "DNI8", carsPerson8),
            new Person("Nombre9", "DNI9", carsPerson9),
            new Person("Nombre10", "DNI10", carsPerson10)
        ));

        System.out.println("personas con coche rojo");
        persons.stream().filter(person -> person.getCars().stream().anyMatch(car -> car.getColor()
                .equalsIgnoreCase("Rojo"))).forEach(System.out::println);

        System.out.println("-----------------------");
        System.out.println("personas con coches opel");
        persons.stream().filter(person -> person.getCars().stream().anyMatch(car -> car.getMake()
                .equalsIgnoreCase("opel"))).forEach(System.out::println);

        System.out.println("-----------------------");
        System.out.println("persona con mas coches");
        Optional<Person> a = persons.stream().max(Comparator.comparing(person -> person.getCars().size()));
        System.out.println(a);

    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej7() {
        //Ej7. Tenemos una clase persona con los siguientes atributos:
            //int id;
            //String nombre;
            //String apellidos;
            //String curso;
            //int nota;
            //int edad;
        //Para inicializar los datos, tienes un archivo “inicialización.java” que añade 1000 personas a una
        //lista. Una vez inicializada tu lista realiza las siguientes búsquedas haciendo uso de programación funcional:
        //• 1. Personas mayores de edad, que están cursando un curso que empieza por A y su nombre contiene una N
        //• 2. Personas con edades entre 20 y 25 años y que estén cursando Acceso a Datos
        //• 3. Muestra las personas que han aprobado el curso de POO
        //• 4. Muestra el número de personas que hay matriculadas en cada curso.

        List<Person2> list = new ArrayList<>();
        addToList(list);

        List<Person2> firstPoint = list.stream().filter(person -> person.getAge() >= 18 && person.getCourse()
                .startsWith("A") && person.getCourse().contains("n")).toList();
        List<Person2> secondPoint = list.stream().filter(person -> person.getAge() >= 20 && person.getAge() <= 25  &&
                person.getCourse().equalsIgnoreCase("acceso a datos")).toList();
        List<Person2> threePoint = list.stream().filter(person -> person.getNotes() >= 5 && person.getCourse()
                .equalsIgnoreCase("poo")).toList();
        Map<String, Long> fourPoint = list.stream().collect(Collectors.groupingBy(Person2::getCourse, Collectors.counting()));

        System.out.println("primer punto:");
        System.out.println(firstPoint);
        System.out.println("------------------");
        System.out.println("segundo punto");
        System.out.println(secondPoint);
        System.out.println("------------------");
        System.out.println("tercer punto");
        System.out.println(threePoint);
        System.out.println("------------------");
        System.out.println("cuarto punto");
        System.out.println(fourPoint);
    }

    private static void addToList(List<Person2> list) {
        list.add(new Person2(1, "Adélie", "Deinhard", "Angular", 10, 45));
        list.add(new Person2(2, "Angélique", "Cloake", "sql", 10, 33));
        list.add(new Person2(3, "Gaëlle", "Cheales", "Express", 5, 47));
        list.add(new Person2(4, "Illustrée", "Maunton", "XML", 4, 68));
        list.add(new Person2(5, "Gwenaëlle", "Flucks", "XML", 1, 27));
        list.add(new Person2(6, "Kallisté", "Edington", "POO", 10, 60));
        list.add(new Person2(7, "Åke", "Chern", "Angular", 1, 19));
        list.add(new Person2(8, "Lèi", "De Mattei", "Oracle", 6, 23));
        list.add(new Person2(9, "Tán", "Yarn", "Java", 1, 60));
        list.add(new Person2(10, "Naéva", "Chase", "Java", 7, 22));
        list.add(new Person2(11, "Clémence", "Klimas", "PostgreSQL", 6, 48));
        list.add(new Person2(12, "Gisèle", "Vannucci", "POO", 4, 23));
        list.add(new Person2(13, "Maïwenn", "Chevis", "XML", 7, 55));
        list.add(new Person2(14, "Tán", "Keiling", "XML", 7, 48));
        list.add(new Person2(15, "Mélinda", "Rasch", "JavaScript", 10, 40));
        list.add(new Person2(16, "Méng", "Mabone", "Oracle", 6, 52));
        list.add(new Person2(17, "Andrée", "Paxman", "Java", 2, 36));
        list.add(new Person2(18, "Marie-ève", "Shrimptone", "POO", 7, 63));
        list.add(new Person2(19, "Esbjörn", "Topaz", "react", 3, 59));
        list.add(new Person2(20, "Aurélie", "Smedley", "POO", 9, 20));
        list.add(new Person2(21, "Aimée", "Knaggs", "Oracle", 10, 62));
        list.add(new Person2(22, "Audréanne", "Aubert", "Oracle", 7, 55));
        list.add(new Person2(23, "Angèle", "Mair", "Patrones de diseño", 9, 38));
        list.add(new Person2(24, "Estée", "Cosens", "PostgreSQL", 7, 39));
        list.add(new Person2(25, "Nélie", "Poleye", "Express", 1, 52));
        list.add(new Person2(26, "Pål", "Mounsey", "odoo", 6, 49));
        list.add(new Person2(27, "Lucrèce", "Cranton", "Java", 8, 55));
        list.add(new Person2(28, "Åsa", "Cronchey", "NodeJs", 8, 49));
        list.add(new Person2(29, "Marylène", "Myott", "Acceso a datos", 6, 43));
        list.add(new Person2(30, "Méthode", "Schulz", "Angular", 3, 75));
        list.add(new Person2(31, "Réjane", "Blowfelde", "POO", 9, 32));
        list.add(new Person2(32, "Måns", "Dunnion", "react", 1, 38));
        list.add(new Person2(33, "Régine", "Freemantle", "Angular", 9, 37));
        list.add(new Person2(34, "Pélagie", "Riccardi", "POO", 8, 45));
        list.add(new Person2(35, "Måns", "Waldren", "POO", 1, 23));
        list.add(new Person2(36, "Clélia", "McClounan", "Angular", 10, 40));
        list.add(new Person2(37, "Nadège", "Praundl", "Patrones de diseño", 5, 24));
        list.add(new Person2(38, "Hélèna", "McCorley", "sql", 4, 51));
        list.add(new Person2(39, "Yè", "Beaby", "Oracle", 3, 75));
        list.add(new Person2(40, "Dà", "Bickerton", "Express", 2, 67));
        list.add(new Person2(41, "Lyséa", "Maylard", "XML", 3, 67));
        list.add(new Person2(42, "Joséphine", "Milsom", "Angular", 9, 67));
        list.add(new Person2(43, "Illustrée", "Egre", "Express", 8, 32));
        list.add(new Person2(44, "Océane", "Nunnery", "Express", 4, 40));
        list.add(new Person2(45, "Vénus", "Cakes", "Oracle", 10, 23));
        list.add(new Person2(46, "Méghane", "Wonter", "Express", 8, 34));
        list.add(new Person2(47, "Thérèse", "Godbolt", "XML", 4, 38));
        list.add(new Person2(48, "Renée", "Matias", "sql", 3, 70));
        list.add(new Person2(49, "Pénélope", "Barbrick", "MySQL", 5, 61));
        list.add(new Person2(50, "Björn", "Massei", "Oracle", 6, 62));
        list.add(new Person2(51, "Maïwenn", "Boughen", "NodeJs", 4, 61));
        list.add(new Person2(52, "Léandre", "Wetherhead", "Express", 5, 22));
        list.add(new Person2(53, "Marie-josée", "Gilmour", "JavaScript", 1, 65));
        list.add(new Person2(54, "Irène", "Allabarton", "Oracle", 9, 66));
        list.add(new Person2(55, "Yú", "Bengtsen", "Express", 7, 26));
        list.add(new Person2(56, "Adélie", "Linsay", "Angular", 9, 38));
        list.add(new Person2(57, "Adèle", "Duferie", "BBDD", 5, 44));
        list.add(new Person2(58, "Léane", "Sotheby", "PostgreSQL", 9, 63));
        list.add(new Person2(59, "Gaétane", "Drinkhall", "MySQL", 3, 53));
        list.add(new Person2(60, "Faîtes", "Leverton", "BBDD", 6, 50));
        list.add(new Person2(61, "Judicaël", "Cubbin", "XML", 7, 32));
        list.add(new Person2(62, "Véronique", "Whyte", "odoo", 9, 33));
        list.add(new Person2(63, "Josée", "Sawers", "PostgreSQL", 6, 71));
        list.add(new Person2(64, "Naëlle", "Puckett", "react", 3, 75));
        list.add(new Person2(65, "Håkan", "Tolfrey", "Java", 4, 24));
        list.add(new Person2(66, "Maëline", "Everard", "PostgreSQL", 3, 18));
        list.add(new Person2(67, "Michèle", "Stempe", "Angular", 6, 47));
        list.add(new Person2(68, "Görel", "Elcocks", "odoo", 3, 35));
        list.add(new Person2(69, "Yóu", "Branston", "Angular", 8, 31));
        list.add(new Person2(70, "Léandre", "Bertelsen", "POO", 3, 32));
        list.add(new Person2(71, "Estée", "Stoyell", "MySQL", 8, 45));
        list.add(new Person2(72, "Stévina", "Trevett", "JavaScript", 7, 30));
        list.add(new Person2(73, "Kù", "Sherman", "Express", 9, 29));
        list.add(new Person2(74, "Léandre", "Brewin", "Java", 10, 51));
        list.add(new Person2(75, "Lyséa", "Meineken", "JavaScript", 10, 30));
        list.add(new Person2(76, "Aimée", "Knowler", "BBDD", 9, 43));
        list.add(new Person2(77, "Néhémie", "Fennessy", "Oracle", 3, 38));
        list.add(new Person2(78, "Frédérique", "Baack", "MySQL", 8, 27));
        list.add(new Person2(79, "Thérèse", "Pemberton", "sql", 5, 39));
        list.add(new Person2(80, "Bérénice", "Lintot", "BBDD", 10, 44));
        list.add(new Person2(81, "Annotés", "Skupinski", "NodeJs", 4, 59));
        list.add(new Person2(82, "Bérangère", "Hattoe", "Java", 6, 75));
        list.add(new Person2(83, "Angélique", "Goldin", "sql", 6, 24));
        list.add(new Person2(84, "Eliès", "Mulleary", "sql", 8, 49));
        list.add(new Person2(85, "Océanne", "Pischof", "JavaScript", 4, 21));
        list.add(new Person2(86, "Marylène", "Chene", "BBDD", 4, 64));
        list.add(new Person2(87, "Séréna", "Blakden", "react", 5, 26));
        list.add(new Person2(88, "Vénus", "Oats", "Express", 7, 39));
        list.add(new Person2(89, "Pål", "McQuorkel", "react", 8, 72));
        list.add(new Person2(90, "Styrbjörn", "Probets", "Java", 8, 58));
        list.add(new Person2(91, "Adélie", "Drepp", "odoo", 6, 38));
        list.add(new Person2(92, "Frédérique", "Saur", "POO", 9, 71));
        list.add(new Person2(93, "Wá", "Dorot", "POO", 8, 73));
        list.add(new Person2(94, "Kù", "Marikhin", "Java", 7, 47));
        list.add(new Person2(95, "Anaé", "Darwent", "Acceso a datos", 4, 21));
        list.add(new Person2(96, "Maïlys", "Pawnsford", "Acceso a datos", 4, 30));
        list.add(new Person2(97, "Annotée", "Tales", "odoo", 2, 44));
        list.add(new Person2(98, "Maëlys", "Crosgrove", "Express", 4, 63));
        list.add(new Person2(99, "Eléonore", "Christley", "POO", 2, 31));
        list.add(new Person2(100, "Lyséa", "Magnay", "MySQL", 7, 23));
        list.add(new Person2(101, "Vénus", "Hannah", "POO", 9, 52));
        list.add(new Person2(102, "Loïs", "Rodda", "PostgreSQL", 5, 28));
        list.add(new Person2(103, "Cunégonde", "Robic", "PostgreSQL", 3, 27));
        list.add(new Person2(104, "Eliès", "Roddick", "sql", 2, 61));
        list.add(new Person2(105, "Mylène", "Dunsford", "Java", 10, 67));
        list.add(new Person2(106, "Aí", "Antliff", "Oracle", 8, 46));
        list.add(new Person2(107, "Thérèse", "Chiese", "BBDD", 6, 69));
        list.add(new Person2(108, "Maëlann", "Crayden", "Angular", 6, 55));
        list.add(new Person2(109, "Adélaïde", "O'Howbane", "react", 10, 36));
        list.add(new Person2(110, "Åsa", "Yesson", "Acceso a datos", 2, 27));
        list.add(new Person2(111, "Thérèse", "Theaker", "NodeJs", 2, 48));
        list.add(new Person2(112, "Cléa", "Caston", "odoo", 1, 18));
        list.add(new Person2(113, "Célestine", "Hensmans", "BBDD", 9, 25));
        list.add(new Person2(114, "Östen", "Pusey", "odoo", 6, 61));
        list.add(new Person2(115, "Yóu", "Scudder", "PostgreSQL", 3, 61));
        list.add(new Person2(116, "Méthode", "Knolles-Green", "Java", 7, 74));
        list.add(new Person2(117, "Intéressant", "Threlkeld", "POO", 5, 52));
        list.add(new Person2(118, "Méthode", "Hanway", "NodeJs", 3, 36));
        list.add(new Person2(119, "Lauréna", "Dalyiel", "POO", 2, 30));
        list.add(new Person2(120, "Gwenaëlle", "Jerdan", "PostgreSQL", 5, 67));
        list.add(new Person2(121, "Intéressant", "Le Prevost", "POO", 9, 27));
        list.add(new Person2(122, "Séverine", "Blakelock", "react", 5, 22));
        list.add(new Person2(123, "Océane", "Leinthall", "Acceso a datos", 8, 24));
        list.add(new Person2(124, "Maï", "Wileman", "PostgreSQL", 7, 39));
        list.add(new Person2(125, "Bécassine", "Kinset", "XML", 2, 44));
        list.add(new Person2(126, "Mélinda", "Batey", "Acceso a datos", 2, 66));
        list.add(new Person2(127, "Naëlle", "Fellini", "Oracle", 9, 37));
        list.add(new Person2(128, "Chloé", "Bungey", "Angular", 7, 18));
        list.add(new Person2(129, "Annotés", "Amesbury", "POO", 2, 70));
        list.add(new Person2(130, "Naëlle", "Hallen", "BBDD", 1, 50));
        list.add(new Person2(131, "Adélaïde", "Brodeau", "XML", 3, 18));
        list.add(new Person2(132, "Marie-hélène", "Cheak", "Express", 4, 27));
        list.add(new Person2(133, "Eliès", "Sygroves", "MySQL", 4, 40));
        list.add(new Person2(134, "Stévina", "Allsebrook", "Oracle", 5, 36));
        list.add(new Person2(135, "Tú", "Craigg", "Acceso a datos", 2, 59));
        list.add(new Person2(136, "Mårten", "Alfuso", "XML", 4, 40));
        list.add(new Person2(137, "Håkan", "Shalcros", "Angular", 6, 31));
        list.add(new Person2(138, "Loïc", "Tanswell", "odoo", 4, 52));
        list.add(new Person2(139, "Méthode", "Klimkin", "Java", 1, 40));
        list.add(new Person2(140, "Ruì", "Sharp", "Oracle", 7, 31));
        list.add(new Person2(141, "Ráo", "Kerford", "Angular", 9, 39));
        list.add(new Person2(142, "Geneviève", "Ianni", "Express", 10, 54));
        list.add(new Person2(143, "Yóu", "Creek", "MySQL", 3, 41));
        list.add(new Person2(144, "Noëlla", "Dulwitch", "MySQL", 9, 49));
        list.add(new Person2(145, "Cécilia", "McKerron", "sql", 2, 39));
        list.add(new Person2(146, "Mén", "Boulder", "react", 8, 48));
        list.add(new Person2(147, "Jú", "Arkill", "Acceso a datos", 4, 34));
        list.add(new Person2(148, "Maëline", "Marriot", "MySQL", 3, 33));
        list.add(new Person2(149, "Anaël", "Knuckles", "POO", 10, 32));
        list.add(new Person2(150, "Naéva", "Devonish", "Oracle", 3, 25));
        list.add(new Person2(151, "Zoé", "Deedes", "JavaScript", 8, 50));
        list.add(new Person2(152, "Gisèle", "Beatens", "sql", 6, 72));
        list.add(new Person2(153, "Anaïs", "Schoenrock", "PostgreSQL", 6, 34));
        list.add(new Person2(154, "Nuó", "Costen", "BBDD", 6, 34));
        list.add(new Person2(155, "Bérénice", "Jarvie", "Java", 1, 66));
        list.add(new Person2(156, "Sòng", "Foster", "react", 9, 55));
        list.add(new Person2(157, "Garçon", "Braferton", "Express", 2, 30));
        list.add(new Person2(158, "Marie-noël", "Lamplough", "NodeJs", 9, 21));
        list.add(new Person2(159, "Eloïse", "Beckwith", "MySQL", 10, 48));
        list.add(new Person2(160, "Gaétane", "Fereday", "Patrones de diseño", 4, 35));
        list.add(new Person2(161, "Bécassine", "Robiot", "odoo", 7, 59));
        list.add(new Person2(162, "Loïs", "Von Brook", "BBDD", 4, 60));
        list.add(new Person2(163, "Aimée", "Meagh", "Express", 9, 41));
        list.add(new Person2(164, "Yú", "Huggett", "react", 7, 39));
        list.add(new Person2(165, "Andréa", "Trott", "NodeJs", 10, 52));
        list.add(new Person2(166, "Mahélie", "Mintrim", "JavaScript", 9, 70));
        list.add(new Person2(167, "Méng", "Bollon", "BBDD", 2, 58));
        list.add(new Person2(168, "Léandre", "Footer", "NodeJs", 7, 62));
        list.add(new Person2(169, "Görel", "Houlston", "odoo", 8, 32));
        list.add(new Person2(170, "Naëlle", "Baughn", "Express", 8, 24));
        list.add(new Person2(171, "Océane", "Streetley", "Express", 1, 62));
        list.add(new Person2(172, "Alizée", "Geane", "BBDD", 3, 31));
        list.add(new Person2(173, "Eugénie", "Shirtcliffe", "Acceso a datos", 6, 62));
        list.add(new Person2(174, "Andrée", "Maiden", "MySQL", 7, 42));
        list.add(new Person2(175, "Clélia", "Rawlingson", "react", 2, 45));
        list.add(new Person2(176, "Salomé", "Starcks", "Patrones de diseño", 5, 70));
        list.add(new Person2(177, "Noëlla", "Zukierman", "MySQL", 9, 27));
        list.add(new Person2(178, "Edmée", "Cofax", "JavaScript", 6, 57));
        list.add(new Person2(179, "Gösta", "Hargreave", "Java", 8, 31));
        list.add(new Person2(180, "Marie-thérèse", "Silson", "PostgreSQL", 9, 51));
        list.add(new Person2(181, "Desirée", "Fortnam", "POO", 3, 69));
        list.add(new Person2(182, "Tú", "Blas", "odoo", 8, 52));
        list.add(new Person2(183, "Åslög", "Jedrzejewsky", "Java", 5, 28));
        list.add(new Person2(184, "Danièle", "Ryrie", "BBDD", 9, 34));
        list.add(new Person2(185, "Lauréna", "Lusted", "BBDD", 3, 58));
        list.add(new Person2(186, "Bénédicte", "Easterbrook", "Angular", 5, 67));
        list.add(new Person2(187, "Sòng", "Mollon", "Oracle", 3, 67));
        list.add(new Person2(188, "Naëlle", "Borley", "BBDD", 4, 62));
        list.add(new Person2(189, "Gaëlle", "Truran", "Patrones de diseño", 7, 59));
        list.add(new Person2(190, "Camélia", "Whybrow", "Express", 2, 40));
        list.add(new Person2(191, "Vénus", "Thombleson", "MySQL", 3, 47));
        list.add(new Person2(192, "Léa", "Rodrigo", "Angular", 10, 58));
        list.add(new Person2(193, "Östen", "Waple", "MySQL", 3, 38));
        list.add(new Person2(194, "Aimée", "McNeillie", "Oracle", 4, 70));
        list.add(new Person2(195, "Dafnée", "McCaghan", "XML", 8, 75));
        list.add(new Person2(196, "Yénora", "Daintry", "sql", 3, 38));
        list.add(new Person2(197, "Yénora", "Baldi", "XML", 2, 70));
        list.add(new Person2(198, "Maïlis", "Bronger", "Patrones de diseño", 5, 63));
        list.add(new Person2(199, "Andréa", "Redhouse", "Java", 2, 20));
        list.add(new Person2(200, "Lén", "Waddell", "NodeJs", 10, 73));
        list.add(new Person2(201, "Camélia", "Tebald", "Java", 9, 57));
        list.add(new Person2(202, "Aloïs", "Boner", "POO", 10, 41));
        list.add(new Person2(203, "Noëlla", "Dalgarnocht", "Oracle", 10, 74));
        list.add(new Person2(204, "Esbjörn", "Axtens", "JavaScript", 1, 55));
        list.add(new Person2(205, "Marie-josée", "Paten", "odoo", 10, 67));
        list.add(new Person2(206, "Rachèle", "Swanton", "Acceso a datos", 10, 25));
        list.add(new Person2(207, "André", "Selburn", "MySQL", 10, 42));
        list.add(new Person2(208, "Irène", "Scrase", "Patrones de diseño", 3, 22));
        list.add(new Person2(209, "Börje", "Humm", "Acceso a datos", 1, 23));
        list.add(new Person2(210, "Örjan", "Wilkinson", "NodeJs", 5, 69));
        list.add(new Person2(211, "Dà", "Oldacre", "Express", 1, 20));
        list.add(new Person2(212, "Amélie", "Saunter", "NodeJs", 7, 67));
        list.add(new Person2(213, "Judicaël", "Langfitt", "Express", 4, 31));
        list.add(new Person2(214, "Mylène", "Arnaudet", "BBDD", 4, 54));
        list.add(new Person2(215, "Aimée", "Lavall", "PostgreSQL", 8, 41));
        list.add(new Person2(216, "Eliès", "Chatwood", "MySQL", 4, 34));
        list.add(new Person2(217, "Maëly", "Kirkhouse", "POO", 8, 27));
        list.add(new Person2(218, "André", "Dashkov", "Patrones de diseño", 6, 28));
        list.add(new Person2(219, "Gaïa", "Kix", "Oracle", 1, 24));
        list.add(new Person2(220, "Kallisté", "Grog", "Patrones de diseño", 6, 48));
        list.add(new Person2(221, "Tú", "McElrea", "BBDD", 5, 19));
        list.add(new Person2(222, "Maëlle", "Lesor", "XML", 7, 36));
        list.add(new Person2(223, "Michèle", "Marielle", "Express", 4, 59));
        list.add(new Person2(224, "Maïly", "Bunson", "JavaScript", 6, 50));
        list.add(new Person2(225, "Mégane", "Foster", "BBDD", 9, 58));
        list.add(new Person2(226, "Séréna", "Slatford", "Express", 3, 51));
        list.add(new Person2(227, "Laïla", "Gaymer", "XML", 9, 57));
        list.add(new Person2(228, "Eléa", "Cotterel", "odoo", 1, 54));
        list.add(new Person2(229, "Cléa", "Scrooby", "MySQL", 2, 29));
        list.add(new Person2(230, "Lén", "Creffield", "PostgreSQL", 4, 62));
        list.add(new Person2(231, "Eloïse", "Castell", "odoo", 8, 52));
        list.add(new Person2(232, "Yáo", "Windham", "Acceso a datos", 2, 68));
        list.add(new Person2(233, "Méline", "Mathou", "MySQL", 7, 40));
        list.add(new Person2(234, "Régine", "Wafer", "JavaScript", 9, 35));
        list.add(new Person2(235, "Gaëlle", "Popov", "Java", 3, 27));
        list.add(new Person2(236, "Åslög", "Berriball", "Express", 4, 25));
        list.add(new Person2(237, "Irène", "Borg-Bartolo", "Patrones de diseño", 6, 65));
        list.add(new Person2(238, "Maïly", "Tomaszek", "NodeJs", 10, 24));
        list.add(new Person2(239, "Valérie", "Walkley", "Java", 1, 20));
        list.add(new Person2(240, "Daphnée", "Merritt", "Patrones de diseño", 4, 67));
        list.add(new Person2(241, "Léone", "Capponeer", "Java", 4, 69));
        list.add(new Person2(242, "Cécilia", "Grafton", "BBDD", 9, 54));
        list.add(new Person2(243, "Ophélie", "McNeachtain", "XML", 10, 59));
        list.add(new Person2(244, "Björn", "Obeney", "JavaScript", 5, 70));
        list.add(new Person2(245, "Amélie", "Antalffy", "POO", 5, 60));
        list.add(new Person2(246, "Angélique", "Greson", "sql", 10, 24));
        list.add(new Person2(247, "Marylène", "Ca", "Java", 5, 64));
        list.add(new Person2(248, "Léane", "Brookton", "MySQL", 5, 20));
        list.add(new Person2(249, "Mylène", "Firks", "JavaScript", 6, 69));
        list.add(new Person2(250, "Léonie", "Heaselgrave", "Java", 10, 40));
        list.add(new Person2(251, "Estée", "Le Page", "JavaScript", 7, 73));
        list.add(new Person2(252, "Östen", "Levesque", "XML", 1, 26));
        list.add(new Person2(253, "Lèi", "Dermot", "POO", 1, 42));
        list.add(new Person2(254, "Marie-hélène", "Campo", "Java", 8, 67));
        list.add(new Person2(255, "Mélys", "Blatherwick", "NodeJs", 1, 22));
        list.add(new Person2(256, "Mahélie", "Pentony", "odoo", 1, 46));
        list.add(new Person2(257, "Dà", "Morris", "POO", 5, 22));
        list.add(new Person2(258, "Dù", "Fice", "POO", 9, 70));
        list.add(new Person2(259, "Cécilia", "Kiljan", "odoo", 5, 19));
        list.add(new Person2(260, "Maïté", "Augur", "Patrones de diseño", 10, 33));
        list.add(new Person2(261, "Léa", "Merrgan", "Patrones de diseño", 10, 45));
        list.add(new Person2(262, "Märta", "Coupland", "BBDD", 3, 54));
        list.add(new Person2(263, "Angèle", "Milier", "Angular", 7, 54));
        list.add(new Person2(264, "Yóu", "Beynkn", "POO", 10, 22));
        list.add(new Person2(265, "Marie-ève", "Kynett", "Oracle", 2, 37));
        list.add(new Person2(266, "Angèle", "Berg", "NodeJs", 6, 27));
        list.add(new Person2(267, "Annotés", "Swadlinge", "BBDD", 6, 41));
        list.add(new Person2(268, "Marie-thérèse", "Irnis", "Java", 3, 63));
        list.add(new Person2(269, "Béatrice", "Litherborough", "Express", 10, 31));
        list.add(new Person2(270, "Gösta", "Delete", "PostgreSQL", 7, 27));
        list.add(new Person2(271, "Angélique", "Hicken", "Acceso a datos", 3, 30));
        list.add(new Person2(272, "Bérangère", "Brayn", "XML", 1, 71));
        list.add(new Person2(273, "Kuí", "Laffin", "MySQL", 10, 64));
        list.add(new Person2(274, "Eléonore", "Kenworthey", "odoo", 9, 63));
        list.add(new Person2(275, "Anaé", "Olivella", "Patrones de diseño", 8, 37));
        list.add(new Person2(276, "Edmée", "Doerffer", "NodeJs", 1, 56));
        list.add(new Person2(277, "Edmée", "Riolfo", "MySQL", 10, 22));
        list.add(new Person2(278, "Régine", "Gabbotts", "odoo", 10, 45));
        list.add(new Person2(279, "Mélys", "Kleynermans", "Patrones de diseño", 10, 35));
        list.add(new Person2(280, "Wá", "Matts", "Express", 6, 73));
        list.add(new Person2(281, "Eléonore", "Quilligan", "Angular", 1, 50));
        list.add(new Person2(282, "Marie-thérèse", "Dukes", "Patrones de diseño", 4, 20));
        list.add(new Person2(283, "Danièle", "Girk", "NodeJs", 6, 44));
        list.add(new Person2(284, "Josée", "Cantua", "NodeJs", 5, 60));
        list.add(new Person2(285, "Eliès", "Vasiljevic", "odoo", 3, 62));
        list.add(new Person2(286, "Marylène", "Burghall", "MySQL", 7, 69));
        list.add(new Person2(287, "Solène", "Cultcheth", "BBDD", 6, 73));
        list.add(new Person2(288, "Rébecca", "Ambrose", "PostgreSQL", 8, 21));
        list.add(new Person2(289, "Pål", "Hutchins", "react", 5, 28));
        list.add(new Person2(290, "Yáo", "Riha", "PostgreSQL", 9, 52));
        list.add(new Person2(291, "Gwenaëlle", "Topp", "Java", 3, 36));
        list.add(new Person2(292, "Loïca", "Granleese", "NodeJs", 8, 74));
        list.add(new Person2(293, "Publicité", "Tripney", "NodeJs", 5, 40));
        list.add(new Person2(294, "Pål", "Milbourne", "XML", 2, 60));
        list.add(new Person2(295, "Cléa", "Martinho", "react", 7, 19));
        list.add(new Person2(296, "Mén", "Neiland", "JavaScript", 1, 67));
        list.add(new Person2(297, "Solène", "Bahl", "sql", 6, 49));
        list.add(new Person2(298, "Mélinda", "Stansfield", "Java", 10, 67));
        list.add(new Person2(299, "Bénédicte", "Granleese", "PostgreSQL", 3, 64));
        list.add(new Person2(300, "Mårten", "Smales", "MySQL", 3, 34));
        list.add(new Person2(301, "Marie-thérèse", "Margetts", "MySQL", 10, 20));
        list.add(new Person2(302, "Lèi", "Schulkins", "sql", 7, 37));
        list.add(new Person2(303, "Noëlla", "Astlatt", "react", 9, 20));
        list.add(new Person2(304, "Bénédicte", "Race", "Java", 5, 62));
        list.add(new Person2(305, "Maëline", "Natalie", "Java", 5, 70));
        list.add(new Person2(306, "Kallisté", "Fandrich", "PostgreSQL", 5, 71));
        list.add(new Person2(307, "Géraldine", "Prosh", "Express", 2, 35));
        list.add(new Person2(308, "Maïlis", "Okker", "Patrones de diseño", 3, 45));
        list.add(new Person2(309, "Pål", "Ezzle", "XML", 4, 29));
        list.add(new Person2(310, "Mélodie", "Larvent", "NodeJs", 9, 35));
        list.add(new Person2(311, "Maïlis", "Honnicott", "XML", 2, 49));
        list.add(new Person2(312, "Maïlys", "MacTimpany", "Angular", 4, 46));
        list.add(new Person2(313, "Alizée", "Pennicott", "Angular", 6, 21));
        list.add(new Person2(314, "Andréanne", "Spybey", "Express", 3, 57));
        list.add(new Person2(315, "Adélaïde", "Stichall", "react", 2, 44));
        list.add(new Person2(316, "Aimée", "Cassie", "Oracle", 2, 37));
        list.add(new Person2(317, "Inès", "Tear", "POO", 10, 50));
        list.add(new Person2(318, "Léa", "Braganca", "Java", 6, 57));
        list.add(new Person2(319, "Zhì", "Philliskirk", "react", 2, 66));
        list.add(new Person2(320, "Edmée", "Asple", "PostgreSQL", 2, 27));
        list.add(new Person2(321, "Marylène", "Millward", "XML", 8, 72));
        list.add(new Person2(322, "Marie-ève", "Pinhorn", "Acceso a datos", 3, 50));
        list.add(new Person2(323, "Maïté", "Dorwood", "Java", 2, 43));
        list.add(new Person2(324, "Cléopatre", "Bichener", "Java", 8, 73));
        list.add(new Person2(325, "Marlène", "Fealy", "react", 10, 52));
        list.add(new Person2(326, "Célestine", "Staner", "Acceso a datos", 5, 44));
        list.add(new Person2(327, "Publicité", "MacDonell", "sql", 7, 56));
        list.add(new Person2(328, "Aimée", "Adelsberg", "sql", 1, 28));
        list.add(new Person2(329, "Laïla", "Bufton", "Angular", 3, 38));
        list.add(new Person2(330, "Géraldine", "Feather", "NodeJs", 10, 32));
        list.add(new Person2(331, "Dorothée", "Buggs", "MySQL", 8, 70));
        list.add(new Person2(332, "Mélanie", "Wane", "react", 9, 55));
        list.add(new Person2(333, "Pò", "Arman", "BBDD", 9, 59));
        list.add(new Person2(334, "Håkan", "Aspray", "MySQL", 9, 39));
        list.add(new Person2(335, "Lucrèce", "Routh", "Express", 5, 18));
        list.add(new Person2(336, "Solène", "Spirit", "Acceso a datos", 6, 18));
        list.add(new Person2(337, "Ruì", "Khomin", "XML", 1, 34));
        list.add(new Person2(338, "Yáo", "Uccello", "Acceso a datos", 1, 73));
        list.add(new Person2(339, "Kuí", "While", "Oracle", 5, 37));
        list.add(new Person2(340, "Bérénice", "Murthwaite", "NodeJs", 10, 20));
        list.add(new Person2(341, "Åsa", "Dewerson", "sql", 6, 31));
        list.add(new Person2(342, "Intéressant", "Fotheringham", "JavaScript", 4, 51));
        list.add(new Person2(343, "Maëlann", "Jaycox", "Oracle", 5, 62));
        list.add(new Person2(344, "Mén", "Denerley", "MySQL", 9, 24));
        list.add(new Person2(345, "Mélia", "Lagden", "Express", 9, 23));
        list.add(new Person2(346, "Laïla", "Bohden", "MySQL", 6, 55));
        list.add(new Person2(347, "Esbjörn", "Canero", "Oracle", 1, 44));
        list.add(new Person2(348, "Judicaël", "Matignon", "odoo", 2, 44));
        list.add(new Person2(349, "Célestine", "Cully", "PostgreSQL", 9, 66));
        list.add(new Person2(350, "Léonie", "Caramuscia", "odoo", 4, 33));
        list.add(new Person2(351, "Cécile", "Pentercost", "POO", 4, 41));
        list.add(new Person2(352, "Hélèna", "Wooland", "odoo", 10, 24));
        list.add(new Person2(353, "Jú", "Brodeau", "NodeJs", 2, 25));
        list.add(new Person2(354, "Intéressant", "Fraczkiewicz", "sql", 9, 69));
        list.add(new Person2(355, "Zhì", "Degg", "sql", 6, 32));
        list.add(new Person2(356, "Liè", "Diglin", "Oracle", 6, 36));
        list.add(new Person2(357, "Marylène", "Nuttey", "Java", 3, 70));
        list.add(new Person2(358, "Görel", "Priestley", "MySQL", 3, 44));
        list.add(new Person2(359, "Kévina", "Kristoffersson", "Oracle", 8, 18));
        list.add(new Person2(360, "Håkan", "McCleary", "POO", 8, 46));
        list.add(new Person2(361, "Loïc", "Maxworthy", "XML", 1, 45));
        list.add(new Person2(362, "Amélie", "Bircher", "Express", 7, 27));
        list.add(new Person2(363, "Liè", "Myford", "sql", 7, 32));
        list.add(new Person2(364, "Eléa", "Hiscocks", "Express", 3, 31));
        list.add(new Person2(365, "Océane", "Pelz", "BBDD", 6, 75));
        list.add(new Person2(366, "Almérinda", "Darby", "Java", 6, 74));
        list.add(new Person2(367, "Alizée", "Olner", "sql", 4, 72));
        list.add(new Person2(368, "Desirée", "Dolby", "MySQL", 8, 31));
        list.add(new Person2(369, "Nuó", "Augur", "Express", 9, 20));
        list.add(new Person2(370, "Kuí", "Wandrey", "NodeJs", 10, 29));
        list.add(new Person2(371, "Maëly", "Sheaber", "odoo", 7, 67));
        list.add(new Person2(372, "Edmée", "Hitzschke", "BBDD", 5, 38));
        list.add(new Person2(373, "Vérane", "O' Cuolahan", "PostgreSQL", 5, 50));
        list.add(new Person2(374, "Lóng", "Scampion", "sql", 8, 32));
        list.add(new Person2(375, "Adélaïde", "Newcomb", "sql", 5, 35));
        list.add(new Person2(376, "Lyséa", "Aldwich", "JavaScript", 3, 20));
        list.add(new Person2(377, "Esbjörn", "Cotter", "Acceso a datos", 3, 57));
        list.add(new Person2(378, "Océanne", "Cheesley", "Oracle", 7, 32));
        list.add(new Person2(379, "Vérane", "Inseal", "BBDD", 4, 54));
        list.add(new Person2(380, "Maëlle", "Smithen", "JavaScript", 3, 37));
        list.add(new Person2(381, "Edmée", "Fiddy", "Acceso a datos", 10, 22));
        list.add(new Person2(382, "Aí", "Goodanew", "NodeJs", 8, 67));
        list.add(new Person2(383, "Cécilia", "Piggins", "XML", 8, 57));
        list.add(new Person2(384, "Marie-hélène", "Winslow", "JavaScript", 2, 46));
        list.add(new Person2(385, "Personnalisée", "Pluthero", "Acceso a datos", 4, 34));
        list.add(new Person2(386, "Cloé", "Firbank", "POO", 7, 35));
        list.add(new Person2(387, "Magdalène", "Ricardet", "POO", 3, 69));
        list.add(new Person2(388, "Danièle", "Glassford", "MySQL", 9, 40));
        list.add(new Person2(389, "Edmée", "Limon", "NodeJs", 10, 18));
        list.add(new Person2(390, "Naéva", "Boles", "BBDD", 1, 39));
        list.add(new Person2(391, "Léandre", "Dayment", "Patrones de diseño", 5, 20));
        list.add(new Person2(392, "Laurène", "Sealove", "NodeJs", 10, 52));
        list.add(new Person2(393, "Thérèsa", "Picopp", "Java", 5, 24));
        list.add(new Person2(394, "Maïlys", "Dykas", "Oracle", 2, 21));
        list.add(new Person2(395, "Annotés", "Gillooly", "Express", 8, 57));
        list.add(new Person2(396, "Mélodie", "Jaime", "BBDD", 5, 22));
        list.add(new Person2(397, "Mélissandre", "Beet", "odoo", 7, 24));
        list.add(new Person2(398, "Maëly", "Stonebanks", "Oracle", 5, 57));
        list.add(new Person2(399, "Véronique", "Mulderrig", "PostgreSQL", 1, 29));
        list.add(new Person2(400, "Cécile", "Brodie", "MySQL", 2, 22));
        list.add(new Person2(401, "Stéphanie", "Clare", "Angular", 8, 60));
        list.add(new Person2(402, "Méghane", "Carn", "sql", 1, 34));
        list.add(new Person2(403, "Anaël", "Calvert", "sql", 6, 43));
        list.add(new Person2(404, "Bérengère", "Castello", "NodeJs", 10, 43));
        list.add(new Person2(405, "Nélie", "Prando", "PostgreSQL", 5, 46));
        list.add(new Person2(406, "Märta", "Maltster", "odoo", 4, 22));
        list.add(new Person2(407, "Fèi", "Bader", "JavaScript", 5, 29));
        list.add(new Person2(408, "Loïs", "Canfer", "PostgreSQL", 10, 60));
        list.add(new Person2(409, "Laïla", "Darwen", "PostgreSQL", 1, 72));
        list.add(new Person2(410, "Personnalisée", "Cooley", "Angular", 3, 63));
        list.add(new Person2(411, "Clélia", "Pyett", "Express", 7, 69));
        list.add(new Person2(412, "Thérèse", "Shercliff", "POO", 2, 73));
        list.add(new Person2(413, "Eugénie", "Creser", "MySQL", 1, 27));
        list.add(new Person2(414, "Naëlle", "Whybrow", "sql", 5, 47));
        list.add(new Person2(415, "Maëlann", "Andrassy", "Patrones de diseño", 8, 29));
        list.add(new Person2(416, "Régine", "Tym", "Java", 9, 48));
        list.add(new Person2(417, "Personnalisée", "Rooze", "PostgreSQL", 7, 45));
        list.add(new Person2(418, "Méghane", "Goter", "Java", 5, 53));
        list.add(new Person2(419, "Marie-noël", "Spillane", "BBDD", 6, 69));
        list.add(new Person2(420, "Béatrice", "Cutmore", "MySQL", 2, 38));
        list.add(new Person2(421, "Eliès", "Baitman", "JavaScript", 3, 69));
        list.add(new Person2(422, "Aimée", "Hitscher", "odoo", 10, 22));
        list.add(new Person2(423, "Maïlis", "Scawn", "Oracle", 5, 49));
        list.add(new Person2(424, "Marie-hélène", "Krzysztof", "POO", 2, 43));
        list.add(new Person2(425, "Yénora", "Stoving", "Java", 3, 41));
        list.add(new Person2(426, "Médiamass", "Gerrill", "Angular", 3, 73));
        list.add(new Person2(427, "Cléa", "Vittery", "NodeJs", 1, 32));
        list.add(new Person2(428, "Marie-thérèse", "de Villier", "odoo", 4, 40));
        list.add(new Person2(429, "Félicie", "Sutheran", "BBDD", 6, 28));
        list.add(new Person2(430, "Wá", "Kornacki", "POO", 8, 72));
        list.add(new Person2(431, "Nélie", "Edwick", "POO", 1, 68));
        list.add(new Person2(432, "Eléonore", "Coode", "MySQL", 4, 39));
        list.add(new Person2(433, "Miléna", "Gowdridge", "react", 5, 29));
        list.add(new Person2(434, "Adèle", "Ecclestone", "POO", 6, 62));
        list.add(new Person2(435, "Lyséa", "Eric", "MySQL", 2, 29));
        list.add(new Person2(436, "Marie-noël", "Ridett", "Express", 6, 43));
        list.add(new Person2(437, "Torbjörn", "Cheer", "BBDD", 9, 41));
        list.add(new Person2(438, "Naëlle", "Gummow", "Java", 3, 38));
        list.add(new Person2(439, "Méghane", "Impett", "PostgreSQL", 10, 27));
        list.add(new Person2(440, "Zhì", "Stedell", "MySQL", 4, 53));
        list.add(new Person2(441, "Léandre", "Dougan", "Java", 10, 45));
        list.add(new Person2(442, "Stéphanie", "Bingall", "react", 9, 51));
        list.add(new Person2(443, "Marie-ève", "Danzelman", "Angular", 1, 57));
        list.add(new Person2(444, "Frédérique", "Whale", "Oracle", 5, 30));
        list.add(new Person2(445, "Anaël", "Rusk", "NodeJs", 8, 73));
        list.add(new Person2(446, "Mélys", "Henzer", "POO", 5, 54));
        list.add(new Person2(447, "Valérie", "Roderighi", "odoo", 7, 49));
        list.add(new Person2(448, "Märta", "Masdon", "Oracle", 6, 26));
        list.add(new Person2(449, "Lauréna", "Tregea", "POO", 10, 41));
        list.add(new Person2(450, "Maëlla", "Chitham", "NodeJs", 8, 25));
        list.add(new Person2(451, "Zhì", "Borgesio", "PostgreSQL", 6, 75));
        list.add(new Person2(452, "Camélia", "Mattaus", "Angular", 9, 32));
        list.add(new Person2(453, "Åsa", "Oby", "Patrones de diseño", 5, 25));
        list.add(new Person2(454, "Cléa", "Flacknoe", "MySQL", 6, 47));
        list.add(new Person2(455, "Frédérique", "Ife", "Express", 10, 43));
        list.add(new Person2(456, "Edmée", "Bardey", "Angular", 9, 64));
        list.add(new Person2(457, "Görel", "Talloe", "PostgreSQL", 10, 64));
        list.add(new Person2(458, "Léana", "Alphonso", "PostgreSQL", 9, 36));
        list.add(new Person2(459, "Anaé", "Aymerich", "Express", 9, 51));
        list.add(new Person2(460, "Athéna", "Emerine", "react", 4, 21));
        list.add(new Person2(461, "Erwéi", "Deverell", "Oracle", 7, 35));
        list.add(new Person2(462, "Michèle", "Colles", "XML", 1, 46));
        list.add(new Person2(463, "Anaëlle", "Blackaller", "react", 4, 70));
        list.add(new Person2(464, "Bécassine", "Rodden", "MySQL", 2, 61));
        list.add(new Person2(465, "Åke", "Ralls", "odoo", 9, 51));
        list.add(new Person2(466, "Loïc", "Withull", "odoo", 2, 29));
        list.add(new Person2(467, "Rachèle", "Garnsey", "PostgreSQL", 1, 57));
        list.add(new Person2(468, "Bécassine", "Folbige", "Angular", 2, 59));
        list.add(new Person2(469, "Maëlla", "Genge", "XML", 4, 50));
        list.add(new Person2(470, "Cloé", "Gaudin", "Angular", 7, 47));
        list.add(new Person2(471, "Bénédicte", "McGhie", "Angular", 9, 65));
        list.add(new Person2(472, "Mahélie", "Brockway", "Java", 5, 38));
        list.add(new Person2(473, "Publicité", "Weatherup", "odoo", 9, 41));
        list.add(new Person2(474, "Yóu", "Hardistry", "Oracle", 6, 42));
        list.add(new Person2(475, "Naëlle", "Tolomei", "XML", 9, 74));
        list.add(new Person2(476, "Maïté", "Klarzynski", "Express", 2, 49));
        list.add(new Person2(477, "Naéva", "Smales", "Java", 4, 69));
        list.add(new Person2(478, "Bérénice", "Brodway", "react", 10, 61));
        list.add(new Person2(479, "Sòng", "Coggell", "POO", 6, 65));
        list.add(new Person2(480, "Sòng", "Robertz", "Express", 6, 37));
        list.add(new Person2(481, "Yóu", "Arber", "Acceso a datos", 2, 42));
        list.add(new Person2(482, "Wá", "Dignall", "Java", 7, 60));
        list.add(new Person2(483, "Chloé", "Renoden", "MySQL", 8, 71));
        list.add(new Person2(484, "Lài", "Olyfant", "Oracle", 4, 73));
        list.add(new Person2(485, "Märta", "Emblem", "Acceso a datos", 6, 38));
        list.add(new Person2(486, "Tú", "Pinfold", "Patrones de diseño", 3, 64));
        list.add(new Person2(487, "Almérinda", "Veare", "PostgreSQL", 3, 71));
        list.add(new Person2(488, "Mà", "Linwood", "react", 2, 35));
        list.add(new Person2(489, "Torbjörn", "Denziloe", "sql", 2, 72));
        list.add(new Person2(490, "Léa", "Currum", "XML", 2, 75));
        list.add(new Person2(491, "Loïs", "Ivanenkov", "BBDD", 10, 18));
        list.add(new Person2(492, "Eloïse", "Astley", "Express", 10, 19));
        list.add(new Person2(493, "Liè", "Thoday", "Angular", 5, 47));
        list.add(new Person2(494, "Gwenaëlle", "Zecchii", "Java", 1, 75));
        list.add(new Person2(495, "Annotés", "Beddie", "POO", 5, 36));
        list.add(new Person2(496, "Illustrée", "Vannuccini", "JavaScript", 7, 24));
        list.add(new Person2(497, "Marylène", "Flintoft", "sql", 1, 60));
        list.add(new Person2(498, "Illustrée", "Boddam", "XML", 6, 21));
        list.add(new Person2(499, "Intéressant", "Alders", "react", 4, 29));
        list.add(new Person2(500, "Örjan", "Pitcaithly", "Acceso a datos", 8, 57));
        list.add(new Person2(501, "Naéva", "Fulep", "BBDD", 6, 25));
        list.add(new Person2(502, "Alizée", "Burston", "PostgreSQL", 8, 22));
        list.add(new Person2(503, "Uò", "Binham", "XML", 6, 44));
        list.add(new Person2(504, "Anaé", "Southern", "react", 4, 32));
        list.add(new Person2(505, "Noëlla", "Camois", "Patrones de diseño", 5, 65));
        list.add(new Person2(506, "Publicité", "Ewols", "NodeJs", 2, 71));
        list.add(new Person2(507, "Maïwenn", "Snipe", "NodeJs", 9, 63));
        list.add(new Person2(508, "Táng", "Joost", "NodeJs", 6, 22));
        list.add(new Person2(509, "Dafnée", "Leinthall", "BBDD", 5, 66));
        list.add(new Person2(510, "Marie-noël", "Hardy", "Angular", 1, 32));
        list.add(new Person2(511, "Maïlis", "Thomke", "react", 9, 21));
        list.add(new Person2(512, "Stévina", "Martinelli", "JavaScript", 1, 36));
        list.add(new Person2(513, "Styrbjörn", "Dormer", "sql", 4, 60));
        list.add(new Person2(514, "Marie-thérèse", "Maddy", "XML", 7, 48));
        list.add(new Person2(515, "Néhémie", "Dyter", "PostgreSQL", 7, 52));
        list.add(new Person2(516, "Maï", "Larham", "Express", 9, 58));
        list.add(new Person2(517, "Mà", "Livzey", "Oracle", 8, 28));
        list.add(new Person2(518, "Stévina", "Phillot", "odoo", 1, 61));
        list.add(new Person2(519, "Daphnée", "Caseley", "odoo", 7, 62));
        list.add(new Person2(520, "Mårten", "Simes", "sql", 9, 33));
        list.add(new Person2(521, "Marie-josée", "Le Estut", "Patrones de diseño", 5, 63));
        list.add(new Person2(522, "Märta", "Caltun", "POO", 8, 51));
        list.add(new Person2(523, "Pélagie", "Hawthorn", "Express", 1, 53));
        list.add(new Person2(524, "Laïla", "Zanre", "XML", 6, 47));
        list.add(new Person2(525, "Lorène", "Vondra", "MySQL", 6, 68));
        list.add(new Person2(526, "Jú", "Frigot", "Angular", 2, 28));
        list.add(new Person2(527, "Laïla", "Siebert", "PostgreSQL", 10, 57));
        list.add(new Person2(528, "Dafnée", "Allett", "Angular", 6, 66));
        list.add(new Person2(529, "Mélys", "Counsell", "XML", 2, 65));
        list.add(new Person2(530, "Jú", "Pecht", "Express", 2, 39));
        list.add(new Person2(531, "Athéna", "Bamford", "Patrones de diseño", 4, 59));
        list.add(new Person2(532, "Publicité", "Scamadin", "JavaScript", 6, 26));
        list.add(new Person2(533, "Adélaïde", "Challis", "XML", 1, 35));
        list.add(new Person2(534, "Agnès", "Ozintsev", "sql", 5, 36));
        list.add(new Person2(535, "Mélanie", "Thorrold", "POO", 1, 63));
        list.add(new Person2(536, "Joséphine", "Moorcraft", "Java", 5, 68));
        list.add(new Person2(537, "Laïla", "Wrigley", "JavaScript", 4, 51));
        list.add(new Person2(538, "Miléna", "Aiton", "Patrones de diseño", 3, 34));
        list.add(new Person2(539, "Maïté", "Hurne", "BBDD", 2, 57));
        list.add(new Person2(540, "Léonie", "Gillmore", "NodeJs", 5, 57));
        list.add(new Person2(541, "Andréa", "Bondar", "odoo", 3, 48));
        list.add(new Person2(542, "Táng", "Wippermann", "Patrones de diseño", 9, 57));
        list.add(new Person2(543, "Athéna", "Peevor", "sql", 2, 39));
        list.add(new Person2(544, "Anaël", "Scallon", "Java", 6, 56));
        list.add(new Person2(545, "Sélène", "Tallet", "MySQL", 5, 52));
        list.add(new Person2(546, "Mà", "Rummer", "Patrones de diseño", 6, 37));
        list.add(new Person2(547, "Almérinda", "Kline", "react", 8, 32));
        list.add(new Person2(548, "Görel", "Syne", "POO", 10, 33));
        list.add(new Person2(549, "Agnès", "Jendrach", "NodeJs", 9, 58));
        list.add(new Person2(550, "Estée", "Moffett", "NodeJs", 1, 59));
        list.add(new Person2(551, "Maëlys", "Liles", "POO", 2, 68));
        list.add(new Person2(552, "Torbjörn", "Mains", "Oracle", 4, 34));
        list.add(new Person2(553, "Léonie", "Jedrychowski", "Acceso a datos", 4, 24));
        list.add(new Person2(554, "Esbjörn", "Skentelbery", "Angular", 2, 39));
        list.add(new Person2(555, "Céline", "Ghiotto", "NodeJs", 3, 52));
        list.add(new Person2(556, "Marie-hélène", "Broddle", "Java", 5, 74));
        list.add(new Person2(557, "Loïs", "Cubberley", "POO", 3, 37));
        list.add(new Person2(558, "Mélinda", "Tregidga", "Oracle", 3, 19));
        list.add(new Person2(559, "Dà", "Sharply", "XML", 9, 18));
        list.add(new Person2(560, "Léandre", "Hehl", "JavaScript", 6, 23));
        list.add(new Person2(561, "Eléonore", "McPhate", "XML", 5, 75));
        list.add(new Person2(562, "Sélène", "Morgon", "XML", 7, 55));
        list.add(new Person2(563, "Mégane", "Braidon", "Java", 9, 61));
        list.add(new Person2(564, "Annotée", "Creyke", "POO", 5, 40));
        list.add(new Person2(565, "Véronique", "Pettis", "POO", 10, 40));
        list.add(new Person2(566, "Inès", "Plaunch", "BBDD", 4, 23));
        list.add(new Person2(567, "Mahélie", "Dumbreck", "NodeJs", 2, 69));
        list.add(new Person2(568, "Liè", "Kerfut", "odoo", 9, 62));
        list.add(new Person2(569, "Adélaïde", "Pemberton", "NodeJs", 8, 65));
        list.add(new Person2(570, "Tú", "Seywood", "NodeJs", 8, 19));
        list.add(new Person2(571, "Mylène", "Hallock", "Acceso a datos", 5, 61));
        list.add(new Person2(572, "Athéna", "Gladtbach", "NodeJs", 1, 50));
        list.add(new Person2(573, "Joséphine", "Weal", "NodeJs", 1, 65));
        list.add(new Person2(574, "Lèi", "Deem", "MySQL", 2, 68));
        list.add(new Person2(575, "Thérèse", "Stenet", "odoo", 5, 50));
        list.add(new Person2(576, "Maëline", "Kalaher", "PostgreSQL", 7, 59));
        list.add(new Person2(577, "Stéphanie", "Wrinch", "Acceso a datos", 8, 24));
        list.add(new Person2(578, "Andréanne", "Liddon", "Express", 1, 49));
        list.add(new Person2(579, "Håkan", "Iacobetto", "PostgreSQL", 6, 65));
        list.add(new Person2(580, "Bérénice", "Wingate", "POO", 10, 73));
        list.add(new Person2(581, "Pénélope", "Bougourd", "PostgreSQL", 8, 62));
        list.add(new Person2(582, "Mégane", "Broske", "MySQL", 3, 37));
        list.add(new Person2(583, "Léana", "Kinney", "Angular", 7, 22));
        list.add(new Person2(584, "Régine", "Portman", "BBDD", 7, 33));
        list.add(new Person2(585, "Intéressant", "Stiffkins", "NodeJs", 1, 35));
        list.add(new Person2(586, "Publicité", "Emerton", "NodeJs", 5, 55));
        list.add(new Person2(587, "Noémie", "Elven", "BBDD", 8, 52));
        list.add(new Person2(588, "Desirée", "Laugherane", "PostgreSQL", 3, 61));
        list.add(new Person2(589, "Maï", "Connichie", "BBDD", 6, 41));
        list.add(new Person2(590, "Mélinda", "Fausset", "Acceso a datos", 9, 53));
        list.add(new Person2(591, "Michèle", "Voase", "sql", 6, 53));
        list.add(new Person2(592, "Yénora", "Gillman", "XML", 8, 54));
        list.add(new Person2(593, "Alizée", "Stiegar", "Acceso a datos", 9, 31));
        list.add(new Person2(594, "Véronique", "Cottage", "odoo", 5, 37));
        list.add(new Person2(595, "Marie-josée", "Giles", "POO", 5, 46));
        list.add(new Person2(596, "Clémence", "Beckensall", "BBDD", 8, 30));
        list.add(new Person2(597, "Adélaïde", "Learoid", "Patrones de diseño", 4, 45));
        list.add(new Person2(598, "Lài", "Daye", "MySQL", 2, 51));
        list.add(new Person2(599, "Aimée", "Borrell", "XML", 8, 58));
        list.add(new Person2(600, "Publicité", "Gumb", "MySQL", 10, 45));
        list.add(new Person2(601, "Simplifiés", "Elcome", "react", 7, 48));
        list.add(new Person2(602, "André", "Corking", "PostgreSQL", 4, 44));
        list.add(new Person2(603, "Lucrèce", "Curnokk", "JavaScript", 2, 69));
        list.add(new Person2(604, "Véronique", "Emby", "Patrones de diseño", 7, 45));
        list.add(new Person2(605, "Méghane", "Balm", "Express", 2, 42));
        list.add(new Person2(606, "Geneviève", "Boustead", "BBDD", 5, 70));
        list.add(new Person2(607, "Ruò", "Laphorn", "PostgreSQL", 2, 25));
        list.add(new Person2(608, "Thérèsa", "Slessor", "Acceso a datos", 2, 57));
        list.add(new Person2(609, "Lèi", "Wellstood", "Oracle", 8, 75));
        list.add(new Person2(610, "Maïlys", "Faughny", "Patrones de diseño", 4, 35));
        list.add(new Person2(611, "Régine", "Mathews", "react", 9, 68));
        list.add(new Person2(612, "Vérane", "Kulis", "odoo", 9, 29));
        list.add(new Person2(613, "Lèi", "Swinley", "JavaScript", 5, 74));
        list.add(new Person2(614, "Zoé", "De Roos", "Java", 1, 31));
        list.add(new Person2(615, "Zoé", "Hulstrom", "Java", 6, 40));
        list.add(new Person2(616, "Lèi", "Chartres", "react", 1, 68));
        list.add(new Person2(617, "Célestine", "Haselgrove", "Express", 2, 29));
        list.add(new Person2(618, "Laïla", "Wrench", "Java", 9, 25));
        list.add(new Person2(619, "Méryl", "MacLure", "Patrones de diseño", 9, 42));
        list.add(new Person2(620, "Régine", "Mottley", "Express", 10, 52));
        list.add(new Person2(621, "Görel", "Youthed", "MySQL", 4, 47));
        list.add(new Person2(622, "Clémence", "Donisthorpe", "JavaScript", 9, 64));
        list.add(new Person2(623, "Faîtes", "Cansdill", "POO", 1, 38));
        list.add(new Person2(624, "Bérengère", "Le Barr", "Java", 9, 59));
        list.add(new Person2(625, "Léone", "Yankin", "Oracle", 4, 50));
        list.add(new Person2(626, "Stéphanie", "Master", "Acceso a datos", 6, 27));
        list.add(new Person2(627, "Marlène", "Wasmuth", "Acceso a datos", 5, 51));
        list.add(new Person2(628, "Lèi", "Sole", "Angular", 5, 36));
        list.add(new Person2(629, "Athéna", "Marle", "XML", 4, 28));
        list.add(new Person2(630, "Anaëlle", "Northgraves", "Java", 3, 37));
        list.add(new Person2(631, "Björn", "Kurdani", "Oracle", 8, 52));
        list.add(new Person2(632, "Marie-hélène", "Chillcot", "react", 5, 22));
        list.add(new Person2(633, "Maëly", "Jeste", "sql", 6, 70));
        list.add(new Person2(634, "Annotés", "Winfindale", "odoo", 9, 36));
        list.add(new Person2(635, "Kévina", "Viollet", "BBDD", 10, 45));
        list.add(new Person2(636, "Maëlys", "Jobbing", "odoo", 10, 46));
        list.add(new Person2(637, "Léa", "Daid", "Oracle", 4, 21));
        list.add(new Person2(638, "Annotée", "Macieja", "NodeJs", 7, 33));
        list.add(new Person2(639, "Wá", "Puddefoot", "Acceso a datos", 5, 32));
        list.add(new Person2(640, "Vérane", "Brugh", "BBDD", 5, 31));
        list.add(new Person2(641, "Méng", "Riccio", "NodeJs", 6, 68));
        list.add(new Person2(642, "Hélène", "Edmonstone", "POO", 3, 52));
        list.add(new Person2(643, "Mélodie", "Arnolds", "NodeJs", 7, 75));
        list.add(new Person2(644, "Maïlys", "Simonin", "react", 10, 37));
        list.add(new Person2(645, "Hélèna", "Vel", "Angular", 3, 67));
        list.add(new Person2(646, "Cléopatre", "Grantham", "Acceso a datos", 3, 52));
        list.add(new Person2(647, "Gösta", "Tayler", "Angular", 6, 71));
        list.add(new Person2(648, "Eliès", "Mathissen", "BBDD", 6, 39));
        list.add(new Person2(649, "Océanne", "McEnhill", "Oracle", 4, 70));
        list.add(new Person2(650, "Ruì", "Imison", "XML", 1, 33));
        list.add(new Person2(651, "Wá", "Ladewig", "odoo", 4, 48));
        list.add(new Person2(652, "Edmée", "Skyner", "MySQL", 3, 53));
        list.add(new Person2(653, "Bénédicte", "Hadden", "Patrones de diseño", 4, 54));
        list.add(new Person2(654, "Mélys", "Plummer", "odoo", 8, 56));
        list.add(new Person2(655, "Léandre", "Keyser", "JavaScript", 3, 27));
        list.add(new Person2(656, "Lauréna", "Tromans", "BBDD", 9, 18));
        list.add(new Person2(657, "Cécilia", "Gillivrie", "XML", 5, 38));
        list.add(new Person2(658, "Clémentine", "Sheaf", "NodeJs", 5, 60));
        list.add(new Person2(659, "Léone", "Dorsey", "react", 2, 67));
        list.add(new Person2(660, "Lèi", "Strathern", "sql", 7, 63));
        list.add(new Person2(661, "Lèi", "Cecchi", "Express", 3, 67));
        list.add(new Person2(662, "Ráo", "Luety", "Patrones de diseño", 3, 22));
        list.add(new Person2(663, "Chloé", "Kennett", "Angular", 2, 21));
        list.add(new Person2(664, "Lài", "Wand", "Express", 6, 69));
        list.add(new Person2(665, "Lóng", "Frarey", "JavaScript", 6, 45));
        list.add(new Person2(666, "Anaé", "Yendle", "JavaScript", 7, 53));
        list.add(new Person2(667, "Océanne", "Stoney", "Acceso a datos", 10, 74));
        list.add(new Person2(668, "Mà", "Wood", "MySQL", 4, 75));
        list.add(new Person2(669, "Méline", "Scane", "odoo", 9, 60));
        list.add(new Person2(670, "Yú", "Malins", "POO", 1, 66));
        list.add(new Person2(671, "Véronique", "Fairhead", "Angular", 4, 68));
        list.add(new Person2(672, "Réservés", "Lammiman", "BBDD", 5, 46));
        list.add(new Person2(673, "Tán", "Barsby", "JavaScript", 6, 21));
        list.add(new Person2(674, "Mårten", "Sanzio", "Angular", 6, 57));
        list.add(new Person2(675, "Bérengère", "Greenough", "XML", 10, 40));
        list.add(new Person2(676, "Cléopatre", "Huddart", "sql", 9, 25));
        list.add(new Person2(677, "Camélia", "Davers", "Express", 8, 57));
        list.add(new Person2(678, "Mélanie", "Prover", "JavaScript", 4, 75));
        list.add(new Person2(679, "Crééz", "Hanretty", "odoo", 6, 75));
        list.add(new Person2(680, "Camélia", "Rebert", "sql", 7, 55));
        list.add(new Person2(681, "Pò", "Lapere", "Angular", 3, 39));
        list.add(new Person2(682, "Maïwenn", "Woodes", "Oracle", 3, 26));
        list.add(new Person2(683, "Cinéma", "McAuslene", "Java", 1, 24));
        list.add(new Person2(684, "Amélie", "Safell", "PostgreSQL", 7, 60));
        list.add(new Person2(685, "Réservés", "Dukesbury", "PostgreSQL", 8, 55));
        list.add(new Person2(686, "Anaël", "Belvin", "MySQL", 6, 31));
        list.add(new Person2(687, "Cléopatre", "MacRirie", "PostgreSQL", 6, 25));
        list.add(new Person2(688, "Pélagie", "Bolitho", "XML", 2, 59));
        list.add(new Person2(689, "Médiamass", "Jura", "Java", 10, 65));
        list.add(new Person2(690, "Andrée", "Bettaney", "sql", 3, 25));
        list.add(new Person2(691, "Fèi", "Veasey", "Angular", 2, 75));
        list.add(new Person2(692, "Mélina", "Carus", "NodeJs", 6, 58));
        list.add(new Person2(693, "Aloïs", "Ingerson", "odoo", 9, 34));
        list.add(new Person2(694, "Clémence", "Cherm", "PostgreSQL", 10, 30));
        list.add(new Person2(695, "Gisèle", "Ripley", "Oracle", 1, 70));
        list.add(new Person2(696, "Maëline", "Shier", "Java", 1, 67));
        list.add(new Person2(697, "Naëlle", "Block", "NodeJs", 5, 40));
        list.add(new Person2(698, "Médiamass", "Westmancoat", "XML", 2, 73));
        list.add(new Person2(699, "Gérald", "Gobeau", "Express", 4, 71));
        list.add(new Person2(700, "Andréanne", "Mayho", "XML", 4, 38));
        list.add(new Person2(701, "Björn", "Ronca", "MySQL", 7, 40));
        list.add(new Person2(702, "Maïly", "Maudson", "Express", 2, 30));
        list.add(new Person2(703, "Märta", "Tolomelli", "Java", 8, 20));
        list.add(new Person2(704, "Laurélie", "Charity", "JavaScript", 5, 26));
        list.add(new Person2(705, "Andrée", "Ritmeier", "POO", 3, 66));
        list.add(new Person2(706, "Gaëlle", "Essam", "NodeJs", 10, 31));
        list.add(new Person2(707, "Mélina", "Crummay", "JavaScript", 2, 54));
        list.add(new Person2(708, "Cécilia", "O'Coskerry", "XML", 7, 59));
        list.add(new Person2(709, "Alizée", "Simonsson", "odoo", 4, 72));
        list.add(new Person2(710, "Maëly", "Jemison", "Angular", 4, 75));
        list.add(new Person2(711, "Ruò", "Iacovucci", "sql", 9, 75));
        list.add(new Person2(712, "Yáo", "Kernocke", "Express", 4, 36));
        list.add(new Person2(713, "Mélys", "Verling", "react", 1, 53));
        list.add(new Person2(714, "Inès", "Budden", "BBDD", 7, 74));
        list.add(new Person2(715, "Åsa", "Revie", "Oracle", 8, 63));
        list.add(new Person2(716, "Naëlle", "Rigbye", "Java", 2, 39));
        list.add(new Person2(717, "Stévina", "Cawthorn", "POO", 6, 33));
        list.add(new Person2(718, "Yè", "Paxforde", "Express", 8, 20));
        list.add(new Person2(719, "Marlène", "McCahey", "sql", 7, 64));
        list.add(new Person2(720, "Méline", "Stimson", "odoo", 8, 37));
        list.add(new Person2(721, "Noëlla", "Alten", "Angular", 1, 21));
        list.add(new Person2(722, "Réjane", "Gianninotti", "odoo", 10, 55));
        list.add(new Person2(723, "Hélène", "Chastang", "Patrones de diseño", 8, 47));
        list.add(new Person2(724, "Kuí", "Bransgrove", "NodeJs", 2, 37));
        list.add(new Person2(725, "Dà", "Archdeckne", "XML", 4, 23));
        list.add(new Person2(726, "Nadège", "Kerbler", "react", 10, 65));
        list.add(new Person2(727, "Crééz", "Bowshire", "PostgreSQL", 2, 59));
        list.add(new Person2(728, "Maï", "Barker", "Acceso a datos", 5, 48));
        list.add(new Person2(729, "Anaël", "MacLachlan", "BBDD", 4, 35));
        list.add(new Person2(730, "Göran", "Legen", "Java", 9, 58));
        list.add(new Person2(731, "Bérangère", "Garatty", "JavaScript", 9, 72));
        list.add(new Person2(732, "Mårten", "Baxill", "sql", 2, 39));
        list.add(new Person2(733, "Léa", "Dartnall", "Express", 7, 64));
        list.add(new Person2(734, "Eléonore", "Pratley", "sql", 7, 62));
        list.add(new Person2(735, "Kù", "Vise", "odoo", 10, 38));
        list.add(new Person2(736, "Mylène", "Fancott", "Patrones de diseño", 4, 31));
        list.add(new Person2(737, "Méryl", "Perrie", "Express", 4, 42));
        list.add(new Person2(738, "Göran", "Mailes", "Oracle", 6, 24));
        list.add(new Person2(739, "Mélia", "Mountcastle", "BBDD", 10, 51));
        list.add(new Person2(740, "Göran", "Airs", "Angular", 8, 22));
        list.add(new Person2(741, "Léandre", "Lealle", "Patrones de diseño", 9, 39));
        list.add(new Person2(742, "Nélie", "Liccardo", "Java", 8, 48));
        list.add(new Person2(743, "Noémie", "Smythe", "NodeJs", 5, 71));
        list.add(new Person2(744, "Yú", "Stonnell", "NodeJs", 6, 65));
        list.add(new Person2(745, "Publicité", "Gencke", "MySQL", 9, 27));
        list.add(new Person2(746, "Lài", "Cottle", "sql", 4, 43));
        list.add(new Person2(747, "Séverine", "Hazzard", "Oracle", 9, 74));
        list.add(new Person2(748, "Adélaïde", "Morais", "XML", 4, 73));
        list.add(new Person2(749, "Séverine", "Purches", "POO", 9, 34));
        list.add(new Person2(750, "Noémie", "McMeeking", "BBDD", 2, 51));
        list.add(new Person2(751, "Nélie", "Raspel", "NodeJs", 3, 20));
        list.add(new Person2(752, "Edmée", "Busch", "Oracle", 9, 52));
        list.add(new Person2(753, "Maëlyss", "Imloch", "Acceso a datos", 8, 73));
        list.add(new Person2(754, "Laurène", "Battrum", "NodeJs", 4, 20));
        list.add(new Person2(755, "Bénédicte", "Bratt", "MySQL", 7, 66));
        list.add(new Person2(756, "Mélodie", "Coomes", "BBDD", 8, 52));
        list.add(new Person2(757, "Mélia", "Radbone", "BBDD", 5, 56));
        list.add(new Person2(758, "Audréanne", "Malkinson", "JavaScript", 9, 55));
        list.add(new Person2(759, "Lóng", "Hurt", "JavaScript", 6, 55));
        list.add(new Person2(760, "Alizée", "Finch", "PostgreSQL", 10, 30));
        list.add(new Person2(761, "Wá", "Josefson", "JavaScript", 1, 41));
        list.add(new Person2(762, "Lyséa", "Dudin", "react", 8, 46));
        list.add(new Person2(763, "Simplifiés", "Toretta", "react", 2, 62));
        list.add(new Person2(764, "Adélie", "Giff", "XML", 8, 58));
        list.add(new Person2(765, "Loïca", "Pinney", "XML", 8, 61));
        list.add(new Person2(766, "Béatrice", "Haglington", "NodeJs", 7, 54));
        list.add(new Person2(767, "Stéphanie", "Zanioletti", "PostgreSQL", 2, 21));
        list.add(new Person2(768, "Sélène", "Hyams", "POO", 9, 57));
        list.add(new Person2(769, "Bécassine", "Lethardy", "MySQL", 6, 73));
        list.add(new Person2(770, "Dafnée", "Coare", "Angular", 5, 54));
        list.add(new Person2(771, "Crééz", "Prine", "BBDD", 3, 72));
        list.add(new Person2(772, "Uò", "Jennings", "PostgreSQL", 3, 20));
        list.add(new Person2(773, "Salomé", "Dalrymple", "Oracle", 9, 41));
        list.add(new Person2(774, "Måns", "Halleybone", "PostgreSQL", 1, 19));
        list.add(new Person2(775, "Méghane", "Rawling", "Oracle", 3, 64));
        list.add(new Person2(776, "Yè", "Sugar", "POO", 1, 59));
        list.add(new Person2(777, "Mélanie", "Maybury", "PostgreSQL", 7, 54));
        list.add(new Person2(778, "Yú", "Ship", "Angular", 2, 21));
        list.add(new Person2(779, "Noëlla", "Gentile", "Express", 8, 73));
        list.add(new Person2(780, "Bérengère", "Humberstone", "POO", 6, 44));
        list.add(new Person2(781, "Daphnée", "Foddy", "sql", 3, 31));
        list.add(new Person2(782, "Bérengère", "Scutchin", "MySQL", 6, 41));
        list.add(new Person2(783, "Naéva", "Seaton", "JavaScript", 1, 72));
        list.add(new Person2(784, "Yú", "Mynett", "Express", 5, 47));
        list.add(new Person2(785, "Gaïa", "Petrello", "BBDD", 6, 55));
        list.add(new Person2(786, "Laïla", "Langdon", "Express", 5, 40));
        list.add(new Person2(787, "Cloé", "Hellwing", "XML", 3, 55));
        list.add(new Person2(788, "Gösta", "Scrammage", "NodeJs", 7, 73));
        list.add(new Person2(789, "Béatrice", "Thorrold", "MySQL", 3, 47));
        list.add(new Person2(790, "Léone", "Vondruska", "BBDD", 7, 27));
        list.add(new Person2(791, "Östen", "Grzegorczyk", "JavaScript", 4, 28));
        list.add(new Person2(792, "Pénélope", "Carrivick", "XML", 4, 24));
        list.add(new Person2(793, "Maï", "Toffoletto", "JavaScript", 4, 71));
        list.add(new Person2(794, "Göran", "Izkovicz", "PostgreSQL", 10, 34));
        list.add(new Person2(795, "Yóu", "Marzele", "Angular", 8, 55));
        list.add(new Person2(796, "Gérald", "Showen", "odoo", 2, 67));
        list.add(new Person2(797, "Almérinda", "Wraighte", "MySQL", 5, 70));
        list.add(new Person2(798, "Ophélie", "Scallon", "Java", 6, 58));
        list.add(new Person2(799, "Mà", "Slopier", "BBDD", 2, 39));
        list.add(new Person2(800, "Åslög", "Dami", "Angular", 5, 68));
        list.add(new Person2(801, "Pénélope", "Anfossi", "Oracle", 2, 59));
        list.add(new Person2(802, "Gaëlle", "Jepson", "BBDD", 8, 21));
        list.add(new Person2(803, "Céline", "Vanichev", "Java", 6, 56));
        list.add(new Person2(804, "Agnès", "Risso", "Java", 1, 44));
        list.add(new Person2(805, "Mélia", "Hindenburg", "BBDD", 5, 67));
        list.add(new Person2(806, "Cécilia", "Morcomb", "PostgreSQL", 8, 44));
        list.add(new Person2(807, "Åslög", "Colquite", "Java", 10, 43));
        list.add(new Person2(808, "Bérangère", "Laetham", "BBDD", 3, 25));
        list.add(new Person2(809, "Stévina", "Attree", "NodeJs", 7, 66));
        list.add(new Person2(810, "Léonore", "Gonzales", "Acceso a datos", 1, 46));
        list.add(new Person2(811, "Pélagie", "Craddy", "Acceso a datos", 8, 22));
        list.add(new Person2(812, "Yénora", "Marchello", "Acceso a datos", 5, 32));
        list.add(new Person2(813, "Maëlle", "Ashmore", "Acceso a datos", 9, 64));
        list.add(new Person2(814, "Cécile", "Wayper", "Patrones de diseño", 6, 25));
        list.add(new Person2(815, "Eliès", "Beccero", "Oracle", 1, 34));
        list.add(new Person2(816, "Adèle", "Rutigliano", "POO", 4, 73));
        list.add(new Person2(817, "Valérie", "Guyet", "POO", 6, 45));
        list.add(new Person2(818, "Lài", "Cahalin", "BBDD", 9, 34));
        list.add(new Person2(819, "Lyséa", "Gwilt", "Angular", 5, 19));
        list.add(new Person2(820, "Anaïs", "Rowthorn", "Java", 8, 31));
        list.add(new Person2(821, "Maëline", "Littlejohns", "odoo", 3, 30));
        list.add(new Person2(822, "Léone", "Dikels", "MySQL", 2, 63));
        list.add(new Person2(823, "Kévina", "Touzey", "NodeJs", 9, 66));
        list.add(new Person2(824, "Maï", "Swaile", "Acceso a datos", 2, 43));
        list.add(new Person2(825, "Maëline", "Fancourt", "NodeJs", 3, 46));
        list.add(new Person2(826, "Kù", "Garthland", "MySQL", 8, 48));
        list.add(new Person2(827, "Salomé", "Gwin", "BBDD", 1, 64));
        list.add(new Person2(828, "Styrbjörn", "Magog", "react", 4, 31));
        list.add(new Person2(829, "Eléonore", "Humbey", "Oracle", 1, 49));
        list.add(new Person2(830, "Judicaël", "Kivelhan", "Oracle", 1, 57));
        list.add(new Person2(831, "Östen", "Rosenstiel", "sql", 6, 45));
        list.add(new Person2(832, "André", "Foley", "JavaScript", 8, 54));
        list.add(new Person2(833, "Garçon", "Verman", "Patrones de diseño", 10, 50));
        list.add(new Person2(834, "Cécile", "Towell", "POO", 10, 40));
        list.add(new Person2(835, "Ráo", "Freschi", "Java", 3, 29));
        list.add(new Person2(836, "Cléopatre", "Porritt", "Angular", 9, 53));
        list.add(new Person2(837, "Gisèle", "Arkell", "odoo", 4, 48));
        list.add(new Person2(838, "Clémentine", "Robiou", "Angular", 5, 56));
        list.add(new Person2(839, "Maïwenn", "Toleman", "BBDD", 7, 70));
        list.add(new Person2(840, "Clélia", "Cleverley", "Acceso a datos", 9, 75));
        list.add(new Person2(841, "Noémie", "Jerromes", "POO", 1, 32));
        list.add(new Person2(842, "Méghane", "Pietrasik", "Java", 5, 39));
        list.add(new Person2(843, "Cléa", "Yewman", "Oracle", 6, 49));
        list.add(new Person2(844, "Léonore", "Denisyev", "JavaScript", 5, 28));
        list.add(new Person2(845, "Adélaïde", "MacDowal", "MySQL", 9, 67));
        list.add(new Person2(846, "Cloé", "Carnie", "JavaScript", 4, 52));
        list.add(new Person2(847, "Maïlis", "Roels", "Oracle", 2, 73));
        list.add(new Person2(848, "Faîtes", "Kos", "Acceso a datos", 6, 69));
        list.add(new Person2(849, "André", "Meeus", "XML", 9, 66));
        list.add(new Person2(850, "Åslög", "Thormwell", "PostgreSQL", 4, 29));
        list.add(new Person2(851, "Maëlla", "Sanchis", "Acceso a datos", 5, 37));
        list.add(new Person2(852, "Léandre", "Davis", "sql", 7, 35));
        list.add(new Person2(853, "Mélia", "Grishenkov", "JavaScript", 10, 25));
        list.add(new Person2(854, "Céline", "Durward", "PostgreSQL", 7, 52));
        list.add(new Person2(855, "Lyséa", "Manklow", "Java", 5, 52));
        list.add(new Person2(856, "Mà", "Maginot", "sql", 9, 49));
        list.add(new Person2(857, "Bérengère", "Illidge", "sql", 3, 19));
        list.add(new Person2(858, "Zoé", "Rounsefell", "Acceso a datos", 7, 74));
        list.add(new Person2(859, "Gérald", "Sayer", "react", 7, 18));
        list.add(new Person2(860, "Vérane", "Morrott", "Java", 2, 30));
        list.add(new Person2(861, "Bérénice", "McAnellye", "Angular", 2, 72));
        list.add(new Person2(862, "Marie-françoise", "Ratazzi", "odoo", 7, 43));
        list.add(new Person2(863, "Nélie", "Hammerberg", "XML", 1, 49));
        list.add(new Person2(864, "Géraldine", "Belsham", "BBDD", 8, 62));
        list.add(new Person2(865, "Börje", "McKitterick", "Java", 8, 36));
        list.add(new Person2(866, "Clémentine", "Coole", "XML", 9, 27));
        list.add(new Person2(867, "Sélène", "Gwyneth", "Angular", 7, 18));
        list.add(new Person2(868, "Clémentine", "Evershed", "sql", 5, 29));
        list.add(new Person2(869, "Desirée", "Jezzard", "Java", 5, 41));
        list.add(new Person2(870, "Fèi", "Ventura", "Acceso a datos", 4, 39));
        list.add(new Person2(871, "Kévina", "McGlaud", "NodeJs", 10, 25));
        list.add(new Person2(872, "Adélaïde", "Rolfo", "XML", 9, 28));
        list.add(new Person2(873, "Vérane", "Godsell", "MySQL", 5, 42));
        list.add(new Person2(874, "Naëlle", "Meiklam", "Patrones de diseño", 2, 19));
        list.add(new Person2(875, "Aloïs", "Goacher", "Express", 4, 20));
        list.add(new Person2(876, "Célestine", "Janisson", "Angular", 8, 28));
        list.add(new Person2(877, "Audréanne", "Blakeborough", "PostgreSQL", 6, 65));
        list.add(new Person2(878, "André", "Seckom", "Java", 8, 44));
        list.add(new Person2(879, "Marie-josée", "Ferie", "Express", 3, 42));
        list.add(new Person2(880, "Mahélie", "Soars", "BBDD", 5, 41));
        list.add(new Person2(881, "Zhì", "Matveyev", "XML", 4, 51));
        list.add(new Person2(882, "Erwéi", "Thonason", "react", 6, 29));
        list.add(new Person2(883, "Bérénice", "McGeorge", "POO", 8, 58));
        list.add(new Person2(884, "Anaé", "Navarro", "PostgreSQL", 8, 57));
        list.add(new Person2(885, "Maïté", "Ruddle", "POO", 3, 28));
        list.add(new Person2(886, "Laurélie", "Tomalin", "NodeJs", 5, 72));
        list.add(new Person2(887, "Naéva", "Cavil", "Express", 9, 55));
        list.add(new Person2(888, "Björn", "Black", "Angular", 3, 27));
        list.add(new Person2(889, "Annotée", "Jouhandeau", "Express", 8, 25));
        list.add(new Person2(890, "Gwenaëlle", "Semmens", "Patrones de diseño", 6, 50));
        list.add(new Person2(891, "Dafnée", "Iamittii", "POO", 5, 73));
        list.add(new Person2(892, "Inès", "Clive", "XML", 7, 65));
        list.add(new Person2(893, "Maëlann", "Imeson", "POO", 6, 65));
        list.add(new Person2(894, "Agnès", "Schubuser", "Angular", 10, 44));
        list.add(new Person2(895, "Börje", "Hanselman", "odoo", 7, 56));
        list.add(new Person2(896, "Laurène", "Korba", "POO", 6, 49));
        list.add(new Person2(897, "Mélissandre", "Boote", "XML", 3, 47));
        list.add(new Person2(898, "Marie-thérèse", "Kemet", "Oracle", 7, 23));
        list.add(new Person2(899, "Kévina", "Springett", "react", 2, 40));
        list.add(new Person2(900, "Léana", "Raveau", "Acceso a datos", 3, 22));
        list.add(new Person2(901, "Ráo", "Edmons", "sql", 4, 29));
        list.add(new Person2(902, "Loïca", "Reinhardt", "Angular", 7, 37));
        list.add(new Person2(903, "Mélodie", "Flintoft", "Java", 10, 20));
        list.add(new Person2(904, "Camélia", "Curee", "Patrones de diseño", 5, 34));
        list.add(new Person2(905, "Néhémie", "Sanbrooke", "odoo", 6, 21));
        list.add(new Person2(906, "Yú", "Lagden", "XML", 4, 71));
        list.add(new Person2(907, "Torbjörn", "Thistleton", "odoo", 3, 60));
        list.add(new Person2(908, "Intéressant", "MacNelly", "PostgreSQL", 6, 37));
        list.add(new Person2(909, "Méghane", "O'Kennavain", "Express", 2, 68));
        list.add(new Person2(910, "Cloé", "Obray", "Java", 3, 55));
        list.add(new Person2(911, "Miléna", "Matias", "react", 6, 31));
        list.add(new Person2(912, "Maïlys", "Wellsman", "PostgreSQL", 9, 51));
        list.add(new Person2(913, "Naéva", "Leng", "Express", 7, 36));
        list.add(new Person2(914, "Maëlle", "Pidler", "PostgreSQL", 3, 23));
        list.add(new Person2(915, "Yóu", "Coenraets", "react", 6, 28));
        list.add(new Person2(916, "Kuí", "Caplen", "POO", 7, 45));
        list.add(new Person2(917, "Nadège", "Sybbe", "Oracle", 6, 18));
        list.add(new Person2(918, "Erwéi", "Agostini", "Angular", 3, 30));
        list.add(new Person2(919, "Esbjörn", "Wixey", "sql", 5, 63));
        list.add(new Person2(920, "Clémence", "Sallans", "Express", 9, 31));
        list.add(new Person2(921, "Intéressant", "Renshaw", "Oracle", 4, 71));
        list.add(new Person2(922, "Loïc", "Charnock", "Oracle", 9, 44));
        list.add(new Person2(923, "Börje", "Itzkovwitch", "MySQL", 3, 36));
        list.add(new Person2(924, "Marie-hélène", "McEvilly", "Express", 7, 22));
        list.add(new Person2(925, "Hélèna", "Tosh", "JavaScript", 2, 51));
        list.add(new Person2(926, "Médiamass", "Beed", "JavaScript", 4, 52));
        list.add(new Person2(927, "Léandre", "Gallager", "Java", 6, 22));
        list.add(new Person2(928, "Desirée", "Tuffs", "PostgreSQL", 6, 49));
        list.add(new Person2(929, "Yóu", "Crome", "odoo", 6, 23));
        list.add(new Person2(930, "Crééz", "Skilling", "Acceso a datos", 4, 26));
        list.add(new Person2(931, "Séverine", "Tuminelli", "BBDD", 2, 62));
        list.add(new Person2(932, "Renée", "Ivison", "sql", 6, 40));
        list.add(new Person2(933, "Gérald", "Kneeland", "Patrones de diseño", 10, 64));
        list.add(new Person2(934, "Marie-hélène", "Trenoweth", "MySQL", 6, 42));
        list.add(new Person2(935, "Kallisté", "Gerber", "Acceso a datos", 5, 48));
        list.add(new Person2(936, "Simplifiés", "Stobo", "sql", 7, 52));
        list.add(new Person2(937, "Adèle", "Attril", "JavaScript", 7, 24));
        list.add(new Person2(938, "Mélinda", "Frude", "odoo", 8, 38));
        list.add(new Person2(939, "Joséphine", "Medland", "JavaScript", 10, 26));
        list.add(new Person2(940, "Frédérique", "Wager", "odoo", 1, 72));
        list.add(new Person2(941, "Renée", "Sibary", "Java", 8, 71));
        list.add(new Person2(942, "Maëlyss", "Ratcliff", "odoo", 6, 61));
        list.add(new Person2(943, "Marie-noël", "Bernaert", "MySQL", 6, 54));
        list.add(new Person2(944, "Marlène", "Brazil", "sql", 7, 21));
        list.add(new Person2(945, "Angèle", "Milborn", "Oracle", 5, 45));
        list.add(new Person2(946, "Vénus", "Mucklo", "POO", 10, 64));
        list.add(new Person2(947, "Solène", "Rodrigues", "JavaScript", 4, 28));
        list.add(new Person2(948, "Mylène", "Cornock", "Java", 7, 61));
        list.add(new Person2(949, "Médiamass", "Domleo", "Express", 2, 18));
        list.add(new Person2(950, "Dà", "Merrett", "Oracle", 2, 28));
        list.add(new Person2(951, "Céline", "Spavon", "Acceso a datos", 9, 68));
        list.add(new Person2(952, "Mélys", "Airton", "BBDD", 1, 21));
        list.add(new Person2(953, "Maïwenn", "Crosher", "Express", 3, 42));
        list.add(new Person2(954, "Táng", "Paynes", "JavaScript", 9, 66));
        list.add(new Person2(955, "Dù", "Regelous", "PostgreSQL", 4, 59));
        list.add(new Person2(956, "Cunégonde", "Baudains", "Express", 5, 75));
        list.add(new Person2(957, "Mélia", "Adshad", "POO", 4, 21));
        list.add(new Person2(958, "Mélanie", "Lafont", "Acceso a datos", 10, 67));
        list.add(new Person2(959, "Angèle", "Aimable", "POO", 4, 55));
        list.add(new Person2(960, "Marie-thérèse", "Impleton", "PostgreSQL", 1, 26));
        list.add(new Person2(961, "Anaïs", "Dibley", "NodeJs", 8, 58));
        list.add(new Person2(962, "Agnès", "Scatchard", "BBDD", 6, 43));
        list.add(new Person2(963, "Zoé", "Abbot", "XML", 6, 19));
        list.add(new Person2(964, "Marie-françoise", "Cloake", "POO", 8, 41));
        list.add(new Person2(965, "Gaétane", "Berkeley", "POO", 4, 60));
        list.add(new Person2(966, "Zoé", "Schusterl", "Java", 2, 52));
        list.add(new Person2(967, "Françoise", "Seabon", "sql", 5, 72));
        list.add(new Person2(968, "Andréanne", "Gorch", "Acceso a datos", 4, 34));
        list.add(new Person2(969, "Adèle", "Herreros", "XML", 9, 18));
        list.add(new Person2(970, "Nadège", "Proffitt", "Express", 10, 26));
        list.add(new Person2(971, "Bénédicte", "Siggers", "react", 8, 74));
        list.add(new Person2(972, "Maïté", "Reboul", "PostgreSQL", 3, 31));
        list.add(new Person2(973, "Michèle", "Alcorn", "Java", 7, 53));
        list.add(new Person2(974, "Garçon", "Robens", "Patrones de diseño", 7, 20));
        list.add(new Person2(975, "Séréna", "Fontell", "Patrones de diseño", 8, 34));
        list.add(new Person2(976, "Andrée", "Digan", "POO", 4, 75));
        list.add(new Person2(977, "Andrée", "D'Andrea", "PostgreSQL", 5, 64));
        list.add(new Person2(978, "Lorène", "Ivens", "PostgreSQL", 3, 63));
        list.add(new Person2(979, "Gösta", "Groucutt", "Patrones de diseño", 7, 27));
        list.add(new Person2(980, "Zoé", "Porson", "PostgreSQL", 1, 44));
        list.add(new Person2(981, "Marie-josée", "Hornbuckle", "Angular", 2, 24));
        list.add(new Person2(982, "Marlène", "Haresnape", "odoo", 5, 62));
        list.add(new Person2(983, "Alizée", "Fulford", "XML", 5, 36));
        list.add(new Person2(984, "Cloé", "Grigoli", "NodeJs", 2, 26));
        list.add(new Person2(985, "Joséphine", "Okroy", "Oracle", 7, 75));
        list.add(new Person2(986, "Marie-françoise", "Hunnicutt", "XML", 6, 52));
        list.add(new Person2(987, "Noëlla", "Kynett", "Oracle", 3, 50));
        list.add(new Person2(988, "Maïté", "Dutteridge", "odoo", 6, 28));
        list.add(new Person2(989, "Lóng", "Noden", "MySQL", 8, 30));
        list.add(new Person2(990, "Börje", "Ahmed", "odoo", 7, 39));
        list.add(new Person2(991, "Gösta", "Jenoure", "sql", 2, 70));
        list.add(new Person2(992, "Vérane", "Vercruysse", "JavaScript", 7, 71));
        list.add(new Person2(993, "Maëlle", "Guile", "Java", 5, 64));
        list.add(new Person2(994, "Görel", "Sawden", "Oracle", 7, 67));
        list.add(new Person2(995, "Salomé", "Very", "JavaScript", 5, 33));
        list.add(new Person2(996, "Célia", "Timmes", "Patrones de diseño", 5, 71));
        list.add(new Person2(997, "Naëlle", "Balls", "Angular", 5, 56));
        list.add(new Person2(998, "Maëlys", "Fabbri", "Patrones de diseño", 10, 32));
        list.add(new Person2(999, "Mahélie", "Laughlan", "Java", 7, 34));
        list.add(new Person2(1000, "Céline", "Rosborough", "sql", 10, 22));
    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej8() {
        //Ej8. Crea un modelo (POJO) con al menos los siguientes atributos:
            //public class Cancion {
            //  String titulo;
            //  String cantante;
            //}
        //Crea una lista de canciones y utiliza el siguiente código para inicializarla:
        //List<Cancion> canciones = new ArrayList<>(Arrays.asList(
            // new Cancion("Livin' on Prayer", "Bon Jovi"),
            // new Cancion("Long Hot Summer", "Keith Urban"),
            // new Cancion("It's my Life", "Bon Jovi"),
            // new Cancion("Dolor Fantasma", "Amadeus"),
            // new Cancion("Run To You", "Bryan Adams"),
            // new Cancion("Summer of 69", "Bryan Adams"),
            // new Cancion("Paranoid", "Black Sabbath"),
            // new Cancion("Cherokee", "Europe"),
            // new Cancion("River Bank", "Brad Paisley")));
        //Realiza las siguientes consultas:
        // Busca las canciones de “Bon Jovi” usando programación tradicional (bucles)
        // Busca las canciones de “Bon Jovi” usando programación funcional.
        // Busca las canciones de “Bon Jovi” usando programación funcional y las canciones encontradas deben acabar
        //en nueva lista.
        // Cuenta el número de canciones que tiene “Bon Jovi” en la lista.
        // Realiza una agrupación por cantante y muestra el número de canciones que tiene cada cantante.
        // Por último introduce una canción existente de nuevo en la lista, por ejemplo:
        //canciones.add(new Cancion("Summer of 69", "Bryan Adams")); Como podrás observar ahora existe un duplicado,
        //Queremos imprimir la información de todas las canciones, pero sin dicho duplicado.

        List<Song> songs = new ArrayList<>(Arrays.asList(
                new Song("Livin' on Prayer", "Bon Jovi"),
                new Song("Long Hot Summer", "Keith Urban"),
                new Song("It's my Life", "Bon Jovi"),
                new Song("Dolor Fantasma", "Amadeus"),
                new Song("Run To You", "Bryan Adams"),
                new Song("Summer of 69", "Bryan Adams"),
                new Song("Summer of 69", "Bryan Adams"),
                new Song("Paranoid", "Black Sabbath"),
                new Song("Cherokee", "Europe"),
                new Song("River Bank", "Brad Paisley")));

        for (Song song : songs) {
            if (song.getSinger().equalsIgnoreCase("Bon Jovi")) {
                System.out.println(song.getTitle());
            }
        }

        List<Song> bonJovisSongs = songs.stream().filter(singer -> singer.getSinger().equalsIgnoreCase(
                "bon jovi")).toList();
        System.out.println("canciones bon jovi funcional");
        bonJovisSongs.forEach(singer -> System.out.println(singer.getTitle()));

        List<String> songsOfBonJovi = new ArrayList<>();
        bonJovisSongs.forEach(song -> songsOfBonJovi.add(song.getTitle()));
        System.out.println(songsOfBonJovi);

        Long numberOfBonJoviSongs = songs.stream().filter(singer -> singer.getSinger().equalsIgnoreCase(
                "bon jovi")).count();

        System.out.println(numberOfBonJoviSongs);
        Map<String, Long> numberOfSingersSongs = songs.stream().collect(Collectors.groupingBy(Song::getSinger, Collectors.counting()));
        System.out.println(numberOfSingersSongs);

        System.out.println("ultimo punto");
        songs.stream().distinct().forEach(System.out::println);
    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej9() {
        //Ej9. Crea un modelo (POJO) que represente un estudiante con los siguientes atributos:
            //private int id;
            //private String dni;
            //private String nombre;
            //private String apellidos;
            //private String nombreCurso;
            //private double nota;
            //private int edad;
        //Carga los siguientes alumnos en una lista:

        //Cargamos la lista de Alumnos
            //listaAlumnos.add(new Alumno(1, "1717213183", "Javier", "Molina Cano", "Java 8", 7, 28));
            //listaAlumnos.add(new Alumno(2, "1717456218", "Ana", "Gómez Álvarez", "Java 8", 10, 33));
            //listaAlumnos.add(new Alumno(3, "1717328901", "Pedro", "Marín López", "Java 8", 8.6, 15));
            //listaAlumnos.add(new Alumno(4, "1717567128", "Emilio", "Duque Gutiérrez", "Java 8", 10, 13));
            //listaAlumnos.add(new Alumno(5, "1717902145", "Alberto", "Sáenz Hurtado", "Java 8", 9.5, 15));
            //listaAlumnos.add(new Alumno(6, "1717678456", "Germán", "López Fernández", "Java 8", 8, 34));
            //listaAlumnos.add(new Alumno(7, "1102156732", "Oscar", "Murillo González", "Java 8", 10, 32));
            //listaAlumnos.add(new Alumno(8, "1103421907", "Antonio Jesús", "Palacio Martínez", "PHP", 9.5, 17));
            //listaAlumnos.add(new Alumno(9, "1717297015", "César", "González Martínez", "Java 8", 8, 26));
            //listaAlumnos.add(new Alumno(10, "1717912056", "Gloria", "González Castaño", "PHP", 10, 28));
            //listaAlumnos.add(new Alumno(11, "1717912058", "Jorge", "Ruiz Ruiz", "Python", 8, 22));
            //listaAlumnos.add(new Alumno(12, "1717912985", "Ignacio", "Duque García", "Java Script", 9.4, 32));
            //listaAlumnos.add(new Alumno(13, "1717913851", "Julio", "González Castaño", "C Sharp", 10, 22));
            //listaAlumnos.add(new Alumno(14, "1717986531", "Gloria", "Rodas Carretero", "Ruby", 7, 18));
            //listaAlumnos.add(new Alumno(15, "1717975232", "Jaime", "Jiménez Gómez", "Java Script", 10, 18));

        //Realiza las siguientes consultas con programación funcional:
        // Muestra todos los alumnos: Lista de Alumnos debes usar una referencia a método.
        // Alumnos cuyo apellido empiezan con el caracter L u G
        // Número de Alumnos
        // Alumnos con nota mayor a 9 y que sean del curso PHP
        // Imprimir los 2 primeros Alumnos de la lista
        // Imprimir el alumno con menor edad
        // Imprimir el alumno con mayor edad
        // Encontrar el primer Alumno
        // Alumnos que tienen un curso en el que el nombre contienen la A
        // Alumnos en que la longitud de su nombre es mayor a 10 caracteres
        // Obtiene los alumnos en los cuales el nombre del curso empieza con el caracter 'p'; y la longitud sea <= a 6
        // Crea una nueva lista llamada “listaNueva” con el contenido de la consulta anterior.

        List<Students> students = new ArrayList<>();
        addToList2(students);

        System.out.println("\npunto 1");
        students.forEach(System.out::println);

        System.out.println("\npunto 2");
        students.stream().filter(stu -> stu.getLastName().toLowerCase().startsWith("l") || stu.getLastName().toLowerCase()
                .startsWith("g")).forEach(System.out::println);

        System.out.println("\npunto 3");
        System.out.println(students.stream().count());

        System.out.println("\npunto 4");
        students.stream().filter(stu -> stu.getNota() > 9 && stu.getCurse().equalsIgnoreCase("php"))
                .forEach(System.out::println);

        System.out.println("\npunto 5");
        students.stream().limit(2).forEach(System.out::println);

        System.out.println("\npunto 6");
        System.out.println(students.stream().min(Comparator.comparing(Students::getAge)));

        System.out.println("\npunto 7");
        System.out.println(students.stream().max(Comparator.comparing(Students::getAge)));

        System.out.println("\npunto 8");
        students.stream().limit(1).forEach(System.out::println);

        System.out.println("\npunto 9");
        students.stream().filter(stu -> stu.getCurse().contains("A")).forEach(System.out::println);

        System.out.println("\npunto 10");
        students.stream().filter(stu -> stu.getName().length() > 10).forEach(System.out::println);

        System.out.println("\npunto 11");
        students.stream().filter(stu -> stu.getName().toLowerCase().startsWith("p") && stu.getName().length() <= 6)
                .forEach(System.out::println);
        
        System.out.println("\npunto 12");
        List<Students> listaNueva = students.stream().filter(stu -> stu.getName().toLowerCase().startsWith("p") &&
                stu.getName().length() <= 6).toList();
        System.out.println(listaNueva);
    }

    private static void addToList2(List<Students> list) {
        list.add(new Students(1, "1717213183", "Javier", "Molina Cano", "Java 8", 7, 28));
        list.add(new Students(2, "1717456218", "Ana", "Gómez Álvarez", "Java 8", 10, 33));
        list.add(new Students(3, "1717328901", "Pedro", "Marín López", "Java 8", 8.6, 15));
        list.add(new Students(4, "1717567128", "Emilio", "Duque Gutiérrez", "Java 8", 10, 13));
        list.add(new Students(5, "1717902145", "Alberto", "Sáenz Hurtado", "Java 8", 9.5, 15));
        list.add(new Students(6, "1717678456", "Germán", "López Fernández", "Java 8", 8, 34));
        list.add(new Students(7, "1102156732", "Oscar", "Murillo González", "Java 8", 10, 32));
        list.add(new Students(8, "1103421907", "Antonio Jesús", "Palacio Martínez", "PHP", 9.5, 17));
        list.add(new Students(9, "1717297015", "César", "González Martínez", "Java 8", 8, 26));
        list.add(new Students(10, "1717912056", "Gloria", "González Castaño", "PHP", 10, 28));
        list.add(new Students(11, "1717912058", "Jorge", "Ruiz Ruiz", "Python", 8, 22));
        list.add(new Students(12, "1717912985", "Ignacio", "Duque García", "Java Script", 9.4, 32));
        list.add(new Students(13, "1717913851", "Julio", "González Castaño", "C Sharp", 10, 22));
        list.add(new Students(14, "1717986531", "Gloria", "Rodas Carretero", "Ruby", 7, 18));
        list.add(new Students(15, "1717975232", "Jaime", "Jiménez Gómez", "Java Script", 10, 18));
    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej10()  {
        //Ej10. Podrás observar en el repositorio un archivo csv llamado “product.csv” debes crear un POJO
        //que represente un producto. Y cargar todos los productos del archivo en una lista y realiza las
        //siguientes consultas usando programación funcional:

        // Imprime la lista de productos.
        // Realiza el equivalente a un select name from productos.
        // Imprime el nombre de los productos cuyo stock sea menos a 10
        // Imprime el nombre de los productos cuyo stock sea menor a 10, pero ordenado por número de el número de
        //stock de menor a mayor (ayuda: para esta consulta es probable que tengas que usar el método sorted, este
        //método recibe un Comparator. Ésta misma interfaz Comparator tiene algunos métodos que nos serán de gran ayuda)
        // Realiza la misma consulta anterior pero ahora ordenando de mayor a menor.
        // Muestra el nombre de los productos con unidades en stock mayor de 10 ordenados ordenar por unidad de stock
        //de forma descendente y por nombre de producto de forma ascendente.
        // Muestra el nombre de los productos con unidades en stock mayor de 10 ordenados ordenar por unidad de stock
        // de forma ascendente y por nombre de producto de forma descendente.
        // Obtener el número de productos agrupados por proveedor.
        // Obtener la suma del precio unitario de todos los productos agrupados por el número de existencias en el
        // almacén, pero solo obtener aquellos registros cuya suma sea mayor a 100
        // Calcula el promedio de existencias en almacén.
        // Producto con el precio unitario más alto.
        // Imprime la lista de productos, pero limitando el número de productos devueltos a 50 (muestra los 50
        // primeros, operador limit en sql)

        List<Products> products = new ArrayList<>();
        String filePath = Metods.importFiles("products.csv");

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int productID = Integer.parseInt(parts[0]);
                String productName = parts[1];
                int supplierID = Integer.parseInt(parts[2]);
                int categoryID = Integer.parseInt(parts[3]);
                String quantityPerUnit = parts[4];
                double unitPrice = Double.parseDouble(parts[5]);
                int unitsInStock = Integer.parseInt(parts[6]);
                int unitsOnOrder = Integer.parseInt(parts[7]);
                int reorderLevel = Integer.parseInt(parts[8]);
                boolean discontinued = Boolean.parseBoolean(parts[9]);
                products.add(new Products(productID, productName, supplierID, categoryID, quantityPerUnit, unitPrice,
                        unitsInStock, unitsOnOrder, reorderLevel, discontinued));
            }

            System.out.println("\npunto 1");
            products.forEach(System.out::println);

            System.out.println("\npunto 2");
            products.forEach(products1 -> System.out.println(products1.getProductName()));

            System.out.println("\npunto 3");
            products.stream().filter(products1 -> products1.getUnitsInStock() < 10).forEach(products1 ->
                    System.out.println(products1.getProductName()));

            System.out.println("\npunto 4");
            products.stream().filter(products1 -> products1.getUnitsInStock() < 10).sorted(Comparator
                    .comparing(Products::getUnitsInStock)).forEach(System.out::println);

            System.out.println("\npunto 5");
            products.stream().filter(products1 -> products1.getUnitsInStock() < 10).sorted(Comparator
                    .comparing(Products::getUnitsInStock).reversed()).forEach(System.out::println);

            System.out.println("\npunto 6");
            products.stream().filter(product -> product.getUnitsInStock() >= 10).sorted(Comparator.comparingInt(
                            Products::getUnitsInStock).reversed().thenComparing(Comparator.comparing(
                                    Products::getProductName))).forEach(System.out::println);

            System.out.println("\npunto 7");
            products.stream().filter(product -> product.getUnitsInStock() >= 10).sorted(Comparator.comparing(
                    Products::getProductName).reversed().thenComparing(Comparator.comparingInt(
                    Products::getUnitsInStock))).forEach(System.out::println);

            System.out.println("\npunto 8");
            Map<Integer, Long> numberOfProducts = products.stream().collect(Collectors.groupingBy(
                    Products::getSupplierID, Collectors.counting()));
            for (Map.Entry<Integer, Long> i : numberOfProducts.entrySet()) {
                System.out.println(i.toString());
            }

            System.out.println("\npunto 9");
            Map<Integer, Double> stockSum = products.stream().collect(Collectors.groupingBy(Products::getUnitsInStock,
                    Collectors.summingDouble(Products::getUnitPrice)));
            stockSum.entrySet().stream().filter(i -> i.getValue() > 100).forEach(i -> System.out.println(
                    "Existencias: " + i.getKey() + ", Suma del precio unitario: " + i.getValue()));

            System.out.println("\npunto 10");
            int average = products.stream().collect(Collectors.summingInt(Products::getUnitsInStock));
            System.out.println(average/products.size());

            System.out.println("\npunto 11");
            System.out.println(products.stream().max(Comparator.comparing(Products::getUnitPrice)));

            System.out.println("\npunto 12");
            products.stream().limit(50).forEach(System.out::println);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}