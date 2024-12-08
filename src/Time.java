import java.util.Timer;
import java.util.TimerTask;

public class Time {
    private int secondsPassed = 0;
    private Score score1;

    private Timer myTimer = new Timer();
    private TimerTask task;

    //creates the seconds timer
    public Time(Score score) {
        score1 = score;
        task = new TimerTask() {
            public void run() {
                if (!score1.getGameOver()) {
                    secondsPassed++;
                    if (getSecondsPassed() >= 30) {
                        score1.setGameOver(true);
                    }
                } else {
                    myTimer.cancel();
                }
            }
        };
    }

    public void start() {
        myTimer.scheduleAtFixedRate(task, 1000, 1000);
    }

    public int getSecondsPassed() {
        return secondsPassed;
    }
}

