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
import cc.cc1234.datastructure.union.QuickUnionV3;
import cc.cc1234.util.Log;

/**
 * 克鲁斯卡尔最小生成树算法
 * 
 * @author vran
 *
 */
public class Kruskal implements MinumTree{
	private static final Log log = Log.getInstance(Kruskal.class);
	private WeightGraph graph;
	private MinHeap<Edge> heap;
	private List<Edge> edges;
	private QuickUnionV3 union;
	public Kruskal(WeightGraph graph) {
		this.graph = graph;
		heap = new MinHeap<>(16, Comparator.comparingDouble(Edge::getWeight));
		union = new QuickUnionV3(graph.vertexs());
		edges = new ArrayList<>();
		log.debug(()->"Init complete edges = "+graph.edges()+", vertexs = "+graph.vertexs());
	}

	@Override
	public List<Edge>  generate() {
		edges.clear();
		visit();
		while(!heap.isEmpty() && edges.size()<graph.vertexs()) {
			Edge edge = heap.min();
			if(!union.isConnected(edge.getTo(), edge.getFrom())) {
				edges.add(edge);
				union.union(edge.getTo(), edge.getFrom());
			}
		}
		return edges;
	}

	private void visit() {
		for(int i=0;i<graph.vertexs();i++) {
			WeightGraphIterator iterator = graph.iterator(i);
			while(!iterator.end()) {
				Edge edge = iterator.next();
				if(edge.getFrom() < edge.getTo()) {
					heap.insert(edge);
				}
			}
		}
	}

	@Override
	public double weight() {
		return edges.stream().mapToDouble((e)->e.getWeight()).sum();
		//		return edges.stream().mapToDouble((e)->e.getWeight()).reduce(0.0,  (a,b)->a+b);
	}
}
