public class StackArray{
  int max_size;
  int[] array;
  int size;

  public StackArray(int size){
    max_size = size;
    array = new int[max_size];
  }

  public boolean isEmpty(){
      return size == 0;
  }

  public boolean isFull(){
      return size == max_size;
  }

  public void push(int value){
    if(isFull()){
      System.out.println("Stack is full, please remove some items");
      return;
    }
      array[size] = value;
      size++;
  }

  public int pop(){
    if(isEmpty()){
      System.out.println("Stack is Empty, please add some items");
      return -1;
    }
    size--;
    int value = array[size];
    return value;
  }

  public int peek(){
    if(isEmpty()){
      System.out.println("Stack is Empty, please add some items");
      return -1;
    }
    return array[size];
  }

}
