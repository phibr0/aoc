package d6;

import java.nio.file.Files;
import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.io.IOException;

public class AOC {
    public static void main(String[] args) throws IOException {
        char[] input = Files.readString(new File("src/d6/input.txt").toPath()).toCharArray();

        char[] lastchars = new char[4];
        for (int i = 0; i < input.length; i++) {
            if (i < lastchars.length) {
                lastchars[i] = input[i];
                continue;
            }

            // Shift all elements to the left
            for (int j = 0; j < lastchars.length - 1; j++) {
                lastchars[j] = lastchars[j + 1];
            }
            lastchars[lastchars.length - 1] = input[i];

            // Check if all elements are different
            if (new HashSet<>(Arrays.asList(lastchars[0], lastchars[1], lastchars[2], lastchars[3]))
                    .size() == lastchars.length) {
                System.out.println("Part 1: " + (i + 1));
                break;
            }
        }

        lastchars = new char[14];
        for (int i = 0; i < input.length; i++) {
            if (i < lastchars.length) {
                lastchars[i] = input[i];
                continue;
            }

            // Shift all elements to the left
            for (int j = 0; j < lastchars.length - 1; j++) {
                lastchars[j] = lastchars[j + 1];
            }
            lastchars[lastchars.length - 1] = input[i];

            // Check if all elements are different
            var set = new HashSet<>(14);
            for (char c : lastchars) {
                set.add(c);
            }
            if (set.size() == lastchars.length) {
                System.out.println("Part 2: " + (i + 1));
                break;
            }
        }
    }
}
