package cc.cc1234.datastructure.queue;

import java.util.Arrays;

/**
 * 基于数组实现的双端队列
 * @author vran
 * @date 2017-07-21 14:30:00
 */
public class ArrayQueue<E> implements Dequeue<E> {
	private int size;
	private Object[] data;
	private int head;
	private int tail;

	public ArrayQueue(int capacity) {
		data =  new Object[capacity];
	}

	@Override
	public boolean add(E e) {
		if(data.length == size) {
			return false;
		}
		data[tail] = e;
		size++;
		tail++;
		if(tail == data.length) {
			tail = 0;
		}
		return true;
	}

	@Override
	public E poll() {
		if(size == 0) {
			return null;
		}
		E e = (E) data[head];
		data[head] = null;
		size--;
		head++;
		if(head == data.length) {
			head = 0;
		}
		return e;
	}

	@Override
	public E peek() {
		if(size == 0) {
			return null;
		}
		return (E) data[head];
	}

	@Override
	public boolean addFirst(E e) {
		if(size == data.length) {
			return false;
		}
		head--;
		if(head < 0) {
			head = data.length-1;
		}
		data[head] = e;
		size++;
		return true;
	}
	
	/**
	 * 获取单并不移除尾元素
	 */
	@Override
	public E tail() {
		if(size == 0) {
			return null;
		}
		E e = null;
		if((tail-1)<0) {
			e = (E) data[data.length-1];
		}else {
			e= (E) data[tail-1];
		}
		return e;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public String toString() {
		return "ArrayQueue [size=" + size + ", data=" + Arrays.toString(data) + ", head=" + head + ", tail=" + tail
				+ "]";
	}

	public static void main(String[] args) {
		Dequeue<Integer> queue = new ArrayQueue<>(4);
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		System.out.println("当队列满了的时候再进行添加会失败："+queue.add(5));
		
		System.out.println("移除两个元素");
		System.out.println(queue.poll());
		System.out.println(queue);
		System.out.println(queue.poll());
		System.out.println(queue);
		System.out.println("------------------------\r\n");

		queue.add(4);
		queue.add(5);
		System.out.println(queue);
		System.out.println("------------------------\r\n");
		
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue);
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue);
		System.out.println("------------------------\r\n");
		
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		System.out.println(queue);
		
		System.out.println(queue.tail());
		System.out.println(queue.addFirst(99));
		
		System.out.println(queue.poll());
		System.out.println(queue);
		System.out.println(queue.addFirst(1));
		System.out.println(queue);
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue);
		System.out.println(queue.addFirst(1));
		System.out.println(queue);
		
		System.out.println(queue.poll());
		System.out.println(queue);
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue);
		System.out.println(queue.poll());
		
		System.out.println(queue.addFirst(4));
		System.out.println(queue.addFirst(3));
		System.out.println(queue.addFirst(2));
		System.out.println(queue.addFirst(1));
		System.out.println(queue.addFirst(1));
		System.out.println(queue);
	}
}
