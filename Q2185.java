public class Q2185 {

    public static int prefixCount(String[] words, String pref) {

        int count = 0;
        for (int i=0; i<words.length; i++){

            if (words[i].length() < pref.length()) continue;
            String s = words[i].substring(0,pref.length());

            if (s.equals(pref)){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

//        Input: words = ["pay","attention","practice","attend"], pref = "at"
//        Output: 2

        System.out.println(prefixCount(new String[]{"pay","attention","practice","attend"}, "at"));

    }
}
