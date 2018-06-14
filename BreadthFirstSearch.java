/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab12;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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
            processVertix(start);
            queue.add(start);
        }
    }

    @Override
    protected void singleComponentLoop() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    
    protected void processVertix(Vertex v) {
        
    }
    
    protected void setHasBeenVisited(Vertex v) {
        this.visitedVertices.put(v, v);
    }
    
    
}
