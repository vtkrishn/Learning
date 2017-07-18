isPalindrome(String str){
	int[] map = new int[128];
	int count = 0;
	for(int i=0;i<str.length();i++){
		map[s.charAt(i)]++;
		if(map[s.charAt(i)] % 2 == 0)
			count--;
		else
			count++;
	}
	return count <= 1;
}
