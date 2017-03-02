package javaproject;

public class Class1 {
    public Class1() {
        super();
    }

    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11};
        TreeNode node = TreeNode.createTree(arr);
        findDistance(node,4,7,arr);
        System.out.println(findDistance(node,4,5,arr));//2
        System.out.println(findDistance(node,6,7,arr));//2
        System.out.println(findDistance(node,8,11,arr));//6
        System.out.println(findDistance(node,10,11,arr));//2
        System.out.println(findDistance(node,8,7,arr));//5
        System.out.println(findDistance(node,9,6,arr));//5
        System.out.println(findDistance(node,8,10,arr));//6

    }

    private static int getIndex(TreeNode root,int a,int[] array,int depth){

        if(a == root.value)
            return depth;
        int index = 0;
        for(int i=1;i<array.length;i++){
            if(array[i] == a)
                index = i;//index = (i % 2 == 0) ? i : i + 1;
                break;
        }
        return getIndex(root,array[index/2], array,depth + 1);
    }

    private static int findDistance(TreeNode root, int a, int b,int[] array){

        if(root == null)
            return 0;
        int aIndex = 0;
        int bIndex = 0;
        //find the parent of both - i/2
        //find the index of a in array - 2i
        //find the index of b in array - 2i+1
        for(int i=1;i<array.length;i++){
            if(array[i] == a){
                aIndex = (i % 2 == 0) ? i : i + 1;
                continue;
            }
            if(array[i] == b){
                bIndex = (i % 2 == 0) ? i : i + 1;
                continue;
            }

            if(aIndex > 0 && bIndex > 0)
                break;
        }

        if(aIndex/2 == bIndex/2)
            return 2;

        int aDepth = getIndex(root,array[aIndex/2],array,0);
        int bDepth = getIndex(root,array[bIndex/2],array,0);

        return aDepth + bDepth;
    }
}
