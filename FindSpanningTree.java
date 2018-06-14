/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab12;

import java.util.ArrayList;

/**
 *
 * @author Fadejimi
 */
public class FindSpanningTree extends DepthFirstSearch {
	private ArrayList<Edge> tree = new ArrayList<Edge>();
	public FindSpanningTree(Graph graph) {
		super(graph);
	}
	protected void processEdge(Edge e) {
			tree.add(e);
	}

	public Graph computeSpanningTree() {
		start();
		//tree is loaded
		Edge[] edges = tree.toArray(new Edge[0]);
		Graph newG  = new Graph(edges);
		return newG;
	}



}
