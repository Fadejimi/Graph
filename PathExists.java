/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab12;

import java.util.Stack;

/**
 *
 * @author Fadejimi
 */
public class PathExists {
    private Graph graph;
    
    public PathExists(Graph graph) {
        this.graph = graph;
    }
    
    public boolean pathExists(Vertex v1, Vertex v2) {
        DepthFirstSearch dfs = new DepthFirstSearch(graph);
        //dfs.handleInitialVertex(v1);
        
        Vertex v = dfs.nextUnvisitedAdjacent(v1);
        while (v != null) {
            if (v == v2) return true;
            v = dfs.nextUnvisitedAdjacent(v1);
        }
        return false;
        
    }
}
