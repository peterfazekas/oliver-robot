package hu.robot.model.service;

import java.util.stream.IntStream;

public class ProgramHelper {

    public static String convertToNewFormat(String commands) {
        StringBuilder newFormat = new StringBuilder();
        String oldFormat = commands + " ";
        int sameCommandCounter = 1;
        char prevCommand = oldFormat.charAt(0);
        for (int i = 1; i < oldFormat.length(); i++) {
            char actualCommand = oldFormat.charAt(i);
            if (prevCommand == actualCommand) {
                sameCommandCounter++;
            } else {
                if (sameCommandCounter > 1) {
                    newFormat.append(sameCommandCounter);
                }
                newFormat.append(prevCommand);
                sameCommandCounter = 1;
            }
            prevCommand = actualCommand;
        }
        return newFormat.toString();
    }

    public static String convertToOldFormat(String newFormat) {
        StringBuilder oldFormat = new StringBuilder();
        StringBuilder number = new StringBuilder();
        for (char command : newFormat.toCharArray()) {
            if (isNumber(command)) {
                number.append(command);
            } else {
                int upperBounder = number.length() > 0 ? Integer.parseInt(number.toString()) : 1;
                IntStream.range(0, upperBounder)
                        .forEach(i -> oldFormat.append(command));
                number = new StringBuilder();
            }
        }
        return oldFormat.toString();
    }

    private static boolean isNumber(char command) {
        return command >= '0' && command <= '9';
    }
}
