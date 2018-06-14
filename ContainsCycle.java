/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab12;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author Fadejimi
 */
public class ContainsCycle {
    private Graph graph;
    
    public ContainsCycle(Graph graph) {
        this.graph = graph;
    }
    
    public boolean containsCycle() {
        DepthFirstSearch dfs = new DepthFirstSearch(graph);
        dfs.handleInitialVertex();
        Stack<Vertex> stack = dfs.stack;
        
        while (!stack.isEmpty()) {
            Vertex v = stack.peek();
            HashMap<Vertex, Vertex> map = dfs.visitedVertices;

            List<Vertex> adjVertexList = graph.getListOfAdjacentVerts(v);
            for (Vertex adjVertex : adjVertexList) {
                if (map.containsKey(adjVertex)) return true;
            }
            
            Vertex v2 = dfs.nextUnvisitedAdjacent(v);
            if (v2 == null) stack.pop();
            else {
                dfs.setHasBeenVisited(v2);
                dfs.processEdge(new Edge(stack.peek(),v));
                dfs.processVertex(v);
                stack.push(v);
            }
            
        }
        
        return false;
    }
}
