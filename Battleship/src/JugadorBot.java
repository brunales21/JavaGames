import java.util.Random;

public class JugadorBot extends Jugador {
    private final Random random = new Random();

    public JugadorBot(Barco[] barcos) {
        super(barcos);
        super.setNombre(Color.RED+"BOT NAVY");
    }

    @Override
    public void colocarBarcos() {
        int posicionX;
        int posicionY;
        for (var barco : getBarcos()) {
            int rand = random.nextInt(4);
            for (int i = 0; i <= rand; i++) {
                barco.rotarBarco();
            }
            do {
                posicionX = random.nextInt(10);
                posicionY = random.nextInt(10);
            } while (!colocarBarco(barco, true, posicionX, posicionY));
        }
    }


    @Override
    public void lanzarBomba(Jugador jugador) {
        tiros++;
        int posicionX, posicionY;
        Casilla casillaAfectada;
        do {
            posicionX = random.nextInt(10);
            posicionY = random.nextInt(10);
            casillaAfectada = jugador.getTablero().getCasillas()[posicionX][posicionY];
        } while (casillaAfectada.isSelected());
        casillaAfectada.select();
        if (casillaAfectada.isPdb() && casillaAfectada.getPdb().getBarco().isHundido()) {
            casillaAfectada.getPdb().getBarco().setBarcoToHundido();
        }
    }
}
