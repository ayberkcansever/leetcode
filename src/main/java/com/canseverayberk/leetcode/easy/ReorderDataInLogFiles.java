package com.canseverayberk.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class ReorderDataInLogFiles {

    public static void main(String[] args) {
        String[] logs = new String[] {
            "6p tzwmh ige mc", "ns 566543603829", "ubd cujg j d yf", "ha6 1 938 376 5", "3yx 97 666 56 5", "d 84 34353 2249", "0 tllgmf qp znc", "s 1088746413789", "ys0 splqqxoflgx", "uhb rfrwt qzx r", "u lrvmdt ykmox", "ah4 4209164350", "rap 7729 8 125", "4 nivgc qo z i", "apx 814023338 8"
        };
        String[] orderedLogs = reorderLogFiles(logs);
    }

    public static String[] reorderLogFiles(String[] logs) {

        List<String> letterLogs = new ArrayList<>();
        List<String> digitLogs = new ArrayList<>();

        for (String log : logs) {
            try {
                String[] words = log.split("\\s");
                for (int i = 1; i < words.length; i++) {
                    String word = words[i];
                    for (char c : word.toCharArray()) {
                        if (c < '0' || c > '9') {
                            throw new NumberFormatException();
                        }
                    }
                }
                digitLogs.add(log);
            } catch (NumberFormatException e) {
                letterLogs.add(log);
            }
        }

        letterLogs.sort((o1, o2) -> {
            String identifier1 = o1.split("\\s")[0];
            String identifier2 = o2.split("\\s")[0];
            String content1 = o1.replace(identifier1 + " ", "");
            String content2 = o2.replace(identifier2 + " ", "");

            if (content1.equals(content2)) {
                return identifier1.compareTo(identifier2);
            }

            return content1.compareTo(content2);
        });

        letterLogs.addAll(digitLogs);
        return letterLogs.toArray(new String[0]);

    }
}
