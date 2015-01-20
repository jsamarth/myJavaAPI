package myUtil;

public class Stack<T> {
	
	private LinkedList<T> list;
	
	// Push method
	public void push(T element) {
		list.add(element);
	}
	
	// Pop method
	public T pop() {
		return list.remove();
	}
	
	// Size method
	public int size() {
		return list.size();
	}


}
