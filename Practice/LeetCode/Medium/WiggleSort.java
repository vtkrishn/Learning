public void wiggleSort(int[] nums) {
    for (int i=1; i<nums.length; i++) {
        int a = nums[i-1];
        if ((i%2 == 1) == (a > nums[i])) {
            nums[i-1] = nums[i];
            nums[i] = a;
        }
    }
}
-----------------
for (int i=1; i<nums.length; i++) {
    int previous = nums[i-1];
    if ((nums[i] > previous) != (i%2 == 1)) {
        nums[i-1] = nums[i];
        nums[i] = previous;
    }
}
-----------------
public class YourClassNameHere {
    public static void main(String[] args) {
        int[] nums = {3,5,6,1,2,4};
        java.util.Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++){
            if(i%2 == 0 && nums[i] > nums[i-1]){
                int temp = nums[i];
                nums[i] = nums[i-1];
                nums[i-1] = temp;
        }

    }
    }
}
---------------
public class YourClassNameHere {
    public static void main(String[] args) {
        int[] nums = {3,5,6,1,2,4};
        for(int i = 0; i < nums.length-1; i++){
            if((i % 2 == 0 && nums[i] > nums[i+1]) ||(i % 2 == 1 && nums[i] < nums[i+1])){
                int temp = nums[i];
                nums[i] = nums[i+1];
                nums[i+1] = temp;
            }
        }

    }
}
