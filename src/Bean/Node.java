package Bean;

import java.util.HashMap;

public class Node {
    public String name;
    private boolean isFinal;
    private boolean isInitial;
    private HashMap<Character, Node> transitions;

    public Node(String name, boolean isInitial, boolean isFinal) {
        this.isInitial = isInitial;
        this.isFinal = isFinal;
        this.name = name;
        this.transitions = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFinal() {
        return isFinal;
    }

    public void setFinal(boolean aFinal) {
        isFinal = aFinal;
    }

    public boolean isInitial() {
        return isInitial;
    }

    public void setInitial(boolean initial) {
        isInitial = initial;
    }

    public HashMap<Character, Node> getTransitions() {
        return transitions;
    }

    public void setTransitions(HashMap<Character, Node> transitions) {
        this.transitions = transitions;
    }

    public Node getTransitionNode(Character character) {
        return transitions.get(character);
    }

    public void setTransitionNode(Character character, Node node) {
        transitions.put(character, node);
    }
}
