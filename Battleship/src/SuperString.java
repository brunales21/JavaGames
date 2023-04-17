import jdk.swing.interop.SwingInterOpUtils;

public class SuperString {
    private String simbolo;
    private String color;
    private String backgroundColor = "";

    public SuperString(String simbolo, String color) {
        this.simbolo = simbolo;
        this.color = color;
    }

    public SuperString(String simbolo, String color, String backgroundColor) {
        this.simbolo = simbolo;
        this.color = color;
        this.backgroundColor = backgroundColor;
    }

    public boolean isBrigthBackground() {
        return backgroundColor.length() == 8;
    }
    public void setColorToNotBold() {
        StringBuilder sb = new StringBuilder(color);
        sb.replace(2, 3, "0");

        this.color = sb.toString();
    }

    public void setColorToBold() {
        StringBuilder sb = new StringBuilder(color);
        sb.replace(2, 3, "1");

        this.color = sb.toString();
    }

    public void setBackgroundColorToBright() {
        StringBuilder sb = new StringBuilder(this.backgroundColor);
        sb.delete(2, 3);
        sb.insert(2, "0;10");
        this.backgroundColor = sb.toString();
    }
    public void setBackgroundColorToNormal() {
        StringBuilder sb = new StringBuilder(this.backgroundColor);
        sb.delete(2, 6);
        sb.insert(2, "4");
        this.backgroundColor = sb.toString();
    }
    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    @Override
    public String toString() {
        return color+backgroundColor+simbolo+Color.RESET;
    }
}
