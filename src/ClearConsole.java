public class ClearConsole {
    public ClearConsole() {

    }
    public void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();


    }
}
