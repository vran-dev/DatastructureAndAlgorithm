package cc.cc1234.algorithm.graph.shortestPath;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cc.cc1234.datastructure.graph.imp.Edge;
import cc.cc1234.datastructure.graph.imp.SparseWeightGraph;
import cc.cc1234.datastructure.graph.imp.WeightGraph;
import cc.cc1234.datastructure.graph.imp.WeightGraphIterator;
import cc.cc1234.util.Log;

/**
 * 贝尔曼-福特算法:相对于dijkstra算法，bellmanFord可以对有负权边的图进行最短路径的计算
 * 时间复杂度:O(E*V)
 * 		
 * @author vran
 *
 */
public class BellmanFord {
	private static final Logger logger = LoggerFactory.getLogger(BellmanFord.class);

	private WeightGraph graph;
	// 源节点
	private int source;
	// 最短路径记录
	private List<Integer>[] path;
	// 最短路径长度
	private Double[] dist;
	// 是否存在负权环
	private boolean hasNegativeCycle;
	private boolean[] marked;

	public BellmanFord(WeightGraph graph, int source) {
		assert source>=0:"Invalid argument source = "+source;
		assert graph!=null:"Invalid argument graph = "+graph;

		this.graph = graph;
		this.source = source;
		marked = new boolean[graph.vertexs()];
		dist = new Double[graph.vertexs()];
		path = new LinkedList[graph.vertexs()];
		for(int i = 0; i < path.length; i++) {
			path[i] = new LinkedList<>();
		}
		Log.info(logger, ()->"BellmanFord init complete");
		generate(source);
		Log.info(logger, ()->"BellmanFord path calc complete");
	}

	/**
	 * 没有负权环的版本
	 * 初始化计算得到最短路径相关信息
	 */
	private void generate(int source) {
		Queue<Integer> queue = new LinkedList<>();
		int[] count = new int[graph.vertexs()];
		dist[source] = 0.0;
		queue.add(source);
		
		while(!queue.isEmpty()) {
			Integer poll = queue.poll();
			count[poll] = ++count[poll];
			if(count[poll]>=graph.vertexs()) {
				Log.info(logger, ()->"This graph has negative cycle: break;");
				hasNegativeCycle = true;
				break;
			}
			WeightGraphIterator itr = graph.iterator(poll);
			while(!itr.end()) {
				Edge edge = itr.next();
				if(dist[edge.getTo()] == null || dist[edge.getTo()] > dist[edge.getFrom()]+edge.getWeight()) {
					dist[edge.getTo()] = dist[edge.getFrom()] + edge.getWeight();
					queue.add(edge.getTo());
				}
			}
			Log.info(logger, ()->"graph.iterator("+poll+"), dist[] = "+Arrays.toString(dist));
		}
		
	}

	public Double dist(int w) {
		return dist[w];
	}

	public List<Integer> path(int w){
		return path[w];
	}

	public boolean exists(int w) {
		return dist[w] != null;
	}

	public boolean hasNegativeCycle() {
		return hasNegativeCycle;
	}
	public static void main(String[] args) {
		WeightGraph graph = new SparseWeightGraph(5,true);
		graph.addEdge(0, 1, 2.0);
		graph.addEdge(0, 2, 4.0);
		graph.addEdge(0, 3, 3.0);
		graph.addEdge(1, 4, 4);
		graph.addEdge(2, 1, -3);
		graph.addEdge(2, 3, -2);
		graph.addEdge(2, 4, 2.0);
		graph.addEdge(3, 4, 1.0);
		graph.addEdge(4, 2, -2.0);
		BellmanFord bf = new BellmanFord(graph, 0);
		System.out.println(Arrays.toString(bf.dist));
		System.out.println(bf.hasNegativeCycle);
	}
}
