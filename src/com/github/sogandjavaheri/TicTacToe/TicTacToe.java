package com.github.sogandjavaheri.TicTacToe;


public class TicTacToe {
    private char[][] board;
    private int size;

    public TicTacToe(int size) {
        this.size = size;
        board = new char[size][size];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void printBoard() {
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public void startGame(Referee referee, Player player1, Player player2) {
        referee.manageGame(player1, player2);
    }

    public char[][] getBoard() {
        return board;
    }
}