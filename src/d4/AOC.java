package d4;

import java.nio.file.Files;
import java.io.File;
import java.io.IOException;

public class AOC {
    public static void main(String[] args) throws IOException {
        String[] input = Files.readString(new File("src/d4/input.txt").toPath()).split("\n");

        int[][][] data = new int[input.length][2][2];
        for (int i = 0; i < input.length; i++) {
            String[] split = input[i].split(",");
            var firstElve = split[0].split("-");
            var secondElve = split[1].split("-");
            data[i][0][0] = Integer.parseInt(firstElve[0]);
            data[i][0][1] = Integer.parseInt(firstElve[1]);
            data[i][1][0] = Integer.parseInt(secondElve[0]);
            data[i][1][1] = Integer.parseInt(secondElve[1]);
        }

        int overlaps = 0;

        for (var pair : data) {
            var firstElve = pair[0];
            var secondElve = pair[1];
            if (firstElve[0] <= secondElve[0] && firstElve[1] >= secondElve[1]) {
                overlaps++;
            } else if (secondElve[0] <= firstElve[0] && secondElve[1] >= firstElve[1]) {
                overlaps++;
            } else if (firstElve[0] >= secondElve[0] && firstElve[0] <= secondElve[1]) {
                overlaps++;
            } else if (secondElve[0] >= firstElve[0] && secondElve[0] <= firstElve[1]) {
                overlaps++;
            }
        }

        System.out.println("Part 1: " + overlaps);
    }
}
