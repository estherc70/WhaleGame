import java.util.Scanner;

public class Whale {
    private String whale;
    private Scanner scan;
    private String userMove;
    private int row;
    private boolean up;
    private boolean down;

    public Whale() {
        whale = "\uD83D\uDC0B";
        scan = new Scanner(System.in);
        row = 2;
        up = false;
        down = false;
    }

    public String getWhale() {
        return whale;
    }

    public void askForMove() {
        System.out.print("Enter move: ");
        userMove = scan.nextLine();
        if (userMove.equals("w")) {
            up = true;
            down = false;
        }
        else if (userMove.equals("s")){
            down = true;
            up = false;
        }
    }

    public boolean getUp() {
        return up;
    }

    public boolean getDown() {
        return down;
    }

    public int getRow() {
        return row;
    }

    public String getUserMove() {
        return userMove;
    }
}


