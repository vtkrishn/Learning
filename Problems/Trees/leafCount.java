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
