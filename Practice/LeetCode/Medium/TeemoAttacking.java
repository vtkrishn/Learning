public class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0) return 0;
        int begin = timeSeries[0], total = 0;
        for (int t : timeSeries) {
            total = total + (t < begin + duration ? t - begin : duration);
            begin = t;
        }
        return total + duration;
    }
}
--------
if (timeSeries.empty()) return 0;
        int res = 0, n = timeSeries.size();
        for (int i = 1; i < n; ++i) {
            int diff = timeSeries[i] - timeSeries[i - 1];
            res += (diff < duration) ? diff : duration;
        }
        return res + duration;
