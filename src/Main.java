public class Main {
    public static void main(String[] args) {
        Grid grid = new Grid();
        ClearConsole clear = new ClearConsole();
        boolean x = false;
        grid.placeWhale();
        while (!x) {
            grid.printGrid();
            grid.moveWhale();
            clear.clear();



        }
    }
}
