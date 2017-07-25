package cc.cc1234.datastructure.union;

/**
 * 并查集
 * @author vran1
 *
 */
public class QuickUnion {
	private int[] id;
	private int count;
	public QuickUnion(int count) {
		this.count = count;
		id = new int[count];
		for(int i = 0; i < count; i++) {
			id[i] = i;
		}
	}
	
	
	
}
