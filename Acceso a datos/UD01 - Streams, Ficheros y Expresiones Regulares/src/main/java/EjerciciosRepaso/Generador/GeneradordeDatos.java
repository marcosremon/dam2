package EjerciciosRepaso.Generador;

import EjerciciosRepaso.model.Estudiante;
import EjerciciosRepaso.model.Instituto;
import EjerciciosRepaso.model.Profesor;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.random.RandomGenerator;

public class GeneradordeDatos {

    public static Supplier<HashMap<String, Float>> listaAsignaturas = () -> new HashMap<>(Map.of(
            "Matematicas", RandomGenerator.getDefault().nextFloat(1, 10.0001f),
            "Fisica", RandomGenerator.getDefault().nextFloat(1, 10.0001f),
            "Historia", RandomGenerator.getDefault().nextFloat(1, 10.0001f),
            "Geografia", RandomGenerator.getDefault().nextFloat(1, 10.0001f),
            "Programacion", RandomGenerator.getDefault().nextFloat(1, 10.0001f),
            "Educacion Fisica", RandomGenerator.getDefault().nextFloat(1, 10.0001f)));

    public static Function<Integer,HashMap<Integer, Profesor>> listaProfesores = (i) -> switch (i) {
        case 1 -> new HashMap<>(Map.of(
                20, new Profesor("12839475B", "Pedro", 20, true),
                21, new Profesor("36472819H", "Sofia", 21, true),
                22, new Profesor("94857362V", "Javier", 22, false),
                23, new Profesor("38475961L", "Marta", 23, true),
                24, new Profesor("29837564G", "Raul", 24, true),
                25, new Profesor("84736291X", "Paula", 25, true),
                26, new Profesor("52647382W", "Sergio", 26, false),
                27, new Profesor("63728459R", "Elena", 27, true),
                28, new Profesor("19283746D", "Diego", 28, true),
                29, new Profesor("76543219P", "Alicia", 29, true)));
        case 2 -> new HashMap<>(Map.of(
                30, new Profesor("98457632J", "Manuel", 30, true),
                31, new Profesor("18374629F", "Clara", 31, false),
                32, new Profesor("29384756T", "Victor", 32, true),
                33, new Profesor("37584921Z", "Patricia", 33, true),
                34, new Profesor("84716253L", "David", 34, true),
                35, new Profesor("56473892N", "Sara", 35, false),
                36, new Profesor("90817254C", "Pablo", 36, true),
                37, new Profesor("23847569S", "Lucia", 37, true),
                38, new Profesor("19283745X", "Daniel", 38, true),
                39, new Profesor("98473216V", "Ines", 39, true)));
        default -> new HashMap<>(Map.of(
                40, new Profesor("72635481M", "Oscar", 40, false),
                41, new Profesor("18375649G", "Teresa", 41, true),
                42, new Profesor("29384716A", "Gabriel", 42, true),
                43, new Profesor("37584926Y", "Isabel", 43, true),
                44, new Profesor("84726319B", "Alberto", 44, true),
                45, new Profesor("52647389U", "Andrea", 45, false),
                46, new Profesor("63728451O", "Roberto", 46, true),
                47, new Profesor("19283746Q", "Nuria", 47, true),
                48, new Profesor("76543215E", "Joaquin", 48, true),
                49, new Profesor("98457631H", "Eva", 49, true)));
    };

