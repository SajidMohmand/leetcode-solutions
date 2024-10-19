class  NodeList{
    int data;
    NodeList next;
    NodeList(int data){
        this.data = data;
    }
}
class  LL2{

    NodeList head;

    public void addFirst(int data){
        NodeList currNode = new NodeList(data);
        if (head == null){
            head = currNode;
        }else{
            currNode.next = head;
            head = currNode;
        }
    }
    public void addLast(int data){
        NodeList currNode = new NodeList(data);
        if (head == null){
            head = currNode;
        }else{
            NodeList temp = head;
            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = currNode;
        }
    }

    public int deleteFromFirst(){
        if (head == null){
            return -1;
        }
        int data = head.data;
        head =  head.next;
        return data;
    }

    public void print(){
        if (head == null){
            System.out.println("!No data Found");
            return;
        }
        NodeList temp = head;
        while (temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }




}

public class Q83 {
    public static NodeList deleteDuplicates(NodeList head) {
        if (head == null) {
            return null;
        }

        NodeList temp = head;

        // Loop through the list
        while (temp != null && temp.next != null) {
            // Check if the current node's data is the same as the next node's data
            if (temp.data == temp.next.data) {
                // Skip the next node as it's a duplicate
                temp.next = temp.next.next;
            } else {
                // Move to the next node
                temp = temp.next;
            }
        }

        return head;
    }


    public static void main(String[] args) {
        LL2 list1 = new LL2();
        list1.addLast(1);
        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(3);
        list1.addLast(3);
        list1.addLast(4);
        list1.print();

        LL2 list2 = new LL2();
        list2.head = deleteDuplicates(list1.head);
        list2.print();

    }
}
