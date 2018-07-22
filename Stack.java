package Algorithms;

public class Stack{
	
	private int stackSize;
	private String stackArray[];
	private int topOfStack = -1;
	
	public Stack(int size) {
		this.stackSize = size;
		this.stackArray = new String[stackSize];
	}
	
	public int getStackSize() {
		return stackSize;
	}
	
	public void push(String value) {
		if(topOfStack < stackSize - 1) {
			topOfStack++;
			stackArray[topOfStack] = value; 
			System.out.println(value + " was successfully added to the stack.");
		}else {
			System.out.println("Stack overflow: cannot push new items to the stack.");
		}
	}
	
	public String pop() {
		if(topOfStack >= 0) {
			System.out.println(stackArray[topOfStack] + " was removed from the stack.");
			return stackArray[topOfStack--];
		}else {
			System.out.println("Stack underflow: no item found.");
			return "";
		}
	}
	
	public void displayStack() {
		System.out.println("----------------");
		for(int i = 0; i < stackSize; i++) {
			System.out.print("  " + i + "   -  ");
			
			if(i <= topOfStack) {
				System.out.println(stackArray[i]);
			}else {
				System.out.println("noVALUE");
			}
		}
		System.out.println("----------------");
	}
		
		
	public static void main(String [] args) {
		Stack ob1 = new Stack(10);
		ob1.displayStack();
		for(int i = 0; i < ob1.getStackSize(); i++) {
			ob1.push(Integer.toString(i+10));
		}
		System.out.println();
		ob1.displayStack();
		ob1.pop();
		ob1.pop();
		ob1.displayStack();
	
		// stack overflow will occur after second execution
		for(int i = 0; i < 3; i++) {
			ob1.push(Integer.toString(i+10));
		}
		ob1.displayStack();
		
		// the last execution will try to remove item from the stack
		// but will not succeed since there are no items in the stack
		// and "No values in the stack for poping"
		for(int i = 0; i < 11; i++) ob1.pop();
		ob1.displayStack();
	}
}
