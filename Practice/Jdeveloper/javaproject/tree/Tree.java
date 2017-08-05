package javaproject.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

public class Tree {
    int[] elements;
    Node root;
    public Tree(int[] array) {
        this.elements = array;
        createTreeNode();
    }
    
    public void convert(){
        if(root == null)
            return;
        concatenate(root,null);
    }
    
    public void levelOrder(Node r){
        int h = height(root);
        for(int i=0;i<=h;i++){
            levelOrder(root,0,i);
            System.out.println("");
        }
    }
    
    public void printKRoot(){
            printKRoot(root,2);
    }
    
    public void printKRoot(Node root, int k){
        if(root == null)
            return;
        if(k == 0){
            System.out.println(root.value);
            return;
        }
        else{
            printKRoot(root.left, k-1);
            printKRoot(root.right, k-1);
        }
    }
    
    public void getWidth(){
        int max = 0;
        int h = height(root);
        for(int i=1;i<=h;i++){
            max = Math.max(max,getWidth(root,i));
        }
        System.out.println(max);
    }
    
    public int getWidth(Node root,int i){
        if(root == null)
            return 0;
        if(i==1)
            return 1;
        else if(i > 1)
            return getWidth(root.left,i-1) + getWidth(root.right,i-1);
        return 0;
    }
    
    public int getWidthQueue(){
        Deque q = new ArrayDeque();
        q.push(root);
        int res = 0;
        while(!q.isEmpty()){
            int count = q.size();
            res = Math.max(count,res);
            while(count>0){
                count = count -1;
                Node n = (Node)q.removeFirst();
                if(n.left != null)
                    q.push(n.left);
                if(n.right != null)
                    q.push(n.right);
            }
        }
        System.out.println(res);
        return res;
    }
    
    
    
    public void doubleTree(){
        doubleTree(root);    
        inOrderRecursion(root);
    }
    
    public void doubleTree(Node root){
        if(root == null)
            return;
        doubleTree(root.left);
        doubleTree(root.right);
        Node left = root.left;
        root.left = new Node(root.value);
        root.left.left = left;
    }
    
    public void sum(){
        System.out.println(sum(root,4));
    }
    
    public boolean sum(Node root, int sum){
        if(root == null)
            return sum == 0;
        int diff = sum-root.value;
        if(diff == 0 && root.left == null && root.right==null)
            return true;
        return (sum(root.left,diff) || sum(root.right,diff));
    }
    
    public void heightBalanced(){
        System.out.println(heightBalanced(root));
    }
    
    public boolean heightBalanced(Node root){
        if(root == null)
            return true;
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.abs(lh-rh) <= 1 && heightBalanced(root.left) && heightBalanced(root.right);
    }
    
    
    public void printSpiral(){
//        Deque s = new ArrayDeque();
//        s.add(root);
//        int height = 0;
//        while(!s.isEmpty()){
//           if(s.isEmpty())
       // }
    }
    
    public void leafCount(){
        System.out.println(leafCount(root));
    }
    public int  leafCount(Node root){
        if(root == null)
            return 0;
        if(root.left == null && root.right==null)
            return 1;    
        return leafCount(root.left) + leafCount(root.right);
    }
    
