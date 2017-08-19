package cc.cc1234.datastructure.graph.imp;


/**
 * 稠密带权图
 * @author vran1
 *
 */
public class DenseWeightGraph implements WeightGraph{
	// 邻接矩阵
	private Edge[][] graph;
	// 定点数
	private int vertexs;
	// 边数
	private int edges;
	// 是否为有向图
	private boolean directed;
	
	public DenseWeightGraph(int vertexs) {
		this(vertexs, false);
	}

	public DenseWeightGraph(int vertexs, boolean directed) {
		this.vertexs = vertexs;
		this.directed = directed;
		graph = new Edge[vertexs][vertexs];
	}

	@Override
	public boolean addEdge(int from, int to, double weight) {
		assert from>=0 && from<vertexs:"Argument \"from\" is invalid"; 
		assert to>=0 && to<vertexs:"Argument \"to\" is invalid"; 
		
		Edge edge = new Edge(from, to, weight);
		graph[from][to] = edge;
		if(!directed) {
			Edge other = new Edge(to, from, weight);
			graph[to][from] = other;
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
		return graph[from][to] != null;
	}

	@Override
	public double weight(int from, int to) {
		return graph[from][to] != null ? graph[from][to].weight:-1;
	}

	@Override
	public boolean directed() {
		return directed;
	}

	@Override
	public WeightGraphIterator iterator(int v) {
		return new GraphIteratorImp(v);
	}
	
	private  class GraphIteratorImp implements WeightGraphIterator{
		int index;
		int v;
		
		public GraphIteratorImp(int v) {
			this.v = v;
		}

		@Override
		public Edge begin() {
			for(index = 0;index<vertexs;index++) {
				 if(graph[v][index] != null) {
					 return graph[v][index];
				 }
			}
			return null;
		}

		@Override
		public Edge next() {
			for(;index<vertexs;index++) {
				if(graph[v][index] != null) {
					Edge edge = graph[v][index];
					++index;
					return edge;
				}
			}
			return null;
		}

		@Override
		public boolean end() {
			return index >= vertexs;
		}
		
	}
	
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("From \t TO \r\n");
		for(int i = 0; i <graph.length; i++) {
			builder.append(" ").append(i).append("\t");
			for(int j = 0; j < graph[i].length; j++) {
				if(graph[i][j]!=null) {
					builder.append(graph[i][j].to).append(" ");
				}
			}
			builder.append("\r\n");
		}
		return builder.toString();
	}

}
