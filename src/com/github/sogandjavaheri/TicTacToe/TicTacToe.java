package com.github.sogandjavaheri.TicTacToe;
import java.util.Scanner;


public class TicTacToe {
    private char[][] board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Scanner scanner;

    public TicTacToe() {
        scanner = new Scanner(System.in);
        board = new char[3][3];
        initializeBoard();
        getPlayerInfo(); // Method to get player names
        currentPlayer = player1;
    }

    public void getPlayerInfo() {
        System.out.print("Enter name for Player 1 (X): ");
        String name1 = scanner.nextLine();
        player1 = new Player(name1, 'X');

        System.out.print("Enter name for Player 2 (O): ");
        String name2 = scanner.nextLine();
        player2 = new Player(name2, 'O');
    }

    private void initializeBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void start() {
        while (true) {
            printBoard();
            System.out.println(currentPlayer.getName() + " (" + currentPlayer.getSymbol() + ") - Enter row and column (0-2): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (!makeMove(row, col, currentPlayer.getSymbol())) {
                System.out.println("Invalid move. Try again.");
                continue;
            }

            char winner = checkWinner();
            if (winner != ' ') {
                printBoard();
                System.out.println(currentPlayer.getName() + " wins!");
                break;
            }

            if (isBoardFull()) {
                printBoard();
                System.out.println("It's a draw!");
                break;
            }

            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }
    }

    private boolean makeMove(int row, int col, char player) {
        if (row >= 0 && row < board.length && col >= 0 && col < board.length && board[row][col] == '-') {
            board[row][col] = player;
            return true;
        }
        return false;
    }

    private char checkWinner() {
        // Check rows
        for (int i = 0; i < board.length; i++) {
            if (checkRow(i)) return board[i][0];
        }

        // Check columns
        for (int i = 0; i < board[0].length; i++) {
            if (checkColumn(i)) return board[0][i];
        }

        // Check diagonals
        if (checkDiagonal()) return board[0][0];
        if (checkAntiDiagonal()) return board[0][board.length - 1];

        return ' ';
    }

    private boolean checkRow(int row) {
        char value = board[row][0];
        if (value == '-') return false;
        for (int col = 1; col < board[row].length; col++) {
            if (board[row][col] != value) return false;
        }
        return true;
    }

    private boolean checkColumn(int col) {
        char value = board[0][col];
        if (value == '-') return false;
        for (int row = 1; row < board.length; row++) {
            if (board[row][col] != value) return false;
        }
        return true;
    }

    private boolean checkDiagonal() {
        char value = board[0][0];
        if (value == '-') return false;
        for (int i = 1; i < board.length; i++) {
            if (board[i][i] != value) return false;
        }
        return true;
    }

    private boolean checkAntiDiagonal() {
        char value = board[0][board.length - 1];
        if (value == '-') return false;
        for (int i = 1; i < board.length; i++) {
            if (board[i][board.length - 1 - i] != value) return false;
        }
        return true;
    }

    private boolean isBoardFull() {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == '-') return false;
            }
        }
        return true;
    }

    private void printBoard() {
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}