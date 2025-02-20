package com.github.sogandjavaheri.TicTacToe;
import java.util.Scanner;

public class Player {
    private String name;
    private char symbol;

    public Player(Scanner scanner, char symbol) {
        System.out.println("Enter name for player " + symbol + ": ");
        this.name = scanner.nextLine();
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    public boolean makeMove(TicTacToe game, int row, int col) {
        char[][] board = game.getBoard();
        if (row >= 0 && row < board.length && col >= 0 && col < board.length && board[row][col] == '-') {
            board[row][col] = symbol;
            return true;
        }
        return false;
    }

}
