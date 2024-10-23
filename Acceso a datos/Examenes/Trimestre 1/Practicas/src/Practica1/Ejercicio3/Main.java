package Practica1.Ejercicio3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        Map<Boolean, List<Integer>> partitioned = numbers.stream().collect(Collectors.partitioningBy(num -> num % 2 == 0));
        System.out.println(partitioned);
    }
}