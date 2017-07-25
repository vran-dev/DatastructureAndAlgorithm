package cc.cc1234.datastructure.union;


/**
 * 并查集
 * 
 * quickfind 查找时间复杂度只有O(1)
 * 
 * @author vran1
 *
 */
public class UnionFind {
	private int[] id;
	private int count;
	
	public UnionFind(int count) {
		this.count = count;
		id = new int[count];
		for(int i=0;i<count;i++) {
			id[i] = i;
		}
	}

	public boolean isConnected(int a, int b) {
		
		return find(a) == find(b);
	}
	
	public int find(int i) {
		if(i<0 && i>id.length) {
			throw new IllegalArgumentException();
		}
		return id[i];
	}
	
	public boolean union(int prepare, int old) {
		int pID = find(prepare);
		int oID = find(old);
		if(pID == oID) { // 本身是连接的
			return false;
		}
		for(int i=0 ; i<count; i++) {
			if(find(i) == pID) {
				id[i] = oID;
				return true;
			}
		}
		return false;
	}
}
