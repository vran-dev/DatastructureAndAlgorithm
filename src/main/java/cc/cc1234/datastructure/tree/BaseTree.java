package cc.cc1234.datastructure.tree;

public abstract class BaseTree<E extends Comparable<? super E>> {
	protected int size;
	
	public abstract void insert(E e);
	
	public abstract boolean contains(E e);
	
	public abstract E remove(E e);
	
	public int size() {
		return size;
	}
}
