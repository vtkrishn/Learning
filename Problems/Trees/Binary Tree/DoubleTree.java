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
