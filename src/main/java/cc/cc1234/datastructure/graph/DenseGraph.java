package cc.cc1234.datastructure.graph;


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
		private int index;
		
		public GraphIteratorImp(int v) {
			this.v = v;
		}

		@Override
		public int begin() {
			index = 0;
			for(int i = 0 ; i < matrix[v].length ;i++) {
				if(matrix[v][i]) {
					return i;
				}
			}
			return -1;
		}

		@Override
		public int next() {
			for(int i = index ; i < matrix[v].length ;i++) {
				if(matrix[v][i]) {
					index = i+1;
					return i;
				}
			}
			return -1;
		}

		@Override
		public boolean end() {
			for(int i = matrix[v].length-1; i>=0 ;i--) {
				if(matrix[v][i]) {
					return i == index;
				}
			}
			return false;
		}
		
	}
	
}
