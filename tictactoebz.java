
import java.util.*;

public class tictactoebz {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean playMore = true;
        System.out.println("        TIC TAC TOE GAME         ");
        System.out.println("Rules:");
        System.out.println("Player 1 uses X, Player 2 uses O");
        System.out.println("Enter row and column numbers (0–n-1)");
        while (playMore) {
            System.out.print("Enter board size: ");
            int n = sc.nextInt();
            System.out.print("Enter Player 1 name (X): ");
            String p1 = sc.next();
            System.out.print("Enter Player 2 name (O): ");
            String p2 = sc.next();
            char[][] board = new char[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(board[i], ' ');
            }
            char turn = 'X';
            boolean finished = false;
            int moves = 0;
            while (!finished) {
                displayBoard(board);
                System.out.println("Current Player:" + (turn == 'X' ? p1 : p2) + "(" + turn + ")");
                System.out.print("Enter your move (row and column): ");
                int r = sc.nextInt();
                int c = sc.nextInt();
                if (r < 0 || r >= n || c < 0 || c >= n) {
                    System.out.println("Invalid position! Try again.");
                    continue;
                }
                if (board[r][c] != ' ') {
                    System.out.println("That cell is already filled. Choose another.");
                    continue;
                }
                board[r][c] = turn;
                moves++;
                if (checkWinner(board, turn)) {
                    displayBoard(board);
                    System.out.println(" " + (turn == 'X' ? p1 : p2) + " wins the game!");
                    finished = true;
                } else if (moves == n * n) {
                    displayBoard(board);
                    System.out.println("It's a draw!");
                    finished = true;
                } else {
                    turn = (turn == 'X') ? 'O' : 'X';
                }
            }
            System.out.print("Would you like to play another game? (y/n): ");
            char ans = sc.next().toLowerCase().charAt(0);
            playMore = (ans == 'y');
        }
        System.out.println("Thank you for playing Tic Tac Toe!");
        sc.close();
    }

    public static void displayBoard(char[][] board) {
        int n = board.length;
        System.out.println();
        System.out.print("   ");
        for (int j = 0; j < n; j++) {
            System.out.print(j + "   ");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print("  ");
            for (int j = 0; j < n; j++) {
                System.out.print("+---");
            }
            System.out.println("+");
            System.out.print(i + " ");
            for (int j = 0; j < n; j++) {
                System.out.print("| " + board[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.print("  ");
        for (int j = 0; j < n; j++) {
            System.out.print("+---");
        }
        System.out.println("+\n");
    }

    public static boolean checkWinner(char[][] b, char ch) {
        int n = b.length;
        for (int i = 0; i < n; i++) {
            boolean row = true, col = true;
            for (int j = 0; j < n; j++) {
                if (b[i][j] != ch) {
                    row = false;
                }
                if (b[j][i] != ch) {
                    col = false;
                }
            }
            if (row || col) {
                return true;
            }
        }
        boolean d1 = true, d2 = true;
        for (int i = 0; i < n; i++) {
            if (b[i][i] != ch) {
                d1 = false;
            }
            if (b[i][n - 1 - i] != ch) {
                d2 = false;
            }
        }
        return d1 || d2;
    }
}
