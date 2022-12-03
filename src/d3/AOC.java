package d3;

import java.nio.file.Files;
import java.io.File;
import java.io.IOException;

public class AOC {
    public static void main(String[] args) throws IOException {
        String input = Files.readString(new File("src/d3/input.txt").toPath());
        String[] rucksacksStrings = input.split("\n");

        String[][] rucksacks = new String[rucksacksStrings.length][2];
        for (int i = 0; i < rucksacksStrings.length; i++) {
            rucksacks[i][0] = rucksacksStrings[i].subSequence(0, (rucksacksStrings[i].length()) / 2).toString();
            rucksacks[i][1] = rucksacksStrings[i]
                    .subSequence(rucksacksStrings[i].length() / 2, rucksacksStrings[i].length()).toString();
        }

        int priority = 0;
        for (var rucksack : rucksacks) {
            for (var item : rucksack[0].toCharArray()) {
                if (rucksack[1].contains(item + "")) {
                    priority += toPriority(item);
                    break;
                }
            }
        }

        System.out.println("Part 1: " + priority);

        String[][] groups = new String[rucksacksStrings.length / 3][3];
        for (int i = 0; i < rucksacksStrings.length; i += 3) {
            for (int j = 0; j < 3; j++) {
                groups[i / 3][j] = rucksacksStrings[i + j];
            }
        }

        int priority2 = 0;
        for (var group : groups) {
            for (var item : group[0].toCharArray()) {
                if (group[1].contains(item + "") && group[2].contains(item + "")) {
                    priority2 += toPriority(item);
                    break;
                }
            }

        }
        System.out.println("Part 2: " + priority2);
    }

    public static int toPriority(char c) {
        if (Character.isUpperCase(c)) {
            return (int) c - 38;
        } else {
            return (int) c - 96;
        }
    }
}
