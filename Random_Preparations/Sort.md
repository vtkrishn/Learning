console.clear();

insertionSort = function(nums){
  for(var i = 1;i<nums.length;i++){//loop complete array
    var key = nums[i]; // take the element from unsorted sub array and store
    var j = i-1;       //  pointer for the elemnt before unsorted element
    while(j>=0 && nums[j] > key){ //the pointer should be greater than zero also greater than the unsorted elemnt
        nums[j+1] = nums[j]; // if so then store the value to the next element
      j--;                   // decrement j
    }
    nums[j+1] = key;     //atlast store the i element in here
    console.log(nums);
  }
//   for(var i = 1;i<nums.length;i++){
//      var key = nums[i];
//      var j = i;
//      while(j > 0 && nums[j-1] > val){
//          nums[j] = nums[j-1];
//        j--;
//      }
//      nums[j] = val;
//      console.log(nums);
//   }
}

insertionSort([34,-1,2,4,56,-32,8,2,0,-11]);
-------------------------------------------------------

Heap Sort

console.clear();
var nums = [5,4,3,2,1];
var n = nums.length;
//1 is root - 0
//2 is left - 2*i + 1 => i  0
//3 is right - 2*i + 2 => i = 0
buildHeap = function(nums){
  for(var i=parseInt(n/2)-1;i>=0;i--)
    heapify(nums, n,i);
     for(var i=n-1;i>=0;i--){
        var temp = nums[i];
        nums[i] = nums[0];
        nums[0] = temp;

       heapify(nums, i, 0);
     }
}

heapify = function(nums,n,index){
    var largest = index;
    var left = 2*index + 1;
    var right = 2*index +2;

    if(left<n && nums[left] > nums[largest])
      largest = left;
    if(right<n && nums[right] > nums[largest])
      largest = right;

    if(largest != index){
      var temp = nums[largest];
      nums[largest] = nums[index];
      nums[index] = temp;

      heapify(nums, largest, n);
    }
}

buildHeap(nums);
console.log(nums);

----------------
