public class Q1475 {

    public static int[] finalPrices(int[] prices) {

        int[] ans = new int[prices.length];

        for (int i=0; i<prices.length; i++){
            boolean flag = false;
            for (int j=i+1; j<prices.length; j++){
                if (prices[i] >= prices[j]){
                    ans[i] = prices[i]-prices[j];
                    flag = true;
                    break;
                }
            }
            if (!flag){
                ans[i] = prices[i];
            }
        }
        return ans;
    }
    static void display(int[] arr){
        for (int num: arr){
            System.out.print(num+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
//        Input: prices = [8,4,6,2,3]
//        Output: [4,2,4,2,3]
        int[] arr = {8,4,6,2,3};
        display(arr);
        int[] res = finalPrices(arr);
        display(res);
    }
}
