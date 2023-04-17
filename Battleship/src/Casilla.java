public class Casilla {
    private boolean selected = false;
    private SuperString skin = new SuperString("  ", "", Color.BLUE_BACKGROUND_BRIGHT);
    private ParteDeBarco pdb;


    public Casilla() {

    }
    public Casilla(String backgroundColor) {
        this.skin.setBackgroundColor(backgroundColor);
    }


    public boolean isDamaged() {
        return selected;
    }

    public boolean isPdb() {
        return pdb != null;
    }

    public void select() {
        this.selected = true;
        if (isPdb()) {
            this.pdb.damage();
        } else {
            this.skin.setSimbolo("~ ");
            this.skin.setBackgroundColor(Color.BLUE_BACKGROUND_BRIGHT);
        }
    }

    public boolean isSelected() {
        return selected;
    }

    public SuperString getSkin() {
        return skin;
    }

    public void setSkin(SuperString skin) {
        this.skin = skin;
    }

    public ParteDeBarco getPdb() {
        return pdb;
    }

    public void setPdb(ParteDeBarco pdb) {
        this.pdb = pdb;
    }


    @Override
    public String toString() {
        if (!isPdb() || getPdb().isHidden()) {
            return skin.toString();
        }
        return this.pdb.toString();
    }
}
