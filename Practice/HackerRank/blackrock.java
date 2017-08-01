static String electionWinner(String[] votes) {
    TreeMap<String,Integer> result = new TreeMap<String,Integer>(Collections.reverseOrder());
    for(int i =0;i<votes.length;i++){
         result.put(votes[i],result.getOrDefault(votes[i], 1) + 1);
    }
    int max = Integer.MIN_VALUE;
    String output = null;
    for(Map.Entry<String,Integer> entry : result.entrySet()){
        String key = entry.getKey();
        int value = entry.getValue();
        if(max < value){
            max = value;
            output = key;
        }
    }
    return output;
}

static int[] arbitrage(String[] quotes) {
    int[] result = new int[quotes.length];
    for(int i=0;i<quotes.length;i++){
        String[] items = quotes[i].split(" ");
        double totalAmout = 100000;
        double usdValue = Double.parseDouble(items[0]);
        double eurValue = Double.parseDouble(items[1]);
        double gbpValue = Double.parseDouble(items[2]);

        double EURbought = totalAmout / usdValue;
        double GBPbought = EURbought / eurValue;
        double USDbought = GBPbought / gbpValue;
        int arbitrage = (int)(USDbought - totalAmout);
        result[i] = USDbought < totalAmout ? 0 : arbitrage;
    }
    return result;
}
