public class Main {
    public static void main(String[] args) {

        GameManager gm = new GameManager();

        FabricaDeBarcos fb = new FabricaDeBarcos();

        Jugador jh = new JugadorHumano(fb.getNewBarcos());
        Jugador jb = new JugadorBot(fb.getNewBarcos());

        GameManager.limpiarConsola();

        gm.addPlayer(jh);
        gm.addPlayer(jb);

        gm.initGame();
        gm.initTableros();

        jb.colocarBarcos();
        jh.colocarBarcos();

        do {
            gm.mostrarTableros();
            jh.lanzarBomba(jb);
            if (jb.lost()) {
                break;
            }
            gm.mostrarTableros();
            GameManager.sleep(1);
            jb.lanzarBomba(jh);
            if (jh.lost()) {
                break;
            }
        } while (true);
        gm.mostrarResultados();

    }
}



/*
        System.out.println("                                                    _  _\n" +
                "                                                   ' \\/ '\n" +
                "   _  _                        <|\n" +
                "    \\/              __'__     __'__      __'__\n" +
                "                   /    /    /    /     /    /\n" +
                "                  /\\____\\    \\____\\     \\____\\               _  _\n" +
                "                 / ___!___   ___!___    ___!___               \\/\n" +
                "               // (      (  (      (   (      (\n" +
                "             / /   \\______\\  \\______\\   \\______\\\n" +
                "           /  /   ____!_____ ___!______ ____!_____\n" +
                "         /   /   /         //         //         /\n" +
                "      /    /   |         ||         ||         |\n" +
                "     /_____/     \\         \\\\         \\\\         \\\n" +
                "           \\      \\_________\\\\_________\\\\_________\\\n" +
                "            \\         |          |         |\n" +
                "             \\________!__________!_________!________/\n" +
                "              \\|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_/|\n" +
                "               \\    _______________                /\n" +
                "^^^%%%^%^^^%^%%^\\_\"/_)/_)_/_)__)/_)/)/)_)_\"_'_\"_//)/)/)/)%%%^^^%^^%%%%^\n" +
                "^!!^^\"!%%!^^^!^^^!!^^^%%%%%!!!!^^^%%^^^!!%%%%^^^!!!!!!%%%^^^^%^^%%%^^^!\n");
*/