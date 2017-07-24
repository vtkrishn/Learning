public class Solution {
    public boolean isPalindrome(String s) {

        if (s == null || s.trim().equals("")) {
            return true;
        }

        s = s.toLowerCase();

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            while (! ((s.charAt(left) >= 'a' && s.charAt(left) <= 'z') || (s.charAt(left) >= '0' && s.charAt(left) <= '9'))) {
                left++;
                if (left == s.length()-1) return true;
            }
            while (! ((s.charAt(right) >= 'a' && s.charAt(right) <= 'z') || (s.charAt(right) >= '0' && s.charAt(right) <= '9'))) {
                right--;
            }

            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
