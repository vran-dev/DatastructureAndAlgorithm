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
		System.out.println("debug:"+m+","+r);
		if(c == 1) {
			return binarySearch(e, 0, m-1);
		}else if(c == -1) {
			return binarySearch(e, m+1, r);
		}else { // c==0
			return data[m];
		}
		
	}
	
	public static void main(String[] args) {
		Integer[] data= {1,2,3,4,5,6,7,9,10};
		BinarySearch<Integer> search=new BinarySearch<>(data);
		System.out.println(search.search(8));
	}
}
