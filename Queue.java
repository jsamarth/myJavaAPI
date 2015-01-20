package myUtil;

public class Queue<T> {
	
	private LinkedList<T> list;
	
	// Push method
	public void enqueue(T element) {
		list.add(element);
	}
	
	// Pop method
	public T dequeue() {
		return list.remove(0);
	}
	
	// Size method
	public int size() {
		return list.size();
	}


}
