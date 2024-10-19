
class  Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
    }
}
class  LL{

    Node head;

    public void addFirst(int data){
        Node currNode = new Node(data);
        if (head == null){
            head = currNode;
        }else{
            currNode.next = head;
            head = currNode;
        }
    }
    public void addLast(int data){
        Node currNode = new Node(data);
        if (head == null){
            head = currNode;
        }else{
            Node temp = head;
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
    // Delete a node with the given value
    public void delete(int value) {
        // Case 1: List is empty
        if (head == null) {
            System.out.println("List is empty. No node to delete.");
            return;
        }

        // Case 2: Delete the head node
        if (head.data == value) {
            head = head.next;
            return;
        }

        // Case 3: Delete a node from the middle or end
        Node temp = head;
        while (temp.next != null && temp.next.data != value) {
            temp = temp.next;
        }

        // If the node to delete is found
        if (temp.next != null) {
            temp.next = temp.next.next;
        } else {
            System.out.println("Node with value " + value + " not found.");
        }
    }
    void reverse(){
        Node prev = null;
        Node curr = head;
        Node next = null;
        while (curr != null){
            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }
        head.next = null;
        head = prev;
    }

    public void print(){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

//    61. Rotate List
public Node rotateRight(Node head, int k) {
    if (head == null || head.next == null || k <= 0) {
        return head;
    }

    // Step 1: Find the length of the list
    Node temp = head;
    int length = 1;  // Start from 1 because we are at the head
    while (temp.next != null) {
        temp = temp.next;
        length++;
    }

    // Step 2: Connect the last node to the head to form a circular list
    temp.next = head;

    // Step 3: Normalize k (in case k is greater than the length of the list)
    k = k % length;
    System.out.println(k);

    // Step 4: Find the new tail (length - k steps from the beginning)
    int stepsToNewHead = length - k;
    Node newTail = head;
    for (int i = 1; i < stepsToNewHead; i++) {
        newTail = newTail.next;
    }

    // Step 5: The new head is the node after the new tail
    Node newHead = newTail.next;
    newTail.next = null;  // Break the circular link

    return newHead;
}




}

public class LinkList_Design {

    // Question-876
    public static Node middleNode(Node head) {
        if (head == null) return null;

        Node temp = head;
        int size = 0;
        while (temp!= null){
            temp  = temp.next;
            size++;
        }
        Node result = head;
        int i = size/2;
        if (i%2 == 1){
            while (i >=1){
                result = result.next;
                i--;

            }
        }else{
            while (i >=0){
                result = result.next;
                i--;

            }
        }

        return result;
    }
    // Question-82
    public static Node deleteDuplicates(Node head) {

        Node temp = head;
        Node prev = null;

        while (temp.next != null){
            if (temp.data == temp.next.data){
                temp.next = temp.next.next;
                continue;
            }
            temp = temp.next;
        }
        return temp;
    }
    public static void main(String[] args) {
        LL list = new LL();
        list.addLast(1);
        list.addLast(1);
        list.addLast(1);
        list.addLast(3);
        list.addLast(6);

//        System.out.println(list.deleteFromFirst());

        list.print();
        LL list2 = new LL();
        list2.head = deleteDuplicates(list.head);
        list2.print();

//        System.out.println(middleNode(list.head).data);

//        list.reverse();
//        list.head = list.rotateRight(list.head, 11);
//        list.print();

//        list.delete(3);
//        list.print();



    }
}
