/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var smallestDistancePair = function(nums, k) {
    var n = nums.length;
    var count = [];
    var N = 1000000;
    for(var i=0;i<=N;i++)
        count[i] = 0;

    for(var i =0;i<n;++i){
        for(var j=i+1;j<n;++j)
              ++count[Math.abs(nums[i]- nums[j])];
    }

    var sum = 0;
    for(var i=0;i<=N;++i){
        sum += count[i];
        if(sum >= k)
            return i;
    }

    return 0;
};
--------------
class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length, low = 0, hi = nums[n-1] - nums[0];
        while (low < hi) {
            int cnt = 0, j = 0, mid = (low + hi)/2;
            for (int i = 0; i < n; ++i) {
                while (j < n && nums[j] - nums[i] <= mid) ++j;
                cnt += j - i-1;
            }
            if (cnt >= k)
                hi = mid;

            else low = mid + 1;
        }

        return low;
    }
}
