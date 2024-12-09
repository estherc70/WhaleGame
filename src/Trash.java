public class Trash {
    private String trash1;
    private Start start;

    public Trash() {
        trash1 = "\uD83D\uDDD1\uFE0F";
    }

    /*An overloaded constructor that takes an input from start class.
    Based on that input the trash1 instance var. gets set to a specific emoji.*/
    public Trash(String emojiInput) {
        if (emojiInput.equals("wastebasket")) {
            trash1 = "\uD83D\uDDD1\uFE0F";  // Wastebasket emoji
        } else if (emojiInput.equals("canned food")) {
            trash1 = "\uD83E\uDD6B";  // Canned food emoji
        } else if (emojiInput.equals("shoes")) {
            trash1 = "\uD83D\uDC5F";  // Shoes emoji
        } else {
            trash1 = "\uD83D\uDDD1\uFE0F";
            System.out.println("Invalid input, please try again!!!");
        }
    }

    public String getTrash() {
        return trash1;
    }

    public int getTrash1Row() {
        return (int) (Math.random()*5);
    }

    public int getTrash2Row() {
        int trash2Row = (int) (Math.random()*5);
        while (trash2Row == getTrash1Row()) {
            trash2Row = (int) (Math.random()*5);
        }
        return trash2Row;
    }

    public int getTrash3Row() {
        int trash3Row = (int) (Math.random()*5);
        while ((trash3Row == getTrash1Row()) || (trash3Row == getTrash2Row())) {
            trash3Row = (int) (Math.random()*5);
        }
        return trash3Row;
    }

    public int getTrash1Col() {
        return (int) (Math.random()*3)+1;
    }

    public int getTrash2Col() {
        int trash2Col = (int) (Math.random()*3) + 1;
        while (trash2Col == getTrash1Col()) {
            trash2Col = (int) (Math.random()*3) + 1;
        }
        return trash2Col;
    }

    public int getTrash3Col() {
        int trash3Col = (int) (Math.random()*3) + 1;
        while ((trash3Col == getTrash1Col()) || (trash3Col == getTrash2Col())) {
            trash3Col = (int) (Math.random()*3) + 1;
        }
        return trash3Col;
    }
}
