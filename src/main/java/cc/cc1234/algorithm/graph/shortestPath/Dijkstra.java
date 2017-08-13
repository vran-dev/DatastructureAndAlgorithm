package cc.cc1234.algorithm.graph.shortestPath;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cc.cc1234.datastructure.graph.imp.Edge;
import cc.cc1234.datastructure.graph.imp.WeightGraph;
import cc.cc1234.datastructure.graph.imp.WeightGraphIterator;
import cc.cc1234.datastructure.heap.IndexMinHeap;
import cc.cc1234.util.Log;

/**
 * 单源最短路径算法
 * 限制条件	：处理的图中不能有负权边
 * 时间复杂度	：ElogV
 * 
 * @author vran1
 *
 */
public class Dijkstra {
	private static final Logger logger = LoggerFactory.getLogger(Dijkstra.class);

	private IndexMinHeap<Double> heap;
	private WeightGraph graph;
	private int start; // 求单源最短路径的起点
	private Double[] dist;
	private boolean[] marked;
	private List<Edge> from;

	public Dijkstra(WeightGraph graph, int start) {
		assert start >= 0 && start < graph.vertexs():"Illegal argument start = "+start;

		this.graph = graph;
		this.start = start;
		heap = new IndexMinHeap<>(Comparator.comparing(Double::doubleValue), graph.vertexs());
		from = new LinkedList<>();
		dist = new Double[graph.vertexs()];
		marked = new boolean[graph.vertexs()];

		Log.info(logger, ()->"init complete: graph.vertexs = "+graph.vertexs());
	}

	private void generate(int v) {
		marked[v] = true;
		dist[v] = 0.0;
		heap.insert(v, 0.0);
		while(!heap.isEmpty()) {
			int idx = heap.getMinIndex();
			marked[idx] = true;
			WeightGraphIterator iterator = graph.iterator(idx);
			while(!iterator.end()) {
				Edge min = iterator.next();
				int w = min.other(idx);
				if(!marked[w]) {
					if(dist[min.getTo()] == null || dist[min.getTo()] < dist[min.getFrom()]+min.getWeight()) {
						dist[min.getTo()] = dist[min.getFrom()]+min.getWeight();
					}
				}
			}

		}
	}

	/**
	 * 从 start --> to 节点的路径长度
	 * @param to
	 * @return
	 */
	public Double shortestPathLength(int to) {
		// TODO
		return null;
	}

	public List<Integer> shortestPath(int to){
		// TODO
		return null;
	}

	/**
	 * 是否存在到to节点的路径
	 * @param to
	 * @return
	 */
	public boolean exists(int to) {
		// TODO
		return false;
	}

	public static void main(String[] args) {
		//TODO

	}
}	
