public class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<String>();
        for(int i=1;i<=n;i++){
            String value = null;
            if(i % 3 == 0 && i%5 == 0)
                value = "FizzBuzz";
            else if(i % 5 == 0)
                value = "Buzz";
            else if(i % 3 == 0)
                value = "Fizz";
            else
                value = ""+i;
            result.add(value);
        }
        return result;
    }
}
