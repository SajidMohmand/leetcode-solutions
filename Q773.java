import java.util.*;

public class Q773 {

    public int slidingPuzzle(int[][] board) {
        // Convert the board to a string representation
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(board[i][j]);
            }
        }
        String start = sb.toString();
        String target = "123450";
        // Define valid neighbors for each index
        int[][] neighbors = {
                {1, 3},        // neighbors of index 0
                {0, 2, 4},     // neighbors of index 1
                {1, 5},        // neighbors of index 2
                {0, 4},        // neighbors of index 3
                {1, 3, 5},     // neighbors of index 4
                {2, 4}         // neighbors of index 5
        };

        // BFS initialization
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);
        int moves = 0;

        // BFS loop
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (current.equals(target)) {
                    return moves; // Target state reached
                }

                int zeroIndex = current.indexOf('0');
                for (int neighbor : neighbors[zeroIndex]) {
                    String next = swap(current, zeroIndex, neighbor);
                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.offer(next);
                    }
                }
            }
            moves++;
        }

        return -1; // Target state not reachable
    }

    // Helper function to swap characters in a string
    private String swap(String str, int i, int j) {
        char[] chars = str.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }

    public static void main(String[] args) {

    }
}
