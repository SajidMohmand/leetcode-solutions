public class Q2109 {
//"LeetcodeHelpsMeLearn", spaces = [8,13,15]
    public static String addSpaces2(String s, int[] spaces) {

        int count = 0;
        for (int space : spaces){
            space += count;
            s = s.substring(0,space)+" "+s.substring(space);
            count++;
        }
        return s;
    }
    public static String addSpaces(String s, int[] spaces) {
        StringBuilder result = new StringBuilder();
        int index = 0;
        for (int space : spaces) {
            result.append(s, index, space);
            result.append(" "); // Add the space
            index = space; // Update the index to the current space
        }
        result.append(s.substring(index));
        return result.toString();
    }


    public static void main(String[] args) {
//        Input: s = "LeetcodeHelpsMeLearn", spaces = [8,13,15]
//        Output: "Leetcode Helps Me Learn"
        System.out.println(addSpaces("LeetcodeHelpsMeLearn",new int[]{8,13,15}));

    }
}
