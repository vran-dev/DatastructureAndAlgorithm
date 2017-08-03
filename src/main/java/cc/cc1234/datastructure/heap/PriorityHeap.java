package cc.cc1234.datastructure.heap;

import java.util.Arrays;

/**
 * 
 * 优先堆:每次取出的值必定是权重值最高的元素
 * @author vran1
 * TOOD
 */
public class PriorityHeap<E> {
	private int size;
	private Node[] data;

	private static class Node<E>{
		E e;
		int weight;

		public Node(E e, int weight) {
			this.e = e;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Node [e=" + e + ", weight=" + weight + "]";
		}

	}

	public PriorityHeap(int capacity) {
		data = new Node[capacity];
	}

	public boolean insert(E e, int weight) {
		if(size == data.length) {
			return false;
		}
		Node<E> n = new Node<>(e, weight);
		data[size] = n;
		shiftUp(size++);
		return true;
	}

	public E pop() {
		if(size == 0) {
			return null;
		}
		Node<E> v = data[0];
		data[0] = data[--size];
		data[size] = null;
		shiftDown(0);
		return v.e;
	}

	public boolean change(E e , int weight) {
		for(int i = 0; i<size; i++) {
			if(data[i].e == e || data[i].e.equals(e)) {
				data[i].weight = weight;
				shiftDown(i);
				shiftUp(i);
				return true;
			}

		}
		return false;
	}

	private void shiftUp(int loc) {
		int c = loc;
		while(c>0) {
			int p = c%2==0?c/2-1:c/2;
			if(data[p].weight < data[c].weight) {
				swap(p, c);
				c = p;
			}else {
				break;
			}
		}
	}

	private void swap(int l , int r) {
		Node<E> temp = data[l];
		data[l] = data[r];
		data[r] = temp;
	}


	private void shiftDown(int loc) {
		int p = loc;
		int c;
		while( (c = 2*p+1) < size) {
			if((c+1)<size && data[c].weight < data[c+1].weight) {
				c += 1;
			}
			if(data[p].weight < data[c].weight) {
				swap(p,c);
				p=c;
			}else {
				break;
			}
		}
	} 
	
	public int size() {
		return size;
	}

	@Override
	public String toString() {
		return "PriorityHeap [size=" + size + ", data=" + Arrays.toString(data) + "]";
	}

}
