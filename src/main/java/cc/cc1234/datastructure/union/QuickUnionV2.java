package cc.cc1234.datastructure.union;

import java.util.Arrays;

/**
 * 并查集优化版（路径压缩）：
 * 上一个版本的并查集的实现在连接new和old时，是找到两者的根节点，
 * 进行判断通过后将new的根节点链接到old节点下面，这样可能会导致old节点
 * 下面的元素膨胀
 * 优化思路:连接new和old节点时，判断两个节点的深度（从根开始），将深度低的节点链接到
 * 深度高的节点下。
 * @author vran1
 *
 */
public class QuickUnionV2 {
	private int[] id;
	private int[] size;
	private int count;
	
	public QuickUnionV2(int count) {
		this.count = count;
		id = new int[count];
		size = new int[count];
		for(int i = 0; i < count; i++) {
			id[i] = i;
			size[i] = 1;
		}
	}
	
	/**
	 * 
	 * @Date 2017年7月26日
	 */
	public int find(int i) {
		return 0;
	}
	
	public boolean isConnected(int v, int old) {
		//TODO
		return false;
	}
	
	public boolean union(int v, int old) {
		return false;
	}
	
	
	
	@Override
	public String toString() {
		return "QuickUnion [id=" + Arrays.toString(id) + ", count=" + count + "]";
	}

	public static void main(String[] args) {
		QuickUnionV2 union = new QuickUnionV2(10);
		System.out.println("union.find(1)="+union.find(1));
		System.out.println("union.isConnected(1,1)="+union.isConnected(1, 1));
		System.out.println("union.isConnected(1,0)="+union.isConnected(1, 1));
		System.out.println("union.union(1,2)="+union.union(1, 2));
		System.out.println(union);
		System.out.println("union.union(1,3)="+union.union(1, 3));
		System.out.println(union);
		
		union.union(5,6);
		union.union(5,7);
		System.out.println(union);
		System.out.println(union.union(1, 6));
		System.out.println(union);
		
	}
}
