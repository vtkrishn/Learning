public static void main(String[] args) {
       for(int i=1;i<=100;i++){
           System.out.println(i % 3 == 0 && i%5 == 0 ? "Fizz Buzz" : i%5 == 0 ? "Buzz" : (i%3 == 0 ? "Fizz" : i));
       }
}

------------------------------

List<String> fizzbuzz(int start, int end) {
       List<String> result = new ArratList<String>();
       for(int i=start;i<=end;i++){
           if(i % 3 == 0 && i % 5 == 0)
               result.add("fizzBuzz");
           else if(i % 3 == 0)
              result.add("fizz");
           else if(i % 5 == 0)
              result.add("buzz");
           else
               result.add(i);
       }
        return result;
}

----------------------------------

import java.util.*;
public class YourClassNameHere {
    public static void main(String[] args) {
      //fizzBuzz(1,15);
      Map<Integer,String> rules = new HashMap<Integer,String>();
      rules.put(3,"a");
      rules.put(5,"b");
      rules.put(7,"c");
      fizzBuzz(15,15, rules);
      fizzBuzz(21,21, rules);
      fizzBuzz(35,35, rules);
      fizzBuzz(105,105, rules);
    }

public static void fizzBuzz(int start,int end,Map<Integer,String> rules){
    for(int i=start;i<=end;i++){
      StringBuilder stb = new StringBuilder();
      boolean flag = false;
      for(Map.Entry<Integer,String> entry: rules.entrySet()){
         int key = entry.getKey();
         String value = entry.getValue();
            if(i % key == 0){
                stb.append(value);
                flag = true;
            }
      }
      if(!flag)
        System.out.println(i);
      else
        System.out.println(stb.toString());
  }
}

public static void fizzBuzz(int start,int end){
  if(start > end)
    return;
    System.out.println(start);
   fizzBuzz(start+1,end);
}
}
