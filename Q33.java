public class Q33 {
    public int search(int[] nums, int target) {
        int n = nums.length;

        // Step 1: Find the pivot
        int pivot = findPivot(nums, 0, n - 1);

        // Step 2: Determine which side of the pivot to search
        if (pivot == 0 || target < nums[0]) {
            // Search in the right part
            return binarySearch(nums, pivot, n - 1, target);
        } else {
            // Search in the left part
            return binarySearch(nums, 0, pivot - 1, target);
        }
    }

    private int binarySearch(int[] arr, int low, int high, int x) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x) return mid;
            if (arr[mid] < x) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    private int findPivot(int[] arr, int low, int high) {
        while (low < high) {
            if (arr[low] <= arr[high]) return low;

            int mid = (low + high) / 2;
            if (arr[mid] > arr[high]) low = mid + 1;
            else high = mid;
        }
        return low;
    }

}
