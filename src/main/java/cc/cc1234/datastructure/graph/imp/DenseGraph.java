package cc.cc1234.datastructure.graph.imp;

import cc.cc1234.datastructure.graph.Graph;
import cc.cc1234.datastructure.graph.GraphIterator;

/**
 * 稠密图：使用邻接矩阵实现
 * @author vran
 */
public class DenseGraph implements Graph{
	private boolean[][]  matrix;
	// 有向性
	private boolean direct;
	
	private int vertexs;
	private int edges;
	
	public DenseGraph(int capacity) {
		this(capacity,false);
	}
	
	public DenseGraph(int capacity, boolean direct) {
		vertexs = capacity; 
		matrix = new boolean[capacity][capacity];
		this.direct = direct;
	}
	
	public boolean addEdge(int v, int w) {
		if(!hasEdge(v, w)) {
			matrix[v][w]=true;
			if(!direct) {
				matrix[w][v]=true;
			}
			edges++;
			return true;
		}
		return false;
	}
	
	public int vertexs() {
		return vertexs;
	}
	
	public int edges() {
		return edges;
	}
	
	public boolean hasEdge(int v, int w) {
		return matrix[v][w];
	}

	@Override
	public GraphIterator iterator(int v) {
		return new GraphIteratorImp(v);
	}
	
	private class GraphIteratorImp implements GraphIterator{
		private int v;
		private int index = -1;
		
		public GraphIteratorImp(int v) {
			this.v = v;
		}

		@Override
		public int begin() {
			for(index = 0 ; index < matrix[v].length ;index++) {
				if(matrix[v][index]) {
					return index;
				}
			}
			return -1;
		}

		@Override
		public int next() {
			for(index=index+1 ; index < vertexs ;index++) {
				if(matrix[v][index]) {
					return index;
				}
			}
			return -1;
		}

		@Override
		public boolean end() {
			return index >= vertexs;
		}
		
	}
	
}
