package Practica1.Ejercicio1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Path workingDirectory = Path.of(System.getProperty("user.dir"));
        Path exercisePath = Path.of(workingDirectory + File.separator + "src" + File.separator + "Practica1" + File.separator + "Ejercicio1");
        Path errorDir = Path.of(exercisePath + File.separator + "Error" + File.separator);
        Path logsDir = Path.of(exercisePath + File.separator + "Logs");
        Path procesedDir = Path.of(exercisePath + File.separator + "Procesed");

        directoryGenerator(errorDir, procesedDir);

        File[] logsFiles = logsDir.toFile().listFiles();
        for (File file : logsFiles) {
            try {
                List<String> fileContent = Files.readAllLines(file.toPath());
                boolean containsError = fileContent.stream().anyMatch(line -> line.matches("(?i).*\\berror\\b.*"));
                if (containsError) {
                    Files.move(file.toPath(), errorDir.resolve(file.getName()), StandardCopyOption.REPLACE_EXISTING);
                } else {
                    Files.move(file.toPath(), procesedDir.resolve(file.getName()), StandardCopyOption.REPLACE_EXISTING);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void directoryGenerator(Path directory1, Path directory2) {
        try {
            if (!Files.exists(directory1) && !Files.isDirectory(directory1)) {
                Files.createDirectory(directory1);
            }
            if (!Files.exists(directory2) && !Files.isDirectory(directory2)) {
                Files.createDirectory(directory2);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}