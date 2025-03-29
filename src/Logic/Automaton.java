package Logic;

import Bean.Node;
import Utility.GraphvizController;

import java.util.*;

public class Automaton {
    private Node currentNode;
    public List<String> symbols;

    public Automaton(Node initialNode, List<String> symbols) {
        this.currentNode = initialNode;

        if (symbols == null || symbols.size() != 2) {
            throw new IllegalArgumentException("La lista de símbolos debe contener exactamente 2 elementos.");
        }

        this.symbols = symbols;

    }

    public boolean evaluate(String inputString) {
        inputString = inputString.toLowerCase();

        if (!inputString.matches("[ab]+")) {
            return false;
        }

        int index = 0;
        while (index < inputString.length()) {
            char symbol = inputString.charAt(index);

            Node nextNode = null;
            if (symbol == 'a') {
                nextNode = currentNode.getLinkA();
            } else if (symbol == 'b') {
                nextNode = currentNode.getLinkB();
            } else {
                return false;
            }

            if (nextNode == null) {
                return false;
            }

            currentNode = nextNode;
            index++;
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
