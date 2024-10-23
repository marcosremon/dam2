package Methods;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Methods {
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
}