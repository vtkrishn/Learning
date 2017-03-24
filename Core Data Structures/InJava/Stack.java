public class MyStack{
  List<Integer> array;
  public MyStack(){
     this.array = new ArrayList<Integer>();
  }

  public boolean isEmpty(){
    return this.array.size() == 0;
  }

  public

  public static void main(String[] args){
    MyStack stack = new MyStack();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.peek();
    stack.push(1);
    stack.peek();

    stack.pop();
    stack.peek();
    stack.pop();
    stack.peek();
    
  }

}
