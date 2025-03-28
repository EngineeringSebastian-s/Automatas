package Bean;

public class Node {
    public boolean isFinal;
    private boolean isInitial;
    private Node linkA = null;
    private Node linkB = null;
    private int state;

    public Node(boolean isInitial, boolean isFinal) {
        this.isInitial = isInitial;
        this.isFinal = isFinal;
    }

    public boolean isFinal() {
        return isFinal;
    }

    public void setFinal(boolean isFinal) {
        this.isFinal = isFinal;
    }

    public boolean isInitial() {
        return isInitial;
    }

    public void setInitial(boolean isInitial) {
        this.isInitial = isInitial;
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

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
