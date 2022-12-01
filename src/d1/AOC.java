package d1;

import java.nio.file.Files;
import java.util.Arrays;
import java.io.File;
import java.io.IOException;

public class AOC {
    public static void main(String[] args) throws IOException {
        String input = Files.readString(new File("src/d1/input.txt").toPath());

        String[] elves = input.split("\n\n");
        int[] calories = new int[elves.length];

        for (int i = 0; i < elves.length; i++) {
            if (elves[i] != null)
                for (var item : elves[i].split("\n")) {
                    calories[i] += Integer.parseInt(item);
                }
        }
        Arrays.sort(calories);

        System.out.println("Part 1:" + calories[calories.length - 1]);
        System.out.println("Part 2:" + (calories[calories.length - 3] + calories[calories.length - 2]
                + calories[calories.length - 1]));
    }
}
