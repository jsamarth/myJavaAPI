package myUtil;

public class Array {
	public static int[] InsertionSort(int[] a) {
		
		int[] array = Array.copy(a);
		int size = array.length;
		for (int i = 1; i < size; i++) {
			int element = array[i];
			int j = i - 1;
			
			while(j >= 0 && array[j] > element) {
				array[j+1] = array[j];
				j--;
				
			}
			
			array[j+1] = element;
		}
		
		return array;
	}
	
	public static boolean linearSearch(int[] array, int value) {
		
		for (int a: array)
			if (a == value)
				return true;
		
		return false;
	}
	
	public static boolean binarySearch(int[] array, int value) {
		
		int l = 0, u = array.length - 1, m;
		
		while(l <= u) {
			m = (l + u) / 2;
			
			if (array[m] == value)
				return true;
			else if (value < array[m])
				u = m - 1;
			else
				l = m + 1;
		}
		
		return false;
	}
	
	public static String toString(int[] array) {
		StringBuffer s = new StringBuffer("[ ");
		for (int a: array)
			s.append(a + " ");
		s.append("]");
		
		return s.toString();
	}
	
	public static int[] copy(int[] array) {
		int[] newlist = new int[array.length];
		
		for (int i = 0; i < array.length; i++)
			newlist[i] = array[i];
		
		return newlist;
		
	}
	
	public static void main(String[]args) {
		int[] array = {1,8,10,4,3};
		System.out.println(Array.binarySearch(Array.InsertionSort(array), 4));
	}
}

