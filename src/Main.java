import java.util.Scanner;

public class Main {

    // Create a scanner to capture the user input
    static Scanner in = new Scanner(System.in);

    // Store the values of the players inputs in an array
    static char[] pos = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};

    static char turn = 'X';
    static int turnCount = 0;

    public static void main(String[] args) {
        playGame();
    }

    static void playGame() {
        int input;
        String winner = null;

        System.out.println("\nWelcome to two player Tic-Tac-Toe.");
        System.out.println("------------------------------------");
        setPositions();
        printBoard();
        resetBoard();
        System.out.println("\nX's will play first. Enter a position number to place X in:");

        while(winner == null) {
            //  Ask the user to enter a position but prevent overwriting inputs by checking if the position already has
            //  an X or O
            do {
                System.out.print("\nEnter a position: ");
                input = in.nextInt();

            } while ((input <= 0 || input > pos.length) || (pos[input - 1] == 'X' || pos[input - 1] == 'O'));

            // Correct the position offset
            pos[input - 1] = turn;

            printBoard();
            winner = checkWinner();

            // Change the Xs or Os based on the turn of the user
            if (turn == 'X') {
                turn = 'O';
            } else if (turn == 'O') {
                turn = 'X';
            }
        }
        if (winner.equalsIgnoreCase("draw")) {
            System.out.print("It is a draw! Thanks for playing.\n");
        } else {
            System.out.print("Congratulations! " + winner +" is the winner! Thanks for playing.\n");
        }

        doYouWantToPlayAgain();
    }

    static void printBoard() {
        // Print the game board
        System.out.println("\n " + pos[0] + " | " + pos[1] + " | " + pos[2] + " ");
        System.out.println("---+---+---");
        System.out.println(" " + pos[3] + " | " + pos[4] + " | " + pos[5] + " ");
        System.out.println("---+---+---");
        System.out.println(" " + pos[6] + " | " + pos[7] + " | " + pos[8] + " \n");
    }

    static void setPositions() {
        // Print the positions on the board
        for (int i = 0; i < 9; i++) {
            pos[i] = (char) (i + '1');
        }
    }

    static void resetBoard() {
        // Clear the board of any values
        pos[0] = ' ';
        pos[1] = ' ';
        pos[2] = ' ';
        pos[3] = ' ';
        pos[4] = ' ';
        pos[5] = ' ';
        pos[6] = ' ';
        pos[7] = ' ';
        pos[8] = ' ';
    }

    static String checkWinner() {
        // Check win conditions
        if (pos[0] == turn && pos[1] == turn && pos[2] == turn ||
            pos[3] == turn && pos[4] == turn && pos[5] == turn ||
            pos[6] == turn && pos[7] == turn && pos[8] == turn ||
            pos[0] == turn && pos[3] == turn && pos[6] == turn ||
            pos[1] == turn && pos[4] == turn && pos[7] == turn ||
            pos[2] == turn && pos[5] == turn && pos[8] == turn ||
            pos[0] == turn && pos[4] == turn && pos[8] == turn ||
            pos[2] == turn && pos[4] == turn && pos[6] == turn) {

            if (turn == 'X') {
                return "X";
            } else if (turn == 'O') {
                return "O";
            }
        }

        turnCount++;

        if (turnCount == 9) {
            return "DRAW";
        }

        return null;
    }

    static void doYouWantToPlayAgain() {
        char ans;
        do {
            System.out.print("\nDo you want to play again? Y/N ");
            ans = in.next().trim().charAt(0);

        } while (ans != 'Y' && ans != 'N');

        if (ans == 'Y') {
            resetBoard();
            turnCount = 0;
            playGame();
        } else if (ans == 'N') {
            gameOver();
        }
    }

    static void gameOver() {
        System.exit(0);
    }
}
