import java.util.ArrayList;

class ProductOfNumbers {

    ArrayList<Integer> arr;
    int index = -1;
    public ProductOfNumbers() {
        arr = new ArrayList<>();
    }

    public void add(int num) {
        arr.add(num);
        index++;
    }

    public int getProduct(int k) {
        int result = 1;
        int temp = index;
        for(int i=0; i<k; i++){
            result *= arr.get(temp);
            temp--;
        }
        return result;
    }
}

public class Q1352 {

}
