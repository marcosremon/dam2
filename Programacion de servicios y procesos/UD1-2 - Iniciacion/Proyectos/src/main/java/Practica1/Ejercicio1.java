package Practica1;

import java.io.*;

public class Ejercicio1 {
    public static void main(String[] args) {
        try {
            File filePath = new File("Files/batPings.bat");
            File logFilePath = new File("Files/log.txt");
            File errorLogFilePath = new File("Files/errorLog.txt");

            ProcessBuilder pbInput = new ProcessBuilder(String.valueOf(filePath));
            ProcessBuilder pbLog = pbInput.redirectOutput(logFilePath);
            ProcessBuilder pbErrorLog = pbInput.redirectError(errorLogFilePath);
            pbInput.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}