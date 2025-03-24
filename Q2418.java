import java.util.Arrays;


public class Q2418 {

//    public static String[] sortPeople(String[] names, int[] heights) {
//
//
//        for (int i=0; i<heights.length; i++){
//
//            int index = i;
//
//            for (int j=i+1; j<heights.length; j++){
//                if (heights[index] < heights[j]){
//                    index = j;
//                }
//            }
//            String temp = names[i];
//            names[i] = names[index];
//            names[index] = temp;
//
//            int temp2 = heights[i];
//            heights[i] = heights[index];
//            heights[index] = temp2;
//
//        }
//        return names;
//    }



    public static String[] sortPeople(String[] names, int[] heights) {


        String[][] arr = new String[names.length][2];

        for (int i=0; i<heights.length; i++){
            arr[i][0] = names[i];
            arr[i][1] = String.valueOf(heights[i]);
        }


        Arrays.sort(arr, (a, b) -> Integer.compare(Integer.parseInt(b[1]), Integer.parseInt(a[1])));

        String[] pNames = new String[heights.length];

        for (int i=0; i<heights.length; i++){
            pNames[i] = arr[i][0];
        }
        return pNames;

    }
}
