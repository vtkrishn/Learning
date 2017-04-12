for(int i=0;i<arr.length;i++)   -> this will iterate for all the rows

for(int j=0;j<arr[0].length;j++)   -> this will iterate for all the columns

array[i-1]/[j]   -> going 1 row top, same column
array[i+1]/[j]   -> going 1 row down, same column

array[i]/[j-1]   -> going 1 column left, same row
array[i]/[j+1]   -> going 1 column right, same row

array[i-1]/[j-1] -> going diagonal top
array[i+1]/[j+1] -> going diagonal down

array[0]/[j] - first row all columns
array[i]/[0] - first column all rows

to check all four direction including diagonal use this loop

x is a row variable
y is a column variable

for(int i=x-1;i<=x+1 && i<matrix.length;i++){
for(int j=y-1;j<=y+1 && j<matrix[0].length;j++){

like
  for(int x=-1;x<=1;x++){
      for(int y=-1;y<=1;y++){
          count = count + arr[i+x]/[j+y];
      }
  }
