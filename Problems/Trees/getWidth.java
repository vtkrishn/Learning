
public void getWidth(){
    int max = 0;
    int h = height(root);
    for(int i=1;i<=h;i++){
        max = Math.max(max,getWidth(root,i));
    }
    System.out.println(max);
}

public int getWidth(Node root,int i){
    if(root == null)
        return 0;
    if(i==1)
        return 1;
    else if(i > 1)
        return getWidth(root.left,i-1) + getWidth(root.right,i-1);
    return 0;
}

public int getWidthQueue(){
    Deque q = new ArrayDeque();
    q.push(root);
    int res = 0;
    while(!q.isEmpty()){
        int count = q.size();
        res = Math.max(count,res);
        while(count>0){
            count = count -1;
            Node n = (Node)q.removeFirst();
            if(n.left != null)
                q.push(n.left);
            if(n.right != null)
                q.push(n.right);
        }
    }
    System.out.println(res);
    return res;
}
