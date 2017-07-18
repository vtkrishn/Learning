public class YourClassNameHere {
    public static void main(String[] args) {
      String[] words = {"practice", "makes", "perfect", "coding", "makes"};
      shortestDistance(words,"coding","practice");
    }

    public static int shortestDistance(String[] words, String word1, String word2) {
		int start = 0;
		int end = 0;
		for(int i = 0;i<words.length;i++){
			if(words[i].equals(word1))
				start = i;
			if(words[i].equals(word2))
				end = i;
		}
		return Math.abs(start-end);
	}

}
