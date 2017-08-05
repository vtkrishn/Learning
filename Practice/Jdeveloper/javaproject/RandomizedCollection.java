//package javaproject;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Random;
//import java.util.Set;
//
//public class RandomizedCollection {
//        List<Integer> nums;
//        Map<Integer,Set<Integer>> map;
//        Random rand;
//        
//        public RandomizedCollection(){
//            map = new HashMap<Integer,Set<Integer>>();
//            nums = new ArrayList<Integer>();
//            rand = new Random();
//        }
//        
//        /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
//        public boolean insert(int val) {
//            boolean flag = false;
//            if(array.containsKey(val)){
//                int value = array.get(val);
//                array.put(val, value+1);
//            }
//            else{
//                array.put(val, 1);
//                flag = true;
//            }
//            
//            nums.add(val);    
//            return flag;
//        }
//        
//        /** Removes a value from the collection. Returns true if the collection contained the specified element. */
//        public boolean remove(int val) {
//            boolean flag = false;
//            if(array.containsKey(val)){
//                int value = array.get(val);
//                if(value > 1)
//                    array.put(val, value-1);
//                else
//                    array.remove(val);
//                    nums.remove(val);
//                flag = true;
//            }
//               
//            return flag;
//        }
//        
//        /** Get a random element from the collection. */
//        public int getRandom() {
//            int index = rand.nextInt(nums.size());
//            return nums.get(index);    
//        }
//}
