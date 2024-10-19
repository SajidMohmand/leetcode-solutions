public class Q1160 {
    public static int countCharacters(String[] words, String chars) {

        StringBuilder s = new StringBuilder();
        for (char i:chars.toCharArray()){
            s.append(i);
        }

        int result = 0;
        for (String word : words){
            boolean flag= true;
            for (char c: word.toCharArray()){
                if (!s.toString().contains(String.valueOf(c))){
                    flag = false;
                    break;
                }
            }
            if (flag){
                result += word.length();
            }
        }
        return result;
    }

    public static void main(String[] args) {

//        words = ["cat","bt","hat","tree"], chars = "atach"

        String[] str = {"hello","world","leetcode"};
        String chars = "welldonehoneyr";
        System.out.println(countCharacters(str,chars));
    }
}
