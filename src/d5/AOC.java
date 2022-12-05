package d5;

import java.nio.file.Files;
import java.util.Stack;
import java.io.File;
import java.io.IOException;

public class AOC {
    public static void main(String[] args) throws IOException {
        // manually processed input:
        String[] towers = { "HTZD",
                "QRWTGCS",
                "PBFQNRCH",
                "LCNFHZ",
                "GLFQS",
                "VPWZBRCS",
                "ZFJ",
                "DLVZRHQ",
                "BHGNFZLD",
        };
        String[] input = Files.readString(new File("src/d5/input.txt").toPath()).split("\n");
        Stack<Character>[] stacks = new Stack[10];
        for (int i = 0; i < towers.length; i++) {
            stacks[i + 1] = new Stack<Character>();
            for (var c : towers[i].toCharArray()) {
                stacks[i + 1].push(c);
            }
        }

        for (var line : input) {
            var parts = line.split(" ");
            int count = Integer.parseInt(parts[1]);
            int from = Integer.parseInt(parts[3]);
            int to = Integer.parseInt(parts[5]);

            // Part 1:
            // for (int i = 0; i < count; i++) {
            // stacks[to].push(stacks[from].pop());
            // }

            // Part 2:
            Stack<Character> temp = new Stack<Character>();
            for (int i = 0; i < count; i++) {
                temp.push(stacks[from].pop());
            }
            for (int i = 0; i < count; i++) {
                stacks[to].push(temp.pop());
            }
        }

        for (int i = 1; i < stacks.length; i++) {
            System.out.print(stacks[i].peek());
        }
    }
}
