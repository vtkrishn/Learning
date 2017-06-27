import java.util.*;

public class Main{

static class Node{
	Node left;
	Node right;
	int value;

	public Node(int data){
		this.value = data;
	}
}

public static void main(String[] args){
	Node n1 = new Node(1);
	Node n2 = new Node(2);
	Node n3 = new Node(3);
	Node n4 = new Node(4);
	Node n5 = new Node(5);
	Node n6 = new Node(6);
	Node n7 = new Node(7);
	Node n8 = new Node(8);

	n1.left = n2;
	n1.right = n3;

	n2.left = n4;
	n2.right = n5;

	n3.left = n6;
	n3.right = n7;

	n7.left = n8;

	List<Integer> maxPath = new ArrayList<>();
	List<Integer> curPath = new ArrayList<>();
	getHeight(n1,curPath,maxPath);
	System.out.println(maxPath.toString());
}

    public static void getHeight(Node root,List<Integer> curPath,List<Integer> maxPath){
        if(null == root) return;
	    curPath.add(root.value);

	    if(root.left == null && root.right == null)
	        if(curPath.size()>maxPath.size()){
	            maxPath.clear();
	            maxPath.addAll(curPath);
	            curPath.remove(curPath.size()-1);
	            return;
	        }

	    getHeight(root.left,curPath,maxPath);
	    getHeight(root.right,curPath,maxPath);
	    curPath.remove(curPath.size()-1);
	            return;
    }
}
