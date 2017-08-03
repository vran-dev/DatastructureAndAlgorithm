package cc.cc1234.algorithm.graph;

import java.util.LinkedList;
import java.util.Queue;

import cc.cc1234.datastructure.graph.Graph;
import cc.cc1234.datastructure.graph.GraphIterator;
import cc.cc1234.datastructure.graph.SparseGraph;


/**
 * 图的广度优先遍历算法
 * 
 * @author vran1
 *
 */
public class BFS {
	private Graph graph;
	private boolean[] visited;
	private Queue<Integer> queue;
	
	public BFS(Graph graph) {
		this.graph = graph;
		visited = new boolean[graph.vertexs()];
		queue = new LinkedList<>();
	}
	
	public void order() {
		for(int i = 0; i < graph.vertexs(); i++) {
			queue.add(i);
			while(!queue.isEmpty()) {
				Integer x = queue.poll();
				if(!visited[x]) {
					visited[x] = true;
					GraphIterator iterator = graph.iterator(x);
					System.out.println("x="+x);
					int j;
					while((j = iterator.next())!=-1 && !visited[j]) {
						System.out.println("\r\n"+x+" add: "+j);
						queue.add(j);
					}
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		Graph graph = new SparseGraph(9);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(4, 3);
		graph.addEdge(4, 5);
		graph.addEdge(5, 6);
		graph.addEdge(3, 6);
		graph.addEdge(7, 8);
		new BFS(graph).order();
	}
	
}
