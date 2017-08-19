package cc.cc1234.algorithm.graph.minumTree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import cc.cc1234.datastructure.graph.imp.Edge;
import cc.cc1234.datastructure.graph.imp.WeightGraph;
import cc.cc1234.datastructure.graph.imp.WeightGraphIterator;
import cc.cc1234.datastructure.heap.IndexMinHeap;
import cc.cc1234.util.Log;

/*
 * 最小生成树
 * LazyPrim算法的优化版本
 */
public class OptimizePrim implements MinumTree{
	private static final Log log = Log.getInstance(OptimizePrim.class);
	
	private IndexMinHeap<Edge> heap;
//	private Edge[] edgeTo;
	private WeightGraph graph;
	private List<Edge> edges;
	private boolean[] marked;

	public OptimizePrim(WeightGraph graph) {
		this.graph = graph;
		edges = new ArrayList<>();
		marked = new boolean[graph.vertexs()];
//		edgeTo = new Edge[graph.vertexs()];
		heap = new IndexMinHeap<>(Comparator.comparingDouble(Edge::getWeight),graph.vertexs());
	}
	
	@Override
	public double weight() {
		return  edges.stream().mapToDouble((e)->e.getWeight()).sum();
	}
	
	@Override
	public List<Edge> generate() {
		edges.clear();
		visit(0);
		while(!heap.isEmpty()) {
			Edge min = heap.popMin();
			log.debug(()->"Min cut edge: "+min);
			edges.add(min);
			visit(min.getTo());
		}
		return edges;
	}
	
	private void visit(int v) {
		if(!marked[v]) {
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
		}
	}

	private static Logger getLogger(Class<?> t,Function<Class<?>, Logger> function) {
		return function.apply(t);
	}
}
