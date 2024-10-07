package Metods;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Metods {
    public static String importFiles(String file) {
        try {
            String workingDirectory = System.getProperty("user.dir");
            String subDirectory = workingDirectory + "/Files";
            Path path = Paths.get(subDirectory + File.separator + file);
            return String.valueOf(path);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Integer> DuplicateNumbersRemover(List<Integer> numbersList) {
        numbersList = numbersList.stream().distinct().toList();
        return numbersList;
    }

    public static List<?> DuplicateRemover(List<?> numbersList) {
        numbersList = numbersList.stream().distinct().toList();
        return numbersList;
    }

    public static void namesKey(List<String> names) {
        Map<Integer, String> namesMap = IntStream.range(0, names.size()).boxed().collect(Collectors.toMap(
                i -> (i + 1), names::get));
        System.out.println(namesMap);
    }

    public static void namesKeyDuplicateRemover(List<String> names) {
        names = names.stream().distinct().toList();
        Map<Integer, String> namesMap = IntStream.range(0, names.size()).boxed().collect(Collectors.toMap(
                i -> (i + 1), names::get));
        System.out.println(namesMap);
    }
}