package com.github.sogandjavaheri.TicTacToe;
import java.util.Scanner;

public class TicTacToeTest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        TicTacToe game = new TicTacToe(3);
        Player player1 = new Player(scanner, 'X');
        Player player2 = new Player(scanner, 'O');
        Referee referee = new Referee(game, player1, player2);
        game.startGame(referee);
    }
}
