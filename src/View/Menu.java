package View;

import Logic.Automaton;

import javax.swing.*;
import java.util.Scanner;

public class Menu {
    public static void runMenu(Automaton automaton) {
        Scanner sc = new Scanner(System.in);
        boolean app = true;
        while (app) {
            String option = MainMenu();
            switch (option) {
                case "Evaluar recorrido":
                    String inputString = JOptionPane.showInputDialog("Ingrese la cadena a evaluar");
                    boolean ope = automaton.evaluate(inputString);
                    if (ope) {
                        JOptionPane.showMessageDialog(null, "Recorrido realizado con éxito", "Verdadero", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "El Recorrido no se puede realizar", "Falso", JOptionPane.ERROR_MESSAGE);
                    }

                    break;
                case "Ver automata":
                    automaton.Show();
                    break;
                case "Salir":
                    System.out.println("Saliendo del programa...");
                    app = false;
                    break;
            }
        }
    }

    public static String MainMenu() {
        String[] options = {"Evaluar recorrido", "Ver automata", "Salir"};
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
