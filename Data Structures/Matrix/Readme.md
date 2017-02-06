for(int i=0;i<arr.length;i++)   -> this will iterate for all the rows

for(int j=0;j<arr[0].length;j++)   -> this will iterate for all the columns

array[i-1]/[j]   -> going 1 row top
array[i+1]/[j]   -> going 1 row down

array[i]/[j-1]   -> going 1 column left
array[i]/[j+1]   -> going 1 column right

array[i-1]/[j-1] -> going diagonal top
array[i+1]/[j+1] -> going diagonal down

array[0]/[j] - first row all columns
array[i]/[0] - first column all rows

to check all four direction including diagonal use this loop

x is a row variable

y is a column variable

for(int i=x-1;i<=x+1 && i<matrix.length;i++){

for(int j=y-1;j<=y+1 && j<matrix[0].length;j++){
