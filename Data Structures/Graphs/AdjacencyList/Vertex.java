package com.graph;

public class Vertex {
    String name;
    Neighbor neighbor;
    public Vertex(String name,Neighbor neighbor) {
        this.name = name;
        this.neighbor = neighbor;
    }
}
