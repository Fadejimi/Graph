/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab12;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author Fadejimi
 */
public class BreadthFirstSearch extends AbstractGraphSearch {
    protected HashMap<Vertex, Vertex> visitedVertices = 
            new HashMap<>();
    Graph graph;
    Queue<Vertex> queue;
    List<Vertex> vertexes = null;
    Iterator<Vertex> iterator = null;
    HashMap<Vertex, LinkedList<Vertex>> adjancyList;
    protected int numVertexes;
    
    public BreadthFirstSearch(Graph g) {
        this.graph = g;
        this.queue = new LinkedList<>();
        vertexes = this.graph.vertices();
        iterator = vertexes.iterator();
        numVertexes = vertexes.size();
        adjancyList = graph.getAdjacencyList();
    }
    
    @Override
    protected boolean getHasBeenVisited(Vertex v) {
        return visitedVertices.containsKey(v);
    }

    @Override
    protected boolean someVertexUnvisited() {
        return visitedVertices.size() == numVertexes - 1;
    }

    @Override
    protected void handleInitialVertex() {
        Vertex v = nextUnvisited();
	handleInitialVertex(v);
    }
    
    

    @Override
    protected void handleInitialVertex(Vertex start) {
        if (start != null) {
            setHasBeenVisited(start);
            processVertex(start);
            queue.add(start);
        }
    }

    @Override
    protected void singleComponentLoop() {
        while (!queue.isEmpty()) {
            Vertex v = queue.remove();
            Set<Vertex> v_list = getUnvisitedAdjencyList(v);
            for (Vertex new_v : v_list) {
                setHasBeenVisited(new_v);
		processEdge(new Edge(queue.peek(),new_v));
		processVertex(new_v);
                queue.add(new_v);
            }
        }
    }

    @Override
    protected void additionalProcessing() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    protected Vertex nextUnvisited() {
        while(iterator.hasNext()) {
            Vertex next = iterator.next();
            if (!visitedVertices.containsKey(next)) {
                //visitedVertices.put(next, next);
                return next;
            }
        }
        return null;
    }
    
    public Set<Vertex> getUnvisitedAdjencyList(Vertex v) {
        Set<Vertex> vertexes = new HashSet<>();
        List<Vertex> adjVerts = this.adjancyList.get(v);
        Iterator<Vertex> it = adjVerts.iterator();
        
        while (it.hasNext()) {
            Vertex new_v = it.next();
            if (!getHasBeenVisited(new_v)) {
                it.remove();
            }
            else {
                vertexes.add(new_v);
                it.remove();
            }
        }
        
        return vertexes;
    }
    
    public void processVertex(Vertex v) {
        
    }
    
    public void setHasBeenVisited(Vertex v) {
        this.visitedVertices.put(v, v);
    }
    
    public void processEdge(Edge e) {
        
    }
}
