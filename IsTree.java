/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab12;

/**
 *
 * @author Fadejimi
 */
public class IsTree {
    private Graph graph;
    
    public IsTree(Graph graph) {
        this.graph = graph;
    }
    
    public boolean isTree() {
        IsConnected connected = new IsConnected(graph);
        if (connected.isConnected()) return false;
        return true;
    }
}
