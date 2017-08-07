package cc.cc1234.datastructure.heap;

import java.util.Comparator;

/**
 * 最小堆
 * @author vran1
 *
 * @param <E>
 */
public class MinHeap<E> {
	private Object[] data;
	private int size;
	private Comparator<? super E> c;

	public MinHeap(int capacity, Comparator<? super E> c) {
		data = new Object[capacity];
		this.c = c;
	}

	public void insert(E e) {
		if(size >= data.length) {
			throw new IllegalStateException();
		}
		data[size++] = e;
		shiftUp(size-1);  
	}

	public E min() {
		if(size == 0) {
			return null;
		}

		E min = (E)data[0];
		data[0] = data[--size];
		data[size] = null;
		shiftDown(0);
		return min;
	}

	private void shiftUp(int k) {
		E e = (E)data[k];
		while(k>0) {
			int p = (k-1)/2;
			/*
			 * data[k] < data[p] 返回正数
			 * data[k] == data[p] 返回0
			 * data[k] > data[p] 返回负数
			 */
			if(c.compare(e, (E)data[p]) < 0) {
				data[k] = data[p];
				k = p;
			}else {
				break;
			}
		}
		data[k] = e;
	}

	private void shiftDown(int k) {
		int half = size/2;
		E e = (E)data[k];
		while(k < half) {
			int child = 2*k+1;
			if((child+1) < size) {
				if(c.compare((E)data[child],(E)data[child+1]) > 0) {
					child += 1;
				}
			}
			
			if(c.compare((E)data[child], e) < 0) {
				data[k] = data[child];
				k = child;
			}else {
				break;
			}
		}
		data[k] = e;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}
}
