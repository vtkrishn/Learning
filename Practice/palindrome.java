public static boolean isPalindrome(String strCheck){
        int start = 0;
        int end = strCheck.length()-1;
        while(start < end){
            if(strCheck.charAt(start) == strCheck.charAt(end)){
                start++;
                end--;
                continue;
            }
            return false;
        }
        return true;
    }
