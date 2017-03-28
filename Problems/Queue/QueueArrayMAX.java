public class YourClassNameHere {
	    public static void main(String[] args) {
	      queue q = new queue();
	      q.enque(1);
	      q.enque(2);
	      q.enque(3);
	      System.out.println(q.peek());
	      System.out.println(q.deque());
	      System.out.println(q.deque());
	      System.out.println(q.deque());
	      System.out.println(q.deque());
	      
	    }
	    
	    
	    static class queue{
	     int head;
	     int tail;
	     final int MAX = 5;
	     int[] arr = new int[MAX];
	     
	     public boolean isEmpty(){
	        return head == tail;
	     }
	     
	     public int getSize(){
	        return tail;
	     }
	     
	     public void enque(int value){
	       if(tail == MAX)
	          System.out.println("Queue is full");
	        else
	          arr[tail++] = value;
	     }
	     
	     public int deque(){
	       if(isEmpty()){
	          System.out.println("Queue is empty");
	         return 0; 
	       }
	       
	        return arr[head++];
	     }
	     
	     public int peek(){
	       if(isEmpty()){
	          System.out.println("Queue is empty");
	          return 0;
	       }
	       
	          return arr[head];
	     }
	      
	    }
	    
	}
