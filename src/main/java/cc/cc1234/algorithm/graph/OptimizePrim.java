package cc.cc1234.algorithm.graph;

import java.util.ArrayList;
import java.util.List;

import cc.cc1234.datastructure.graph.imp.Edge;
import cc.cc1234.datastructure.graph.imp.WeightGraph;
import cc.cc1234.datastructure.heap.IndexMinHeap;

/*
 * 最小生成树
 * LazyPrim算法的优化版本
 */
public class OptimizePrim {
	
	private IndexMinHeap<Edge> heap;
	private WeightGraph graph;
	private List<Edge> edges;
	
	public OptimizePrim(WeightGraph graph) {
		this.graph = graph;
		edges = new ArrayList<>();
		heap = new IndexMinHeap<>((from,to)->from.getWeight() == to.getWeight()?0:from.getWeight()>to.getWeight()?1:-1,
				graph.vertexs());
	}
	
	public double weight() {
		return  edges.stream().mapToDouble((e)->e.getWeight()).sum();
	}
	
	public List<Edge> minumTree(){
		return edges;
	}
	
	
}
