import java.util.Scanner;

public class Start {

    //instance variables
    private Grid grid;
    private Time time;
    private Score score;
    private Scanner scanner;
    private Trash trash;

    //constructor class
    public Start(Score score) {
        this.score = score;
        grid = new Grid(score);
        time = new Time(score);
        scanner = new Scanner(System.in);
        trash = new Trash();
    }

    //prints out the main menu and uses ANSI Escape Sequences to modify text
    public void mainMenu() {
        System.out.println();
        System.out.println("--------------------------------------------------------------");
        System.out.println("|                 \u001B[97mWelcome to the \u001B[1m\u001B[38;5;117mWhale Game\u001B[0m \uD83D\uDC0B               |");
        System.out.println("|                                                            |");
        System.out.println("| \u001B[38;5;153mIn this game, you have to move the whale up and down to\u001B[0m    |");
        System.out.println("| \u001B[38;5;153mavoid the incoming trash. You start with three lives and\u001B[0m   |");
        System.out.println("| \u001B[38;5;153mlose a life every time there is a collision with the trash\u001B[0m.|");
        System.out.println("| \u001B[38;5;153mEach round lasts [30 seconds]. At the end of the game, you\u001B[0m |");
        System.out.println("| \u001B[38;5;153mwill receive your score, try to get a high score!      \u001B[0m    |");
        System.out.println("|                                                            |");
        System.out.println("|                      \u001B[97m\u001B[4mGame Controls\u001B[0m:                        |");
        System.out.println("| \u001B[97mTo move up: input\u001B[0m \u001B[38;5;219m\u001B[3m\"w\"\u001B[0m                                      |");
        System.out.println("| \u001B[97mTo move down: input\u001B[0m \u001B[38;5;230m\u001B[3m\"s\"\u001B[0m                                    |");
        System.out.println("|                                                            |");
        System.out.println("--------------------------------------------------------------");
    }

    public String askEmoji() {
        System.out.print("Which trash emoji would you want? \nDo you want a wastebasket emoji, canned food, or shoes?:");
        String input = (scanner.nextLine()).toLowerCase();

        while (!input.equals("wastebasket") && !input.equals("canned food") && !input.equals("shoes")) {
            System.out.println("Invalid input. Please choose either 'wastebasket', 'canned food', or 'shoes'.");
            input = scanner.nextLine().trim().toLowerCase();
        }
        return input;
    }

    //starts the game by calling necessary methods
    public void startGame() {
        grid.placeWhale();
        String emojiChoice = askEmoji();  // Ask for emoji once and store it
        Trash customTrash = new Trash(emojiChoice);  // Create a custom Trash object
        grid.setTrashEmoji(customTrash);  // Set the emoji for the grid
        grid.placeTrashsInitial();  // Place the trash on the grid initially
        time.start();
        mainMenu();
        while (!score.getGameOver()) {
            grid.printGrid();
            grid.moveWhale();
            printEndingInfo();
        }
    }

    //prints out the game info after the game ends
    public void printEndingInfo() {
        if (score.getGameOver()) {
            printInfo();
        }
    }

    //prints out the game info
    public void printInfo() {
        System.out.println();
        System.out.println("--------------------------------------------------------------");
        System.out.println("|                          \u001B[38;5;203mGame over!\u001B[0m                        |");
        System.out.println("|                                                            |");
        if (score.getScore() <= 9) {
            System.out.println("| \u001B[38;5;231mYou scored:\u001B[0m \u001B[38;5;228m" + score.getScore() + " ⭐\u001B[0m \u001B[38;5;231mpoints \u001B[0m                                   |");
        } else {
            System.out.println("| \u001B[38;5;231mYou scored:\u001B[0m \u001B[38;5;228m" + score.getScore() + " ⭐\u001B[0m \u001B[38;5;231mpoints \u001B[0m                                  |");
        }
        System.out.println("|                                                            |");
        System.out.println("|                     \u001B[38;5;153mThanks for playing!\u001B[0m                    |");
        System.out.println("|      \u001B[97mWe hope you enjoyed playing \u001B[1m\u001B[38;5;117mThe Whale Game\u001B[0m \uD83D\uDC0B         |");
        System.out.println("--------------------------------------------------------------");
    }
}
