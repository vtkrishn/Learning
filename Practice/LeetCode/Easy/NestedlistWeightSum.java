public int depthSum(List<NestedInteger> nestedList) {
    return helper(nestedList, 1);
}

public int helper(List<NestedInteger> nestedList, int depth){
    if(nestedList==null||nestedList.size()==0)
        return 0;

    int sum=0;
    for(NestedInteger ni: nestedList){
        if(ni.isInteger()){
            sum += ni.getInteger() * depth;
        }else{
            sum += helper(ni.getList(), depth+1);
        }
    }

    return sum;
}

----------------------
public int depthSum(List<NestedInteger> nestedList) {
   LinkedList<NestedInteger> queue = new LinkedList<NestedInteger>();
   LinkedList<Integer> depth = new LinkedList<Integer>();
   for(int i=0;i<nestedList.size();i++){
		queue.offer(nestedList.get(i));
		depth.offer(1);
   }

   while(!queue.isEmpty()){
	 NestedInteger nest = queue.poll();
	 Integer dep = depth.poll();
	 if(nest.isInteger()){
		sum = sum + dep * nest.getInteger();
	 }
	 else{
		for(int i=0;i<nest.size();i++){
			queue.offer(nest.get(i));
			depth.offer(dep + 1);
		}
	 }
   }
   return sum;
}
