var validPalindrome = function(s) {
    var i = 0, j = s.length - 1;
        while (i < j && s[i] === s[j]) {
            i++;
            j--;
        }

        var result = isPalindrome(s,i+1,j) || isPalindrome(s,i,j-1);
        return result;
  };

var isPalindrome = function(a,i,j){
    var start = i;
    var end = j;
    while(start < end){
      if(a[start] !== a[end])
        return false;
      start++;
      end--;
    }
    return true;
}
