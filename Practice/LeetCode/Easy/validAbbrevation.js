/**
 * @param {string} word
 * @param {string} abbr
 * @return {boolean}
 */
var validWordAbbreviation = function(word, abbr) {
    var sum = 0;
	  var charSum = 0;
	  for(var i=0;i<abbr.length;i++){
          if(abbr[i] == '0' && sum == 0) return false;
          if(abbr[i] >= '0' && abbr[i] <= '9'){
            sum = (sum * 10) + parseInt(abbr[i]-'0');
				}
				else{
					charSum += sum;
                    if(charSum >= word.length || abbr[i] != word.charAt(charSum)) return false;
					sum = 0;
                    charSum++;
				}
    }
	return (charSum + sum) == word.length;
};
