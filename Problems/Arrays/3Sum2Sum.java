two sum
Map<Integer, Integer> map = new HashMap();
{1,2,3,5} - 7
for(int i=0;i<n;i++){
	if(map.containsKey(arr[i])){
		return arr[map.get(arr[i])], arr[i];
	}
	else{
		map.put(target-arr[i],i); -- 7 - 3
	}
}
----------------------
//sort it
for(int i=0;i<arr.length;i++){
	for(int j= arr.length - 1;j>=0;j--){
		if(target == arr[j] + arr[i])
			return arr[j],arr[i];
		if(arr[j] + arr[i] < target){
			i++;
		}
	}
}
----------------
three sum
(1,2,3,4,5) - 8

//sort it
for(int i=0;i<arr.length;i++){
	for(int j= arr.length - 1;j>=0;j--){
		int a[] = findTwoSum(arr,target - arr[j]);
			if (target == arr[j] + a[0] + a[1])
				return arr[j] , a[0] , a[1];
	}
}
