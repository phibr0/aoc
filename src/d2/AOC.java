package d2;

import java.nio.file.Files;
import java.io.File;
import java.io.IOException;

public class AOC {
    public static void main(String[] args) throws IOException {
        String input = Files.readString(new File("src/d2/input.txt").toPath());
        String[] moves = input.split("\n");

        int score = 0;
        int score2 = 0;

        for (String move : moves) {
            var tuple = move.split(" ");
            var op = tuple[0];
            var me = tuple[1];

            // Part 1

            // Shape
            switch (me) {
                case "Z":
                    score++;
                case "Y":
                    score++;
                case "X":
                    score++;
            }

            // Draw
            if ((me.equals("X") && op.equals("A"))
                    || (me.equals("Y") && op.equals("B"))
                    || (me.equals("Z") && op.equals("C"))) {
                score += 3;
            }

            // Win/Loss
            if (me.equals("Y") && op.equals("A")) {
                score += 6;
            } else if (me.equals("Z") && op.equals("B")) {
                score += 6;
            } else if (me.equals("X") && op.equals("C")) {
                score += 6;
            }

            // Part 2

            if (me.equals("X")) {
                // I need to loose
                if (op.equals("A")) {
                    // I choose scissors
                    score2 += 3 + 0;
                } else if (op.equals("B")) {
                    // I choose rock
                    score2 += 1 + 0;
                } else {
                    // I choose paper
                    score2 += 2 + 0;
                }
            } else if (me.equals("Y")) {
                // I need to draw
                if (op.equals("A")) {
                    // I choose rock
                    score2 += 1 + 3;
                } else if (op.equals("B")) {
                    // I choose paper
                    score2 += 2 + 3;
                } else {
                    // I choose scissors
                    score2 += 3 + 3;
                }
            } else if (me.equals("Z")) {
                // I need to win
                if (op.equals("A")) {
                    // I choose paper
                    score2 += 2 + 6;
                } else if (op.equals("B")) {
                    // I choose scissors
                    score2 += 3 + 6;
                } else {
                    // I choose rock
                    score2 += 1 + 6;
                }
            }

        }

        System.out.println("Part 1: " + score);
        System.out.println("Part 2: " + score2);
    }
}
