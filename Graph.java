package parte2;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.Filter;


public class Graph{
	protected List<Integer> nodes;
	protected List<Edge> edges;
	private static Logger logger;
	public Graph(){
		nodes = new ArrayList<Integer>();
		edges = new ArrayList<Edge>();
		if (logger==null) {
			logger = Logger.getLogger(Graph.class.getName());
			
			Handler hnd = new ConsoleHandler();
			hnd.setLevel(Level.FINE);
			logger.addHandler(hnd);
			
			logger.setLevel(Level.WARNING);
			
			Logger rootLogger  = logger.getParent();
			for(Handler h: rootLogger.getHandlers()) {
				h.setLevel(Level.OFF);
			}
		}
	}
	
	public void addNode(int node) {
		if (!nodes.contains(node)) {
			nodes.add(node);
			logger.info("Se ha agregado el nodo "+ node+" al grafo.");
		}else {
			logger.warning("El nodo recibido ya pertenecia al grafo.");
		}
	}
	
	public void addEdge(int node1, int node2) {
		boolean encontre=false;
		Edge nuevo = new Edge(node1,node2);
		if (nodes.contains(node1) && nodes.contains(node2)) {
			if (edges.size()>0) {
				for (int i=0;i<edges.size() && !encontre;i++){
					if (edges.get(i).equals(nuevo))
						encontre=true;
				}
			}
			if (!encontre) {
				edges.add(nuevo);
				logger.info("Se ha agregado el arco entre "+node1+" y "+node2+" al grafo.");
			}else {
				logger.warning("El arco entre "+node1+" y "+node2+" ya pertenecia al grafo");
			}
		}
	}
	
	public void removeNode(int node) {
		int index;
		if (nodes.contains(node)) {
			index = nodes.indexOf(node);
			nodes.remove(index);
			logger.info("Se ha removido el nodo "+node+" del grafo.");
		}else {
			logger.warning("El nodo "+node+"no pertenecia al grafo, por lo tanto no se lo elimino.");
		}
	}
	
	public void removeEdge(int node1, int node2) {
		if (nodes.contains(node1) && nodes.contains(node2)) {
			Edge buscado = new Edge(node1,node2);
			boolean encontre=false;
			if (edges.size()>0) {
				for (int i=0;i<edges.size() && !encontre;i++){
					if (edges.get(i).equals(buscado)) {
						encontre=true;
						edges.remove(i);
						logger.info("Se ha removido el arco entre "+node1+" y "+node2+" del grafo.");
					}
				}
			}else{
				logger.warning("No se elimino el arco entre "+node1+" y "+node2+" porque no pertenecia al grafo.");
			}
			if (!encontre)
				logger.warning("No se elimino el arco entre "+node1+" y "+node2+" porque no pertenecia al grafo.");
		}else {
			logger.warning("No se elimino el arco entre "+node1+" y "+node2+" porque al menos uno de los nodos no pertenece al grafo.");
		}
	}
}