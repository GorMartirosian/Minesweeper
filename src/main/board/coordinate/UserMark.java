package main.board.coordinate;

import main.board.coordinate.Coordinate;

public class UserMark extends Coordinate {
    private final char flag;

    public UserMark(int x, int y, char flag) {
        super(x, y);
        this.flag = flag;
    }

    public char getFlag() {
        return flag;
    }
}
