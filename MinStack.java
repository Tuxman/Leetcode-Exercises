public class MinStack {

    private Node root;
        
    private class Node {        //implement singly linked list as it is constant time O(n) for computations
            private int value;
            private Node next;
    }

    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
        Node current = root;
        root = new Node();
        root.value = x;
        root.next = current;
    }
    
    public void pop() {
        if(root == null) {
            new java.util.NoSuchElementException();
        }
        root = root.next;
    }
    
    public int top() {
        return root.value;
    }
    
    public int getMin() {
        Node current = root;
        int min = root.value;
        while(current != null) {
            if(min > current.value) {
                min = current.value;
            }
            current = current.next;
        }
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */