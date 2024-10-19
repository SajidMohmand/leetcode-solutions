public class Q125 {

    public static boolean isPalindrome2(String s) {
        if(s.length() == 2 && s.replaceAll("[^a-zA-Z0-9]", "").isEmpty()) return true;
        if (s.length() == 1 || s.charAt(0) == ' '){
            return true;
        }
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        s = s.toLowerCase();
        if (s.isEmpty()){
            return false;
        }
        s = s.replace(" ","");
        for (int i=0,j = s.length()-1;i <s.length(); i++,j--){
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
    }
    public static boolean isPalindrome(String s) {
        int l = 0;
        int h = s.length() - 1;
        s = s.toLowerCase();

        while (l <= h) {
            char getAtl = s.charAt(l);
            char getAth = s.charAt(h);

            if (!Character.isLetterOrDigit(getAtl)) {
                l++;
            } else if (!Character.isLetterOrDigit(getAth)) {
                h--;
            } else if (getAtl == getAth) {
                l++;
                h--;
            } else {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {


        String s = "A man, a plan, a canal: Panama";
        String s2 = " ";
        String s3 = "@#%";
        System.out.println(isPalindrome(s3));
    }
}
