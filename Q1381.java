public class Q1381 {
    int[] stack;
    int size;
    int maxSize;

    // Constructor to initialize the stack with a fixed max size
    public Q1381(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];  // Stack implemented using array
        size = 0;  // Initially, the stack is empty
    }

    // Method to push an element onto the stack
    public void push(int x) {
        // Push only if the stack is not full
        if (size < maxSize) {
            stack[size] = x;
            size++;
        }
    }

    // Method to pop an element from the stack
    public int pop() {
        // Pop only if the stack is not empty
        if (size == 0) {
            return -1;  // Stack is empty, return -1
        }
        size--;
        return stack[size];  // Return the top element
    }

    // Method to increment the bottom k elements by val
    public void increment(int k, int val) {
        // Increment the bottom k elements or all elements if k > size
        int limit = Math.min(k, size);
        for (int i = 0; i < limit; i++) {
            stack[i] += val;
        }
    }

    public static void main(String[] args) {
        Q1381 customStack = new Q1381(5); // Create a stack with max size 5
        customStack.push(1);  // Stack: [1]
        customStack.push(2);  // Stack: [1, 2]
        System.out.println(customStack.pop());    // Output: 2, Stack: [1]
        customStack.push(2);  // Stack: [1, 2]
        customStack.push(3);  // Stack: [1, 2, 3]
        customStack.push(4);  // Stack: [1, 2, 3, 4]
        customStack.increment(5, 100);  // Increment all elements: Stack: [101, 102, 103, 104]
        customStack.increment(2, 100);  // Increment first 2 elements: Stack: [201, 202, 103, 104]
        System.out.println(customStack.pop());    // Output: 104, Stack: [201, 202, 103]
        System.out.println(customStack.pop());    // Output: 103, Stack: [201, 202]
        System.out.println(customStack.pop());    // Output: 202, Stack: [201]
    }
}
