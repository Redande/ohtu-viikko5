package ohtu;

public class TennisGame {

    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1")) {
            player1Score += 1;
        } else {
            player2Score += 1;
        }
    }

    public String getScore() {
        if (player1Score == player2Score) {
            return evenPoints();
        } else if (player1Score >= 4 || player2Score >= 4) {
            return bothPlayersPointsFortyOrOver();
        } else {
            return playerPoints(player1Score) + "-" + playerPoints(player2Score);
        }
    }

    private String playerPoints(int score) {
        switch (score) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            default:
                return "Forty";
        }
    }
    
    private String evenPoints() {
        if (player1Score < 4) {
            return playerPoints(player1Score) + "-All";
        } else {
            return "Deuce";
        }
    }

    private String bothPlayersPointsFortyOrOver() {
        int difference = player1Score - player2Score;
        if (difference == 1) {
            return "Advantage player1";
        } else if (difference == -1) {
            return "Advantage player2";
        } else if (difference >= 2) {
            return "Win for player1";
        } else {
            return "Win for player2";
        }
    }
}
