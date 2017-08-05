package javaproject.tree;

public class TreeClient {
    Node root1,root2;
    public TreeClient() {
        super();
    }
    
    static class Node 
    {
        int data;
        Node left, right;
      
        Node(int item) 
        {
            data = item;
            left = right = null;
        }
    }
    
    /* A utility function to check whether trees with roots as root1 and
           root2 are identical or not */
        boolean areIdentical(Node root1, Node root2) 
        {
      
            /* base cases */
            if (root1 == null && root2 == null)
                return true;
      
            if (root1 == null || root2 == null)
                return false;
      
            /* Check if the data of both roots is same and data of left and right
               subtrees are also same */
            return (root1.data == root2.data
                    && areIdentical(root1.left, root2.left)
                    && areIdentical(root1.right, root2.right));
        }
      
        /* This function returns true if S is a subtree of T, otherwise false */
        boolean isSubtreeGeeks(Node T, Node S) 
        {
            /* base cases */
            if (S == null) 
                return true;
      
            if (T == null)
                return false;
      
            /* Check the tree with root as current node */
            if (areIdentical(T, S)) 
                return true;
      
            /* If the tree with root as current node doesn't match then
               try left and right subtrees one by one */
            return isSubtreeGeeks(T.left, S)
                    || isSubtreeGeeks(T.right, S);
        }
    
    
    public static boolean isSubTreeRatnakar(Node root, Node tree){
        if(root == null || tree == null)
                return true;
        else if(root == null && tree != null)
                return false;
        else {
                if(root.data == tree.data)
                        return (isSubTreeRatnakar(root.left, tree.left) && isSubTreeRatnakar(root.right,tree.right));
                else
                        return (isSubTreeRatnakar(root.left, tree) || isSubTreeRatnakar(root.right,tree));
         }
                    
    }
    
    public static boolean isSubTreeVinod(Node root, Node tree){
            if(root == null || tree == null)
                            return true;
                    if(root.data != tree.data){
                            return isSubTreeVinod(root.left,tree)|| isSubTreeVinod(root.right,tree);
                    }
                    else{
                            if(root.left == null && root.right == null)
                                    return true;
                            if(root.left == null || root.right == null)
                                return false;
                            return isSubTreeVinod(root.left,tree.left) && isSubTreeVinod(root.left,tree.left);
                    }          
    }
    
    public static void main(String args[]) 
        {
            TreeClient tree = new TreeClient();
              
            // TREE 1
            /* Construct the following tree
                  26
                 /   \
                10     3
               /    \     \
              4      6      3
               \
                30  */
               
            tree.root1 = new Node(26);
            tree.root1.right = new Node(3);
            tree.root1.right.right = new Node(3);
            tree.root1.left = new Node(10);
            tree.root1.left.left = new Node(4);
            tree.root1.left.left.right = new Node(3);
            tree.root1.left.right = new Node(6);
      
            // TREE 2
            /* Construct the following tree
               10
             /    \
             4      6
              \
              30  */
               
            tree.root2 = new Node(10);
            tree.root2.right = new Node(6);
            tree.root2.left = new Node(4);
            tree.root2.left.right = new Node(30);
            
            if (tree.isSubtreeGeeks(tree.root1, tree.root2))
                System.out.println("Tree 2 is subtree of Tree 1 ");
            else
                System.out.println("Tree 2 is not a subtree of Tree 1");
            
            if (tree.isSubTreeVinod(tree.root1, tree.root2))
                System.out.println("Tree 2 is subtree of Tree 1 ");
            else
                System.out.println("Tree 2 is not a subtree of Tree 1");
            
            if (tree.isSubTreeRatnakar(tree.root1, tree.root2))
                System.out.println("Tree 2 is subtree of Tree 1 ");
            else
                System.out.println("Tree 2 is not a subtree of Tree 1");
        }
}
