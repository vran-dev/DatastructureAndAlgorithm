package cc.cc1234.algorithm.sort;

/**
 *  冒泡排序
 * @author vran1
 *
 * @param <E>
 */
public class BubbleSort<E extends Comparable<? super E>> extends BaseSort<E>{
	
	public BubbleSort(E[] data) {
		super(data);
	}

	@Override
	public void doSort(E[] data) {
		for(int i = data.length-1; i>=0; i--) {
			for(int j = 0; j<i; j++) {
				if(data[j].compareTo(data[j+1])==1) {
					swap(j, j+1);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Integer[] ins= {1,8,7,6,5,4,3,2};
		BubbleSort<Integer> sort = new BubbleSort<>(ins);
		sort.sort();
		System.out.println(sort.toString());
	}
}
