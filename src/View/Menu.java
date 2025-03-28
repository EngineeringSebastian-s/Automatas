package View;

import Bean.Node;
import Logic.Automaton;

import javax.swing.*;
import java.util.Scanner;

public class Menu {
    public static void runMenu(Node initialNode) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        while (running) {
            String option = MainMenu();
            switch (option) {
                case "Ingresar cadena":
                    String inputString = JOptionPane.showInputDialog("Ingrese la cadena a evaluar");
                    Automaton automaton = new Automaton(initialNode, inputString);
                    System.out.println("Resultado: " + automaton.evaluate());
                    break;
                case "Salir":
                    System.out.println("Saliendo del programa...");
                    running = false;
                    break;
            }
        }
    }

    public static String MainMenu() {
        String[] options = {"Ingresar cadena", "Salir"};
        return (String) JOptionPane.showInputDialog(
                null,
                "Seleccione una opción:",
                "Menú del Autómata",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );
    }
}
