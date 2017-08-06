package cc.cc1234.algorithm.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import cc.cc1234.datastructure.graph.imp.Edge;
import cc.cc1234.datastructure.graph.imp.SparseWeightGraph;
import cc.cc1234.datastructure.graph.imp.WeightGraph;
import cc.cc1234.datastructure.graph.imp.WeightGraphIterator;
import cc.cc1234.datastructure.heap.MinHeap;

/**
 * 最小生成树算法--LazyPrim:
 * 基于切分定理
 * @author vran1
 *
 */
public class LazyPrim {
	
	private WeightGraph graph;
	
	private MinHeap<Edge> minHeap;
	
	private List<Edge> edges;
	private boolean[] marked;
	
	public LazyPrim(WeightGraph graph) {
		this.graph = graph;
		marked = new boolean[graph.vertexs()];
		edges = new ArrayList<>(graph.vertexs()-1);
		minHeap = new MinHeap<>(graph.edges(), new Comparator<Edge>() {

			@Override
			public int compare(Edge from, Edge to) {
				return from.getWeight() == to.getWeight() ? 0 : from.getWeight()>to.getWeight()?1:-1;
			}
			
		} );  
	}
	
	public List<Edge> minumTree(){
		edges.clear();
		visit(0);
		while(!minHeap.isEmpty()){
			Edge min = minHeap.min();
			if(!marked[min.getTo()]) {
				edges.add(min);
				visit(min.getTo());
			}
		}
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
	 * 最小生成树的所有节点
	 * @return
	 */
	public List<Integer> vertexs(){
		return null;
	}
	
	/**
	 * 最小生成树的总权值
	 * @return
	 */
	public double weight() {
		double sum = 0;
		for(Edge edge:edges) {
			sum += edge.getWeight();
		}
		return sum;
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
		LazyPrim lazyPrim = new LazyPrim(graph);
		List<Edge> minumTree = lazyPrim.minumTree();
		System.out.println(minumTree);
		System.out.println(lazyPrim.weight());
	}
}
