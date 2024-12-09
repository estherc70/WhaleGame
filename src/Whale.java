import java.util.Scanner;

public class Whale {
    private String whale;
    private Scanner scan;
    private String userMove;
    private int row;
    private boolean up;
    private boolean down;
    public String name;


    //constructor for whale
    public Whale() {
        whale = "\uD83D\uDC0B";
        scan = new Scanner(System.in);
        row = 2;
        up = false;
        down = false;
    }

    //constructor for whale with a name
    public Whale(String name) {
        this.name = name;
    }

    public void nameLength() {
        if (name.length() > 5) {
            System.out.println("Wow you have a long name!");
        }
    }
    //returns whale
    public String getWhale() {
        return whale;
    }

    //asks the user if they want to move the whale up or down
    public void askForMove() {
        System.out.print("\u001B[97mEnter move:\u001B[0m ");
        userMove = scan.nextLine();
        userMove = userMove.toLowerCase();
        //checks to see if the user chose w or s and set them to the corresponding boolean respectively
        if (userMove.equals("w")) {
            up = true;
            down = false;
        }
        else if (userMove.equals("s")){
            down = true;
            up = false;
        }
    }

    //returns getUp boolean
    public boolean getUp() {
        return up;
    }

    //returns getDown boolean
    public boolean getDown() {
        return down;
    }

    //returns the row that whale is at right now
    public int getRow() {
        return row;
    }

}


