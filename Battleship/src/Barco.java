public class Barco {
    private final ParteDeBarco[] partes;
    private boolean isHundido = false;


    public Barco(ParteDeBarco[] partes) {
        this.partes = partes;
        for (var parte : partes) {
            parte.setBarco(this);
        }
    }

    public void mostrarBarco() {
        Casilla[][] tBarco = new Casilla[8][20];
        for (int i = 0; i < tBarco.length; i++) {
            for (int j = 0; j < tBarco[i].length; j++) {
                tBarco[i][j] = new Casilla();
                tBarco[i][j].getSkin().setBackgroundColor("");
            }
        }
        for (ParteDeBarco parte : partes) {
            tBarco[4 + parte.getX()][4 + parte.getY()].setPdb(parte);
        }
        for (Casilla[] casillas : tBarco) {
            for (Casilla casilla : casillas) {
                System.out.print(casilla);
            }
            System.out.println();
        }
    }

    public void rotarBarco() {
        for (ParteDeBarco parte : partes) {
            int aux = parte.getX();
            parte.setX(parte.getY());
            parte.setY(-aux);
        }
    }

    public ParteDeBarco[] getPartes() {
        return partes;
    }

    public void setBarcoToHundido() {
        this.isHundido = true;
        for (ParteDeBarco parte : partes) {
            parte.getSkin().setBackgroundColor(Color.RED_BACKGROUND);

        }
    }


    public boolean isHundido() {
        return partes.length == getPdbHundidasCount();
    }


    public int getPdbHundidasCount() {
        int count = 0;
        for (var parte : partes) {
            if (parte.isDamaged()) {
                count++;
            }
        }
        return count;
    }


}
