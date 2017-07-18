public class YourClassNameHere {
    public static void main(String[] args) {
      int[] nums = {4,3,2,7,8,2,3,1};
      findDisappearedNumbers(nums);
    }

    public static void findDisappearedNumbers(int[] nums) {
        for(int i=0;i<nums.length;i++){
           int index = nums[i];
            if(nums[Math.abs(index)-1] > 0){
                nums[Math.abs(index)-1]= -nums[Math.abs(index)-1];
            }

        }
       for(int j =1 ;j <= nums.length ; j++){
            if(nums[j-1] > 0){
                System.out.println(j);
            }
        }
    }

}
