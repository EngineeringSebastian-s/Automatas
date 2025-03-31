package Logic;

import Bean.Node;
import Utility.GraphvizController;

import java.util.*;

public class Automaton {
    private final Node initalNode;
    public List<String> symbols;

    public Automaton(Node initialNode, List<String> symbols) {
        this.initalNode = initialNode;
        if (symbols == null || symbols.size() != 2) {
            throw new IllegalArgumentException("La lista de símbolos debe contener exactamente 2 elementos.");
        }
        this.symbols = symbols;

    }

    public boolean evaluate(String inputString) {

        for (char symbol : inputString.toCharArray()) {
            if (!symbols.contains(String.valueOf(symbol))) {
                return false;
            }
        }

        int index = 0;
        StringBuilder ConfigGraphviz = new StringBuilder("digraph g {\n")
                .append("rankdir=LR;\n")
                .append("inicio [shape=plaintext];\n")
                .append("node [fillcolor=yellow,style=filled];\n");
        Node currentNode = this.initalNode;
        while (index < inputString.length()) {
            char symbol = inputString.charAt(index);
            Node nextNode = getNextNode(currentNode, symbol, this.symbols);

            if (nextNode == null) {
                return false;
            }

            if (currentNode.isFinal()) {
                ConfigGraphviz.append(String.format("%s [shape=doublecircle]", currentNode.getName()));
            }

            if (currentNode.isInitial()) {
                ConfigGraphviz.append(String.format("inicio -> %s;\n%s [fillcolor=lightblue, style=filled]", currentNode.getName(), currentNode.getName()));
            }

            ConfigGraphviz.append(String.format("%s -> %s [label=\"%c\"];\n", currentNode.getName(), nextNode.getName(), symbol));
            currentNode = nextNode;
            index++;
        }
        ConfigGraphviz.append("}\n");
        if (currentNode.isFinal()) {
            GraphvizController.generate(ConfigGraphviz.toString());
            return true;
        }
        return false;
    }

    private Node getNextNode(Node currentNode, char symbol, List<String> symbols) {
        if (symbols.size() < 2) {
            return null;
        }

        if (String.valueOf(symbol).equals(symbols.get(0))) {
            return currentNode.getLinkA();
        } else if (String.valueOf(symbol).equals(symbols.get(1))) {
            return currentNode.getLinkB();
        }
        return null;
    }

    public void Show() {
        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        StringBuilder ConfigGraphviz = new StringBuilder("digraph g {\n")
                .append("rankdir=LR;\n")
                .append("inicio [shape=plaintext];\n")
                .append("node [fillcolor=yellow,style=filled];\n");

        queue.add(this.initalNode);
        visited.add(this.initalNode);

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.isFinal()) {
                ConfigGraphviz.append(String.format("%s [shape=doublecircle]", node.getName()));
            }

            if (node.isInitial()) {
                ConfigGraphviz.append(String.format("inicio -> %s;\n%s [fillcolor=lightblue, style=filled]", node.getName(), node.getName()));
            }

            processLink(node, node.getLinkA(), "a", "red", queue, visited, ConfigGraphviz);
            processLink(node, node.getLinkB(), "b", "blue", queue, visited, ConfigGraphviz);
        }
        ConfigGraphviz.append("}\n");
        GraphvizController.generate(ConfigGraphviz.toString());
    }


    private void processLink(Node node, Node linkedNode, String label, String color,
                             Queue<Node> queue, Set<Node> visited, StringBuilder graphConfig) {
        if (linkedNode != null) {
            graphConfig.append(node.getName()).append(" -> ")
                    .append(linkedNode.getName()).append(" [label=\"")
                    .append(label).append("\", color=").append(color).append("];\n");

            if (visited.add(linkedNode)) { // Solo añade si no ha sido visitado
                queue.add(linkedNode);
            }
        }
    }
}
