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
