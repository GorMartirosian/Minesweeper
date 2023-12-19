package main;

import main.board.Board;
import main.board.BoardFactory;
import main.board.coordinate.UserMark;
import main.util.io.UserInputUtil;

public class Game {

    public static void main(String[] args) {
        System.out.println("Welcome to the game Minesweeper! ");
        boolean playAgain = true;
        while (playAgain) {
            play();
            if(UserInputUtil.getInputString("Do you want to play again? (y/n) ").equals("y")) {
                continue;
            }
            playAgain = false;
        }
    }

    private static int selectDifficulty() {
        return UserInputUtil.getInputInt("""
                What difficulty do you want to play?
                1) Easy
                2) Medium
                3) Hard""");
    }

    private static void play(){
        Board board = BoardFactory.generate(selectDifficulty());
        board.print();
        UserMark mark = UserInputUtil.getUserMark();
        Loop: while (true) {
            if(mark.hasFlag()){
                if(mark.getFlag() == 'm') {
                    board.markCell(mark.getX(),mark.getY());
                } else {
                    board.unmarkCell(mark.getX(),mark.getY());
                }
            } else {
                switch (board.openCell(mark.getX(),mark.getY())) {
                    case 1: board.victory();
                        break Loop;
                    case -1: board.gameOver();
                        break Loop;
                }
            }
            board.print();
            mark = UserInputUtil.getUserMark();
        }
    }
}