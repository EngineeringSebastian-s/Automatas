package Utility;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class GraphvizController {

    public static void generate(String statement) {
        createFile(statement);
        createImage();
        openImage();
    }

    public static void openImage() {
        String rootPath = System.getProperty("user.dir");
        String imagePath = rootPath + "\\src\\View\\Graph.jpg";
        System.out.println("Abriendo imagen... (5 seg)");

        File imageFile = new File(imagePath);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (imageFile.exists()) {
            try {
                Desktop.getDesktop().open(imageFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("La imagen no existe en la ruta especificada.");
        }
    }

    public static void createFile(String statement) {
        try {
            clearFile();
            String rootPath = System.getProperty("user.dir");
            FileWriter fileWriter = new FileWriter(rootPath + "\\src\\Utility\\ConfigGraphviz.txt");
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write(statement);
            writer.close();
        } catch (Exception ex) {
            System.out.println("No se ha podido generar la imagen: " + ex.getMessage());
        }
    }

    public static void clearFile() {
        try {
            String rootPath = System.getProperty("user.dir");
            FileWriter writer = new FileWriter(rootPath + "\\src\\Utility\\ConfigGraphviz.txt");
            writer.write("");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error al vaciar el archivo: " + e.getMessage());
        }
    }

    public static void createImage() {
        try {
            String rootPath = System.getProperty("user.dir");
            String dotPath = rootPath + "\\libraries\\Graphviz\\dot.exe";
            String inputFilePath = rootPath + "\\src\\Utility\\ConfigGraphviz.txt";
            String outputFilePath = rootPath + "\\src\\View\\Graph.jpg";

            String typeParam = "-Tjpg";
            String outputParam = "-o";

            String[] command = new String[5];
            command[0] = dotPath;
            command[1] = typeParam;
            command[2] = inputFilePath;
            command[3] = outputParam;
            command[4] = outputFilePath;

            Runtime runtime = Runtime.getRuntime();
            runtime.exec(command);
            System.out.println(Arrays.toString(command));
        } catch (Exception e) {
            System.out.println("No se ha podido generar la imagen: " + e.getMessage());
        }
    }
}
