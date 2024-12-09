public class Score {
    /* Game System:
       - The player starts with three lives and loses one if the whale collides with the trash on the next move
       - There is also a score system where the seconds a player survives for is converted to points by multiplying
       the minutes by 3.14
       - Created a helper method to round the score to the nearest whole number
     */

    //instance variables
    private int score;
    private int lives;
    private int time;
    private boolean gameOver;

    //constructor
    public Score(int initialScore) {
         score = initialScore;
         lives = 3;
         time = 0;
         gameOver = false;
    }

    //helper class to round the score to the nearest int
    private int roundNumber(double input) {
        int roundedNumber;
        roundedNumber = (int) Math.rint(input);
        return roundedNumber;
    }

    //updates the seconds passed from the timer class
    public void updateTime(int input) {
        time = input;
    }

    //converts the seconds passed into score points by multiplying by 3.14
    public int getScore() {
        score = roundNumber(time * 3.14);
        return score;
    }

    //get method for lives
    public int getLives() {
        return lives;
    }

    //updates the lives after each collision
    public void updateLives() {
        lives = lives - 1;
        if (lives <= 0) {
            gameOver = true;
        }
    }

    //get method for game over
    public boolean getGameOver() {
        return gameOver;
    }

    //set method for game over
    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
}
