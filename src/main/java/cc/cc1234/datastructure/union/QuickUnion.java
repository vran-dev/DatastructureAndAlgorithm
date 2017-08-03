package cc.cc1234.datastructure.union;

import java.util.Arrays;

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
	
	/**
	 * 
	 * @Date 2017年7月26日
	 */
	public int find(int i) {
		if(i<0 || i>=id.length) {
			throw new IllegalArgumentException();
		}
		if(id[i] != i) {
			return find(id[i]);
		}else {
			return id[i];
		}
	}
	
	public boolean isConnected(int v, int old) {
		if(v<0 || v>id.length || old<0 || old>id.length) {
			throw new IllegalArgumentException();
		}
		
		if(v == old) {
			return true;
		}
		
		return find(v) == find(old);
	}
	
	public boolean union(int v, int old) {
		if(v<0 || v>id.length || old<0 || old>id.length) {
			throw new IllegalArgumentException();
		}
 		if(v == old) {
 			return true;
 		}
 		int vId = find(v);
 		int oId= find(old);
 		if(vId == oId) {
 			return true;
 		}else {
 			id[vId] = old;
 			return true;
 		}
	}
	
	
	
	@Override
	public String toString() {
		return "QuickUnion [id=" + Arrays.toString(id) + ", count=" + count + "]";
	}

}
