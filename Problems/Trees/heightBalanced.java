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
