import java.util.ArrayList;
import java.util.List;

class NumberContainers {

    List<String> list;
    public NumberContainers() {
        list = new ArrayList<>();
    }

    public void change(int index, int number) {

        if (list.size() < index) return;
        list.add(index,String.valueOf(number));
    }

    public int find(int number) {
        if (list.contains(String.valueOf(number))){
            return list.indexOf(String.valueOf(number));
        }
        return -1;
    }
}


public class Q2349 {


    public static void main(String[] args) {

    }
}
