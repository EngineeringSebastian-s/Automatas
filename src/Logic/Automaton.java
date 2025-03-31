package Logic;

import Bean.Node;
import Bean.Symbol;
import Utility.GraphvizController;

import java.util.*;

public class Automaton {
    private final Node initalNode;
    public List<Symbol> symbols;

    public Automaton(Node initialNode, List<Symbol> symbols) {
        this.initalNode = initialNode;
        if (symbols == null || symbols.size() != 2) {
            throw new IllegalArgumentException("La lista de símbolos debe contener exactamente 2 elementos.");
        }
        this.symbols = symbols;

    }

    public boolean evaluate(String inputString) {

        for (char symbol : inputString.toCharArray()) {
            if (symbols.stream().noneMatch(s -> s.getCharacter() == symbol)) {
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
            Node nextNode = currentNode.getTransitionNode(symbol);

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
            for(Symbol symbol : this.symbols) {
                Node linkedNode = node.getTransitionNode(symbol.getCharacter());
                if (linkedNode != null) {
                    ConfigGraphviz.append(node.getName()).append(" -> ")
                            .append(linkedNode.getName()).append(" [label=\"")
                            .append(symbol.getCharacter()).append("\", color=").append(symbol.getColor()).append("];\n");

                    if (visited.add(linkedNode)) {
                        queue.add(linkedNode);
                    }
                }
            }
        }
        ConfigGraphviz.append("}\n");
        GraphvizController.generate(ConfigGraphviz.toString());
    }
}
