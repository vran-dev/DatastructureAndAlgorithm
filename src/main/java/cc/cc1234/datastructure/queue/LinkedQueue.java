package cc.cc1234.datastructure.queue;


/**
 * 
 * 链表队列实现
 * @author vran1
 *
 */
public class LinkedQueue<E> implements Dequeue<E>{
	// 队列头
	private Node<E> head;
	// 队列尾
	private Node<E> tail;
	private int size;
	
	private static class Node<E>{
		E v;
		Node<E> next;
		Node<E> pre;
		
		public Node(E v) {
			this.v = v;
		}

		public Node(E v, Node<E> next, Node<E> pre) {
			this.v = v;
			this.next = next;
			this.pre = pre;
		}

		@Override
		public String toString() {
			return "Node [v=" + v +"]";
		}
		
	}
	
	@Override
	public boolean add(E e) {
		if(e == null) {
			return false;
		}
		Node<E> n =new Node<>(e);
		if(head == null) {
			head = tail = n;
		}else {
			tail.next = n;
			n.pre = tail;
			tail = n;
		}
		size++;
		return true;
	}

	@Override
	public E poll() {
		if(head == null) {
			return null;
		}
		Node<E> node = head;
		head = head.next;
		if(size == 1) {
			tail = null;
		}
		size--;
		return node.v;
	}

	@Override
	public E peek() {
		if(head == null) {
			return null;
		}
		return head.v;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean addFirst(E e) {
		if(e == null) {
			return false;
		}
		Node<E> n = new Node<>(e);
		if(head == null) {
			head = tail = n;
		}else {
			head.pre = n;
			n.next = head;
			head = n;
		}
		size++;
		return true;
	}

	@Override
	public E tail() {
		if(tail == null) {
			return null;
		}
		return tail.v;
	}
	
	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	
	@Override
	public String toString() {
		return "LinkedQueue [head=" + head + ", tail=" + tail + ", size=" + size + "]";
	}

	public static void main(String[] args) {
		Dequeue<Integer> q = new LinkedQueue<>();
		q.add(1);
		q.add(2);
		q.addFirst(99);
		System.out.println(q.tail());
		System.out.println(q);
		System.out.println(q.poll());
		System.out.println(q.poll());
		System.out.println(q);
//		q.add(2);
	}

	
}
