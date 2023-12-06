package main.util.io;

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
}
