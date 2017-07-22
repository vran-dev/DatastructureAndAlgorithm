package cc.cc1234.datastructure.stack;

public interface IStack<E> {
	boolean push(E e);
	
	E pop();
	
	int size();
}
