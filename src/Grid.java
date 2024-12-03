public class Grid {

    private String[][] grid = {{"\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6"},
        {"\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6"},
        {"\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6"},
        {"\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6"},
        {"\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6"}};
    private Whale whale;
    private int whaleRow;
    private int prev;


    //constructor
    public Grid() {
        whale = new Whale();
        whaleRow = whale.getRow();
        prev = 0;

    }


    public void printGrid() {
        for(String[] row : grid) {
            for(String c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public void placeWhale() {
        grid[whaleRow][0] = whale.getWhale();
    }

    public void setBlue(int row) {
        grid[row][0] = "\uD83D\uDFE6";
    }

    public void moveWhale() {
        prev = whaleRow;
        whale.askForMove();
        if (whale.getUp()) {
            whaleRow--;
        }
        else if (whale.getDown()) {
            whaleRow++;
        }
        if (!checkOutOfBound()) {
            placeWhale();
            setBlue(prev);
        }
        else {
            System.out.println("Out of bound!\nEnter a new move!");
        }
    }

    public boolean checkOutOfBound() {
        if (whaleRow > 4 || whaleRow < 0) {
            return true;
        }
        else {
            return false;
        }
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
