package cc.cc1234.algorithm.graph.minumTree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cc.cc1234.datastructure.graph.imp.Edge;
import cc.cc1234.datastructure.graph.imp.WeightGraph;
import cc.cc1234.datastructure.graph.imp.WeightGraphIterator;
import cc.cc1234.datastructure.heap.MinHeap;
import cc.cc1234.util.Log;

/**
 * 最小生成树算法--LazyPrim:
 * 基于切分定理
 * @author vran1
 *
 */
public class LazyPrim implements MinumTree{
	private static final Log log = Log.getInstance(LazyPrim.class);
	
	private WeightGraph graph;
	
	private MinHeap<Edge> minHeap;
	
	private List<Edge> edges;
	private boolean[] marked;
	
	public LazyPrim(WeightGraph graph) {
		this.graph = graph;
		marked = new boolean[graph.vertexs()];
		edges = new ArrayList<>(graph.vertexs()-1);
		minHeap = new MinHeap<>(graph.edges(),Comparator.comparingDouble(Edge::getWeight));  
	}
	
	@Override
	public List<Edge> generate() {
		edges.clear();
		visit(0);
		while(!minHeap.isEmpty()){
			Edge min = minHeap.min();
			if(!marked[min.getTo()]) {
				edges.add(min);
				visit(min.getTo());
			}
		}
		log.debug(()->"Generate tree complete: "+edges.toString());
		return edges;
	}
	
	private void visit(int v) {
		marked[v] = true;
		WeightGraphIterator iterator = graph.iterator(v);
		while(!iterator.end()) {
			Edge edge = iterator.next();
			if(!marked[edge.other(v)]) {
				minHeap.insert(edge);
			}
		}
	}
	
	
	/**
	 * 最小生成树的总权值
	 * @return
	 */
	@Override
	public double weight() {
		return edges.stream().mapToDouble((e)->e.getWeight()).sum();
	}
}
