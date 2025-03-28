
public class Queue<A> {
	
	//data MUST ONLY use Stack(s)
	private Stack<A> stackA;
	private Stack<A> stackB;
	
	
	
	public Queue() {
		stackA = new Stack<A>();
		stackB = new Stack<A>();
	}
	
	
	//add to queue
	public void enqueue(A el) {
		stackA.push(el);
	}
	
	
	//remove from queue
	//return null if empty
	public A dequeue() {
		if (stackA.empty()) {
			return null;
		} else {
			int x = stackA.size();
			//transfer all stack A to stack B in reverse order
			for (int i = 0; i < x; i++) {
				stackB.push(stackA.pop());
			}
			//store & remove top element from stack B
			A temp = stackB.pop();
			//transfer everything back from stack B to stack A
			for (int i = 0; i < x-1; i++) {
				stackA.push(stackB.pop());
			}
			return temp;
		}
	}
	
	
	public A peek() {
		if (stackA.empty()) {
			return null;
		} else {
			int x = stackA.size();
			//transfer all stack A to stack B in reverse order
			for (int i = 0; i < x; i++) {
				stackB.push(stackA.pop());
			}
			//store top element from stack B
			A temp = stackB.peek();
			//transfer everything back from stack B to stack A
			for (int i = 0; i < x; i++) {
				stackA.push(stackB.pop());
			}
			return temp;
		}
	}
	
	
	public int size() {
		return stackA.size();
	}
	
	
	public String toString() {
		if (stackA.size() == 0) {
			return "[]";
		}
		String res = "[";
		int x = stackA.size();
		System.out.println(stackA.toString());
		//transfer all stack A to stack B in reverse order
		for (int i = 0; i < x; i++) {
			stackB.push(stackA.pop());
		}
		//add element to String res until there is only one element left
		while (stackB.size() > 1) {
			res += stackB.peek() + ", ";
			stackA.push(stackB.pop());
		}
		//do same for last element & close string
		res+= stackB.peek() + "]";
		stackA.push(stackB.pop());
		
		return res;
	}
	
	
	public boolean empty() {
		if (stackA.size() > 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	

}
