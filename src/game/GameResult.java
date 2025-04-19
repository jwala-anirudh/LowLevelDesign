package game;

public class GameResult {
    boolean isOver;
    String winner;

    public GameResult(boolean over, String winner) {
        this.isOver = over;
        this.winner = winner;
    }

    public boolean isOver() {
        return isOver;
    }

    public String getWinner() {
        return winner;
    }
}
