package main.util.io;

import main.board.coordinate.UserMark;
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
        String userInput = getInputString("Select coordinate (to mark/unmark, add m/u).");
        while (!isValid(userInput)) {
            userInput = getInputString("Invalid input! Select coordinate (to mark/unmark, add m/u).");
        }
        return new UserMark(getRow(userInput),
                            getColumn(userInput),
                            getFlag(userInput));
    }

    private static boolean isValid(String input) {
        String[] tokens = splitInput(input);
        return tokens.length >= 2 && isNumeric(tokens[0]) && isNumeric(tokens[1]);
    }

    private static boolean isNumeric(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * "1 4u"
     * '0 0m'
     * @param input
     * @return
     */
    private static int getRow(String input) {
        return Integer.parseInt(splitInput(input)[0]);
    }

    private static int getColumn(String input) {
        return Integer.parseInt(splitInput(input)[1]);
    }

    private static Character getFlag(String input) {
        String[] tokens = splitInput(input);
        if(tokens.length > 2) {
            return tokens[2].charAt(0);
        }
        return null;
    }
    private static String[] splitInput(String input) {
        return input.split(" |(?=m)|(?=u)");
    }
}