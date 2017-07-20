package cc.cc1234.datastructure.tree;

public abstract class BaseTree<E extends Comparable<? super E>> {
	
	public abstract void insert(E e);
	
	public abstract E get(int index);
	
	public abstract E contains(E e);
	
}
