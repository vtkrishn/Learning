Map<String,Integer> map = new LinkedHashMap<String,Integer>();
//make use of removeEldestEntry in LinkedHashMap
map = new java.util.LinkedHashMap<String, Integer>(100, 0.6f, true) {
            protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
                return lastSecond - eldest.getValue() > 10;
            }
        };
shouldPrintMessage(int timeStamp, String message){
	if(map.containsKey(message)){
		int loggedTime = map.get(message);
		if(Math.abs(timeStamp-loggedTime) >= 10){
			map.put(message,timeStamp);
			return true;
		}
		else
			return false;
	}
}
