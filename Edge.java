package parte2;
public class Edge {
	protected int v1;
	protected int v2;
	
	public Edge(int v1, int v2) {
		this.v1=v1;
		this.v2=v2;
	}
	public int getFirstVertex(){
		return v1;
	}
	public int getSecondVertex(){
		return v2;
	}
	public void setFirstVertex(int v) {
		v1=v;
	}
	
	public void setSecondVertex(int v) {
		v2=v;
	}
}
