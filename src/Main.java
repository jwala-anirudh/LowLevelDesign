import api.GameEngine;
import game.Board;
import game.Cell;
import game.Move;
import game.Player;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameEngine gameEngine = new GameEngine();
        Board board = gameEngine.start("TicTacToe");

        // Make moves in a loop
        int row, column;
        Scanner scanner = new Scanner(System.in);

        while (!gameEngine.isComplete(board).isOver()) {
            Player computer = new Player("O");
            Player opponent = new Player("X");

            System.out.printf("Make your move!");

            row = scanner.nextInt();
            column = scanner.nextInt();

            Move oppMove = new Move(new Cell(row, column));
            gameEngine.move(board, opponent, oppMove);

            if (!gameEngine.isComplete(board).isOver()) {
                Move computerMove = gameEngine.suggestMove(computer, board);
                gameEngine.move(board, computer, computerMove);
            }
        }

        System.out.println("Game Result : " + gameEngine.isComplete(board));
    }
}
