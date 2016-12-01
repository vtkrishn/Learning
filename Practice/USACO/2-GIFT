http://train.usaco.org/usacoprob2?a=iJ0r7MLJ6j4&S=gift1
/*
ID: vin.sin1
LANG: JAVA
PROG: gift1
*/
import java.io.*;
import java.util.*;

public class gift1 {

  static class Friend{

	String name;
	int availableMoney;
	int giftCount;
	String[] givers;

	public Friend(String name){
		this.name = name;
	}
	public void setAvailableMoney(int value){
		this.availableMoney = value;
	}

	public void setGiftCount(int value){
		this.giftCount = value;
	}

	public void setGivers(String[] values){
		this.givers = values;
	}

	public void compute(java.util.LinkedHashMap<String,Friend> names,int split){
	   for(int i=0;i<giftCount;i++){
	     Friend f = names.get(givers[i]);
	      f.setAvailableMoney(f.availableMoney + split);
	   }

	}

}

	public static void main(String[] args) throws IOException,FileNotFoundException{

  // Use BufferedReader rather than RandomAccessFile; it's much faster
  BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
    // input file name goes above
  PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));

	// Use StringTokenizer vs. readLine/split -- lots faster
  StringTokenizer st = new StringTokenizer(f.readLine());
  //no of friends
  int NP = Integer.parseInt((String)st.nextElement());
  //name of each of the friends
  java.util.LinkedHashMap<String,Friend> names = new java.util.LinkedHashMap<String,Friend>();
  //get all the friends name and put it in the map
  for(int i=0;i<NP;i++){
	  String name = st.nextToken();
	  names.put(name,new Friend(name));
  }

  //if there are more elements
  while(st.hasMoreElements()){

  	  //get the name
  	  String name = st.nextToken();
  	  //get the money
  	  int money = Integer.parseInt((String)st.nextElement());
  	  //get the count
  	  int giftCount = Integer.parseInt((String)st.nextElement());

  	  String[] givers = new String[giftCount];

  	  //get the givers name
  	  if(giftCount > 0){
    	  for(int i=0;i<giftCount;i++){
    		  givers[i] = st.nextToken();
    	  }
    	  //for each of the friends assign the values
    	  Friend friend = names.get(name);

    	  //set the available money
    	  if(friend.availableMoney == 0){
    	    friend.setAvailableMoney(money);
    	  }
    	  else{
    	    //if availanble money is already set
    	    friend.setAvailableMoney(friend.availableMoney-money);
    	  }
    	  //set the giftCount and the givers
    	  friend.setGiftCount(giftCount);
    	  friend.setGivers(givers);

        int split = giftCount != 0 ? money / giftCount : money;
	      int remaining = giftCount != 0 ? money % giftCount : money;
	      if(money == friend.availableMoney)
	      friend.setAvailableMoney(remaining-friend.availableMoney);

    	  friend.compute(names,split);
    }
  }

  //print the values
  printMap(names);
  out.close();  // close the output file
}

public static void printMap(java.util.Map<String,Friend> names){
  for (java.util.Map.Entry<String, Friend> entry : names.entrySet())
      System.out.println(entry.getKey() + "/" + entry.getValue().availableMoney);
}

}
