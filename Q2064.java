public class Q2064 {

    public static int minimizedMaximum(int n, int[] quantities) {
        int left = 1;
        int right = getMaxQuantity(quantities);
        int result = right;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canDistribute(n, quantities, mid)) {
                result = mid; // Try to minimize x further
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return result;
    }
    
    private static boolean canDistribute(int n, int[] quantities, int maxProductsPerStore) {
        int requiredStores = 0;
        for (int quantity : quantities) {
            requiredStores += (int) Math.ceil((double) quantity / maxProductsPerStore);
            if (requiredStores > n) {
                return false;
            }
        }
        return true;
    }
    
    private static int getMaxQuantity(int[] quantities) {
        int max = 0;
        for (int quantity : quantities) {
            max = Math.max(max, quantity);
        }
        return max;
    }   
    

    public static void main(String[] args){

        // Input: n = 6, quantities = [11,6]
// Output: 3
 
        int[] arr = {11,6};
        int n = 6;
        System.out.println(minimizedMaximum(n,arr));

    }
}