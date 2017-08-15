public class MyStack {
    LinkedList<Integer> queue1;
    LinkedList<Integer> queue2;
    int size = 0;
    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<Integer>();
        queue2 = new LinkedList<Integer>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if(queue1.isEmpty())
            queue2.addFirst(x);
        else
            queue1.addFirst(x);
        size++;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int result = 0;
        if(queue1.isEmpty()){
            while(!queue2.isEmpty()){
                int val = queue2.removeLast();
                queue1.addFirst(val);
            }
            result = queue1.removeFirst();
        }
        else{
            while(!queue1.isEmpty()){
                int val = queue1.removeLast();
                queue2.addFirst(val);
            }
            result = queue2.removeFirst();
        }
        size--;
        return result;
    }

    /** Get the top element. */
    public int top() {
        int result = 0;
        if(size != 0){
            if(queue1.isEmpty())
                result = queue2.peek();
            else
               result = queue1.peek();
        }
        return result;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return size == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
