//iterative
(function(exports){
    'use strict';

    console.clear();

    function ListNode(val) {
      this.val = val;
      this.next = null;
    }

    var mergeKLists = function(l) {
      var j = l.length;
      for(var i = 0;i<j;i++){
        while(i<j){
            l[i] = merge(l[i],l[j]);
            i++;
            j--;
          }
      }
      return l[0];
     };

    var merge = function (l1,l2){
      if(l1 === null)
        return l2;
      if(l2 === null)
        return l1;

      if(l1.val < l2.val){
        l1.next = merge(l1.next,l2);
        return l1;
      }
      else{
        l2.next = merge(l1.next,l2);
        return l2;
      }

    };


    var l1 = new ListNode(1);
    l1.next = new ListNode(5);
    l1.next.next = new ListNode(10);
    l1.next.next.next = new ListNode(15);

    var l2 = new ListNode(2);
    l2.next = new ListNode(3);
    l2.next.next = new ListNode(7);
    l2.next.next.next = new ListNode(11);
    l2.next.next.next.next = new ListNode(12);
    l2.next.next.next.next.next = new ListNode(18);

    var l3 = new ListNode(1);
    l3.next = new ListNode(4);
    l3.next.next = new ListNode(6);
    l3.next.next.next = new ListNode(9);
    l3.next.next.next.next = new ListNode(12);
    l3.next.next.next.next.next = new ListNode(17);

    var l = [l1,l2,l3];
    console.log(mergeKLists(l));

})(typeof window === 'undefined' ? module.exports : window)
------------------------------
//recursive
var mergeKLists = function(lists) {
    return partition(lists,0,lists.length-1);
};

var partition = function(lists, start, end) {
    if(start == end) return lists[start];
     if(start < end){
       var mid = start + (end-start)/2;
       return merge(partition(lists,start,mid),partition(lists,mid+1,end));
     }
      else
        return null;
    };

var merge = function (l1,l2){
      if(l1 == null) return l2;
      if(l2 == null) return l1;
      if(l1.val < l2.val){
        l1.next = merge(l1.next,l2);
        return l1;
      }
      else{
        l2.next = merge(l1.next,l2);
        return l2;
      }
};

------------------------
