package cc.cc1234.algorithm.search;


/**
 * 顺序查找
 * @author vran
 */
public class SequenceSearch<E extends Comparable<? super E>> {
	
	private E[] data;
	
	public SequenceSearch(E[] data) {
		super();
		this.data = data;
	}

	public E search(E e) {
		for(int i=0 ; i<data.length; i++) {
			if(data[i].compareTo(e) == 1) {
				return data[i];
			}
		}
		return null;
	}
}
