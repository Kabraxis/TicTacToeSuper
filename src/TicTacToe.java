import java.util.Scanner;

public class TicTacToe {
    static Scanner scanner = new Scanner(System.in);

    static int player;
    static String playerInput;
    static String regex = "[ABC][1-3]\\s[XO]";

    static char a1 = '_';
    static char a2 = '_';
    static char a3 = '_';

    static char b1 = '_';
    static char b2 = '_';
    static char b3 = '_';

    static char c1 = '_';
    static char c2 = '_';
    static char c3 = '_';

    public static void main(String[] args) {

        while (checkSlots() == true) {
            printPlayingfield();
            playTurnMessage();
            if (validatePlayerInput() == false) {
                wrongInput();
            } else {
                playerSwitcher();
                columnCheck();
            }
        }
        gameOver();
    }


    public static boolean checkSlots() {
        // System.out.println("\nStep 1");
        if ((a1 == '_') || (a2 == '_') || (a3 == '_')
                || (b1 == '_') || (b2 == '_') || (b3 == '_')
                || (c1 == '_') || (c2 == '_') || (c3 == '_')) {
            return true;
        }
        return false;
    }

    public static void printPlayingfield() {
            /* This 2 dimensional array stores the basic look of the playing field, as well as the locations
               where moves can be placed and also stores the actual move as long as the game's running.

               >--1-2-3-<
               A| _ _ _ |
               B| _ _ _ |    <-- The default playing field appearance. Corners are written in unicode.
               C| _ _ _ |
               >--------<
               \u25DC, \u25DD, \u25DF, \u25DE
             */
        char[][] ticSuper = {{'>', '-', '-', '1', '-', '2', '-', '3', '-', '<'},
                {'A', '|', ' ', a1, ' ', a2, ' ', a3, ' ', '|'},
                {'B', '|', ' ', b1, ' ', b2, ' ', b3, ' ', '|'},
                {'C', '|', ' ', c1, ' ', c2, ' ', c3, ' ', '|'},
                {'>', '-', '-', '-', '-', '-', '-', '-', '-', '<'},
        };

        for (int row = 0; row < 5; row++) {
            int column;
            for (column = 0; column < 9; column++) {
                System.out.print(ticSuper[row][column]);
            }
            System.out.print(ticSuper[row][column] + "\n");
        }
    }

    public static void playTurnMessage() {
        // How to play, call player whose turn it is and ask for input
        System.out.println("\nValid formats: A1 X or b3 o");
        System.out.println("It's player " + player + "'s turn!");
        System.out.println("Enter: ");
    }

    public static String getPlayerInput() {
        playerInput = scanner.nextLine();
        return playerInput;
    }

    public static boolean validatePlayerInput() {
        if (!playerInput.toUpperCase().matches(regex)) {
            return false;
        }
        return true;
    }

    public static void wrongInput() {
        while (validatePlayerInput() == false) {
            System.out.println("\nInvalid move! Only enter letters A-C, followed by numbers 1-3, followed by a space, followed by letters X or O.");
            System.out.println("Please try again player " + player + ":");
            getPlayerInput();
            if (playerInput.toUpperCase().matches(regex)) {
                break;
            }
        }
    }

    public static void playerSwitcher() {
        if (player == 1) {
            player = 2;
        } else {
        player = 1;
        }
    }

    public static void columnCheck() {
        // column 'a' check
        if (playerInput.toLowerCase().charAt(0) == 'a') {
            // assigning value to the related position on the array
            if (playerInput.charAt(1) == '1') {
                a1 = playerInput.toUpperCase().charAt(3);
            } else if (playerInput.charAt(1) == '2') {
                a2 = playerInput.toUpperCase().charAt(3);
            } else if (playerInput.charAt(1) == '3') {
                a3 = playerInput.toUpperCase().charAt(3);
            }
        }

        // column 'b' check
        if (playerInput.toLowerCase().charAt(0) == 'b') {
            // assigning value to the related position on the array
            if (playerInput.charAt(1) == '1') {
                b1 = playerInput.toUpperCase().charAt(3);
            } else if (playerInput.charAt(1) == '2') {
                b2 = playerInput.toUpperCase().charAt(3);
            } else if (playerInput.charAt(1) == '3') {
                b3 = playerInput.toUpperCase().charAt(3);
            }
        }

        // column 'c' check
        if (playerInput.toLowerCase().charAt(0) == 'c') {
            // assigning value to the related position on the array
            if (playerInput.charAt(1) == '1') {
                c1 = playerInput.toUpperCase().charAt(3);
            } else if (playerInput.charAt(1) == '2') {
                c2 = playerInput.toUpperCase().charAt(3);
            } else if (playerInput.charAt(1) == '3') {
                c3 = playerInput.toUpperCase().charAt(3);
            }
        }
    }

    public static void gameOver() {
        // After game finishes / all slots occupied
        // Cat emoji \ud83d\ude38
        printPlayingfield();
        System.out.println("\n--------------");
        System.out.println("Game Over! :-P");
        System.out.println("--------------");

    }
}
