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

    public Score() {
         score = 0;
         highestScore = 0;
         lives = 3;
         time = new Time(this);
    }

    private int roundNumber(double input) { // helper class
        int roundedNumber;
        roundedNumber = (int) Math.rint(input);
        return roundedNumber;
    }

    public int getScore() {
        return roundNumber(time.getSecondsPassed() * 3.14);
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
    }

    public boolean getGameOver() {
        if (lives == 0) { // implement timer when Time.getSecondsPassed() is not null
            return true;
        } else {
            return false;
        }
    }
}
