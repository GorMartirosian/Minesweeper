package main;

import main.board.Board;
import main.util.io.UserInputUtil;
import java.sql.Time;
import java.time.LocalTime;

public class Game {
    Player player;

    public static void main(String[] args) {
        welcomePlayer();
        boolean playAgain = true;
        while (playAgain) {
            Game game = new Game();
            game.play();
            game.reportResults();
            if(UserInputUtil.getInputString("Do you want to play again? (y/n)").equals("y")){
                continue;
            }
            playAgain = false;
        }
    }

    private static void welcomePlayer(){

    }

    private void play(){

    }
    private void reportResults(){

    }
}