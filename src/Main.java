public class Main {
    public static void main(String[] args) {
        Grid grid = new Grid();
        Time time = new Time();
        ClearConsole clear = new ClearConsole();
        boolean x = false;
        grid.placeWhale();
        while (!x) {
            time.start();
            grid.printGrid();
            grid.moveWhale();
            clear.clear();
        }
    }
}
