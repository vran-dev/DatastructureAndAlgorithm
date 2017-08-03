package cc.cc1234.algorithm.search;

/**
 * 	二分查找 
 *  待查找数据一定是有序的
 */
public class BinarySearch<E extends Comparable<? super E>> {
	private E[] data;
	
	public BinarySearch(E[] data) {
		this.data = data;
	}
	
	public E search(E e) {
		if(data==null || data.length==0) {
			return null;
		}
		return binarySearch(e , 0, data.length-1);
	}
	
	/**
	 * 递归二分查找
	 */
	private E binarySearch(E e,int l, int r) {
		if(l>r) {
			return null;
		}
		
		int m = (l+r)/2;
		int c = data[m].compareTo(e);
		if(c == 1) {
			return binarySearch(e, 0, m-1);
		}else if(c == -1) {
			return binarySearch(e, m+1, r);
		}else { // c==0
			return data[m];
		}
		
	}
	
}
