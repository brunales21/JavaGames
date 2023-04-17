import java.util.Random;
import java.util.Scanner;

public class TresEnRaya {

    public static Random rand = new Random();
    public static Scanner sc = new Scanner(System.in);
    final static String boardColor = Color.WHITE_BOLD_BRIGHT;
    final static String EMPTY_GAP = boardColor + "# ";

    public static void main(String[] args) {
        jugar();
    }


    public static void jugar() {
        final String p1Color = Color.GREEN;
        final String p2Color = Color.YELLOW_BOLD_BRIGHT;
        final String wordsColor = Color.CYAN_BOLD;

        String p1 = p1Color + "X ";
        String p2 = p2Color + "O ";

        boolean turno1 = randBool();
        int fila = 0;
        int columna = 0;
        do {
            cleanConsole();
            String[][] board = initGameBoard(EMPTY_GAP);
            System.out.println("\n" + Color.BLUE + "TaTeTi\n");
            System.out.println(Color.PURPLE_BOLD_BRIGHT + "1-Multiplayer" + Color.CYAN_BOLD_BRIGHT + "\n2-UserVsComputer" + Color.GREEN_BOLD_BRIGHT + "\n3-AI");
            boolean existsW = false;
            int input = sc.nextInt();
            boolean humanMode = true;
            boolean AIvsUser = false;


            switch (input) {
                case 1:
                    humanMode = true;
                    break;
                case 2:
                    AIvsUser = true;
                    break;
                case 3:
                    humanMode = false;
                    break;
            }

            do {
                showBoard(board);

                if (AIvsUser) {
                    humanMode = !humanMode;
                }

                if (!humanMode) {
                    sleep(1);
                }

                do {
                    //System.out.print(wordsColor + "row: ");
                    fila = getInput(humanMode);
                    //System.out.print(wordsColor + "col: ");
                    columna = getInput(humanMode);
                    //System.out.println();
                } while (!board[fila - 1][columna - 1].equals(EMPTY_GAP) || fila > 3 || fila < 0 || columna > 3 || columna < 0);

                if (turno1) {
                    board[fila - 1][columna - 1] = p1;
                    turno1 = false;
                } else {
                    board[fila - 1][columna - 1] = p2;
                    turno1 = true;
                }

                saltoDeLineax2();

                if (won(board, p1)) {
                    showBoard(board);
                    System.out.println(p1 + "won");
                    existsW = true;
                }
                if (won(board, p2)) {
                    showBoard(board);
                    System.out.println(p2 + "won");
                    existsW = true;
                } else if (!existsW && !contains(board, EMPTY_GAP)) {
                    showBoard(board);
                    System.out.println(Color.RED + "EMPATE");
                    break;
                }

            } while (!existsW);

        } while (seguirJugando());

    }

    public static void saltoDeLinea() {
        System.out.println();
    }

    public static void saltoDeLineax2() {
        System.out.println();
        System.out.println();
    }

    public static boolean checkWinner(String[][] board, String player) {

        int p = 0;

        //Checks horizontales
        for (int i = 0; i<6; i++) {
            p=0;
            for (int j = 0; j<7; j++) {
                if (!board[i][j].equals(player)) {
                    p = 0;
                } else {
                    p++;
                }
                if (p==4) {
                    return true;
                }
            }
        }

        p=0;

        //Checks verticales
        for (int i = 0; i<7; i++) {
            p=0;
            for (int j = 0; j<6; j++) {
                if (!board[j][i].equals(player)) {
                    p = 0;
                } else {
                    p++;
                }
                if (p==4) {
                    return true;
                }
            }
        }

        //Checks diagonales ->
        for (int offset = -2; offset<=0; offset++) {
            p = 0;
            for (int i = 0; i<=6; i++) {
                if (i-offset > 5) {
                    break;
                }
                if (!board[i-offset][i].equals(player)) {
                    p = 0;
                } else {
                    p++;
                }
                if (p==4) {
                    return true;
                }
            }

        }

        for (int offset = 1; offset<=3; offset++) {
            p = 0;
            for (int i = 0; i<=6; i++) {
                if (i+offset > 6) {
                    break;
                }
                if (!board[i][i+offset].equals(player)) {
                    p = 0;
                } else {
                    p++;
                }
                if (p==4) {
                    return true;
                }
            }

        }

        //Checks diagonales <-
        for (int columna = 3; columna<=8; columna++) {
            p=0;
            for (int fila = 0; fila<columna; fila++) {
                if (fila>5) {
                    break;
                }
                if (columna-fila>6) {
                    continue;
                }
/*
                if (board[fila][columna-fila].equals(player)) {
                    p++;
                } else {
                    p=0;
                }
 */
                p = (board[fila][columna-fila].equals(player)) ? p+1 : 0;

                if (p==4) {
                    return true;
                }
            }

        }


        return false;
    }

