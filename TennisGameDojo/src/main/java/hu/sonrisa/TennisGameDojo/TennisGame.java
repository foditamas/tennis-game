package hu.sonrisa.TennisGameDojo;

public class TennisGame {
    private int playerOneScore = 0;
    private int playerTwoScore = 0;
    private String playerTwoName;
    private String playerOneName;

    public TennisGame(String playerOneName, String playerTwoName) {
        this.playerOneName = playerOneName;
        this.playerTwoName = playerTwoName;
    }

    public String getScore() {
        //TODO
       return "no solution yet";
    }


    public void playerOneScores() {
        playerOneScore++;
    }

    public void playerTwoScores() {
        playerTwoScore++;
    }
}
