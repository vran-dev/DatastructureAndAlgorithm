package cc.cc1234.datastructure.union;

import java.util.Arrays;

/**
 * 并查集优化版（路径压缩）：
 * @author vran1
 */
public class QuickUnionV3 {
	private int[] id;
	private int[] level;
	private int count;
	
	public QuickUnionV3(int count) {
		this.count = count;
		id = new int[count];
		level = new int[count];
		for(int i = 0; i < count; i++) {
			id[i] = i;
			level[i] = 1;
		}
	}
	
	/**
	 * 路径压缩执行
	 * @Date 2017年7月26日
	 */
	public int find(int i) {
		if(i<0 || i>id.length) {
			throw new IllegalArgumentException();
		}
		
		int pid = id[i];
		while(pid != i) {
			id[i] = id[pid];
			i = pid;  
			pid = id[i];
		}
		return pid;
	}
	
	public boolean isConnected(int v, int old) {
		return find(v) == find(old);
	}
	
	public boolean union(int v, int old) {
		int vId = find(v);
		int oId = find(old);
		if(vId == oId) {
			return true;
		}
		
		if(level[vId] > level[oId]) {
			id[oId] = vId;
		}else if(level[vId] == level[oId]){
			id[vId] = oId;
			level[oId]++;
		}else{
			id[vId] = oId;
		}
		return true;
	}
	
	public int size(int v) {
		return level[v];
	}
	
	@Override
	public String toString() {
		return "QuickUnion [id=" + Arrays.toString(id) + ", count=" + count + "]";
	}

	public static void main(String[] args) {
		System.out.println("-------------------");
		QuickUnionV3 v2 = new QuickUnionV3(6);
		System.out.println(v2);
		System.out.println(Arrays.toString(v2.level));
		
		System.out.println("union(1,2)="+v2.union(1, 2));
		System.out.println("union(3,4)="+v2.union(3, 4));
		System.out.println("union(1,4)="+v2.union(1, 4));
		System.out.println(v2);
		System.out.println("union(0,5)="+v2.union(0, 5));
		System.out.println(v2);
		System.out.println(v2.find(1));
		System.out.println(v2);
	}
	
}
