public class Solution{
public static ListNode mergeKLists(ListNode[] lists){
    return partion(lists,0,lists.length-1);
}

public static ListNode partion(ListNode[] lists,int s,int e){
    if(s==e)  return lists[s];
    if(s<e){
        int q=(s+e)/2;
        ListNode l1=partion(lists,s,q);
        ListNode l2=partion(lists,q+1,e);
        return merge(l1,l2);
    }else
        return null;
}

    //This function is from Merge Two Sorted Lists.
    public static ListNode merge(ListNode l1,ListNode l2){
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1.val<l2.val){
            l1.next=merge(l1.next,l2);
            return l1;
        }else{
            l2.next=merge(l1,l2.next);
            return l2;
        }
    }
}
-----------------
//priorty Queue
public class Solution{
    public static ListNode mergeKLists(ListNode[] lists){

        if (lists==null||lists.length==0) return null;

        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1,ListNode o2){
                if (o1.val<o2.val)
                    return -1;
                else if (o1.val==o2.val)
                    return 0;
                else
                    return 1;
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode result = dummy;

        //add to pq first index of all the lists
        for(int i=0;i<lists.length;i++){
            if(lists[i] != null)
                pq.add(lists[i]);
        }

        //then compare and build the list
        while(!pq.isEmpty()){
            result.next = pq.poll();
            result = result.next;

            if(result.next != null)
                pq.add(result.next);
        }
        return dummy.next;
    }
}
