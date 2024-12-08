public class Score {
    /* Game System:
       - The player starts with three lives and loses one if the whale collides with the trash on the next move
       - There is also a score system where the seconds a player survives for is converted to points by multiplying
       the minutes by 3.14
       - [Create a helper class to round the score to the nearest whole number]
       - The highest score will be kept track of
     */
    private int score;
    private int lives;
    private int time;
    private boolean gameOver;

    public Score() {
         score = 0;
         lives = 3;
         time = 0;
         gameOver = false;
    }

    private int roundNumber(double input) { // helper class
        int roundedNumber;
        roundedNumber = (int) Math.rint(input);
        return roundedNumber;
    }

    public void updateTime(int input) {
        time = input;
    }

    public int getScore() {
        score = roundNumber(time * 3.14);
        return score;
    }

    public int getLives() {
        return lives;
    }

    public void updateLives() {
        lives = lives - 1;
        if (lives <= 0) {
            gameOver = true;
        }
    }

    public boolean getGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
}
