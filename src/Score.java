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
    private int seconds;
    private Time time;
    private boolean gameOver;

    public Score() {
         score = 0;
         highestScore = 0;
         lives = 3;
         seconds = time.getSecondsPassed();
         gameOver = false;
    }

    public int roundNumber(double input) { // helper class
        int roundedNumber;
        roundedNumber = (int) Math.rint(input);
        return roundedNumber;
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

    public void convertToPoints() {
        score = roundNumber(seconds * 3.14); //ROUNDING CLASS NEEDED
    }

    public void updateLives() {
//        if (whalePosition == trashPosition) {
//            lives--;
//        }
//        [set game over to true if lives = 0]

    }

    public boolean getGameOver() {
     return gameOver;
    }

    public void setGameOver(boolean input) {
        if (input == true) {
            gameOver = true; // use for timer class when timer is over the set time (e.g 5 minutes)
        } else {
            gameOver = false;
        }
    }
}
