public List<String> generatePossibleNextMoves(String s) {
	List<String> result = new ArrayList<String>();

	if(str == null)
		return result;

	char[] ch = str.toCharArray();
	for(int i=0;i<str.length();i++){
		if(ch[i] == ch[i+1] && ch[i] == '+'){
			ch[i] = '-';
			ch[i+1] = '-';
			result.add(new String(arr));
			ch[i] = '+';
			ch[i+1] = '+';
		}
	}

	return result;
}
