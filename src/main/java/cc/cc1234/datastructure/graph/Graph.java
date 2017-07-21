package cc.cc1234.datastructure.graph;

public interface Graph {
	
	/*
	 * 添加邻边
	 */
	boolean addEdge(int v, int w);
	/*
	 * 是否存在指定顶点的边
	 */
	boolean hasEdge(int v,int w);
	/*
	 * 邻边数
	 */
	int edges();
	/*
	 * 顶点数
	 */
	int vertexs();
	
	GraphIterator iterator(int v);
}
