public class YourClassNameHere {
	    public static void main(String[] args)  throws Exception{
	Stack s = new Stack();
	s.push(1);
	s.push(2);
	s.push(3);
	s.push(4);
	System.out.println(s.pop());
	System.out.println(s.pop());
	System.out.println(s.top());
	s.push(33);
	s.push(44);
	System.out.println(s.top());
	System.out.println(s.pop());
	System.out.println(s.top());
	    }


	 static class Stack{
  int[] arr;
  int size;
  int MAX=5;

  public Stack(){
      arr = new int[MAX];
      size = 0;
  }

  public void push(int value) throws Exception{
    if(size == MAX)
      throw new Exception("Stack overflow");
    else
      arr[size++] = value;
  }

  public int pop()  throws Exception{
    if(isEmpty())
      throw new Exception("Stack is empty");
    else{
      return arr[--size];
    }
  }

  public int top()  throws Exception{
    if(isEmpty())
      throw new Exception("Stack is empty");
    else{
      return arr[size-1];
    }
  }

  public boolean isEmpty(){
    return size == 0;
  }

}
	}
