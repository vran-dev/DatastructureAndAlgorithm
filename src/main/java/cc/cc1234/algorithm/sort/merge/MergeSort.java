package cc.cc1234.algorithm.sort.merge;

import cc.cc1234.algorithm.sort.BaseSort;
import cc.cc1234.algorithm.sort.SortTest;

/**
 * 归并排序
 * @author vran
 */
public class MergeSort<E extends Comparable<? super E>> extends BaseSort<E> {

	@Override
	public void sort(E[] data) {
		doSort(data,0,data.length-1);
	}
	
	/**
	 * [left,right] -->[left,(left+right)/2],((left+right)/2,right]
	 */
	private void doSort(E[] data, int left, int right) {
		if(left < right) {
			int m = (left + right)/2;  // left+right 在数值较大的情况可能会溢出
			doSort(data, left, m);
			doSort(data, m+1, right);
			merge(data, left, m, right);
		}
	}
	
	private void merge(E[]data,int left,int m,int right) {
		int len = right-left+1;
		Object[] temp=new Object[len];
		int leftPos = left, leftEnd = m;
		int rightPos = m+1, rightEnd = right;
		int tempPos = 0;
		
		while(leftPos <= leftEnd && rightPos <= rightEnd) {
			if(data[leftPos].compareTo(data[rightPos])<1) {
				temp[tempPos++] = data[leftPos++];
			}else {
				temp[tempPos++] = data[rightPos++];
			}
		}
		
		while(leftPos <= leftEnd) {
			temp[tempPos++] = data[leftPos++];
		}
		
		while(rightPos <= rightEnd) {
			temp[tempPos++] = data[rightPos++];
		}
		
		for(int i = left; i<=right; i++) {
			data[i] = (E) temp[i-left];
		}
	}

}
