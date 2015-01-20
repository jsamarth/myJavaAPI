package myUtil;

public class LinkedListObject {
	
	private Object value;
	private LinkedListObject next;
	private int size;
	
	LinkedListObject() {
		this.size = 0;
		this.next = null;
	}
	
	LinkedListObject(Object[] array) {
		
		this.size = 0;
		
		int size = array.length;
		for (int i = 0; i < size; i++)
			this.add(array[i]);

	}
	
	LinkedListObject(LinkedListObject l) {
		
		this.size = 0;
		
		int size = l.size();
		for (int i = 0; i < size; i++)
			this.add(l.get(i));
		
	}
	
	// sets the 'element' at a certain 'index'
	public void set(int index, Object element) throws IndexOutOfBoundsException{
		if (index >= this.size() || index < 0)
			throw new IndexOutOfBoundsException("Index is out of bounds");
		
		else {
			
			LinkedListObject crawley = this;
			
			for (int i = 0; i < index; i++) {
				crawley = crawley.next;
			}
			
			crawley.next.value = element;
		}
		
	}

	// adds an element at the last index
	public void add(Object element) {
		LinkedListObject newNode = new LinkedListObject();
		newNode.value = element;
		newNode.next = null;
		
		LinkedListObject crawley = this;
		
		while (crawley.next != null) {
			crawley = crawley.next;
		}
		
		crawley.next = newNode;
		
		this.size++;
		
	}
	
	// adds an element at the 'index' index
	public void add(int index, Object element) throws IndexOutOfBoundsException{
		
		if (index > this.size || index < 0) 
			throw new IndexOutOfBoundsException("Index is out of bounds");
		
		else {
			LinkedListObject newNode = new LinkedListObject();
			newNode.value = element;
			
			LinkedListObject crawley = this;
			
			for (int i = 0; i < index; i++) {
				crawley = crawley.next;
			}
			
			newNode.next = crawley.next;
			crawley.next = newNode;
			this.size++;
		}
		
	}
	
	// adds another list to the current list
	public void addList(LinkedListObject l) {
		
		int size = l.size();
		for (int i = 0; i < size; i++)
			this.add(l.get(i));
		
	}
	
	// adds another list to the current list
	public void addList(Object[] l) {
		
		for (int i = 0; i < l.length; i++)
			this.add(l[i]);
		
	}
	
	// removes the last element
	public Object remove() {
		
		LinkedListObject crawley = this;
		
		while(crawley.next.next != null) {
			crawley = crawley.next;
		}
		
		LinkedListObject rnode = crawley.next;
		crawley.next = null;
		
		this.size--;
		return rnode.value;
		
	}
	
	// removes the element at the 'index' index
	public Object remove(int index) throws IndexOutOfBoundsException{
		
		if (index >= this.size  || index < 0) 
			throw new IndexOutOfBoundsException("Index is out of bounds");
		
		else {
			
			LinkedListObject crawley = this;
			
			for (int i = 0; i < index; i++) {
				crawley = crawley.next;
			}
			
			LinkedListObject rnode = crawley.next;
			crawley.next = crawley.next.next;
			
			this.size--;
			return rnode.value;
		}
		
	}
	
	// removes the element of type T
	public void removeElement(Object element) throws IndexOutOfBoundsException{
		
		if (!this.isPresent(element)) 
			throw new IndexOutOfBoundsException("Element not found");
		
		else {
			
			LinkedListObject crawley = this;
			
			while(crawley.next.value != element) {
				crawley = crawley.next;
			}
			
			crawley.next = crawley.next.next;
			
			this.size--;
		}
		
	}

	// gets the element at the 'index' index 
	public Object get(int index) throws IndexOutOfBoundsException{
		if (index >= this.size || index < 0) 
			throw new IndexOutOfBoundsException("Index is out of bounds");
		
		else {
			
			LinkedListObject crawley = this;
			
			for (int i = 0; i <= index; i++) {
				crawley = crawley.next;
			}
			
			return crawley.value;
		}
		
	}
	
	// checks if an element is present
	public boolean isPresent(Object element) {
		LinkedListObject crawley = this;
		
		boolean isPresent = false;
		while (crawley != null) {
			if (crawley.value == element) {
				isPresent = true;
				break;
			}
			crawley = crawley.next;
		}
		
		return isPresent;
	}

	// used to print the entire list
	public String toString() {
		StringBuffer s = new StringBuffer();
		s.append("[ ");
		LinkedListObject crawley = this.next;
		while (crawley != null) {
			s.append(crawley.value + " ");
			crawley = crawley.next;
		}
		s.append("]");
		return s.toString();
	}
	
	// returns a part of the original list, from indices start, to end, with start as inclusive, but end exclusive
	public LinkedListObject slice(int start, int end) throws IndexOutOfBoundsException{
		if (start < 0 || start >= end || start > this.size || end < 0 || end > this.size) 
			throw new IndexOutOfBoundsException("Index is out of bounds");
		
		else {
			LinkedListObject newList = new LinkedListObject();
			for (int i = start; i < end; i++)
				newList.add(this.get(i));
			newList.size = end - start;
			return newList;
		}
	}
	
	// returns the original list extended by 'times' times
	public void multiplyList(int times) {
		LinkedListObject copy = this.slice(0, this.size);
		
		for (int i = 1; i < times; i++) {
			this.addList(copy);
		}
	}
	
	// returns the size of the list
	public int size() {
		return this.size;
	}
	
	
}
