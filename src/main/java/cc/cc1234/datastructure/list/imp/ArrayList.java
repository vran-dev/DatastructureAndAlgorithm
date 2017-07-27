package cc.cc1234.datastructure.list.imp;

import java.util.Arrays;

import cc.cc1234.datastructure.list.BaseList;

/**
 * 顺序表（物理连续）
 * @author vran
 */
public class ArrayList<E extends Comparable<? super E>> extends BaseList<E>{

	private Object[] data;
	
	public ArrayList(int capacity) {
		this.data = new Object[capacity];
	}
	
	@Override
	public void add(E e) {
		checkAndIncrCapacity();
		data[size] = e;
		size++;
	}

	@Override
	public E remove(int index) {
		if(index >= size) {
			throw new IllegalArgumentException("arguments index["+index+"]>=size["+size +"]is invalid") ;
		}
		E e = (E) data[index];
		data[index] = null;
		for(int i = index; i<size-1; i++) {
			data[i] = data[i+1];
		}
		size--;
		data[size] = null;
		return e;
	}

	@Override
	public E get(int index) {
		if(index >= size) {
			throw new IllegalArgumentException("arguments index["+index+"]>=size["+size +"]is invalid") ;
		}
		
		return (E) data[index];
	}
	
	/**
	 * 可以使用二分查找作优化
	 */
	@Override
	public boolean contains(E e) {
		for(int i=0; i<super.size(); i++) {
			if(((E)data[i]).compareTo(e) == 1) {
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 *  为了方便理解，我这儿使用了for做复制。
	 *  实际实现可以使用System.arrayCopy(...)函数
	 */
	private void checkAndIncrCapacity() {
		if(size == data.length) {
			int newCapacity = data.length << 1;
			Object[] objs = new Object[newCapacity];
			for(int i=0 ; i<data.length; i++) {
				objs[i] = data[i];
			}
			data = objs;
		}
	}

	@Override
	public String toString() {
		return "ArrayList [data=" + Arrays.toString(data) + ", size=" + size + "]";
	}
	
	public static void main(String[] args) {
		BaseList<Integer> list=new ArrayList<>(3);
		list.add(1);
		list.add(2);
		list.add(3);
		System.out.println(list);
		list.add(4);
		list.add(5);
		list.add(6);
		System.out.println(list);
		
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i)+" ");
		}
		System.out.println("\r\n---------------");
		for(int i=0;i<list.size();i++) {
			System.out.print(list.contains(i)+" ");
		}
		System.out.println("\r\n---------------");
		System.out.println(list.remove(0));
		System.out.println(list);
		
		list.add(7);
		System.out.println(list.remove(list.size()-1));
		System.out.println(list);
		
		System.out.println(list.remove(3));
		System.out.println(list);
		
	}
	
}
