public class Q2490 {
    public static boolean isCircularSentence(String sentence) {

        String[] arr = sentence.split(" ");

//        "eetcode" case cover
        if (arr.length ==1){
            if (arr[0].charAt(0) != arr[0].charAt(arr[0].length()-1)){
                return false;
            }
        }
//        The last character of the last word is equal to the first character of the first word.
//        case cover
        if (arr[0].charAt(0) != arr[arr.length-1].charAt(arr[arr.length-1].length()-1)){
            return false;
        }

        String prev = arr[0];
        String next = "";
        for (int i=1; i<arr.length; i++){
            next = arr[i];
            if (prev.charAt(prev.length()-1) != next.charAt(0)){
                return false;
            }
            prev = next;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isCircularSentence("Leetcode is cool"));
    }
}
