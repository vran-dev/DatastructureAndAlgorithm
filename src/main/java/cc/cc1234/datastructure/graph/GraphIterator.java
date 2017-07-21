package cc.cc1234.datastructure.graph;

public interface GraphIterator {
	
	/*
	 * 回到元素起始点
	 */
	int begin();
	
	/*
	 * 得到下一个相邻节点
	 */
	int next();
	
	/*
	 * 没有元素可遍历
	 */
	boolean end();
}
