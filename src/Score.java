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
    private RoundingHelper round;

    public Score() {
         score = 0;
         highestScore = 0;
         lives = 3;
//         seconds = ; [TIMER CLASS NEEDED]
        round = new RoundingHelper();
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
        score = round.RoundNumber(seconds * 3.14); //ROUNDING CLASS NEEDED
    }

    public void updateLives() {
//        if (whalePosition == trashPosition) {
//            lives--;
//        }
    }
}
