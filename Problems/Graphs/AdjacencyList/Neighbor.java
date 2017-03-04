package com.graph;

public class Neighbor {
    int index;
    Neighbor next;
    public Neighbor(int index, Neighbor next) {
        this.index = index;
        this.next = next;
    }
}
