public class Grid {

    private String[][] grid = {{"\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6"},
        {"\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6"},
        {"\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6"},
        {"\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6"},
        {"\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6"}};
    private Whale whale;
    private Trash trash2;
    private Trash trash3;
    private int whaleRow;
    private int trash1Row;
    private int trash2Row;
    private int trash3Row;
    private int trash1Col;
    private int trash2Col;
    private int trash3Col;
    private int prev;

    Trash trash1 = new Trash();
    //constructor
    public Grid() {
        whale = new Whale();
        whaleRow = whale.getRow();
        trash2 = new Trash();
        trash3 = new Trash();
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
            if (whale.getUp()) {
                whaleRow++;
            }
            else {
                whaleRow--;
            }
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

    public void placeTrashs() {
        grid[trash1.getTrash1Row()][6] = trash1.getTrash();
        grid[trash2.getTrash2Row()][6] = trash2.getTrash();
        grid[trash3.getTrash3Row()][6] = trash3.getTrash();
    }
}
