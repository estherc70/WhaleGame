public class Main {
    public static void main(String[] args) {
        Score score = new Score();
        Start start = new Start(score);
        start.mainMenu();
        start.startGame();
        if (score.getGameOver()) {
            start.printInfo();
        }
    }
}
