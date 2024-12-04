import java.util.Timer;
import java.util.TimerTask;

public class Time {

    private int secondsPassed = 0;

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

}
