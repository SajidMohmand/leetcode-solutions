import java.util.*;
public class Q2657 {
    public static int[] findThePrefixCommonArray1(int[] A, int[] B) {

        int[] c = new int[A.length];

        for (int i=0; i<c.length; i++){
            int count = 0;
            for (int j = 0; j <= i; j++) {

                for (int x=0; x<=i; x++){
                    if (A[j] == B[x]){
                        count++;
                    }
                }
            }
            c[i] = count;
        }

        return c;
    }

    // optimize version of logic
    public static int[] findThePrefixCommonArray(int[] A, int[] B) {

        int n = A.length;
        int[] c = new int[n];
        HashSet<Integer> seenInA = new HashSet<>();
        HashSet<Integer> seenInB = new HashSet<>();
        int commonCount = 0;

        for (int i = 0; i < n; i++) {
            // Add current elements to the respective sets
            if (seenInB.contains(A[i])) {
                commonCount++;
            }
            seenInA.add(A[i]);

            if (seenInA.contains(B[i])) {
                commonCount++;
            }
            seenInB.add(B[i]);

            // Update the result array
            c[i] = commonCount;
        }

        return c;
    }

    public static void main(String[] args) {
//        Input: A = [1,3,2,4], B = [3,1,2,4]
//        Output: [0,2,3,4]
        int[] res = findThePrefixCommonArray(new int[]{1,3,2,4},new int[]{3,1,2,4});

        for (int i=0; i<res.length; i++){
            System.out.print(res[i]+" ");
        }
        System.out.println();
    }
}
