package cc.cc1234.datastructure.graph.imp;

/**
 * 带权图的边
 * @author vran1
 *
 */
public class Edge {
	int from;
	int to;
	double weight;
	
	public Edge(int from, int to, double weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
	
	public int other(int v) {
		assert v >=0 :"Argument \"v\" is invalid";
		return v == to?from:to;
	}

	public double getWeight() {
		return weight;
	}

	public int getFrom() {
		return from;
	}

	public int getTo() {
		return to;
	}

	@Override
	public String toString() {
		return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
	}
	
}
