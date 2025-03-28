package Logic;

import Bean.Node;

public class Automaton {
    private Node currentNode;
    private final String inputString;
    private int index = 0;

    public Automaton(Node initialNode, String inputString) {
        this.currentNode = initialNode;
        this.inputString = inputString;
    }

    public static Node initializeNodes() {
        Node q0 = new Node(true, false);
        Node q1 = new Node(false, true);
        Node q2 = new Node(false, false);
        Node q4 = new Node(false, true);
        Node q5 = new Node(false, true);
        Node q6 = new Node(false, true);
        Node q7 = new Node(false, true);

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

        return q0;
    }

    public boolean evaluate() {
        while (index < inputString.length()) {
            char symbol = inputString.charAt(index);
            Node nextNode = (symbol == 'a') ? currentNode.getLinkA() : currentNode.getLinkB();

            if (nextNode != null) {
                currentNode = nextNode;
                index++;
            } else {
                return false;
            }
        }
        return currentNode.isFinal();
    }

}
