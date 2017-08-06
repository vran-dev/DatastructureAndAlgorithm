package cc.cc1234.datastructure.graph.imp;

import cc.cc1234.datastructure.graph.GraphIterator;

/**
 * 带权图
 * 
 * @author vran1
 *
 */
public interface WeightGraph {
	
	/**
	 * 添加from节点到to节点的边
	 * @param from
	 * @param to
	 * @param weight   权值
	 * @return true添加成功：false添加失败
	 */
	boolean addEdge(int from, int to, double weight);
	
	/**
	 * 图的节点个数
	 * @return
	 */
	int vertexs();
	
	/**
	 * 图的边数
	 * @return
	 */
	int edges(); 
	
	/**
	 * 是否包含从from节点到to节点的边
	 */
	boolean  contains(int from, int to);
	
	/**
	 * 从from节点到to节点的权值，若不存在则返回-1
	 * @param from
	 * @param to
	 * @return
	 */
	double weight(int from, int to);
	
	/**
	 * 是否是有向图
	 * @return
	 */
	boolean directed();
	
	/**
	 * 节点v的迭代器
	 * @param v
	 * @return
	 */
	WeightGraphIterator iterator(int v);
}
