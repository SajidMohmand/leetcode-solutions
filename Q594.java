import java.util.*;

public class Q594 {
    public static int findLHS(int[] nums) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        int maxLength = 0;
        for (int key : freqMap.keySet()) {
            if (freqMap.containsKey(key + 1)) {
                int currentLength = freqMap.get(key) + freqMap.get(key + 1);
                maxLength = Math.max(maxLength, currentLength);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
//        Input: nums = [1,3,2,2,5,2,3,7]
//        Output: 5

        System.out.println(findLHS(new int[]{1,3,2,2,5,2,3,7}));
    }
}
