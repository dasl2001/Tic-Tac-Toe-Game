import java.util.Scanner;
public class TicTacToe {
    static char[][] board = {
        {'1', '2', '3'},
        {'4', '5', '6'},
        {'7', '8', '9'}
    };
    static char currentPlayer = 'X';
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean gameEnded = false;
        System.out.println("Välkommen till Tre-i-rad (Tic Tac Toe)!");
        printBoard();
        while (!gameEnded) {
            System.out.print("Spelare " + currentPlayer + ", välj en ruta (1-9): ");
            int move = scanner.nextInt();
            if (makeMove(move)) {
                printBoard();
                if (checkWin()) {
                    System.out.println("Spelare " + currentPlayer + " vinner!");
                    gameEnded = true;
                } else if (isBoardFull()) {
                    System.out.println("Oavgjort!");
                    gameEnded = true;
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Ogiltigt drag. Försök igen.");
            }
        }
        scanner.close();
    }
    public static void printBoard() {
        System.out.println();
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(" " + c + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static boolean makeMove(int move) {
        if (move < 1 || move > 9) return false;
        int row = (move - 1) / 3;
        int col = (move - 1) % 3;
        if (board[row][col] != 'X' && board[row][col] != 'O') {
            board[row][col] = currentPlayer;
            return true;
        }
        return false;
    }
    public static boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer &&
                board[i][1] == currentPlayer &&
                board[i][2] == currentPlayer)
                return true;
            if (board[0][i] == currentPlayer &&
                board[1][i] == currentPlayer &&
                board[2][i] == currentPlayer)
                return true;
        }
        return (board[0][0] == currentPlayer &&
                board[1][1] == currentPlayer &&
                board[2][2] == currentPlayer) ||
               (board[0][2] == currentPlayer &&
                board[1][1] == currentPlayer &&
                board[2][0] == currentPlayer);
    }
    public static boolean isBoardFull() {
        for (char[] row : board) {
            for (char c : row) {
                if (c != 'X' && c != 'O')
                    return false;
            }
        }
        return true;
    }
}
