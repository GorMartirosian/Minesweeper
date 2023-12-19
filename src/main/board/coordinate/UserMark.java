package main.board.coordinate;

public class UserMark extends Coordinate {
    private final Character flag;

    public UserMark(int x, int y, Character flag) {
        super(x, y);
        this.flag = flag;
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
