package cc.cc1234.datastructure.heap;

import java.util.Comparator;


/**
 * 最小索引堆
 * @author vran1
 *
 */
public class IndexMinHeap<E> {
	private Comparator<E> comparator; // 比较器
	private Object[] data; // 数据
	private int[]  index; // 索引
	private int size;
	private int capacity;

	public IndexMinHeap(Comparator<E> comparator, int capacity) {
		this.comparator = comparator;
		this.data = new Object[capacity];
		this.index = new int[capacity];
		this.capacity = capacity;
	}

 	public IndexMinHeap(Comparator<E> comparator, E[] data) {
		this.comparator = comparator;
		this.data = data;
		this.index = new int[data.length];
		size = data.length;
		capacity = data.length;
		
		for(int i=0;i<index.length;i++) {
			index[i] = i;
		}
		heapify(size-1);
	}
	
	public boolean insert(int i, E e) {
		if(i >= capacity) {
			throw new IllegalArgumentException();
		}
		if(data[i] != null || size >= capacity) {
			return false;
		}
		
		data[i] = e;
		index[size++] = i;
		shiftUp(size-1);
		return true;
	}
	
	/**
	 * 改变索引index处的值
	 * @param idx	index
	 * @param e		New value
	 * @return		Old value
	 * @Date 2017年8月7日
	 */
	public E change(int idx, E e) {
		if(idx < 0 || idx >= capacity) {
			throw new IllegalArgumentException();
		}
		
		if(data[idx] == null) {
			throw new NullPointerException("data[idx] == null");
		}
		E old = (E) data[idx];
		data[idx] = e;
		
		for(int i = 0; i < size; i++) {
			if(index[i]==idx) {
				shiftUp(i);
				shiftDown(i);
			}
		}
		
		return old;
	}

	/*
	 * 移除并获取最小值
	 */
	public E popMin() {
		if(size == 0) {
			return null;
		}
		E e = (E) data[index[0]];
		data[index[0]] = null;
		index[0] = index[--size];
		index[size] = 0;
		shiftDown(0);
		return e;
	}
	
	/**
	 * 获取最小值的索引
	 * @return
	 * @Date 2017年8月7日
	 */
	public int getMinIndex() {
		if(size == 0) {
			return -1;
		}
		return index[0];
	}
	
	public E get(int idx) {
		if(idx < 0) {
			throw new IllegalArgumentException();
		}
		
		return (E) data[idx];
	}
	
	private void heapify(int k) {
		while(k>0) {
			shiftUp(k);
			k--;
		}
	}
	
	/*
	 * k是指向索引的索引
	 */
	private void shiftUp(int k) {
		int idx = index[k];
		
		while(k > 0) {
			int pIdx = (k-1)/2;
			if(comparator.compare((E)data[idx], (E)data[index[pIdx]]) < 0) {
				index[k] = index[pIdx];
				k = pIdx;
			}else {
				break;
			}
		}
		index[k] = idx;
	}

	private void shiftDown(int k) {
		int idx = index[k];
		int half = size/2;
		while(k < half) {
			int c = 2*k+1; // left child
			if((c+1) < size && comparator.compare((E)data[index[c]], (E)data[index[c+1]]) > 0) { // right child < left child
				++c;
			}
			
			if(comparator.compare((E) data[idx], (E)data[index[c]]) > 0) { // child < e
				index[k] = index[c];
				k = c;
			}else {
				break;
			}
		}
		index[k] = idx;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public static void main(String[] args) {
		Integer[] data = {6,1,3,4,2,9};
		IndexMinHeap<Integer> heap = new IndexMinHeap(new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.equals(o2)?0:o1>o2?1:-1;
			}
			
		},6);
		
		heap.insert(0, 10);
		heap.insert(1, 20);
		heap.insert(2, 26);
		heap.insert(3, 16);
		heap.insert(4, 30);
		heap.insert(5, 36);
		for(int i=0 ;i<6;i++) {
			System.out.print(heap.get(i)+" ");
		}
		
		System.out.println("\r\n-----------------------");
		heap.change(5, 1);
		while(!heap.isEmpty()) {
			System.out.print(heap.popMin()+" ");
		}
		
	}
}
