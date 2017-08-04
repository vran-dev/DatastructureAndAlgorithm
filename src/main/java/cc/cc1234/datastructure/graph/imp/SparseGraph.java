package cc.cc1234.datastructure.graph.imp;

import java.util.ArrayList;
import java.util.List;

import cc.cc1234.datastructure.graph.Graph;
import cc.cc1234.datastructure.graph.GraphIterator;

/**
 * 稀疏图
 * @author vran1
 *
 */
public class SparseGraph implements Graph{
	private List<List<Integer>> linked;
	private int vertexs;
	private int edges;
	private boolean direct;
	
	public SparseGraph(int capacity) {
		this(capacity,  false);
	}

	public SparseGraph(int capacity, boolean direct) {
		this.direct = direct;
		linked = new ArrayList<>(capacity);
		vertexs = capacity;
		for(int i=0; i < capacity ;i++) {
			linked.add(new ArrayList<Integer>());
		}
	}
	
	public boolean addEdge(int v, int w) {
		if(hasEdge(v, w)) {
			return false;
		}
		linked.get(v).add(w);
		if(v!=w && !direct) {
			linked.get(w).add(v);
		}
		edges++;
		return true;
	}
	
	public boolean hasEdge(int v, int w) {
		for(int i=0;i<linked.get(v).size();i++) {
			if(linked.get(v).get(i)==w) {
				return true;
			}
		}
		return false;
	}
	
	public int vertexs() {
		return vertexs;
	}
	
	public int edges() {
		return edges;
	}

	@Override
	public GraphIterator iterator(int v) {
		return new GraphIteratorImp(v);
	}
	
	private class GraphIteratorImp implements GraphIterator{
		private int v;
		private int index;
		
		public GraphIteratorImp(int v) {
			this.v = v;
		}

		@Override
		public int begin() {
			index = 0;
			return linked.get(v).get(0);
		}

		@Override
		public int next() {
			if(index < linked.get(v).size()) {
				return linked.get(v).get(index++);
			}
			return -1;
		}

		@Override
		public boolean end() {
			return index == linked.get(v).size();
		}
		
	}
}
