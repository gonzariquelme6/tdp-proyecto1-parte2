package parte2;

public class Prueba {
	public static void main(String[] args) {
		Graph g = new Graph();
		g.addNode(1);
		g.addNode(4);
		g.addNode(10);
		g.addNode(15);
		
		g.addEdge(1, 4);
		g.addEdge(1, 10);
		g.addEdge(4, 15);
		
		g.removeNode(4);
		g.removeEdge(4, 15);
	}
}
