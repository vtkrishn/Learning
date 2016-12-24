public class RandomizedCollection {
        Map<Integer,Integer> array;

        public RandomizedCollection(){
            array = new HashMap<Integer,Integer>();
        }

                /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
        public boolean insert(int val) {
            boolean flag = false;
            if(array.containsKey(val)){
                int value = array.get(val);
                array.put(val, value+1);
            }
            else{
                array.put(val, 1);
                flag = true;
            }
            return flag;
        }

               /** Removes a value from the collection. Returns true if the collection contained the specified element. */
        public boolean remove(int val) {
            boolean flag = false;
            if(array.containsKey(val)){
                int value = array.get(val);
                if(value > 1)
                    array.put(val, value-1);
                else
                    array.remove(val);
                flag = true;
            }

            return flag;
        }

}
