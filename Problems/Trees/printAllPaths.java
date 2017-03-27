public void printAllPath(List l){
    if(root == null)
        return;
    printAllPathHelp(root,l);
}
public void printAllPathHelp(Node root, List l){
    if(root == null)
        return;
    l.add(root.value);
    if(root.left == null && root.right == null){
        for(int i = 0 ;i<l.size();i++){
            System.out.print(l.get(i));
        }
        System.out.println("");
    }
    else{
        printAllPathHelp(root.left,l);
        l.remove(root.left.value);
        printAllPathHelp(root.right,l);
        l.remove(root.right.value);
    }
}
