package com.home.graph.one;

/**
 * Graph Representation by Adjacency Matrix.
 * <p>
 * It takes Space: O(v^2) & Time to initialize: O(v^2)
 */
public class GraphAdjMat {

    private boolean adjMatrix[][];
    private int vertexCount;

    // constructor with parameter
    GraphAdjMat(int vertexCount) {
        this.vertexCount = vertexCount;
        adjMatrix = new boolean[vertexCount][vertexCount];
    }

    // add edge at vertices i, j
    public void addEdge(int i, int j) {
        if (i >= 0 && i < vertexCount && j >= 0 && j < vertexCount) {
            adjMatrix[i][j] = true;
            adjMatrix[j][i] = true;
        }
    }

    // remove edge
    public void removeEdge(int i, int j) {
        if (i >= 0 && i < vertexCount && j >= 0 && j < vertexCount) {
            adjMatrix[i][j] = false;
            adjMatrix[j][i] = false;
        }
    }

    // check edge is exist
    public boolean isEdge(int i, int j) {
        if (i >= 0 && i < vertexCount && j >= 0 && j < vertexCount) {
            return adjMatrix[i][j];
        }
        else {
            return false;
        }
    }
}
