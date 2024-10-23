package Practica1.Ejercicio2;

import Methods.Methods;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {

        Path inputPath = Paths.get(Methods.importFiles("input.txt"));
        Path floatOutputPath = Paths.get(Methods.importFiles("Float.txt"));
        Path integerOutputPath = Paths.get(Methods.importFiles("Integer.txt"));
        Path stringOutputPath = Paths.get(Methods.importFiles("String.txt"));

        try (BufferedReader br = Files.newBufferedReader(inputPath) ;
             BufferedWriter bwFloat = Files.newBufferedWriter(floatOutputPath);
             BufferedWriter bwInteger = Files.newBufferedWriter(integerOutputPath);
             BufferedWriter bwString = Files.newBufferedWriter(stringOutputPath)) {

            String floatsRegex = "\\d+\\.\\d+";
            String integerRegex = "\\d+";

            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\s");
                for (String i : parts) {
                    if (i.matches(floatsRegex)) {
                        bwFloat.write(i + System.lineSeparator());
                    } else if (i.matches(integerRegex)) {
                        bwInteger.write(i + System.lineSeparator());
                    } else {
                        bwString.write(i + System.lineSeparator());
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}