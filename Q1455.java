public class Q1455 {
    public static int isPrefixOfWord(String sentence, String searchWord) {

        String[] arr = sentence.split(" ");

        int count = 1;
        for (String s : arr){
            if (s.startsWith(searchWord)){
                return count;
            }
            count++;
        }
        return -1;
    }

    public static void main(String[] args) {
//        Input: sentence = "i love doing coding", searchWord = "cod"
//        Output: 4
        System.out.println(isPrefixOfWord("i love eating burger", "burg"));
    }
}
