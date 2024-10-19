public class ApnaCollegeFunctionExercise {

    public static void Fibonacci(int n){

        System.out.print("0 1 ");
        int prev = 0;
        int curr = 1;
        for (int i=0; i<n; i++){
            int sum = prev + curr;
            System.out.print(sum+" ");
            prev = curr;
            curr = sum;
        }
    }

    public static void main(String[] args) {
        Fibonacci(7);
    }
}
