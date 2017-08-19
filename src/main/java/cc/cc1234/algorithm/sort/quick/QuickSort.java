package cc.cc1234.algorithm.sort.quick;


import cc.cc1234.algorithm.sort.BaseSort;

/**
 * 快速排序
 * @author vran
 */
public class QuickSort<E extends Comparable<? super E>> extends BaseSort<E>{

	@Override
	public void sort(E[] data) {
		doSort(data, 0, data.length-1);
	}

	/**
	 * 
	 * [left,right] -->
	 * E p
	 * [left,pos] < p
	 * (pos,right] >= p
	 * 
	 */
	private void doSort(E[] data, int left, int right) {
		if(left<right) {
			int x = partition(data, left, right);
			doSort(data, left, x-1);
			doSort(data, x+1, right);
		}

	}

	/**
	 * default status: 
	 * [left+1, lt] <= p 
	 * [lt+1,pos) > p
	 */
	private int partition(E[] data, int left, int right) {
		int pn = (left+right)/2;
		E p = data[pn];
		swap(data, left, pn);

		int pos = left+1;
		int lt = left;
		while(pos <= right) {
			if(data[pos].compareTo(p) == -1 ) {
				swap(data, ++lt, pos);
			}
			pos++;
		}

		swap(data, lt, left);
		return lt;
	}

}
