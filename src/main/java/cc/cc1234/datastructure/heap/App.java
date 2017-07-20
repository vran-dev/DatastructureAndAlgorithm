package cc.cc1234.datastructure.heap;

public class App {
	public static void main(String[] args) {
		 Integer[] randomData = {5,4,6,7,1,2,8,9,3};
		 MaxHeap<Integer> heap= new MaxHeap<>(randomData);
		 for(int i=0;i<randomData.length;i++) {
			System.out.println( heap.pop());
		 }
	}
}
