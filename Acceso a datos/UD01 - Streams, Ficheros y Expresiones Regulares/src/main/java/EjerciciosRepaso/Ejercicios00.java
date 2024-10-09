package EjerciciosRepaso;



import EjerciciosRepaso.Generador.GeneradordeDatos;
import EjerciciosRepaso.model.Estudiante;
import EjerciciosRepaso.model.Instituto;
import Metods.Metods;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Ejercicios00 {
    public static void main(String[] args) {
        Map<Integer, Instituto> mapadeInstitutos = new HashMap<>(GeneradordeDatos.listaInstitutos.get());
        Scanner sc = new Scanner(System.in);

        System.out.print("elije un ejercicio: ");
        int exercise = sc.nextInt();

        switch (exercise) {
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
                ej6(mapadeInstitutos);
                break;
            case 7:
                ej7(mapadeInstitutos);
                break;
            case 8:
                ej8();
                break;
            case 9:
                ej9(mapadeInstitutos);
                break;
            case 10:
                ej10(mapadeInstitutos);
                break;
            case 11:
                ej11(mapadeInstitutos);
                break;
            case 12:
                ej12(mapadeInstitutos);
                break;
            default:
                System.out.println("ejercicio no valido");
                break;
        }
    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej1() {
        //Ej1. A partir de una lista de números, Crea una función (método) para eliminar los elementos duplicados.

        List<Integer> numbersList = Arrays.asList(1, 2, 3, 4, 5, 2, 3, 6, 7, 5, 8, 9, 10, 3);
        System.out.println(numbersList);
        System.out.println(Metods.DuplicateNumbersRemover(numbersList));
    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej2() {
        //Ej2. A partir del ejercicio 1, convierte tu función en una función que permita
        //eliminar los elementos duplicados independientemente de si es una lista de
        //números o texto. La idea es que la función sea genérica y funcione en ambos casos.

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 2, 3, 6, 7, 5, 8, 9, 10, 3);
        List<String> words = Arrays.asList("manzana", "naranja", "pera", "manzana", "uva", "pera", "platano",
                "naranja", "mango", "manzana");

        System.out.println(numbers);
        System.out.println(words);
        System.out.println(Metods.DuplicateRemover(numbers));
        System.out.println(Metods.DuplicateRemover(words));
    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej3() {
        //Ej3. A partir de una lista de nombres (alguno duplicado). Genera una lista de
        //números únicos del mismo tamaño que la lista de nombres. Por último, Fusiona
        //las listas a un Map, de modo que la clave sea el numero único y el valor el nombre.
        //Ejemplo:
        //1 - Ana
        //2 - Luis
        //3 - Marta
        //4 - Luis
        //5 - Sofía
        //6 - Ana
        //7 - Carlos

        List<String> names = Arrays.asList("Ana", "Luis", "Marta", "Luis", "Sofía", "Ana", "Carlos");
        Metods.namesKey(names);
    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej4() {
        //Ej4. A partir del ejercicio 3, debes eliminar los duplicados que pudiera tener el Map.
        //Y en caso de borrar repeticiones, vuelve a asignar las claves de modo que no
        //permanezcan saltos de clave.
        //Sin Duplicados:
        //1 - Ana
        //2 - Luis
        //3 - Marta
        //4 - Sofía
        //5 – Carlos

        List<String> names = Arrays.asList("Ana", "Luis", "Marta", "Luis", "Sofía", "Ana", "Carlos");
        Metods.namesKeyDuplicateRemover(names);
    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej5() {
        //Ej5. A partir de una lista de Strings. Utiliza un Predicate para filtrar aquellos
        //elementos que podrían ser Integers. Después crea otra lista de números, añade
        //los números de la primera lista a esta y mantén solo los Strings en la original.
        //Ejemplo:
        //[1, -2, Ana, 4, -3, Carlos, 7, -8, Sofía, 5, 0, Laura, -10, 8, Carmen, -1, 6, Elena]
        //[1, -2, 4, -3, 7, -8, 5, 0, -10, 8, -1, 6]
        //[Ana, Carlos, Sofía, Laura, Carmen, Elena]

        List<?> list = new ArrayList<>(Arrays.asList(1, -2, "Ana", 4, -3, "Carlos", 7, -8, "Sofía", 5, 0, "Laura",
                -10, 8, "Carmen", -1, 6, "Elena"));
        List<Integer> numbersList = new ArrayList<>();
        List<String> wordsList = new ArrayList<>();

        list.forEach(e -> {
            if (e instanceof Number) {
                numbersList.add((Integer) e);
            } else wordsList.add((String) e);
        });
        System.out.println(numbersList);
        System.out.println(wordsList);
    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej6(Map<Integer, Instituto> mapadeInstitutos) {
        StringBuilder sb = new StringBuilder();
        mapadeInstitutos.entrySet().forEach(institute -> {
            sb.append("Instituto con id:" + institute.getKey() + "\n");
            sb.append(institute.getValue().getDirector() + "\n");
            sb.append("Lista de profesores: \n");
            institute.getValue().getMapdeProfesores().entrySet().forEach(teacher -> sb.append(
                    teacher.getValue().toString() + "\n"));
            sb.append("Lista de alumnos:" + "\n");
            institute.getValue().getMapdeEstudiantes().entrySet().forEach(student -> sb.append(
                    student.getValue().toString() + "\n"));
            sb.append("\n");
        });

        File file = new File(Metods.importFiles("info.txt"));
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write(String.valueOf(sb));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej7(Map<Integer, Instituto> mapadeInstitutos) {
        mapadeInstitutos.entrySet().forEach(institute -> {
            System.out.println("Instituto con id:" + institute.getKey() + " y director:");
            System.out.println(institute.getValue().getDirector());
            int numberOfStudents = institute.getValue().getMapdeEstudiantes().size();
            int numberOfTeachers = institute.getValue().getMapdeProfesores().size();
            System.out.println("Estudiantes: " + numberOfStudents);
            System.out.println("Profesores: " + numberOfTeachers);
            System.out.println();
        });
    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej8() {
        List<Instituto> listaFusion = new ArrayList<>(GeneradordeDatos.listaInstitutos.get().values().stream().toList());
        listaFusion.addAll(GeneradordeDatos.listaInstitutos.get().values().stream().toList());
        listaFusion.stream().distinct().forEach(institute -> System.out.println(institute.getDirector().toString()));
    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej9(Map<Integer, Instituto> mapadeInstitutos) {
        File file = new File(Metods.importFiles("formatedInfo.txt"));
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            StringBuilder sb = new StringBuilder();
            mapadeInstitutos.entrySet().stream().forEach(institute -> {
                institute.getValue().getMapdeEstudiantes().forEach((id, students) -> {
                    Map<String, Float> subjectNotes = students.getListaAsignaturasyNotas();
                    subjectNotes.replaceAll((subject, note) -> {
                        return Math.round(note * 10f) / 10f;
                    });
                });
                sb.append("Instituto con id: ").append(institute.getKey()).append("\n").append(institute.getValue()
                        .getDirector()).append("\n").append("Lista de profesores:\n");
                institute.getValue().getMapdeProfesores().entrySet().forEach(teacher -> sb.append(teacher.getValue().toString() + "\n"));
                sb.append("Lista de alumnos:\n");
                institute.getValue().getMapdeEstudiantes().entrySet().forEach(student -> sb.append(student.getValue().toString() + "\n"));
                sb.append("\n");
            });

            bw.write(String.valueOf(sb));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej10(Map<Integer, Instituto> mapadeInstitutos) {
        File file = new File(Metods.importFiles("losMejoresAlumnos.txt"));
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            StringBuilder sb = new StringBuilder();
            mapadeInstitutos.entrySet().forEach(institute -> {
                institute.getValue().getMapdeEstudiantes().values().forEach(student -> {
                    boolean bestNotes = student.getListaAsignaturasyNotas().values().stream()
                            .allMatch(note -> note >= 9.0);
                    if (bestNotes){
                        sb.append(student.toString() + "\n");
                    }
                });
            });

            bw.write(String.valueOf(sb));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej11(Map<Integer, Instituto> mapadeInstitutos) {

    }

//----------------------------------------------------------------------------------------------------------------------

    private static void ej12(Map<Integer, Instituto> mapadeInstitutos) {

    }
}