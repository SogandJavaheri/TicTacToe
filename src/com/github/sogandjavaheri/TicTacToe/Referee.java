package com.github.sogandjavaheri.TicTacToe;
import java.util.Scanner;

public class Referee {
    private TicTacToe game;
//    private Player player1;
//    private Player player2;

    public Referee(){
//        this(game, player1, player2);
    }

    public Referee(TicTacToe game, Player player1, Player player2) {
        this.game = game;
//        this.player1 = player1;
//        this.player2 = player2;
    }

    public void manageGame(Player player1, Player player2) {
        Scanner scanner = new Scanner(System.in);
        Player currentPlayer = player1;

        while (true) {
            game.printBoard();
            System.out.println(currentPlayer.getName() + " (" + currentPlayer.getSymbol() + ") - Enter row and column (0-2): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (!currentPlayer.makeMove(game, row, col)) {
                System.out.println("Invalid move. Try again.");
                continue;
            }

            char winner = checkWinner();
            if (winner != ' ') {
                game.printBoard();
                System.out.println(currentPlayer.getName() + " wins!");
                break;
            }

            if (isBoardFull()) {
                game.printBoard();
                System.out.println("It's a draw!");
                break;
            }

            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }
    }

    private char checkWinner() {
        char[][] board = game.getBoard();
        int size = board.length;

        for (int i = 0; i < size; i++) {
            if (checkRow(board, i) || checkColumn(board, i)) {
                return board[i][0];
            }
        }

        if (checkDiagonal(board)) {
            return board[0][0];
        }
        if (checkAntiDiagonal(board)) {
            return board[0][size - 1];
        }

        return ' ';
    }

    private boolean checkRow(char[][] board, int row) {
        char value = board[row][0];
        if (value == '-') return false;
        for (int j = 1; j < board.length; j++) {
            if (board[row][j] != value) return false;
        }
        return true;
    }

    private boolean checkColumn(char[][] board, int col) {
        char value = board[0][col];
        if (value == '-') return false;
        for (int i = 1; i < board.length; i++) {
            if (board[i][col] != value) return false;
        }
        return true;
    }

    private boolean checkDiagonal(char[][] board) {
        char value = board[0][0];
        if (value == '-') return false;
        for (int i = 1; i < board.length; i++) {
            if (board[i][i] != value) return false;
        }
        return true;
    }

    private boolean checkAntiDiagonal(char[][] board) {
        char value = board[0][board.length - 1];
        if (value == '-') return false;
        for (int i = 1; i < board.length; i++) {
            if (board[i][board.length - 1 - i] != value) return false;
        }
        return true;
    }

    private boolean isBoardFull() {
        char[][] board = game.getBoard();
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == '-') {
                    return false;
                }
            }
        }
        return true;
    }
}
