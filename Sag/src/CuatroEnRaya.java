import java.util.Random;
import java.util.Scanner;

public class CuatroEnRaya {
    public static Random rand = new Random();
    public static Scanner sc = new Scanner(System.in);
    public static final String EMPTY_GAP = Color.WHITE_BOLD_BRIGHT + "O ";

    public static void main(String[] args) {
        jugar();
    }

    public static void jugar() {
        String[][] board = initGameBoard(6, 7, EMPTY_GAP);
        String p1 = Color.RED + "O ";
        String p2 = Color.BLUE + "O ";
        boolean turno1 = true;
        boolean existsWinner = false;

        do {
            showBoard(board);

            if (turno1) {
                setBoard(board, p1);
                turno1 = false;
            } else {
                setBoard(board, p2);
                turno1 = true;
            }

            if (checkWinner(board, p1)) {
                System.out.println("red won");
                existsWinner = true;
            } else if (checkWinner(board, p2)) {
                System.out.println("blue won");
                existsWinner = true;
            } else if (!contains(board, EMPTY_GAP)) {
                System.out.println("Empate");
                break;
            }

        } while (!existsWinner);
        showBoard(board);
    }

    public static void setBoard(String[][] board, String p) {
        boolean played = false;
        int c;
        do {
            do {
                c = sc.nextInt();
            } while (c<0||c>7);

            for (int f = 5; f>=0; f--) {
                if (board[f][c-1].equals(EMPTY_GAP)) {
                    board[f][c-1] = p;
                    played = true;
                    break;
                }
            }
        } while (!played);

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
                System.out.print(array[x][y]);
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

    public static void cleanConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


}