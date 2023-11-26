package main.board.cell;

public class Cell {
    private boolean hasBomb;
    private boolean isMarked;
    private boolean isOpened;

    public Cell(boolean hasBomb, boolean isMarked, boolean isOpened) {
        this.hasBomb = hasBomb;
        this.isMarked = isMarked;
        this.isOpened = isOpened;
    }

    public Cell() {
        this(false,false,false);
    }

    public boolean hasBomb() {
        return hasBomb;
    }

    /**
     * Only used when cell is initialized.
     */
    public void setBomb(){
        hasBomb = true;
    }

    public boolean isOpened() {
        return isOpened;
    }

    public void open() {
        if(!isOpened()) {
            if(hasBomb()) {
                //todo game over
            } else {
                isOpened = true;
            }
        }
    }

    public boolean isMarked() {
        return isMarked;
    }

    public void setMark(boolean marked) {
        if(!isOpened()) {
            isMarked = marked;
        }
    }
}