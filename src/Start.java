public class Start {

    //instance variables
    private Grid grid;
    private Time time;
    private Score score;

    //constructor class
    public Start(Score score) {
        this.score = score;
        grid = new Grid(score);
        time = new Time(score);
    }

    //prints out the main menu
    public void mainMenu() {
        System.out.println();
        System.out.println("--------------------------------------------------------------");
        System.out.println("|                 \u001B[97mWelcome to the \u001B[1m\u001B[38;5;117mWhale Game\u001B[0m \uD83D\uDC0B               |");
        System.out.println("|                                                            |");
        System.out.println("| \u001B[38;5;153mIn this game, you have to move the whale up and down to\u001B[0m    |");
        System.out.println("| \u001B[38;5;153mavoid the incoming trash. You start with three lives and\u001B[0m   |");
        System.out.println("| \u001B[38;5;153mlose a life every time there is a collision with the trash\u001B[0m.|");
        System.out.println("| \u001B[38;5;153mEach round lasts [30 seconds]. At the end of the game, you\u001B[0m |");
        System.out.println("| \u001B[38;5;153mwill receive your score, try to beat the highest score!\u001B[0m    |");
        System.out.println("|                                                            |");
        System.out.println("|                      \u001B[97m\u001B[4mGame Controls\u001B[0m:                        |");
        System.out.println("| \u001B[97mTo move up: input\u001B[0m \u001B[38;5;219m\u001B[3m\"w\"\u001B[0m                                      |");
        System.out.println("| \u001B[97mTo move down: input\u001B[0m \u001B[38;5;230m\u001B[3m\"s\"\u001B[0m                                    |");
        System.out.println("|                                                            |");
        System.out.println("--------------------------------------------------------------");
    }

    //starts the game
    public void startGame() {
        grid.placeWhale();
        grid.placeTrashsInitial();
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
