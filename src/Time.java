import java.util.Timer;
import java.util.TimerTask;

public class Time {

    int secondsPassed = 0;
    int finalSeconds = 0;

    Grid grid = new Grid();
    Timer myTimer = new Timer();
    TimerTask task = new TimerTask() {
        public void run() {
            if (secondsPassed < 10) {
                secondsPassed ++;
            }
        }
    };

    public void start() {
        myTimer.scheduleAtFixedRate(task,1000,1000);
    }

    public void currentTime() {
        myTimer.cancel();
        finalSeconds += secondsPassed;
        secondsPassed = 0;
    }
}
