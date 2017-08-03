package cc.cc1234.datastructure.queue.imp;


/**
 * 
 * 优先队列：保证每次从队列头获取的元素都是优先级最高的。
 * 
 * 与最大堆不一样的是，内部元素的顺序也是按照优先级进行排列的，而且可以直接从尾部取出优先级最小的元素
 * 
 * @author vran
 * @date 2017-07-27 18:34:12
 */
public class PriorityQueue<E> {
	private int size;
	// 头结点
	private Node<E> head;
	// 尾节点
	private Node<E> tail;
	
	private static class Node<E>{
		E value;
		int priority; // 优先级 值越大优先级余越高
		Node<E> pre; // 上一个节点
		Node<E> next; // 下一个节点
		
		public Node(E value, int priority) {
			this(value,priority,null);
		}

		public Node(E value, int priority, Node<E> pre) {
			super();
			this.value = value;
			this.priority = priority;
			this.pre = pre;
		}

		@Override
		public String toString() {
			return "Node [value=" + value + ", priority=" + priority + ", next=" + next + "]";
		}

	}
	
	public boolean add(E e, int priority) {
		if(e == null) {
			return false;
		}
		Node<E> node = new Node<>(e, priority);
		return insertNode(node);
	}
	
	private boolean insertNode(Node<E> node) {
		if(head == null) {
			head = tail = node;
			size++;
			return true;
		}
		// 两种思路
		// 1 先加入队列尾，然后一层层交换上去
		// 2  找到自己的位置，然后再交换
		// 先处理极端情况：优先级是不是最大的
		if(node.priority >= head.priority) {
			head.pre = node;
			node.next = head;
			head = node;
			size++;
			return true;
		}
		
		Node<E> n = tail;
		while(n!=null) {
			if(n.priority < node.priority) {
				n = n.pre;
			}else {
				Node<E> nNext = n.next;
				n.next = node;
				node.pre = n;
				if(nNext!=null) {
					nNext.pre = node;
					node.next = nNext;
				}else {
					tail = node;
				}
				size++;
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 移除并获取头元素
	 * @return
	 * @Date 2017年7月27日
	 */
	public E poll() {
		if(size == 0) {
			return null;
		}
		Node<E> e = head;
		head = head.next;
		if(head != null) {
			head.pre = null;
		}else {
			tail = null;
		}
		size--;
		return e.value;
	}
	
	public E removeTail() {
		if(size == 0) {
			return null;
		}
		Node<E> e = tail;
		size--;
		tail = e.pre;
		if(tail == null) {
			head = null;
		}else {
			tail.next = null;
		}
		return e.value;
	}
	
	public int size() {
		return size;
	}
	
	
	
	@Override
	public String toString() {
		return " [size=" + size + ", head=" + head;
	}

	public static void main(String[] args) {
		PriorityQueue<String> pq = new PriorityQueue<>();
		pq.add("A", 9);
		pq.add("B", 3);
		pq.add("C", 5);
		pq.add("D", 6);
		pq.add("E", 9);
		pq.add("F", 2);
		System.out.println(pq.size);
		String n = null;
		while((n=pq.poll())!=null) {
			System.out.println(n+","+pq.size);
		}
	}
}
