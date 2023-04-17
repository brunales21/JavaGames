public class ParteDeBarco {
    private Barco barco;
    private SuperString skin;
    private boolean damaged = false;
    private boolean hidden = false;
    private int x;
    private int y;


    public ParteDeBarco(SuperString skin, int x, int y) {
        this.skin = skin;
        this.x = x;
        this.y = y;

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void damage() {
        damaged = true;
        if (hidden) {
            hidden = false;
        }
        skin.setBackgroundColor(Color.RED_BACKGROUND_BRIGHT);

    }

    public boolean isHidden() {
        return hidden;
    }

    public void setVisibility(boolean hidden) {
        this.hidden = hidden;
    }

    public void hide() {
        this.hidden = true;
    }

    public boolean isDamaged() {
        return damaged;
    }

    public Barco getBarco() {
        return barco;
    }

    public void setBarco(Barco barco) {
        this.barco = barco;
    }

    public SuperString getSkin() {
        return skin;
    }

    public void setSkin(SuperString skin) {
        this.skin = skin;
    }

    @Override
    public String toString() {
        return skin.toString();
    }
}