    public static Function<Integer,HashMap<Integer, Estudiante>> listaEstudiantes = (i) -> {
        HashMap<Integer, Estudiante> lista = new HashMap<>();
        switch(i) {
            case 1 -> {
                lista.putAll(Map.of(
                        1, new Estudiante("36458358G", "Luca", 1, listaAsignaturas.get()),
                        2, new Estudiante("28374651H", "Nia", 2, listaAsignaturas.get()),
                        3, new Estudiante("84726319J", "Santiago", 3, listaAsignaturas.get()),
                        4, new Estudiante("37492015K", "Valeria", 4, listaAsignaturas.get()),
                        5, new Estudiante("83749206L", "Mateo", 5, listaAsignaturas.get()),
                        6, new Estudiante("94736281M", "Sofia", 6, listaAsignaturas.get()),
                        7, new Estudiante("10293847N", "Martín", 7, listaAsignaturas.get()),
                        8, new Estudiante("56473829O", "Camila", 8, listaAsignaturas.get()),
                        9, new Estudiante("83749205P", "Dario", 9, listaAsignaturas.get())));
                lista.putAll(Map.of(
                        10, new Estudiante("38475612Q", "Ariana", 10, listaAsignaturas.get()),
                        11, new Estudiante("93847561R", "Emiliano", 11, listaAsignaturas.get()),
                        12, new Estudiante("83749204S", "Isabella", 12, listaAsignaturas.get()),
                        13, new Estudiante("64738291T", "Gabriel", 13, listaAsignaturas.get()),
                        14, new Estudiante("94857362U", "Luciana", 14, listaAsignaturas.get()),
                        15, new Estudiante("28374658V", "Sebastian", 15, listaAsignaturas.get()),
                        16, new Estudiante("48392017W", "Catalina", 16, listaAsignaturas.get()),
                        17, new Estudiante("39485712X", "Bruno", 17, listaAsignaturas.get()),
                        18, new Estudiante("29384751Y", "Renata", 18, listaAsignaturas.get()),
                        19, new Estudiante("10293846Z", "Thiago", 19, listaAsignaturas.get())));
            }
            case 2 -> {
                lista.putAll(Map.of(
                        20, new Estudiante("84726318A", "Julieta", 20, listaAsignaturas.get()),
                        21, new Estudiante("37492016B", "Tomas", 21, listaAsignaturas.get()),
                        22, new Estudiante("83749203C", "Emilia", 22, listaAsignaturas.get()),
                        23, new Estudiante("94736282D", "Joaquin", 23, listaAsignaturas.get()),
                        24, new Estudiante("10293845E", "Agustina", 24, listaAsignaturas.get()),
                        25, new Estudiante("56473828F", "Facundo", 25, listaAsignaturas.get()),
                        26, new Estudiante("83749202G", "Victoria", 26, listaAsignaturas.get()),
                        27, new Estudiante("38475613H", "Lucas", 27, listaAsignaturas.get()),
                        28, new Estudiante("93847562I", "Mia", 28, listaAsignaturas.get()),
                        29, new Estudiante("83749201J", "Benjamin", 29, listaAsignaturas.get())));
                lista.putAll(Map.of(
                        30, new Estudiante("64738290K", "Valentina", 30, listaAsignaturas.get()),
                        31, new Estudiante("94857363L", "Federico", 31, listaAsignaturas.get()),
                        32, new Estudiante("28374659M", "Florencia", 32, listaAsignaturas.get()),
                        33, new Estudiante("48392018N", "Franco", 33, listaAsignaturas.get()),
                        34, new Estudiante("39485713O", "Paulina", 34, listaAsignaturas.get()),
                        35, new Estudiante("29384752P", "Nicolas", 35, listaAsignaturas.get()),
                        36, new Estudiante("10293844Q", "Aitana", 36, listaAsignaturas.get()),
                        37, new Estudiante("84726317R", "Ezequiel", 37, listaAsignaturas.get()),
                        38, new Estudiante("37492014S", "Alejandra", 38, listaAsignaturas.get()),
                        39, new Estudiante("83749200T", "Iván", 39, listaAsignaturas.get())));
            }
            default -> {
                lista.putAll(Map.of(
                        40, new Estudiante("94736283U", "Claudia", 40, listaAsignaturas.get()),
                        41, new Estudiante("10293843V", "Daniel", 41, listaAsignaturas.get()),
                        42, new Estudiante("56473827W", "Liliana", 42, listaAsignaturas.get()),
                        43, new Estudiante("83749199X", "Pablo", 43, listaAsignaturas.get()),
                        44, new Estudiante("38475614Y", "Lourdes", 44, listaAsignaturas.get()),
                        45, new Estudiante("93847563Z", "Esteban", 45, listaAsignaturas.get()),
                        46, new Estudiante("83749198A", "Cecilia", 46, listaAsignaturas.get()),
                        47, new Estudiante("64738289B", "Miguel", 47, listaAsignaturas.get()),
                        48, new Estudiante("94857364C", "Carla", 48, listaAsignaturas.get()),
                        49, new Estudiante("28374660D", "Andres", 49, listaAsignaturas.get())));
                lista.putAll(Map.of(
                        50, new Estudiante("48392019E", "Daniela", 50, listaAsignaturas.get()),
                        51, new Estudiante("39485714F", "Gonzalo", 51, listaAsignaturas.get()),
                        52, new Estudiante("29384753G", "Clara", 52, listaAsignaturas.get()),
                        53, new Estudiante("10293842H", "Ricardo", 53, listaAsignaturas.get()),
                        54, new Estudiante("84726316I", "Eugenia", 54, listaAsignaturas.get()),
                        55, new Estudiante("37492013J", "Mauricio", 55, listaAsignaturas.get()),
                        56, new Estudiante("83749197K", "Lorena", 56, listaAsignaturas.get()),
                        57, new Estudiante("94736284L", "Raul", 57, listaAsignaturas.get()),
                        58, new Estudiante("10293841M", "Margarita", 58, listaAsignaturas.get()),
                        59, new Estudiante("56473826N", "Alfonso", 59, listaAsignaturas.get())));
            }
        }
        return lista;
    };

    public static Supplier<Map<Integer, Instituto>> listaInstitutos = () -> {
        return Map.of(
                1, new Instituto(new Profesor("00000001L", "Elena", 1, true), listaEstudiantes.apply(1), listaProfesores.apply(1)),
                2, new Instituto(new Profesor("00000002L", "Luna", 2, true), listaEstudiantes.apply(2), listaProfesores.apply(2)),
                3, new Instituto(new Profesor("00000003L", "Pedro", 3, true), listaEstudiantes.apply(3), listaProfesores.apply(3))
        );
    };

    public static Supplier<Map<String,Integer>> finalizar = () -> {
        return Map.ofEntries(
                Map.entry("z", 6),
                Map.entry("ii", 5),
                Map.entry(".", 19),
                Map.entry("a", 3),
                Map.entry("d", 8),
                Map.entry("o", 9),
                Map.entry(",", 10),
                Map.entry("g", 12),
                Map.entry("F", 0),
                Map.entry("r", 13),
                Map.entry("n", 2),
                Map.entry("i", 1),
                Map.entry(" ", 11),
                Map.entry("aa", 7),
                Map.entry("aaa", 14),
                Map.entry("l", 4),
                Map.entry("s", 18),
                Map.entry("c", 15),
                Map.entry("iii", 16),
                Map.entry("aaaa", 17)

        );
    };

}
