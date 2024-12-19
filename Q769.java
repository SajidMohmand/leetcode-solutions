public class Q769 {

    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int maxLeft = -1;
        int chunks = 0;
        for (int i = 0; i < n; i++) {
            maxLeft = Math.max(maxLeft, arr[i]);
            if (maxLeft == i) {
                chunks++;
            }
        }
        return chunks;
    }
}
