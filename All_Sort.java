public class All_Sort {

    public static void display(int[] arr){
        for (int i: arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static void bubbleSort(int[] arr){

        for (int i=0; i<arr.length-1; i++){
            for (int j=0; j<arr.length-i-1; j++){
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        display(arr);
    }

    public static void selectionSort(int[] arr){

        for (int i=0; i<arr.length; i++){
            int smallest = i;
            for (int j=i+1; j<arr.length; j++){
                if (arr[smallest] > arr[j]){
                    smallest = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
        }
        display(arr);
    }

    public static void insertionSort(int[] arr){

        for (int i=1; i<arr.length; i++){
            int curr = arr[i];
            int j = i-1;
            while (j >= 0 && arr[j] > curr){
                arr[j+1] = arr[j];
                j--;
            }

            arr[j+1] = curr;
        }
        display(arr);
    }




    public static void main(String[] args) {
        int[] arr = {4,2,5,3,1};
//        bubbleSort(arr);
//        selectionSort(arr);
        insertionSort(arr);

    }
}

