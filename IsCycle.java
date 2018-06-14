/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab12;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author Fadejimi
 */
public class IsCycle {
    private Graph graph;
    
    public IsCycle(Graph graph) {
        this.graph = graph;
    }
    
    public boolean isCycle() {
        DepthFirstSearch dfs = new DepthFirstSearch(graph);
        dfs.handleInitialVertex();
        Stack<Vertex> stack = dfs.stack;
        Set<Vertex> cycleSet = new HashSet<>();
        int count = 0;
        
        while (!stack.isEmpty()) {
            Vertex v = stack.peek();
            cycleSet.add(v);
            count++;
            HashMap<Vertex, Vertex> map = dfs.visitedVertices;

            List<Vertex> adjVertexList = graph.getListOfAdjacentVerts(v);
            for (Vertex adjVertex : adjVertexList) {
                if (map.containsKey(adjVertex)) {
                    if (cycleSet.size() == count) return true;
                    else {
                        cycleSet.clear();
                        count = 0;
                    }
                    //return true;
                }
            }
            
            Vertex v2 = dfs.nextUnvisitedAdjacent(v);
            if (v2 == null) {
                stack.pop();
                cycleSet.clear();
                count = 0;
            }
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
