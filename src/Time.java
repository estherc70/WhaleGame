import java.util.Timer;
import java.util.TimerTask;

public class Time {
    private int secondsPassed = 0;
    private Score score;

    private Timer myTimer = new Timer();
    private TimerTask task;

    //creates the seconds timer
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
    //
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

