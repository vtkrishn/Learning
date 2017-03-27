public int LCA(Node root, Node node1,Node node2){
    if(root == null)
        return 0;
    if(node1.value < root.value && node2.value < root.value)
        LCA(root.left,node1,node2);
    if(node1.value > root.value && node2.value > root.value)
        LCA(root.right,node1,node2);
    return root;
}
