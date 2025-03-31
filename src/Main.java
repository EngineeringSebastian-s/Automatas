import Bean.Node;
import Bean.Symbol;
import Logic.Automaton;
import View.Menu;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        List<Symbol> symbols = new ArrayList<Symbol>();
        symbols.add(new Symbol('a',"red"));
        symbols.add(new Symbol('b',"blue"));

        //initializeNodes
        Node q0 = new Node("Q0", true, false);
        Node q1 = new Node("Q1", false, true);
        Node q2 = new Node("Q2", false, false);
        Node q3 = new Node("Q3", false, false);
        Node q4 = new Node("Q4", false, true);
        Node q5 = new Node("Q5", false, true);
        Node q6 = new Node("Q6", false, true);
        Node q7 = new Node("Q7", false, true);

        q0.setTransitionNode('a', q4);
        q1.setTransitionNode('a', q2);
        q1.setTransitionNode('b', q1);
        q2.setTransitionNode('a', q1);
        q2.setTransitionNode('b', q5);
        q4.setTransitionNode('a', q6);
        q4.setTransitionNode('b', q1);
        q5.setTransitionNode('a', q1);
        q5.setTransitionNode('b', q5);
        q6.setTransitionNode('a', q6);
        q6.setTransitionNode('b', q7);
        q7.setTransitionNode('a', q6);
        q7.setTransitionNode('b', q7);

        Automaton automaton = new Automaton(q0, symbols);

        Menu.runMenu(automaton);
    }
}