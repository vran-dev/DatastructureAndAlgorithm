package cc.cc1234.algorithm.graph.traversal;

import java.util.ArrayList;
import java.util.List;

import cc.cc1234.datastructure.graph.Graph;
import cc.cc1234.datastructure.graph.GraphIterator;
import cc.cc1234.datastructure.graph.imp.DenseGraph;

/**
 * 图的深度优先遍历
 * 
 * @author vran1
 *
 */
public class DFS {
	private int[] union;
	private boolean[] visited;
	private Graph graph;
	private int count;
	
	public DFS(Graph graph) {
		this.graph = graph;
		visited = new boolean[graph.vertexs()];
		union = new int[graph.vertexs()];
	}

	public List<Integer> order() {
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < graph.vertexs(); i++) {
			if(!visited[i]) {
				doOrder(i,list);
				count++;
			}
		}
		return list;
	}
	
	private void doOrder(int v,List<Integer> list) {
		list.add(v);
		union[v] = count;
		visited[v] = true;
		GraphIterator iterator = graph.iterator(v);
		int r;
		while((r=iterator.next())!=-1) {
			if(!visited[r]) {
				doOrder(r,list);
			}
		}
	}
	
	/*
	 * 联通分量
	 */
	public int count() {
		return count;
	}
	
	/*
	 * 判断两个顶点是不是连通的
	 */
	public boolean connected(int v, int w) {
		assert v>=0 && v<graph.vertexs():"arguments 0=< v <= vertexs";
		assert w>=0 && w<graph.vertexs():"arguments 0<= w <= vertexs";
		
		return union[v] == union[w];
	}
	public static void main(String[] args) {
		Graph graph = new DenseGraph(6);
		graph.addEdge(0, 2);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.addEdge(1, 5);
		
		DFS dfs = new DFS(graph);
		List<Integer> list = dfs.order();
		System.out.println(list);
		System.out.println("联通分量="+dfs.count);
	}
}
