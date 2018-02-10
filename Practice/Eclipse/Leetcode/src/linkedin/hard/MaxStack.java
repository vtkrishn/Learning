package linkedin.hard;

public class MaxStack{
	myStack myst;
	myStack maxMyst;
	
	public static void main(String[] args) {
		MaxStack stack = new MaxStack(4);
		stack.push(5); 
		stack.push(1);
		stack.push(5);
		stack.top(); //-> 5
		stack.popMax(); //-> 5
		stack.top(); //-> 1
		stack.peekMax(); //-> 5
		stack.pop(); //-> 1
		stack.top(); //-> 5
	}
	
	public MaxStack(int size) {
		myst = new myStack(size);
		maxMyst = new myStack(size);
	}
	
	public void push(int value) {
		myst.push(value);
		if(maxMyst.top() < value) {
			maxMyst.push(value);
		}
		else {
			maxMyst.push(maxMyst.top());
		}
	}
	
	public void pop() {
		myst.pop();
		maxMyst.pop();
	}
	
	public int top() {
		return myst.top();
	}
	public int peekMax() {
		return maxMyst.top();
	}
	
	public int popMax() {
		int max = maxMyst.top();
		myStack buffer = new myStack(4);
		while(myst.top() != max) {
			buffer.push(myst.top());
			myst.pop();
		}
		myst.pop();
		while(buffer.top != 0) {
			myst.push(buffer.top());
			buffer.pop();
		}
		return max;
	}
	
	static class myStack{
		int[] array;
		int top;
		
		public myStack(int size) {
			array = new int[size];
			top = -1;	
		}
		public void push(int value) {
			if(top < array.length-1)
				array[++top] = value;
			else
				System.out.println("exeding max size, ignoring the command");
		}
		
		public void pop() {
			if(top > 0 && top < array.length)
				array[top--] = 0;
			else
				System.out.println("No element to pop, ignoring the command");
		}
		
		public int top() {
			if(top > 0 && top < array.length) {
				System.out.println(array[top]);
				return array[top];
			}
			return -1;
		}	
	}
	
	
	
	
	
}
