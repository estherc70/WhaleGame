public class Start {

    private Grid grid;
    private Time time;
    private Score score;

    public Start(Score score) {
        this.score = new Score();
        grid = new Grid();
        time = new Time(score);
    }

    public void mainMenu() {
        System.out.println("--------------------------------------------------------------");
        System.out.println("|                 \u001B[97mWelcome to the \u001B[1m\u001B[38;5;117mWhale Game\u001B[0m                  |");
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

    public void startGame() {
        grid.placeWhale();
        grid.placeTrashsInitial();
        time.start();
        while (!score.getGameOver()) {
            grid.printGrid();
            grid.moveWhale();
            if (grid.collide()) {
                System.out.println("Ouch! You ran into the trash, you lost one life");
                System.out.println(score.getLives());
            }
        }
    }

    public void printInfo() {
        System.out.println("--------------------------------------------------------------");
        System.out.println("|                          Game over!                        |");
        System.out.println("|                                                            |");
        System.out.println("| You scored: " + score.getScore() + "                          |");
        if (score.getScore() > score.getHighestScore()) {
            System.out.println("| Congrats! You beat the previous highest score of " + score.getHighestScore() + "     |");
        } else if (score.getScore() < score.getHighestScore()) {
            System.out.println("| The highest score is: " + score.getHighestScore() + "            |");
            System.out.println("| Try beating it again next time!");
        } else {
            System.out.println("| Whoa! You got the same score as the previous high score!   |");
            System.out.println("| Maybe you can beat it next time!                           |");
        }
        System.out.println("|                                                            |");
        System.out.println("|                     Thanks for playing!                    |");
        System.out.println("--------------------------------------------------------------");
    }
}
