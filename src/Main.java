public class Main {
    public static void main(String[] args) {

    }

    // To get started with the game
    public Board start() {
        return new Board();
    }

    // Specifies what move does a player want to perform
    public void move(Board board, Player player, Move move) {

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
                firstCharacter = board1.cells[i][0];
                for (int j = 0; j < 3; j++) {
                    if (!board1.cells[i][j].equals(firstCharacter)) {
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
                firstCharacter = board1.cells[0][i];
                for (int j = 0; j < 3; j++) {
                    if (!board1.cells[j][i].equals(firstCharacter)) {
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
                firstCharacter = board1.cells[0][0];
                if (!board1.cells[i][i].equals(firstCharacter)) {
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
                firstCharacter = board1.cells[0][2];
                if (!board1.cells[i][2 - i].equals(firstCharacter)) {
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
                    if (board1.cells[j][i] != null) {
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
}

class Board {

}

class TicTacToeBoard extends Board {
    String[][] cells = new String[3][3];
}

class Player {

}

class Move {

}

class GameResult {
    boolean isOver;
    String winner;

    public GameResult(boolean over, String winner) {
        this.isOver = over;
        this.winner = winner;
    }
}
