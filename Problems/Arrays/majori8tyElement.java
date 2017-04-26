int maj_index = 0, count = 1;
int i;
      for(i=1;i<arr.length;i++){
      	if(arr[i] == arr[maj_index])
      		count++;
      	else
      		count--;

      	if(count == 0)
      		maj_index = i;
      		count = 1;
      }		
