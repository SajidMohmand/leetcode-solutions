import java.util.Arrays;

public class ZigZagConversion {
    static void printZigZagConcat(String str, int n) {

        // Corner Case (Only one row)
        if (n == 1)
        {
            System.out.print(str);
            return;
        }
        char[] str1 = str.toCharArray();

        // Find length of string
        int len = str.length();

        // Create an array of
        // strings for all n rows
        String[] arr = new String[n];
        Arrays.fill(arr, "");

        // Initialize index for
        // array of strings arr[]
        int row = 0;
        boolean down = true; // True if we are moving
        // down in rows, else false

        // Traverse through
        // given string
        for (int i = 0; i < len; ++i)
        {
            // append current character
            // to current row
            arr[row] += (str1[i]);

            // If last row is reached,
            // change direction to 'up'
            if (row == n - 1)
            {
                down = false;
            }

            // If 1st row is reached,
            // change direction to 'down'
            else if (row == 0)
            {
                down = true;
            }

            // If direction is down,
            // increment, else decrement
            if (down)
            {
                row++;
            }
            else
            {
                row--;
            }
        }

        // Print concatenation
        // of all rows
        for (int i = 0; i < n; ++i)
        {
            System.out.print(arr[i]);
        }
    }

    public static void main(String[] args) {
        printZigZagConcat("PAHNAPLSIIGYIR", 3);
    }
}
