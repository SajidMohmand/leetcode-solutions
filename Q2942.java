import java.util.*;
public class Q2942 {
    public static List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> list = new Stack<>();
        for (int i=0; i<words.length; i++){
            for (int j=0; j<words[i].length(); j++){
                if (words[i].charAt(j) == x){
                    list.add(i);
                    break;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        String[] words = {"leet","code"};
        char x = 'e';
        System.out.println(findWordsContaining(words,x));
    }
}
