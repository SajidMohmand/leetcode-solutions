import java.util.TreeMap;
public class Q2762 {
    public static long continuousSubarrays(int[] nums) {
        TreeMap<Integer, Integer> freqMap = new TreeMap<>();
        int left = 0;
        long totalSubarrays = 0;
        for (int right = 0; right < nums.length; right++) {
            freqMap.put(nums[right], freqMap.getOrDefault(nums[right], 0) + 1);
            while (freqMap.lastKey() - freqMap.firstKey() > 2) {
                int leftValue = nums[left];
                freqMap.put(leftValue, freqMap.get(leftValue) - 1);
                if (freqMap.get(leftValue) == 0) {
                    freqMap.remove(leftValue);
                }
                left++;
            }
            totalSubarrays += right - left + 1;
        }
        return totalSubarrays;
    }

    public static void main(String[] args) {
//        Input: nums = [5,4,2,4]
//        Output: 8

        System.out.println(continuousSubarrays(new int[]{5,4,2,4}));
    }
}
