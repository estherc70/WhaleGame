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
    private int trash1RowPrev, trash2RowPrev,trash3RowPrev;
    private int prev, moves;
    private Score score;

    //constructor
    public Grid(Score score) {
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
        this.score = score;
    }

    public void setTrashEmoji(Trash trash) {
        trash1 = trash;
        trash2 = trash;
        trash3 = trash;
    }

    //uses two for loops to print the grid
    public void printGrid() {
        for(String[] row : grid) {
            for(String c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    //places the whale
    //whaleRow is the updates row index to place the whale from if the user chose w or s
    public void placeWhale() {
        grid[whaleRow][0] = whale.getWhale();
    }

    //sets the previous position of the whale blue once the whale gets placed in a new position
    //row is the previous position of the whale
    public void setBlue(int row) {
        grid[row][0] = "\uD83D\uDFE6";
    }

    //sets the previous positions of the trashes blue once the trash moves
    //row and col are the previous positions of the trashes
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

    //moves the whale according to the user's move
    //updates the index of the row accordingly
    //also checks to see if user moved out of bound
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
                if (whaleRow == trash1Row ||
                        whaleRow == trash2Row ||
                        whaleRow == trash3Row) {
                    grid[whaleRow][0] = "\uD83D\uDCA5"; //replaces the whale with an explosion emoji to replicate a collision
                    if (score.getLives() == 1) {
                        System.out.println("❗\u001B[0m\u001B[38;5;210mOh no, You lost all three lives!\u001B[0m \uD83D\uDC94 \uD83D\uDC94 \uD83D\uDC94");
                        score.updateLives();
                    } else {
                        System.out.println("❗\u001B[0m\u001B[38;5;210mOuch! You ran into the trash, you lost one life\u001B[0m");
                        score.updateLives();
                    }
                }
                trash1RowPrev = trash1Row;
                trash2RowPrev = trash2Row;
                trash3RowPrev = trash3Row;
                setBlueTrash2();
                moves++;
            }else if (moves == 2){
                setBlueTrash3();
                if (whaleRow == trash1Row ||
                        whaleRow == trash2Row ||
                        whaleRow == trash3Row) {
                    grid[whaleRow][0] = whale.getWhale();
                }
                if (whaleRow == trash1RowPrev ||
                        whaleRow == trash2RowPrev ||
                        whaleRow == trash3RowPrev) {
                    grid[whaleRow][0] = "\uD83D\uDCA5"; //replaces the whale with an explosion emoji to replicate a collision
                    if (score.getLives() == 1) {
                        System.out.println("❗\u001B[0m\u001B[38;5;210mOh no, You lost all three lives!\u001B[0m \uD83D\uDC94 \uD83D\uDC94 \uD83D\uDC94");
                        score.updateLives();
                    } else {
                        System.out.println("❗\u001B[0m\u001B[38;5;210mOuch! You ran into the trash, you lost one life\u001B[0m");
                        score.updateLives();
                    }
                }
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
            System.out.println("\u001B[38;5;210mOut of bound!\nEnter a new move!\u001B[0m"); //prevents the user from moving out of bounds
        }
    }

    //checks to see if user is out of bound (out of the grid)
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
}
