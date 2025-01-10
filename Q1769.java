public class Q1769 {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] answer = new int[n];

        // Left-to-right pass
        int left_count = 0;  // Count of balls to the left
        int left_cost = 0;   // Cost of moving those balls
        for (int i = 0; i < n; i++) {
            answer[i] += left_cost;
            if (boxes.charAt(i) == '1') {
                left_count++;
            }
            left_cost += left_count;
        }

        // Right-to-left pass
        int right_count = 0;  // Count of balls to the right
        int right_cost = 0;   // Cost of moving those balls
        for (int i = n - 1; i >= 0; i--) {
            answer[i] += right_cost;
            if (boxes.charAt(i) == '1') {
                right_count++;
            }
            right_cost += right_count;
        }

        return answer;
    }

    
}
