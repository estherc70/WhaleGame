public class Score {
    /* Game System:
       - The player starts with three lives and loses one if the whale collides with the trash on the next move
       - There is also a score system where the seconds a player survives for is converted to points by multiplying
       the minutes by 3.14
       - [Create a helper class to round the score to the nearest whole number]
       - The highest score will be kept track of
     */
    private int score;
    private int highestScore;
    private int lives;
    private Time time;
    private boolean gameOver;

    public Score() {
         score = 0;
         highestScore = 0;
         lives = 3;
         time = new Time(this);
         gameOver = false;
    }

    private int roundNumber(double input) { // helper class
        int roundedNumber;
        roundedNumber = (int) Math.rint(input);
        return roundedNumber;
    }

    public void updateScore() {
        // Calculate the score based on time and update the score field
        score = roundNumber(time.getSecondsPassed() * 3.14);
    }

    public int getScore() {
        return score;
    }

    public int getHighestScore() {
        if (score > highestScore) {
            highestScore = score;
        }
        return highestScore;
    }

    public int getLives() {
        return lives;
    }

    public void updateLives() {
        lives = lives - 1;
        System.out.println(getGameOver());
        if (lives < 0) {
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
