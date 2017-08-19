package cc.cc1234.algorithm.graph.shortestPath;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cc.cc1234.datastructure.graph.imp.Edge;
import cc.cc1234.datastructure.graph.imp.SparseWeightGraph;
import cc.cc1234.datastructure.graph.imp.WeightGraph;
import cc.cc1234.datastructure.graph.imp.WeightGraphIterator;
import cc.cc1234.datastructure.heap.IndexMinHeap;
import cc.cc1234.util.Log;

/**
 * 单源最短路径算法 限制条件 :处理的图中不能有负权边 时间复杂度 :ElogV
 * 
 * @author vran1
 *
 */
public class Dijkstra {
	private static final Log log = Log.getInstance(Dijkstra.class);
	private IndexMinHeap<Double> heap;
	private WeightGraph graph;
	private int start; // 求单源最短路径的起点
	private Double[] dist; // 长度记录
	private boolean[] marked;
	private List<Integer>[] from;// 路径记录

	public Dijkstra(WeightGraph graph, int start) {
		assert start >= 0 && start < graph.vertexs() : "Illegal argument start = " + start;

		this.graph = graph;
		this.start = start;
		heap = new IndexMinHeap<>(Comparator.comparing(Double::doubleValue), graph.vertexs());
		from = new LinkedList[graph.vertexs()];
		dist = new Double[graph.vertexs()];
		marked = new boolean[graph.vertexs()];

		for (int i = 0; i < from.length; i++) {
			from[i] = new LinkedList<Integer>();
		}
		log.info(() -> "init complete: graph.vertexs = " + graph.vertexs());
		generate(this.start);
	}

	private void generate(int v) {
		marked[v] = true;
		dist[v] = 0.0;
		heap.insert(v, 0.0);
		while (!heap.isEmpty()) {
			int idx = heap.getMinIndex();
			heap.popMin();
			marked[idx] = true;
			WeightGraphIterator iterator = graph.iterator(idx);
			while (!iterator.end()) {
				Edge edge = iterator.next();
				int w = edge.other(idx);
				if (!marked[w]) {
					if (dist[edge.getTo()] == null || dist[edge.getTo()] > dist[edge.getFrom()] + edge.getWeight()) {
						dist[edge.getTo()] = dist[edge.getFrom()] + edge.getWeight();
						if (heap.get(w) == null) {
							heap.insert(w, dist[w]);
							from[w].add(edge.getFrom());
						} else {
							heap.change(w, dist[w]);
							from[w].clear();
							log.debug(() -> "from[" + edge.getTo() + "].addAll = " + from[edge.getFrom()]);
							from[w].addAll(from[edge.getFrom()]);
							from[w].add(edge.getFrom());
						}
					}
				}
			}
		}
	}

	/**
	 * 从 start --> to 节点的路径长度
	 * 
	 * @param to
	 * @return
	 */
	public Double dist(int to) {
		return dist[to];
	}

	public List<Integer> path(int to) {
		log.debug(() -> "Go to " + to + " path: " + from[to]);
		return from[to];
	}

	/**
	 * 是否存在到to节点的路径
	 * 
	 * @param to
	 * @return
	 */
	public boolean exists(int to) {
		return dist[to] != null;
	}

	public static void main(String[] args) {
		WeightGraph graph = new SparseWeightGraph(8);
		graph.addEdge(0, 1, 0.3);
		graph.addEdge(0, 2, 0.2);
		graph.addEdge(0, 3, 0.4);
		graph.addEdge(1, 4, 0.4);
		graph.addEdge(2, 1, 0.2);
		graph.addEdge(2, 3, 0.1);
		graph.addEdge(2, 4, 0.3);
		graph.addEdge(3, 4, 0.1);
		Dijkstra dijkstra = new Dijkstra(graph, 0);
		System.out.println(dijkstra.dist(3));
		System.out.println(dijkstra.dist(4));
		System.out.println(dijkstra.path(1));
		System.out.println(dijkstra.path(2));
		System.out.println(dijkstra.path(3));
		System.out.println(dijkstra.path(4));
	}
}
