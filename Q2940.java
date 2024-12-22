import java.util.*;
public class Q2940 {
    private int[] segTree;

    private void buildSegmentTree(int[] heights, int start, int end, int stIdx) {
        if (start == end) {
            segTree[stIdx] = start;
            return;
        }

        int mid = start + (end - start) / 2;
        buildSegmentTree(heights, start, mid, 2 * stIdx);
        buildSegmentTree(heights, mid + 1, end, 2 * stIdx + 1);

        segTree[stIdx] = heights[segTree[2 * stIdx]] >= heights[segTree[2 * stIdx + 1]]
                ? segTree[2 * stIdx] : segTree[2 * stIdx + 1];
    }

    private int rangeMaxQuery(int[] heights, int qs, int qe, int start, int end, int stIdx) {
        if (start >= qs && end <= qe)
            return segTree[stIdx];
        if (start > qe || end < qs)
            return -1;

        int mid = start + (end - start) / 2;
        int leftMax = rangeMaxQuery(heights, qs, qe, start, mid, 2 * stIdx);
        int rightMax = rangeMaxQuery(heights, qs, qe, mid + 1, end, 2 * stIdx + 1);

        if (leftMax == -1) return rightMax;
        if (rightMax == -1) return leftMax;

        return heights[leftMax] >= heights[rightMax] ? leftMax : rightMax;
    }

    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length;
        segTree = new int[4 * n];
        buildSegmentTree(heights, 0, n - 1, 1);

        List<Integer> result = new ArrayList<>();
        for (int[] query : queries) {
            int alice = query[0], bob = query[1];

            if (alice == bob) {
                result.add(alice);
                continue;
            }

            if (alice > bob) {
                int temp = alice;
                alice = bob;
                bob = temp;
            }

            if (heights[alice] < heights[bob]) {
                result.add(bob);
                continue;
            }

            int low = bob, high = n - 1, ans = -1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                int maxIdx = rangeMaxQuery(heights, low, mid, 0, n - 1, 1);

                if (heights[maxIdx] > heights[alice]) {
                    ans = maxIdx;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            result.add(ans);
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
