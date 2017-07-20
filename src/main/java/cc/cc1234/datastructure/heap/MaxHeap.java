package cc.cc1234.datastructure.heap;

import java.util.Arrays;

/**
 * 最大堆(不支持扩容)
 * @author vran1
 */
public class MaxHeap<E extends Comparable<? super E>> {
	private Object[] data;
	private int size;
	
	public MaxHeap(int capacity) {
		data=new Object[capacity];
	}

	public void insert(E e) {
		if( e==null || size==data.length ) {
			throw new IllegalStateException();
		}
		doInsert(e);
	}
	
	private void doInsert(E e) {
		data[size]=e;
		shiftUp(size);
		size++;
	}

	/**
	 * 弹出堆顶元素
	 * @return
	 */
	public E pop() {
		if( size > 0) {
			E e = (E) data[0];
			data[0] = data[size-1];
			data[--size] = null;
			shiftDown(0);
			return e;
		}
		return  null;
	}
	
	private void shiftUp(int n) {
		while(n>0) {
			int p = n%2 == 0 ? n/2-1 : n/2;
			if(((E)data[p]).compareTo((E)data[n]) == -1) {
				swap(data, p, n);
				n=p; 
			}else {
				break;
			}
		}
	}
	
	private void shiftDown(int n) {
		int c;
		while((c = n*2+1)<size) {
			//chid: left < right
			if((c+1)<size && ((E)data[c]).compareTo((E)data[c+1]) == -1 ){
				c+=1;
			}
			
			if(((E)data[n]).compareTo((E)data[c]) == -1) {
//				System.out.println("befo n="+n+",c="+c+",data="+Arrays.toString(data));
				swap(data, n, c);
//				System.out.println("swap n="+n+",c="+c+",data="+Arrays.toString(data));
//				System.out.println("--------------------------------");
				n = c;
			}else {
				break;
			}
		}
		
	}
	
	private void swap(Object[] data, int l, int r) {
		E temp = (E) data[l];
		data[l] = data[r];
		data[r] = temp;
	}
	
	public int size() {
		return size;
	}

	@Override
	public String toString() {
		return "MaxHeap [data=" + Arrays.toString(data) + ", size=" + size + "]";
	}
	
}
