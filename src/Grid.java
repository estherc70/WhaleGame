public class Grid {

    private String[][] grid = {{"\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6"},
        {"\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6"},
        {"\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6"},
        {"\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6"},
        {"\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6","\uD83D\uDFE6"}};
    private Whale whale;
    private Trash trash1, trash2, trash3;
    private int whaleRow;
    private int trash1Row , trash2Row, trash3Row;
    private int trash1Col, trash2Col, trash3Col;
    private int prev, moves;

    //constructor
    public Grid() {
        whale = new Whale();
        whaleRow = whale.getRow();
        trash1 = new Trash();
        trash2 = new Trash();
        trash3 = new Trash();
        prev = 0;
        trash1Col = trash1.getTrash1Col();
        trash2Col = trash2.getTrash2Col();
        trash3Col = trash3.getTrash3Col();
        moves = 0;
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

    public void setBlue(int row, int col) {
        grid[row][col] = "\uD83D\uDFE6";
    }

    public void setBlueTrash() {
        setBlue(trash1Row,6);
        setBlue(trash2Row,6);
        setBlue(trash3Row,6);
    }

    public void setBlueTrash2() {
        setBlue(trash1Row,trash1Col);
        setBlue(trash2Row,trash2Col);
        setBlue(trash3Row,trash3Col);
    }

    public void setBlueTrash3() {
        setBlue(trash1Row,0);
        setBlue(trash2Row,0);
        setBlue(trash3Row,0);
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
            if (moves == 1) {
                placeTrashs2();
                setBlueTrash2();
                moves++;
            }else if (moves == 2){
                setBlueTrash3();
                placeTrashsInitial();
                moves = 0;
            } else {
                placeTrashs1();
                setBlueTrash();
                moves++;
            }
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

    public void placeTrashsInitial() {
        trash1Row = trash1.getTrash1Row();
        trash2Row = trash2.getTrash2Row();
        trash3Row = trash3.getTrash3Row();
        grid[trash1Row][6] = trash1.getTrash();
        grid[trash2Row][6] = trash2.getTrash();
        grid[trash3Row][6] = trash3.getTrash();
    }

    public void placeTrashs1() {
        grid[trash1Row][trash1Col] = trash1.getTrash();
        grid[trash2Row][trash2Col] = trash2.getTrash();
        grid[trash3Row][trash3Col] = trash3.getTrash();
    }

    public void placeTrashs2() {
        grid[trash1Row][0] = trash1.getTrash();
        grid[trash2Row][0] = trash2.getTrash();
        grid[trash3Row][0] = trash3.getTrash();
    }

    public boolean collide() {
        //if (grid.)
        return false;
    }
}
