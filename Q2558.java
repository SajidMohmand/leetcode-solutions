import java.util.PriorityQueue;
import java.util.Collections;
public class Q2558 {

    public static long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int gift : gifts) {
            maxHeap.add(gift);
        }
        for (int i = 0; i < k; i++) {
            int maxGifts = maxHeap.poll();
            maxHeap.add((int) Math.sqrt(maxGifts));
        }
        long res = 0;
        for (int gift : maxHeap) {
            res += gift;
        }
        return res;
    }

//    public static long pickGifts(int[] gifts, int k) {
//
//        long res = 0;
//        for (int i=0; i<k; i++){
//
//            int x = gifts[0];
//            int index = 0;
//            for (int j=1; j<gifts.length; j++){
//                if (x < gifts[j]){
//                    x = gifts[j];
//                    index = j;
//                }
//            }
//            gifts[index] = (int)Math.sqrt(x);
//        }
//        for (int n: gifts){
//            res += n;
//        }
//        return res;
//    }

    public static void main(String[] args) {
//        Input: gifts = [25,64,9,4,100], k = 4
//        Output: 29
        System.out.println(pickGifts(new int[]{25,64,9,4,100},4));

    }
}
