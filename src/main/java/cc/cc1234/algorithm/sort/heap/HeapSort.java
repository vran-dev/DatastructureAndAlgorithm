package cc.cc1234.algorithm.sort.heap;

import cc.cc1234.algorithm.sort.BaseSort;
import cc.cc1234.algorithm.sort.SortTest;
import cc.cc1234.datastructure.heap.MaxHeap;


/**
 * 堆排序
 * @author vran1
 *
 */
public class HeapSort<E extends Comparable<? super E>> extends BaseSort<E> {
	private MaxHeap<E> heap;
	@Override
	public void sort(E[] data) {
		heap = new MaxHeap<>(data.length);
		for(E e:data) {
			heap.insert(e);
		}
		for(int i=data.length-1;i>=0;i--) {
			data[i] = heap.pop();
		}
	}
	
	public static void main(String[] args) {
		SortTest.test(new HeapSort<>());
	}
}
