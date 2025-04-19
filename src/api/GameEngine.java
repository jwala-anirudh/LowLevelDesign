package api;

import boards.TicTacToeBoard;
import game.Board;
import game.Move;
import game.Player;
import game.GameResult;
import game.Cell;

public class GameEngine {
    // To get started with the game
    public Board start(String type) {
        if (type.equals("TicTacToe")) {
            return new TicTacToeBoard();
        } else {
            throw new IllegalArgumentException();
        }
    }

    // Specifies what move does a player want to perform
    public void move(Board board, Player player, Move move) {
        if (board instanceof TicTacToeBoard) {
            TicTacToeBoard board1 = (TicTacToeBoard) board;
            board1.setCell(Move.getCell(), player.symbol());
        } else {
            throw new IllegalArgumentException();
        }
    }

    // Says whether a game is complete or incomplete
    // And who is the winner / is the match draw
    public GameResult isComplete(Board board) {
        if (board instanceof TicTacToeBoard) {
            TicTacToeBoard board1 = (TicTacToeBoard) board;
            String firstCharacter = "-";

            // Row level check
            boolean rowComplete = true;
            for (int i = 0; i < 3; i++) {
                rowComplete = true;
                firstCharacter = board1.getCell(i, 0);
                for (int j = 0; j < 3; j++) {
                    if (!board1.getCell(i, j).equals(firstCharacter)) {
                        rowComplete = false;
                        break;
                    }
                }
                if (rowComplete) {
                    break;
                }
            }

            if (rowComplete) {
                return new GameResult(true, firstCharacter);
            }

            // Column level check
            boolean columnComplete = true;
            for (int i = 0; i < 3; i++) {
                columnComplete = true;
                firstCharacter = board1.getCell(0, i);
                for (int j = 0; j < 3; j++) {
                    if (!board1.getCell(j, i).equals(firstCharacter)) {
                        columnComplete = false;
                        break;
                    }
                }
            }

            if (columnComplete) {
                return new GameResult(true, firstCharacter);
            }

            // Diagonal level check
            boolean diagonalComplete = true;
            for (int i = 0; i < 3; i++) {
                diagonalComplete = true;
                firstCharacter = board1.getCell(0, 0);
                if (!board1.getCell(i, i).equals(firstCharacter)) {
                    diagonalComplete = false;
                    break;
                }
            }

            if (diagonalComplete) {
                return new GameResult(true, firstCharacter);
            }

            // Reverse Diagonal level check
            boolean reverseDiagonalComplete = true;
            for (int i = 0; i < 3; i++) {
                reverseDiagonalComplete = true;
                firstCharacter = board1.getCell(0, 2);
                if (!board1.getCell(i, 2 - i).equals(firstCharacter)) {
                    reverseDiagonalComplete = false;
                    break;
                }
            }

            if (reverseDiagonalComplete) {
                return new GameResult(true, firstCharacter);
            }

            // Draw condition
            int countOfFilledCells = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 1; j < 3; j++) {
                    if (board1.getCell(i, j) != null) {
                        countOfFilledCells += 1;
                    }
                }
            }

            if (countOfFilledCells == 9) {
                return new GameResult(true, "-");
            } else {
                return new GameResult(false, "-");
            }
        } else {
            return new GameResult(false, "-");
        }
    }

    public Move suggestMove(Player computer, Board board) {
        if (board instanceof TicTacToeBoard) {
            TicTacToeBoard board1 = (TicTacToeBoard) board;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board1.getCell(j, i) == null) {
                        return new Move(new Cell(i, j));
                    }
                }
            }

            throw new IllegalArgumentException();
        } else {
            throw new IllegalArgumentException();
        }
    }
}
