import java.util.ArrayList;

public class Stack<J> {

	//Data
	private ArrayList<J> data;
	
	//Add a constructor - default constructor
	public Stack(){
	
		//initialize the instance vars!
		data = new ArrayList<J>();
		
	}
	
	
	//use the ArrayList to string to return a String representation of the data
	public String toString() {
		return data.toString();
	}
	
	//add the element to the Stack
	public void push(J el) {
		data.add(el);	//end of the list is the "TOP"
	}
	
	//remove and return the top of the stack
	//return null if empty
	public J pop() {
		if (data.isEmpty()) {
			return null;
		} else { 
			return data.remove(data.size()-1);
		}
	}
	
	//return the size of the stack
	public int size() {
		return data.size();
	}
	
	//return element at top without removing it, else return null if empty
	public J peek() {
		if (data.isEmpty()) {
			return null;
		} else {
			return data.get(data.size()-1);
		}
	}
	
	
	//return true if stack is empty, false otherwise
	public boolean empty() {
		if (data.size() > 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	
	
	
	
	
}
