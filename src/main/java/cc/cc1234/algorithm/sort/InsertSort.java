package cc.cc1234.algorithm.sort;

/**
 * 插入排序
 * @author vran1
 */
public class InsertSort<E extends Comparable<? super E>> extends BaseSort<E>{

	@Override
	public void sort(E[] data) {
		for(int i = 1; i < data.length; i++) {
			int pos = i;
			E v = data[i];
			for(int j = i-1; j>=0 ;j--) {
				if( v.compareTo(data[j]) == -1) {
					data[pos] = data[j];
					pos = j;
				}else {
					break;
				}
			}
			data[pos] = v;
		}
	}
	
	public static void main(String[] args) {
		SortTest.test(new InsertSort<Integer>());
	}
	
}
