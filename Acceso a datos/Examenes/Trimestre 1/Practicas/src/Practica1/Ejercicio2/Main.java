package Practica1.Ejercicio2;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        String filePath = "Files/input.txt";
        String floatTxtPath = "Files/Float.txt";
        String intTxtPath = "Files/Integer.txt";
        String stringTxtPath = "Files/String.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath));
             BufferedWriter bwFlo = new BufferedWriter(new FileWriter(floatTxtPath));
             BufferedWriter bwInt = new BufferedWriter(new FileWriter(intTxtPath));
             BufferedWriter bwStr = new BufferedWriter(new FileWriter(stringTxtPath))) {

            String floatsRegex = "\\d+\\.\\d+";
            String integerRegex = "\\d+";
            String stringRegex = ".*";

            String line = null;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\s");
                for (String i : parts) {
                    if (i.matches(floatsRegex)) {
                        bwFlo.write(i);
                        bwFlo.newLine();
                    } else if (i.matches(integerRegex)) {
                        bwInt.write(i);
                        bwInt.newLine();
                    } else if (i.matches(stringRegex)) {
                        bwStr.write(i);
                        bwStr.newLine();
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