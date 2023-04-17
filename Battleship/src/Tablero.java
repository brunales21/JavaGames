public class Tablero {
    public final static int WIDTH = 10;
    public final static int HEIGHT = 10;
    private Casilla[][] casillas = new Casilla[WIDTH][HEIGHT];


    public void showTablero() {
        char[] letras = getLetras();
        int[] numeros = getNumeros();
        System.out.print(" ");
        for (int i = 0; i < 10; i++) {
            System.out.print(Color.WHITE_BOLD_BRIGHT+" "+numeros[i]+"");
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.print(Color.WHITE_BOLD_BRIGHT+letras[i]+" ");
            for (int j = 0; j < casillas.length; j++) {
                System.out.print(Color.RESET+casillas[i][j]);
            }
            System.out.println();
        }
    }



    private static char[] getLetras() {
        char[] abecedario = new char[26];
        for (int i = 0; i < abecedario.length; i++) {
            abecedario[i] = (char)('A' + i);
        }
        return abecedario;
    }

    private static int[] getNumeros() {
        int[] numeros = new int[10];
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = i;
        }
        return numeros;
    }

    public Casilla[][] getCasillas() {
        return casillas;
    }

    public void setCasillas(Casilla[][] casillas) {
        this.casillas = casillas;
    }
}
