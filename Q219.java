import java.util.*;

public class Q219 {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> window = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (window.contains(nums[i])) {
                return true;
            }
            window.add(nums[i]);
            if (window.size() > k) {
                window.remove(nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        Input: nums = [1,2,3,4,1], k = 3
//        Output: true

        System.out.println(containsNearbyDuplicate(new int[]{1,2,3,4,1},3));
    }
}
