-----------------------------------------
21 Merge Two Sorted Lists 35.4% Easy
-----------------------------------------
//array list version
var mergeTwoLists = function(l1, l2) {
      var result = [];
      var i=0,j=0,k = 0;
      while(l1 !== undefined && l2 !== undefined && i<l1.length && j < l2.length){
        if(l1[i] > l2[j])
          result[k++] = l2[j++];
        else
          result[k++] = l1[i++];
      }
      return result;
   };
-----------------------------------------
//iterative
  var mergeTwoLists = function(l1, l2) {
      var result = new ListNode(0);
      var head = result;
      var i=0,j=0,k = 0;
      if(l1 === undefined)
        return l2;
      if(l2 === undefined)
         return l1;
      while(l1 && l2){
        if(l1.val > l2.val){
           result.next = l2;
           l2 = l2.next;
         }
        else{
          result.next = l1;
          l1 = l1.next;
        }
        result = result.next;
      }

      if(l1 !== null)
        result.next = l1;
      if(l2 !== null)
        result.next = l2;

      return head.next;
   };
-----------------------------------------
//recursive
var mergeTwoLists = function(l1, l2) {
    if(l1 === null) return l2;
    if(l2 === null) return l1;

    if(l1.val < l2.val) {
        l1.next = mergeTwoLists(l1.next, l2);
        return l1;
    } else {
        l2.next = mergeTwoLists(l2.next, l1);
        return l2;
    }
};
-----------------------------------------
