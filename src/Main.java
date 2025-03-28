import Bean.Node;
import Logic.Automaton;

import static Logic.Automaton.initializeNodes;
import static View.Menu.runMenu;


public class Main {
    public static void main(String[] args) {
        Node initialNode = initializeNodes();
        Automaton automaton = new Automaton(initialNode, "aaa");
        System.out.println(automaton.evaluate());

        runMenu(initialNode);
    }
}