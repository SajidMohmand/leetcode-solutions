public class Q1861 {
    public static char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        for (int i = 0; i < m; i++) {
            int emptyPos = n - 1;
            for (int j = n - 1; j >= 0; j--) {
                if (box[i][j] == '*') {
                    emptyPos = j - 1;
                } else if (box[i][j] == '#') {
                    box[i][j] = '.';
                    box[i][emptyPos] = '#';
                    emptyPos--;
                }
            }
        }
        char[][] rotatedBox = new char[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rotatedBox[j][m - 1 - i] = box[i][j];
            }
        }
        return rotatedBox;
    }
    static void display(char[][] arr){
        for (int i=0; i<arr.length; i++){
            for (int j=0; j<arr[i].length; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[][] box = {{'#','.','#'}};

        char[][] res = rotateTheBox(box);
        display(res);

    }
}
