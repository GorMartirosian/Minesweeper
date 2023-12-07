package main.util.io;

import main.board.coordinate.UserMark;

import java.util.Optional;
import java.util.Scanner;

public class UserInputUtil {

    private UserInputUtil(){
    }

    public static String getInputString(String message) {
        System.out.println(message);
        Scanner reader = new Scanner(System.in);
        return reader.nextLine();
    }

    public static int getInputInt(String message) {
        System.out.println(message);
        Scanner reader = new Scanner(System.in);
        return reader.nextInt();
    }

    public static UserMark getUserMark() {
        String userInput = UserInputUtil.getInputString("Select coordinate (to mark/unmark, add m/u).");
        return new UserMark(getRow(userInput),
                            getColumn(userInput),
                            getFlag(userInput).orElse('x'));
    }

    private static int getRow(String input) {

    }

    private static int getColumn(String input) {

    }

    private static Optional<Character> getFlag(String input) {

    }
}
