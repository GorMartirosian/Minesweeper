package main.board.coordinate;

import main.board.coordinate.Coordinate;

public class UserMark extends Coordinate {
    private final Character flag;

    public UserMark(int x, int y, Character flag) {
        super(x, y);
        this.flag = flag;
    }

    public UserMark(int x, int y) {
        this(x,y,null);
    }

    public char getFlag() {
        if(hasFlag()){
            return flag;
        }
        throw new UnsupportedOperationException("Is not a mark for putting a flag!");
    }

    public boolean hasFlag(){
        return flag != null;
    }
}
