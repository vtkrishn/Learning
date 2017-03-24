package javaproject;

import java.util.ArrayList;
import java.util.List;

public class MyStack{
  List<Integer> array;
  public MyStack(){
     this.array = new ArrayList<Integer>();
  }

  public boolean isEmpty(){
    return this.array.size() == 0;
  }

  public int pop(){
    if(isEmpty())
      System.out.println("Nothing to pop");
    else{
        int size = this.array.size();
        int value = this.array.remove(size-1);
        System.out.println("popped "+ value);
        return value;
    }
    return -1;
  }

  public int peek(){
    if(isEmpty())
      System.out.println("Nothing to peek");
      else{
          int size = this.array.size();
          int value = this.array.get(size-1);
          System.out.println("peeked "+ value);
          return value;
      }
      return -1;
  }

  public void push(int value){
    this.array.add(value);
      System.out.println("pushed "+ value);
  }



  public static void main(String[] args){
    MyStack stack = new MyStack();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.peek();
    stack.push(13);
    stack.peek();

    stack.pop();
    stack.peek();
    stack.pop();
    stack.peek();
      stack.pop();
      stack.pop();
      stack.pop();
      stack.peek();
  }

}
