package javaproject.tree;

import java.util.ArrayList;
import java.util.List;

public class TreeMain {
    public TreeMain() {
        super();
    }
    
    public static void main(String[] args){
        int[] array = {1,2,3,4,5};
        Tree tree = new Tree(array);
        //tree.traversal();
        //In Order
        // 4 2 5 1 6 3 7 
        // Pre Order
        // 1 2 4 5 3 6 7 
        // Post Order
        // 4 5 2 6 7 3 1
        //tree.traversalIteration();
//        List l = new ArrayList();
//        tree.printAllPath(l);
        //tree.convert();
    //tree.levelOrder(null);
        //tree.leafCount();
        //tree.printSpiral();
        //tree.heightBalanced();
        //twosum(array,5);
        //tree.sum();
        //tree.doubleTree();
        //tree.getWidth();
        //tree.getWidthQueue();
        tree.printKRoot();
    }
    private static List twosum(int[] array, int sum){
        int i=0;
        int j=0;
        int s=0;
        List l = new ArrayList();
        while(i<array.length){
            j = i+1;
            while(j<array.length){
                s = array[i] + array[j];
                if(s == sum){
                    l.add(array[i] + ", "+ array[j]);
                }
                j++;
            }
            i++;
        }
        return l;
    }
}
