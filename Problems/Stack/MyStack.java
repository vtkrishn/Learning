public class MyStack{

int size;
int[] array;

public MyStack(int maxSize){
array = new int[maxSize];
size = 0;
}

public synchronized void push(int element) throws Exception{
    if(size > array.length-1)
        throw new Exception("Overflow");
    else
        array[size] = element;
    size++;
}

public synchronized int pop() throws Exception{
    int value = 0;
    if(size == 0)
        throw new Exception("Underflow");
    else
      value = array[--size];
    return value;
}


public static void main(String[] args)  throws Exception{
    MyStack stack = new MyStack(5);
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.push(5);
     stack.pop();
      stack.pop();
       stack.pop();
        stack.pop();
         stack.pop();
          stack.pop();
}
}
