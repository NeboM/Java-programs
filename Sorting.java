package Algorithms;

public class Sorting {
	
	private final int MAX_ARRAY_SIZE = 50;
	private int [] array = new int[MAX_ARRAY_SIZE];
	private int arraySize = 10;
	
	public void generateRandomValues() {
		for(int i = 0; i < arraySize; i++) {
			array[i] = (int)(Math.random()*10+1);
		}
	}
	public void printArray() {
		System.out.println("Index - Value");
		for(int i = 0; i < arraySize; i++) {
			System.out.println("  " + i + "   -   " + array[i]);
		}
	}
	public void swap(int indexOne, int indexTwo) {
		int temp = array[indexOne];
		array[indexOne] = array[indexTwo];
		array[indexTwo] = temp;
	}
	
	public void bubbleSort() {
		for(int i = arraySize - 1; i > 0; i--) {
			for(int j = 0; j < i; j++) {
				if(array[j] > array[j+1]){
					swap(j,j+1);
				}
			}
		}
	}
	public void selectionSort() {
		for(int i = 0; i < arraySize; i++) {
			int minimum = i;
			for(int j = i; j < arraySize; j++) {
				if(array[minimum] > array[j]) {
					minimum = j;
				}
			}
			swap(i,minimum);
		}
	}
	public void insertionSort() {
		for(int i = 1; i < arraySize; i++) {
			int j = i;
			int toInsert = array[i];
			while((j > 0) && (array[j-1] > toInsert)) {
				array[j] = array[j-1];
				j--;
			}
			array[j] = toInsert;
		}
	}
	public static void main(String [] args) {
		Sorting ob1 = new Sorting();
		ob1.generateRandomValues();
		ob1.printArray();
//		ob1.bubbleSort();
//		ob1.selectionSort();
		ob1.insertionSort();
		ob1.printArray();
	}
}