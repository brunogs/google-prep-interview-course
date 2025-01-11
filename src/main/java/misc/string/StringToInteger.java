package misc.string;

import java.math.BigInteger;

public class StringToInteger {

    public int myAtoi(String s) {

        boolean skippedWhitespaces = false;
        char signal = '.';
        String currentValue = "";
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (!skippedWhitespaces && currentChar == ' ') {
                continue;
            }
            skippedWhitespaces = true;

            if (signal == '.') {
                if (currentChar == '+' || currentChar == '-') {
                    signal = currentChar;
                    continue;
                }
                signal = '+';
            }

            if (Character.isDigit(currentChar)) {
                currentValue += currentChar;
                continue;
            }
            // stop iteration
            break;
        }

        if (currentValue.length() == 0) {
            return 0;
        }
        BigInteger result = new BigInteger(currentValue);
        if (result.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) >= 1 && signal == '+') {
            return Integer.MAX_VALUE;
        } else if (result.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) >= 1 && signal == '-') {
            return Integer.MIN_VALUE;
        }

        if (signal == '-') {
            return result.intValue() * -1;
        }
        return result.intValue();
    }
}
