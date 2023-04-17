public class FabricaDeBarcos {

    public Barco[] getNewBarcos() {
        // Creamos la forma del cuadrado
        Barco cuadrado = new Barco(new ParteDeBarco[]{new ParteDeBarco(new SuperString("  ", Color.YELLOW, Color.YELLOW_BACKGROUND_BRIGHT), 0, 0), new ParteDeBarco(new SuperString("  ", Color.YELLOW, Color.YELLOW_BACKGROUND_BRIGHT), 0, 1), new ParteDeBarco(new SuperString("  ", Color.YELLOW, Color.YELLOW_BACKGROUND_BRIGHT), 1, 0), new ParteDeBarco(new SuperString("  ", Color.YELLOW, Color.YELLOW_BACKGROUND_BRIGHT), 1, 1)});
        Barco barcoL = new Barco(new ParteDeBarco[]{new ParteDeBarco(new SuperString("  ", Color.GREEN, Color.GREEN_BACKGROUND_BRIGHT), 0, 0), new ParteDeBarco(new SuperString("  ", Color.GREEN, Color.GREEN_BACKGROUND_BRIGHT), 1, 0), new ParteDeBarco(new SuperString("  ", Color.GREEN, Color.GREEN_BACKGROUND_BRIGHT), 2, 0), new ParteDeBarco(new SuperString("  ", Color.GREEN, Color.GREEN_BACKGROUND_BRIGHT), 2, 1)});
        Barco z = new Barco(new ParteDeBarco[]{new ParteDeBarco(new SuperString("  ", Color.WHITE, Color.WHITE_BACKGROUND_BRIGHT), 0, 0), new ParteDeBarco(new SuperString("  ", Color.WHITE, Color.WHITE_BACKGROUND_BRIGHT), 0, 1), new ParteDeBarco(new SuperString("  ", Color.WHITE, Color.WHITE_BACKGROUND_BRIGHT), 1, 1), new ParteDeBarco(new SuperString("  ", Color.WHITE, Color.WHITE_BACKGROUND_BRIGHT), 1, 2)});
        Barco barcoBarra = new Barco(new ParteDeBarco[]{new ParteDeBarco(new SuperString("  ", Color.CYAN, Color.CYAN_BACKGROUND_BRIGHT), 0, 0), new ParteDeBarco(new SuperString("  ", Color.CYAN, Color.CYAN_BACKGROUND_BRIGHT), 0, 1), new ParteDeBarco(new SuperString("  ", Color.CYAN, Color.CYAN_BACKGROUND_BRIGHT), 0, 2), new ParteDeBarco(new SuperString("  ", Color.CYAN, Color.CYAN_BACKGROUND_BRIGHT), 0, 3)});
        Barco barcoT = new Barco(new ParteDeBarco[]{new ParteDeBarco(new SuperString("  ", Color.PURPLE, Color.PURPLE_BACKGROUND_BRIGHT), 0, 0), new ParteDeBarco(new SuperString("  ", Color.PURPLE, Color.PURPLE_BACKGROUND_BRIGHT), 1, -1), new ParteDeBarco(new SuperString("  ", Color.PURPLE, Color.PURPLE_BACKGROUND_BRIGHT), 1, 0), new ParteDeBarco(new SuperString("  ", Color.PURPLE, Color.PURPLE_BACKGROUND_BRIGHT), 1, 1)});

        Barco[] barcos = new Barco[]{cuadrado, barcoBarra, barcoT, barcoL, z};
        for (Barco barco: barcos) {
            for (ParteDeBarco parte: barco.getPartes()) {
                if (parte.getX() == 0 && parte.getY() == 0) {
                    //Se destaca parte origen
                    parte.getSkin().setBackgroundColorToNormal();
                }
            }
        }
        return barcos;
    }
}
