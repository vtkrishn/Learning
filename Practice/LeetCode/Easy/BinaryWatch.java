public class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> result = new ArrayList<String>();
        for(int hour=0;hour<12;hour++){
            for(int min=0;min<60;min++){
                if (Integer.bitCount(hour) + Integer.bitCount(min) == num) {
                    result.add(String.format("%d:%02d", hour, min));
                }
            }
        }
         return result;
    }
}
