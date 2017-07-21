package cc.cc1234.datastructure.queue;


/**
 * 双端队列
 * @author vran
 */
public interface Dequeue<E> extends Queue<E> {
	/**
	 *  添加元素到队列头
	 * @Date 2017年7月21日
	 */
	boolean addFirst(E e);
	
	/*
	 * 返回队列尾元素 
	 */
	E  tail();
}
