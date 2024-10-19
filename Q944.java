public class Q944 {
    public static int minDeletionSize(String[] strs) {

        int count = 0;
        for (String str: strs){
            for (int i=0; i<str.length()-1; i++){
                if (str.charAt(i) > str.charAt(i+1)){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
