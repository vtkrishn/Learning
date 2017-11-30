var areSentencesSimilar = function(words1, words2, pairs) {
  if(words1.length !== words2.length)
        return false;

	var pairSet = {};
  for(var i=0;i<pairs.length;i++)
		pairSet[pairs[i][0] + "#" +  pairs[i][1]] = (pairs[i][0] + "#" +  pairs[i][1]);

	console.log(pairSet);

	for(var i=0;i<words1.length;i++){
		var val1 = words1[i] + "#" + words2[i];
		var val2 = words2[i] + "#" + words1[i];

		if(words1[i] != words2[i] && pairSet[val1] === undefined && pairSet[val2] === undefined){
			return false;
		}
	}

	return true;
};
