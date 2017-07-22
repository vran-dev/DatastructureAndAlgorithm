package cc.cc1234.datastructure.queue;

public interface Queue<E> {
	
	/**
	 * 添加指定元素到队列尾
	 * @Date 2017年7月21日
	 */
	boolean add(E e);
	
	/**
	 * 移除并返回队列头元素
	 * @Date 2017年7月21日
	 */
	E poll();
	
	/**
	 * 获取队列头元素，但是不移除
	 * @Date 2017年7月21日
	 */
	E peek();
	
	int size();
	
	boolean isEmpty();
}
