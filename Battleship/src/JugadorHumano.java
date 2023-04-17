import java.util.Scanner;

public class JugadorHumano extends Jugador {
    private final Scanner sc = new Scanner(System.in);

    public JugadorHumano(Barco[] barcos) {
        super(barcos);
    }

    @Override
    public void colocarBarcos() {
        GameManager.limpiarConsola();
        String rspt = "";
        int letra = 0;
        int num = 0;
        boolean rf;
        for (var barco : getBarcos()) {
            GameManager.limpiarConsola();
            getTablero().showTablero();
            barco.mostrarBarco();
            do {
                rspt = sc.nextLine();
                while (rspt.equals("")) {
                    GameManager.limpiarConsola();
                    getTablero().showTablero();
                    barco.rotarBarco();
                    barco.mostrarBarco();
                    rspt = sc.nextLine();
                }
                String posicion = rspt.replace(" ", "").toUpperCase();
                if (!respectsFormat(posicion)) {
                    System.out.println("Formato de entrada: letra+numero");
                    rf = false;
                    continue;
                } else {
                    rf = true;
                }
                letra = posicion.charAt(0)-'A';
                num = posicion.charAt(1)-'0';
                if (!isInTablero(barco, letra, num)) {
                    System.out.println("Fuera del tablero");
                    continue;
                }
                if (pisaBarco(barco, letra, num)) {
                    System.out.println("Se superpone con otro barco");
                }
            } while (!rf || !colocarBarco(barco, false, letra, num));

        }
    }

    @Override
    public void lanzarBomba(Jugador jugador) {
        tiros++;
        String posicion = "";
        Casilla casillaAfectada = null;
        int letra = 0;
        int num = 0;
        do {
            System.out.print("Coordenada de lanzamiento: ");
            posicion = sc.nextLine().replaceAll(" ", "").toUpperCase();
            if (!respectsFormat(posicion)) {
                System.out.println("Formato de entrada: (A-J)(0-9)");
                continue;
            }
            letra = posicion.charAt(0)-'A';
            num = posicion.charAt(1)-'0';
            casillaAfectada = jugador.getTablero().getCasillas()[letra][num];
            if (casillaAfectada.isSelected()) {
                System.out.println("Esta casilla ya esta usada.");
            }
        } while (casillaAfectada == null || casillaAfectada.isSelected());
        casillaAfectada.select();

        if (casillaAfectada.isPdb() && casillaAfectada.getPdb().getBarco().isHundido()) {
            casillaAfectada.getPdb().getBarco().setBarcoToHundido();
        }
    }

    private boolean respectsFormat(String position) {
        if (position.length() == 2) {
            return isBetween(65, 75, position.charAt(0)) && isBetween(48, 57, position.charAt(1));
        }
        return false;
    }

    private boolean isBetween(int x, int y, int p) {
        return p>=x && p<=y;
    }
    public Scanner getSc() {
        return sc;
    }
}
