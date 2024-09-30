import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ImportFiles {
    public static String getProduct(String file) {
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