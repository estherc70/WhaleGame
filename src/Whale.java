import java.util.Scanner;

public class Whale {
    private String whale;
    private Scanner scan;
    private String userMove;
    private int row;
    public Whale() {
        whale = "\uD83D\uDC0B";
        scan = new Scanner(System.in);
        row = 2;
    }

    public String getWhale() {
        return whale;
    }

    public String moveWhale() {
        System.out.print("Enter move: ");
        userMove = scan.nextLine();
        return userMove;
    }

    public void setWhaleRow() {
        if(userMove.equals("w")) {
            row--;
        }
        else if (userMove.equals("S")) {
            row++;
        }
        else {
            System.out.println("Please enter a valid move!");
        }
    }

    public int getRow() {
        return row;
    }
}


