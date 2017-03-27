public void levelOrder(Node r){
    int h = height(root);
    for(int i=0;i<=h;i++){
        levelOrder(root,0,i);
        System.out.println("");
    }
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
