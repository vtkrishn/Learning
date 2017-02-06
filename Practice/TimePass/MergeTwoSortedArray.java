public class YourClassNameHere {
    public static void main(String[] args) {
      int[] a = {1, 3, 4, 5, 6, 7};
int[] b = {2, 6, 9, 8};
int[] result = new int[a.length+b.length];

int k=0;
int i=0;
int j=0;

while(k<result.length && i< a.length && j < b.length){
	if(a[i] < b[j]){
		result[k] = a[i];
		i++;
	}
	else{
		result[k] = b[j];
		j++;
	}
	k++;
}

while(i<a.length){
result[k++] = a[i++];
}

while(j<b.length){
result[k++] = b[j++];
}
    }
}
