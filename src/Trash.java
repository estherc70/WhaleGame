public class Trash {
    private String trash1;
    private int trash1Row;
    private int trash2Row;
    private int trash3Row;
    private int trash1Col;
    private int trash2Col;
    private int trash3Col;

    public Trash() {
        trash1 = "\uD83D\uDDD1\uFE0F";
    }

    public String getTrash() {
        return trash1;
    }

    public int getTrash1Row() {
        return (int) (Math.random()*5);
    }

    public int getTrash2Row() {
        int row = (int) (Math.random()*5);
        while (row == getTrash1Row()) {
            row = (int) (Math.random()*5);
        }
        return row;
    }

    public int getTrash3Row() {
        int row = (int) (Math.random()*5);
        while ((row == getTrash1Row()) || (row == getTrash2Row())) {
            row = (int) (Math.random()*5);
        }
        return row;
    }
}
