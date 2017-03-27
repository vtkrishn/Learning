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
