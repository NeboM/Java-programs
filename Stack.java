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
		
		for(int i = 0; i < ob1.getStackSize(); i++){ 
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
		//  "Stack underflow: no item found." message will be displayed.
		for(int i = 0; i < 11; i++) ob1.pop();
		
		ob1.displayStack();
	}
}

/*   	OUTPUT: 

----------------
  0   -  noVALUE
  1   -  noVALUE
  2   -  noVALUE
  3   -  noVALUE
  4   -  noVALUE
  5   -  noVALUE
  6   -  noVALUE
  7   -  noVALUE
  8   -  noVALUE
  9   -  noVALUE
----------------
10 was successfully added to the stack.
11 was successfully added to the stack.
12 was successfully added to the stack.
13 was successfully added to the stack.
14 was successfully added to the stack.
15 was successfully added to the stack.
16 was successfully added to the stack.
17 was successfully added to the stack.
18 was successfully added to the stack.
19 was successfully added to the stack.

----------------
  0   -  10
  1   -  11
  2   -  12
  3   -  13
  4   -  14
  5   -  15
  6   -  16
  7   -  17
  8   -  18
  9   -  19
----------------
19 was removed from the stack.
18 was removed from the stack.
----------------
  0   -  10
  1   -  11
  2   -  12
  3   -  13
  4   -  14
  5   -  15
  6   -  16
  7   -  17
  8   -  noVALUE
  9   -  noVALUE
----------------
10 was successfully added to the stack.
11 was successfully added to the stack.
Stack overflow: cannot push new items to the stack.
----------------
  0   -  10
  1   -  11
  2   -  12
  3   -  13
  4   -  14
  5   -  15
  6   -  16
  7   -  17
  8   -  10
  9   -  11
----------------
11 was removed from the stack.
10 was removed from the stack.
17 was removed from the stack.
16 was removed from the stack.
15 was removed from the stack.
14 was removed from the stack.
13 was removed from the stack.
12 was removed from the stack.
11 was removed from the stack.
10 was removed from the stack.
Stack underflow: no item found.
----------------
  0   -  noVALUE
  1   -  noVALUE
  2   -  noVALUE
  3   -  noVALUE
  4   -  noVALUE
  5   -  noVALUE
  6   -  noVALUE
  7   -  noVALUE
  8   -  noVALUE
  9   -  noVALUE
----------------

*/
