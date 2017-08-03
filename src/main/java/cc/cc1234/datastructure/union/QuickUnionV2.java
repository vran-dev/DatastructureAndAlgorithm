package cc.cc1234.datastructure.union;

import java.util.Arrays;

/**
 * 并查集优化版（Rank优化）：
 * 上一个版本的并查集的实现在连接new和old时，是找到两者的根节点，
 * 进行判断通过后将new的根节点链接到old节点下面，这样可能会导致old节点
 * 下面的元素膨胀
 * 优化思路:连接new和old节点时，判断两个节点的深度（从根开始），将深度低的节点链接到
 * 深度高的节点下。
 * @author vran1
 */
public class QuickUnionV2 {
	private int[] id;
	private int[] level;
	private int count;
	
	public QuickUnionV2(int count) {
		this.count = count;
		id = new int[count];
		level = new int[count];
		for(int i = 0; i < count; i++) {
			id[i] = i;
			level[i] = 1;
		}
	}
	
	/**
	 * @Date 2017年7月26日
	 */
	public int find(int i) {
		if(i<0 || i>id.length) {
			throw new IllegalArgumentException();
		}
		
		int pid = id[i];
		if(pid == i) {
			return pid;
		}
		
		return find(id[pid]);
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

}
