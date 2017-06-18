package javaproject;

public class Solution78 {
    public Solution78() {
        super();
    }

    static class Node{
          int value;
          Node left;
          Node right;

          public Node(int data){
            this.value = data;
          }
        }

    public static void main(String[] args){
                Node node1 = new Node(1);
                Node node2 = new Node(2);
                Node node3 = new Node(3);
                Node node4 = new Node(4);
                Node node5 = new Node(5);

                node1.left = node2;
                node1.right = node3;
                node3.left = node4;
                node3.right = node5;

                printAncestor(node1,5);
    }

    public static boolean printAncestor(Node root, int value){
       if(root == null)
           return false;

       boolean left = printAncestor(root.left, value);
       boolean right = printAncestor(root.right, value);
       if(root.value == value)
           return true;

       if(left || right)
        System.out.println(root.value);

       return left || right;
    }
}
