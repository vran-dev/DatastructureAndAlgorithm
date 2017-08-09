package cc.cc1234.algorithm.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cc.cc1234.datastructure.graph.imp.Edge;
import cc.cc1234.datastructure.graph.imp.SparseWeightGraph;
import cc.cc1234.datastructure.graph.imp.WeightGraph;
import cc.cc1234.datastructure.graph.imp.WeightGraphIterator;
import cc.cc1234.datastructure.heap.IndexMinHeap;

/*
 * 最小生成树
 * LazyPrim算法的优化版本
 */
public class OptimizePrim {
	private static final Logger logger = getLogger(OptimizePrim.class, LoggerFactory::getLogger);
	
	private IndexMinHeap<Edge> heap;
	private WeightGraph graph;
	private List<Edge> edges;
	private boolean[] marked;
	
	public OptimizePrim(WeightGraph graph) {
		this.graph = graph;
		edges = new ArrayList<>();
		marked = new boolean[graph.vertexs()];
		heap = new IndexMinHeap<>((from,to)->from.getWeight() == to.getWeight()?0:from.getWeight()>to.getWeight()?1:-1,
				graph.vertexs());
		visit(0);
	}

	public double weight() {
		return  edges.stream().mapToDouble((e)->e.getWeight()).sum();
	}

	private void visit(int v) {
		marked[v] = true;
		WeightGraphIterator iterator = graph.iterator(v);
		while(!iterator.end()) {
			Edge edge = iterator.next();
			if(!marked[edge.getTo()]) {
				if(heap.get(edge.getTo()) == null) {
					heap.insert(edge.getTo(), edge);
				}else {
					if(heap.get(edge.getTo()).getWeight() > edge.getWeight()) {
						heap.change(edge.getTo(), edge);
					}
				}
			}
		}

		if(!heap.isEmpty()) {
			Edge min = heap.popMin();
			edges.add(min);
			visit(min.getTo());
		}

	}

	public List<Edge> minumTree(){
		return edges;
	}
	
	private static Logger getLogger(Class<?> t,Function<Class<?>, Logger> function) {
		return function.apply(t);
	}
	
	public static void main(String[] args) {
		SparseWeightGraph graph = new SparseWeightGraph(8);
		graph.addEdge(0, 2, 0.26);
		graph.addEdge(0, 4, 0.38);
		graph.addEdge(0, 6, 0.58);
		graph.addEdge(0, 7, 0.16);
		graph.addEdge(1, 2, 0.36);
		graph.addEdge(1, 3, 0.29);
		graph.addEdge(1, 5, 0.32);
		graph.addEdge(1, 7, 0.19);
		graph.addEdge(2, 3, 0.17);
		graph.addEdge(2, 6, 0.40);
		graph.addEdge(2, 7, 0.34);
		graph.addEdge(3, 6, 0.52);
		graph.addEdge(4, 5, 0.35);
		graph.addEdge(4, 6, 0.93);
		graph.addEdge(4, 7, 0.37);
		graph.addEdge(5, 7, 0.28);
		OptimizePrim prim = new OptimizePrim(graph);
		List<Edge> minumTree = prim.minumTree();
		System.out.println(minumTree);
		System.out.println(prim.weight());
	}
}