    public static void sleep(int time) {
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static boolean won(String[][] board, String player) {

        boolean line = false;

        //Checks horizontales
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                if (!board[x][y].equals(player)) {
                    line = false;
                    break;
                } else {
                    line = true;
                }
            }
            if (line) {
                return true;
            }
        }


        //Checks verticales
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                if (!board[y][x].equals(player)) {
                    line = false;
                    break;
                } else {
                    line = true;
                }
            }
            if (line) {
                return true;
            }
        }

        //Checks diagonales
        // (desc)
        for (int x = 0; x < 3; x++) {
            if (!board[x][x].equals(player)) {
                line = false;
                break;
            } else {
                line = true;
            }
        }
        if (line) {
            return true;
        }

        // (asc)
        for (int x = 0; x < 3; x++) {
            line = board[x][2 - x].equals(player);
            if (!line) {
                break;
            }
        }
        return line;
    }

    public static int getInput(boolean n) {
        if (n) return sc.nextInt();
        else return rand.nextInt(3) + 1;
    }

    public static boolean randBool() {
        return rand.nextInt(2) != 0;
    }

    public static boolean sonIguales(int[][] a, int[][] b) {
        boolean sonIguales = true;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] != b[i][j]) {
                    sonIguales = false;
                }
            }
        }
        return sonIguales;
    }

    public static String[][] initGameBoard(String c) {
        String[][] board = new String[3][3];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = c;
            }
        }
        return board;
    }

    public static String[][] initGameBoard(int height, int width, String c) {
        String[][] board = new String[height][width];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = c;
            }
        }
        return board;
    }


    public static void showBoard(String[][] array, String color) {
        cleanConsole();
        for (int x = 0; x < array.length; x++) {
            for (int y = 0; y < array[x].length; y++) {
                System.out.print(color + array[x][y]);
            }
            System.out.println();
        }
    }

    public static void showBoard(String[][] array) {
        cleanConsole();
        for (int x = 0; x < array.length; x++) {
            for (int y = 0; y < array[x].length; y++) {
                System.out.print(boardColor+array[x][y]);
            }
            System.out.println();
        }
    }

    public static boolean contains(String[][] sa, String s) {
        boolean contains = false;
        for (int i = 0; i < sa.length; i++) {
            if (contains) {
                break;
            }
            for (int j = 0; j < sa[0].length; j++) {
                if (s.equals(sa[i][j])) {
                    contains = true;
                    break;
                }
            }
        }
        return contains;
    }

    static final String RESPUESTAS_POSITIVAS = "YSys";
    static final String RESPUESTAS_NEGATIVAS = "Nn";


    //Esta funcion simplemente devuelve verdadero o falso en funcion del input (si recibe una s/y devuelve verdadero, si no falso)
    public static boolean seguirJugando() {

        Scanner scanner = new Scanner(System.in);
        String input;
        do {
            System.out.println(Color.WHITE_BOLD_BRIGHT+"DESEA JUGAR OTRA PARTIDA? (y/n)");
            input = scanner.nextLine();
        } while (RESPUESTAS_POSITIVAS.indexOf(input.charAt(0)) == -1 && RESPUESTAS_NEGATIVAS.indexOf(input.charAt(0)) == -1);

        if (RESPUESTAS_POSITIVAS.indexOf(input.charAt(0)) != -1) {
            return true;
        }
        return false;
    }

    public static void cleanConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


}
