public class ModifiedStack<E extends Comparable>{
  E[] array;
  int size;
  Stack<E> internalStack;

  public static void main(String[] args) throws Exception {
   ModifiedStack<Integer> mod = new ModifiedStack<Integer>(5);
   mod.push(-1);
   mod.push(4);
   mod.push(3);
   mod.push(2);
   mod.push(1);
   mod.pop();
   mod.pop();
   System.out.println(mod.getMin());
  }

  public ModifiedStack(int maxSize){
      array = (E[])Array.newInstance(Comparable.class, maxSize);
      size = 0;
      internalStack = new Stack<E>();
  }

  public void push(E item) throws Exception{
      if(isFull())
        throw new Exception("Stack is full ,cannot push");
      else{
        array[size++] = item;
        if(internalStack.isEmpty() || item.compareTo(internalStack.peek()) < 0)
            internalStack.push(item);
      }
  }

  public E peek() throws Exception{
    if(isEmpty())
        throw new Exception("Stack is empty ,cannot peek");
    else{
        return array[size];
    }
  }

  public E pop() throws Exception{
      if(isEmpty())
          throw new Exception("Stack is empty ,cannot pop");
      else{
          E value = array[--size];
          if(value.compareTo(internalStack.peek()) == 0)
              internalStack.pop();
          return value;
      }
  }

  public E getMin() throws Exception{
      if(isEmpty())
          throw new Exception("Stack is empty ,cannot pop");
      else
        return internalStack.peek();
  }

  public boolean isEmpty(){
    return size == 0;
  }

  public boolean isFull(){
    return size == array.length;
  }
}
