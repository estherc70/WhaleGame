import java.util.Timer;
import java.util.TimerTask;

public class Time {

    int secondsPassed = 0;

    Grid grid = new Grid();
    Timer myTimer = new Timer();
    TimerTask task = new TimerTask() {
        public void run() {
            if (secondsPassed < 10) {
                secondsPassed ++;
                System.out.println("Seconds passed: " + secondsPassed);
                System.out.println();
            }
        }
    };

    public void start() {
        myTimer.scheduleAtFixedRate(task,1000,1000);
    }
}
