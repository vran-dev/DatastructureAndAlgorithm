package cc.cc1234.algorithm.sort;

import java.util.Arrays;

public abstract class BaseSort<E extends Comparable<? super E>> {
	protected E[] data;
	
	public BaseSort(E[] data) {
		this.data = data;
	}

	public void sort() {
		doSort(data);
	}
	
	public abstract void doSort(E[] data);
	
	public void swap(int left, int right) {
		if(left>data.length||right>data.length) {
			throw new IllegalArgumentException();
		}
		
		E t=data[left];
		data[left]=data[right];
		data[right]=t;
	}

	public E[] getData() {
		return data;
	}

	public void setData(E[] data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return Arrays.toString(data);
	}
	
	
}
