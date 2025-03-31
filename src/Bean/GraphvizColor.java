package Bean;

public enum GraphvizColor {
    RED("red"), LIGHT_RED("lightcoral"),
    BLUE("blue"), LIGHT_BLUE("lightblue"),
    GREEN("green"), LIGHT_GREEN("lightgreen"),
    YELLOW("yellow"), LIGHT_YELLOW("lightyellow"),
    ORANGE("orange"),
    PURPLE("purple"),
    PINK("pink"),
    BLACK("black"),
    WHITE("white"),
    GRAY("gray"), LIGHT_GRAY("lightgray"),
    BROWN("brown"),
    CYAN("cyan"), LIGHT_CYAN("lightcyan"),
    MAGENTA("magenta"), LIGHT_MAGENTA("violet");

    private final String colorName;

    GraphvizColor(String colorName) {
        this.colorName = colorName;
    }

    public String getColor() {
        return colorName;
    }

    public static GraphvizColor fromString(String color) {
        for (GraphvizColor graphvizColor : GraphvizColor.values()) {
            if (graphvizColor.colorName.equalsIgnoreCase(color)) {
                return graphvizColor;
            }
        }
        throw new IllegalArgumentException("Color no soportado: " + color);
    }
}

