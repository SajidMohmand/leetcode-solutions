public class Q2429 {
    public int minimizeXor(int num1, int num2) {
        int setBitsNum2 = Integer.bitCount(num2);
        int setBitsNum1 = Integer.bitCount(num1);

        int x = num1;

        if (setBitsNum1 > setBitsNum2) {
            for (int i = 0; i < 32 && setBitsNum1 > setBitsNum2; i++) {
                if ((x & (1 << i)) != 0) { // Check if bit `i` is set
                    x &= ~(1 << i); // Turn off bit `i`
                    setBitsNum1--;
                }
            }
        } else if (setBitsNum1 < setBitsNum2) {
            for (int i = 0; i < 32 && setBitsNum1 < setBitsNum2; i++) {
                if ((x & (1 << i)) == 0) { // Check if bit `i` is unset
                    x |= (1 << i); // Turn on bit `i`
                    setBitsNum1++;
                }
            }
        }

        return x;
    }

    public static void main(String[] args) {

    }
}
