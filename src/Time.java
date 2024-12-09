/*I used a video I found for YouTube to do the initial startup of my Timer class
 Link : https://www.youtube.com/watch?v=36jbBSQd3eU&list=PLWuJnJNxM3bCyKDrFonlks3ZoQhfxpZw_*/

import java.util.Timer;
import java.util.TimerTask;

public class Time {
    private int secondsPassed = 0;
    private Score score;

    private Timer myTimer = new Timer();
    private TimerTask task;

    /*Creates the seconds timer
    Sets the gameOver to true if the time is up meaning 30 seconds*/
    public Time(Score score) {
        this.score = score;
        task = new TimerTask() {
            public void run() {
                if (!score.getGameOver()) {
                    secondsPassed++;
                    updateTimeInScore();
                    if (getSecondsPassed() >= 30) {
                        score.setGameOver(true);
                    }
                } else {
                    myTimer.cancel();

                }
            }
        };
    }

    /*Delay - delay in milliseconds before task is to be executed.
    Period - time in milliseconds between successive task executions.
    1000 milliseconds = 1 sec */
    public void start() {
        myTimer.scheduleAtFixedRate(task, 1000, 1000);
    }

    public int getSecondsPassed() {
        return secondsPassed;
    }

    public void updateTimeInScore() {
        score.updateTime(secondsPassed);
    }

}

