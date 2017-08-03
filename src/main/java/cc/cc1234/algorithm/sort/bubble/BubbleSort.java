package cc.cc1234.algorithm.sort.bubble;

import cc.cc1234.algorithm.sort.BaseSort;
import cc.cc1234.algorithm.sort.SortTest;

/**
 *  冒泡排序
 * @author vran1
 */
public class BubbleSort<E extends Comparable<? super E>> extends BaseSort<E>{

	@Override
	public void sort(E[] data) {
		for(int i = data.length-1; i>=0; i--) {
			for(int j = 0; j<i; j++) {
				if(data[j].compareTo(data[j+1])==1) {
					swap(data, j ,j+1);
				}
			}
		}
	}
}
