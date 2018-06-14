/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab12;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Fadejimi
 */
public class IsConnected {
    
    private Graph graph;
    
    public IsConnected(Graph graph) {
        this.graph = graph;
    }
    public boolean isConnected() {
        HashMap<Vertex, Vertex> vertexMap = new HashMap<>();
        DepthFirstSearch dfs = new DepthFirstSearch(graph);
        List<Vertex> vertexes = graph.vertices();
        
        dfs.singleComponentLoop();
        boolean flag = true;
        vertexMap = dfs.visitedVertices;
        for (Vertex v : vertexes) {
            if (!vertexMap.containsKey(v)) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
