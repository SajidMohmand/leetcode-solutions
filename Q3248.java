import java.util.*;
public class Q3248 {
    public static int finalPositionOfSnake(int n, List<String> commands) {
        // Starting position at cell 0, which is (0,0) in the grid
        int x = 0, y = 0;

        // Traverse through all commands
        for (String command : commands) {
            switch (command) {
                case "UP":
                    x -= 1; // Move up (row decreases)
                    break;
                case "DOWN":
                    x += 1; // Move down (row increases)
                    break;
                case "LEFT":
                    y -= 1; // Move left (column decreases)
                    break;
                case "RIGHT":
                    y += 1; // Move right (column increases)
                    break;
            }
        }

        // Calculate the final 1D position in the grid using the formula (x * n) + y
        return (x * n) + y;
    }

    public static void main(String[] args) {
        int n = 2;List<String> commands = new ArrayList<>();
        commands.add("RIGHT");
        commands.add("DOWN");

//        finalPositionOfSnake(n,commands);
        System.out.println(finalPositionOfSnake(n,commands));
    }
}
