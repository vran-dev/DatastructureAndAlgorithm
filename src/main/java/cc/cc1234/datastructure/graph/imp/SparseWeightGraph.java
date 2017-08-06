package cc.cc1234.datastructure.graph.imp;

import java.util.LinkedList;
import java.util.List;

import cc.cc1234.datastructure.graph.GraphIterator;

/**
 * 稀疏带权图
 * @author vran1
 *
 */
public class SparseWeightGraph implements WeightGraph{
	private List<List<Edge>> graph;
	private int vertexs;
	private int edges;
	private boolean directed;
	
	public SparseWeightGraph(int vertexs) {
		this(vertexs, false);
	}

	public SparseWeightGraph(int vertexs, boolean directed) {
		this.vertexs = vertexs;
		this.directed = directed;
		graph = new LinkedList<>();
		for(int i = 0; i < vertexs; i++) {
			graph.add(new LinkedList<>());
		}
	}

	@Override
	public boolean addEdge(int from, int to, double weight) {
		assert from>=0 && from<vertexs:"Argument \"from\" is invalid"; 
		assert to>=0 && to<vertexs:"Argument \"to\" is invalid"; 
		
		Edge edge = new Edge(from, to, weight);
		graph.get(from).add(edge);
		if(!directed) {
			Edge other = new Edge(to, from, weight);
			graph.get(to).add(other);
		}
		edges++;
		return true;
	}

	@Override
	public int vertexs() {
		return vertexs;
	}

	@Override
	public int edges() {
		return edges;
	}

	@Override
	public boolean contains(int from, int to) {
		assert from>=0 && from<vertexs:"Argument \"from\" is invalid"; 
		assert to>=0 && to<vertexs:"Argument \"to\" is invalid"; 
		
		for(int i = 0;i<graph.get(from).size();i++) {
			if(graph.get(from).get(i).to == to) {
				return true;
			}
		}
		return false;
	}

	@Override
	public double weight(int from, int to) {
		assert from>=0 && from<vertexs:"Argument \"from\" is invalid"; 
		assert to>=0 && to<vertexs:"Argument \"to\" is invalid"; 
		
		for(int i = 0;i<graph.get(from).size();i++) {
			if(graph.get(from).get(i).to == to) {
				return graph.get(from).get(i).weight;
			}
		}
		return -1;
	}

	@Override
	public boolean directed() {
		return directed;
	}

	@Override
	public WeightGraphIterator iterator(int v) {
		return new GrapIteratorImp(v);
	}
	
	private class GrapIteratorImp implements WeightGraphIterator{
		int index;
		int v;
		
		public GrapIteratorImp(int v) {
			this.v = v;
		}

		@Override
		public Edge begin() {
			index = 0;
			if(graph.get(v).get(index) != null) {
				return graph.get(v).get(0);
			}
			return null;
		}

		@Override
		public Edge next() {
			for(;index<graph.get(v).size();index++) {
				Edge edge = graph.get(v).get(index);
				if(edge!=null) {
					index++;
					return edge;
				}
			}
			return null;
		}

		@Override
		public boolean end() {
			return index >= graph.get(v).size();
		}
		
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FROM \t TO \r\n");
		for(int i = 0; i < graph.size();i++) {
			builder.append(" ").append(i).append("\t");
			for(Edge edge:graph.get(i)) {
				builder.append(" ").append(edge.to).append(" ");
			}
			builder.append("\r\n");
		}
		return builder.toString();
	}
}
