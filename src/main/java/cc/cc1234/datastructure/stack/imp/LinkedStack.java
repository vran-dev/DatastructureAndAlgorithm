package cc.cc1234.datastructure.stack;


/**
 * 基于链表的栈实现
 * @author vran1
 */
public class LinkedStack<E> implements IStack<E>{
	private Node<E> head;
	private int size;
	
	private static class Node<E>{
		E v;
		Node<E> next;
		Node<E> pre;
		public Node(E v, Node<E> next, Node<E> pre) {
			this.v = v;
			this.next = next;
			this.pre = pre;
		}
		public Node() {
			super();
		}
		public Node(E v) {
			this.v = v;
		}
		
	}
	
	@Override
	public boolean push(E e) {
		if(e == null) {
			return false;
		}
		
		if(head == null) {
			head = new Node<>(e);
		}else {
			Node<E> n = head;
			Node<E> node = new Node<>(e);
			node.next = n;
			head = node;
		}
		size++;
		return true;
	}

	@Override
	public E pop() {
		if(size == 0) {
			return null;
		}
		Node<E> node = head;
		head =node.next;
		size--;
		return node.v;
	}

	@Override
	public int size() {
		return size;
	}
	
	public static void main(String[] args) {
		IStack<Integer> stack = new LinkedStack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		Integer i = null;
		while((i = stack.pop()) != null) {
			System.out.println(i+" , size="+stack.size());
		}
	}
}