    public void levelOrder(Node r,int level,int i){
        if(r == null)
            return;
        if(level == i)
            System.out.print(r.value);
        level=level+1;
        
        levelOrder(r.left, level,i);
        levelOrder(r.right, level,i);
    }
    public int height(Node root){
        if(root == null)
            return 0;
        return Math.max(height(root.left),height(root.right)) + 1;
    }
    public void concatenate(Node left, Node right){
        if(left == null && right == null)
           return; 
        if(left != null){
            concatenate(left.left,left.right);
            left.right = left;
        }
        
        if(right != null)
            concatenate(right.left,right.right);
            //right.left = right;            
    }
    
//    public int LCA(Node root, Node node1,Node node2){
//        if(root == null)
//            return 0;
//        if(node1.value < root.value && node2.value < root.value)
//            LCA(root.left,node1,node2);
//        if(node1.value > root.value && node2.value > root.value)
//            LCA(root.right,node1,node2);
//        return root;
//    }
    
    
    public void printAllPath(List l){
        if(root == null)
            return;
        printAllPathHelp(root,l);
    }
    public void printAllPathHelp(Node root, List l){
        if(root == null)
            return;
        l.add(root.value);
        if(root.left == null && root.right == null){
            for(int i = 0 ;i<l.size();i++){
                System.out.print(l.get(i));
            }
            System.out.println("");
        }
        else{
            printAllPathHelp(root.left,l);
            l.remove(root.left.value);
            printAllPathHelp(root.right,l);
            l.remove(root.right.value);
        }
    }
    
    public void traversalIteration(){
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println("In Order");
        inOrderIteration();
        System.out.println("\nPre Order");
        preOrderIteration();
        System.out.println("\nPost Order");
        //postOrderIteration();
    }
    
    
    public void traversal(){
        System.out.println("In Order");
        inOrderRecursion(root);
        System.out.println("\nPre Order");
        preOrderRecursion(root);
        System.out.println("\nPost Order");
        postOrderRecursion(root);
    }
    
    
    private void preOrderIteration(){
        Deque<Node> stack = new ArrayDeque<Node>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node node = stack.peek();
            while(node.left != null){
             stack.push(node.left);
              node = node.left;
            }    
                    
            }
    }
    
    private void inOrderIteration(){
        Deque<Node> stack = new ArrayDeque<Node>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node node = stack.peek();
            while(node.left != null){
                stack.push(node.left);
                node = node.left;
            }
            System.out.print(node.value +" ");
            stack.pop();
            if(!stack.isEmpty()){
                node = stack.pop();
                System.out.print(node.value +" ");
                if(node.right != null){
                    stack.push(node.right);
                }
            }
        }
    }
    
    private void preOrderRecursion(Node r){
        if(r == null)
            return;
        System.out.print(r.value +" ");
        preOrderRecursion(r.left);
        preOrderRecursion(r.right);    
    }
    
    private void postOrderRecursion(Node r){
        if(r == null)
            return;
        postOrderRecursion(r.left);
        postOrderRecursion(r.right);    
        System.out.print(r.value +" ");
    }
    
    private void inOrderRecursion(Node r){
        if(r == null)
            return;
        inOrderRecursion(r.left);
        System.out.print(r.value +" ");
        inOrderRecursion(r.right);    
    }
    
    private void createTreeNode(){
        boolean flag = true;
        for(int i=0;i<elements.length;i++){
            if(root == null){
                root = new Node(elements[i]);
            }
            else{
                if(flag){
                    Node left = new Node(elements[i]);
                     if(root.left == null)
                        root.left = left;
                     else{
                        root.left.left = createNode(root.left,left,true);
                     }
                }
                else{
                    Node right = new Node(elements[i]);
                    if(root.right == null)
                       root.right = right;
                    else
                        root.left.right = createNode(root.left,right,false);
                    }
                flag = !flag;
            }
        }
//        root = new Node(1);
//        root.left = new Node(2);
//        root.right = new Node(3);
//        root.left.left = new Node(4);
//        root.left.right = new Node(5);
//        root.right.right = new Node(8);
//        root.right.right.left = new Node(6);
//        root.right.right.right = new Node(7);
//        root.left.left.left = new Node(14);
//        root.left.left.right = new Node(15);
    }
    
    private Node createNode(Node node,Node target,boolean flag){
        if(flag){
            node.left = target;
            return node.left;
        }
        else{
            node.right = target;
            return node.right;
        }
    }
    
    static class Node{
        int value;
        Node left;
        Node right;
        
        Node(int value){
            this.value = value;
        }
    }
}
