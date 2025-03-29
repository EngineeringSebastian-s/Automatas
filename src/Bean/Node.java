package Bean;

public class Node {
    public String name;
    public boolean isFinal;
    private boolean isInitial;
    private Node linkA = null;
    private Node linkB = null;

    public Node(String name, boolean isInitial, boolean isFinal) {
        this.isInitial = isInitial;
        this.isFinal = isFinal;
        this.name = name;
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

    public Node getLinkA() {
        return linkA;
    }

    public void setLinkA(Node linkA) {
        this.linkA = linkA;
    }

    public Node getLinkB() {
        return linkB;
    }

    public void setLinkB(Node linkB) {
        this.linkB = linkB;
    }
}
