package cc.cc1234.datastructure.list;

public abstract class BaseList<E extends Comparable<? super E>> {
	private int size;
	
	public abstract void add(E e);
	
	public abstract E remove(int index);
	
	public abstract E get(int index);
	
	public abstract boolean contains(E e);
	
	public int size() {
		return size;
	}
}
