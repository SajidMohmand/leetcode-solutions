import java.util.*;
public class Q231 {

    public static boolean isPowerOfTwo(int n) {

        if (n <= 0) return false;
        return (n & (n-1)) == 0;
    }


    public static void main(String[] args) {


        System.out.println(isPowerOfTwo(3));
    }
}
