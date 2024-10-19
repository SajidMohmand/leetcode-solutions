import  java.util.*;
public class Q1002 {
    public static List<String> commonChars(String[] words) {
        List<String> list = new ArrayList<>();

        for (int i=0; i<words[0].length(); i++){
            for (int j=1; j<words.length; j++){
                boolean flag=false;
                String str = "";
                for (int k=0; k<words[j].length(); k++){
                    if (words[0].charAt(i) == words[j].charAt(k)){
                        flag = true;
                        str = String.valueOf(words[0].charAt(k));
                        break;
                    }
                }
                if (!flag){
                    break;
                }else {
                    list.add(str);
                }
            }
        }
        return list;
    }
}
