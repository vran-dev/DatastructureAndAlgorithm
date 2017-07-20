package cc.cc1234.algorithm.sort;

/**
 * 排序抽象
 * @author vran1 
 */
public abstract class BaseSort<E extends Comparable<? super E>> {

	public abstract void sort(E[] data);
	
	public void swap(E[] data,int left, int right) {
		if(left>data.length||right>data.length) {
			throw new IllegalArgumentException();
		}
		
		E t=data[left];
		data[left]=data[right];
		data[right]=t;
	}

}
