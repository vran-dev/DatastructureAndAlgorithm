package cc.cc1234.algorithm.graph;

import cc.cc1234.datastructure.graph.DenseGraph;
import cc.cc1234.datastructure.graph.Graph;
import cc.cc1234.datastructure.graph.GraphIterator;

/**
 * 图的深度优先遍历
 * 
 * @author vran1
 *
 */
public class DFS {
	private boolean[] visited;
	private Graph graph;
	private int count;
	
	public DFS(Graph graph) {
		this.graph = graph;
		visited = new boolean[graph.vertexs()];
	}

	public void order() {
		for(int i = 0; i < graph.vertexs(); i++) {
			if(!visited[i]) {
				System.out.print(i+"->");
				doOrder(i);
				count++;
				System.out.println("\r\n");
			}
		}
	}
	
	private void doOrder(int v) {
		visited[v] = true;
		GraphIterator iterator = graph.iterator(v);
		int r;
		while((r=iterator.next())!=-1) {
			if(!visited[r]) {
				System.out.print(r+"->");
				doOrder(r);
			}
		}
	}
	
	/*
	 * 联通分量
	 */
	public int count() {
		return count;
	}
	
	public static void main(String[] args) {
		Graph graph = new DenseGraph(5);
		GraphIterator iter = graph.iterator(0);
		graph.addEdge(0, 2);
		graph.addEdge(1, 3);
		graph.addEdge(0, 4);
		DFS dfs = new DFS(graph);
		dfs.order();
		System.out.println("联通分量="+dfs.count);
	}
}
