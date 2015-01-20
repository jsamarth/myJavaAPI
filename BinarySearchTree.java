package myUtil;

public class BinarySearchTree {
	private int value;
	BinarySearchTree left;
	BinarySearchTree right;
	
	BinarySearchTree(int root) {
		this.value = root;
		left = null;
		right = null;
	}
	
	public void add(int element) {
		if (element < this.value) {
			if (this.left == null) 
				this.left = new BinarySearchTree(element);
			
			else 
				this.left.add(element);
		}
		
		else if (element > this.value) {
			if (this.right == null) 
				this.right = new BinarySearchTree(element);
			
			else 
				this.right.add(element);
		}
	}

	public boolean search(int element) {
		if (this == null) {
			return false;
		}
		if (element == this.value)
			return true;
		else if (element < this.value) {
			return this.left.search(element);
		}
		else {
			return this.right.search(element);
		}
	}

	public static void main (String[]args) {
		BinarySearchTree tree = new BinarySearchTree(5);
		tree.add(3);
		tree.add(6);
		tree.add(2);
		tree.add(4);
		System.out.println(tree.search(10));
	}
}
