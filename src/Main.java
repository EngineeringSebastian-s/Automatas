import Bean.Node;
import Logic.Automaton;
import View.Menu;

import java.util.List;


public class Main {
    public static void main(String[] args) {

        //initializeNodes
        Node q0 = new Node("Q0", true, false);
        Node q1 = new Node("Q1", false, true);
        Node q2 = new Node("Q2", false, false);
        Node q3 = new Node("Q3", false, false);
        Node q4 = new Node("Q4", false, true);
        Node q5 = new Node("Q5", false, true);
        Node q6 = new Node("Q6", false, true);
        Node q7 = new Node("Q7", false, true);

        q0.setLinkA(q4);
        q0.setLinkB(null);
        q1.setLinkA(q2);
        q1.setLinkB(q1);
        q2.setLinkA(q1);
        q2.setLinkB(q5);
        q4.setLinkA(q6);
        q4.setLinkB(q1);
        q5.setLinkA(q1);
        q5.setLinkB(q5);
        q6.setLinkA(q6);
        q6.setLinkB(q7);
        q7.setLinkA(q6);
        q7.setLinkB(q7);
        Automaton automaton = new Automaton(q0, List.of(new String[]{"a", "b"}));

        Menu.runMenu(automaton);
    }
}