package View;

import Bean.Node;
import Logic.Automaton;

import javax.swing.*;

public class Menu {
    public static void runMenu(Node initialNode) {
        boolean running = true;
        while (running) {
            String[] options = {"Enter string", "Exit"};
            int selection = JOptionPane.showOptionDialog(
                    null, "Select one:", "Let's play a game!",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, options, options[0]);

            if (selection == 0) {
                String inputString = JOptionPane.showInputDialog("Enter the string to evaluate");
                if (inputString != null) {
                    Automaton automaton = new Automaton(initialNode, inputString);
                    JOptionPane.showMessageDialog(null, automaton.evaluate());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Goodbye!");
                running = false;
            }
        }
    }
}
