public class Q2337 {


//        Input: start = "_L__R__R_", target = "L______RR"
    public static boolean canChange(String start, String target) {
        String startPieces = start.replace("_", "");
        String targetPieces = target.replace("_", "");
        if (!startPieces.equals(targetPieces)) {
            return false;
        }
        int i = 0, j = 0; // Pointers for start and target
        int n = start.length();
        while (i < n && j < n) {
            while (i < n && start.charAt(i) == '_') {
                i++;
            }
            while (j < n && target.charAt(j) == '_') {
                j++;
            }
            if (i == n && j == n) {
                return true;
            }
            if (i == n || j == n) {
                return false;
            }
            if (start.charAt(i) != target.charAt(j)) {
                return false;
            }
            if (start.charAt(i) == 'L' && j > i) {
                return false;
            }
            if (start.charAt(i) == 'R' && j < i) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }

    public static void main(String[] args) {

//        Input: start = "_L__R__R_", target = "L______RR"
//        Output: true

        System.out.println(canChange("_L__R__R_","L______RR"));
    }
}
