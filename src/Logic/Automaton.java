package Logic;

import Bean.Node;
import Utility.GraphvizController;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Automaton {
    private Node currentNode;
    private int index = 0;

    public Automaton(Node initialNode) {
        this.currentNode = initialNode;
    }

    public boolean evaluate(String inputString) {
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

    public void Show(){
        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        StringBuilder ConfigGraphviz = new StringBuilder("graph g\n{\n");

        queue.add(currentNode);
        visited.add(currentNode);

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.getLinkA() != null) {
                ConfigGraphviz.append(String.format("%s -> %s [label=\"a\"];\n",node.getName(),node.getLinkA().getName()));
                if (!visited.contains(node.getLinkA())) {
                    queue.add(node.getLinkA());
                    visited.add(node.getLinkA());
                }
            }

            if (node.getLinkB() != null) {
                ConfigGraphviz.append(String.format("%s -> %s [label=\"b\"];\n",node.getName(),node.getLinkB().getName()));
                if (!visited.contains(node.getLinkB())) {
                    queue.add(node.getLinkB());
                    visited.add(node.getLinkB());
                }
            }
        }
        ConfigGraphviz.append("Q0 [color=red];\n");
        ConfigGraphviz.append("}\n");
        GraphvizController.generate(ConfigGraphviz.toString());
    }

}
