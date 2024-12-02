public class Grid {

    private String[][] grid = {{"\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6"},
        {"\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6"},
        {"\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6"},
        {"\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6"},
        {"\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6"}};
    private Whale whale;
    private int whaleRow;

    //constructor
    public Grid() {
        whale = new Whale();
        whaleRow = whale.getRow();
    }


    public void printGrid() {
        for(String[] row : grid) {
            for(String c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public void placeWhale(int row, int col) {
        grid[row][col] = whale.getWhale();
    }

    public void placeTrash1(int row, int col) {
        grid[row][col] = "";
    }

    public void placeTrash2(int row, int col) {
        grid[row][col] = "";
    }

    public void placeTrash3(int row, int col) {
        grid[row][col] = "";
    }

}
