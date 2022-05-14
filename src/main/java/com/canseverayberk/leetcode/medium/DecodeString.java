package com.canseverayberk.leetcode.medium;

/**
 * https://leetcode.com/problems/decode-string
 */
public class DecodeString {

    public static void main(String[] args) {
        String s = "3[a]2[bc]";git add .
        String decodedString = decodeString(s);
    }

    public static String decodeString(String s) {
        String decodedString = decode(s);
        while (decodedString.contains("[") && decodedString.contains("]")) {
            decodedString = decode(decodedString);
        }
        return decodedString;
    }

    private static String decode(String s) {
        int firstClose = s.indexOf("]");
        if (firstClose == -1)
            return s;
        int lastOpen = s.substring(0, firstClose).lastIndexOf("[");
        String repeatedString = s.substring(lastOpen + 1, firstClose);

        int repeatTimes = 0;
        int index = -1;
        while (true) {
            try {
                repeatTimes = Integer.parseInt(s.substring(lastOpen + index, lastOpen));
                index--;
            } catch (NumberFormatException | StringIndexOutOfBoundsException exception) {
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < repeatTimes; i++) {
            sb.append(repeatedString);
        }

        String replacement = String.valueOf(repeatTimes).concat("[").concat(repeatedString).concat("]");
        return s.replace(replacement, sb.toString());
    }
}
