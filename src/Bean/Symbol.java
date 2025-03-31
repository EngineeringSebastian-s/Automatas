package Bean;

import static Bean.GraphvizColor.fromString;

public class Symbol {
    private Character character;
    private GraphvizColor color;

    public Symbol(Character character, String color) {
        this.character = character;
        this.color = fromString(color);
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public void setColor(String color) {
        this.color = fromString(color);
    }

    public String getColor() {
        return color.getColor();
    }

}
